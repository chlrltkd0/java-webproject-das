console.log('Started', self);
self.addEventListener('install', function(event){
  self.skipWaiting();
  console.log('Installed', event);
});
self.addEventListener('activate', function(event){
  console.log('Activated', event);
})
self.addEventListener('push', function(event){
  var title = "내 주변 배달요청";
  event.waitUntil(
    self.registration.showNotification(title, {
      icon: 'src/resources/img/icon.png',
      body : '배달 가능한 목록을 확인하세요'
    })
  )
})

self.addEventListener('notificationclick', function(event) {
    event.notification.close();
    var url = 'https://weather.diano.kr/';
    event.waitUntil(
        clients.matchAll({
            type: 'window'
        })
        .then(function(windowClients) {
            for (var i = 0; i < windowClients.length; i++) {
                var client = windowClients[i];
                if (client.url === url && 'focus' in client) {
                    return client.focus();
                }
            }
            if (clients.openWindow) {
                return clients.openWindow(url);
            }
        })
    );
});
