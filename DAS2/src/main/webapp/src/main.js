import Vue from 'vue'
import App from './App.vue'
import VueRouter from 'vue-router'
import BootstrapVue from 'bootstrap-vue'
import Vuex from 'vue-router'
import axios from 'axios'
import * as VueGoogleMaps from 'vue2-google-maps'

import Routes from './routes'
import {store} from './store'

Vue.prototype.$http = axios;

Vue.use(VueRouter);
Vue.use(BootstrapVue);
Vue.use(VueGoogleMaps, {
  load : {
    key : 'AIzaSyBdHGWCDHpZtFEkvjHBXhkb886qEbBxqBM',
    libraries: 'places,drawing'
  }
});

const router = new VueRouter({
  routes:Routes
})

export const vm = new Vue({
  el: '#app',
  render: h => h(App),
  router: router,
  store
})

function urlB64ToUint8Array(base64String) {
  const padding = '='.repeat((4 - base64String.length % 4) % 4);
  const base64 = (base64String + padding)
    .replace(/\-/g, '+')
    .replace(/_/g, '/');

  const rawData = window.atob(base64);
  const outputArray = new Uint8Array(rawData.length);

  for (let i = 0; i < rawData.length; ++i) {
    outputArray[i] = rawData.charCodeAt(i);
  }
  return outputArray;
}
const applicationServerPublicKey = 'BKNcoyQxATUzyWCaC396ZPnzCTJS-uj6V86FUyJk6Jsu0hL9QZNklfF74yRMWfsLG9d_HwvrOWi1vBJoeZJc42Q';
const applicationServerKey = urlB64ToUint8Array(applicationServerPublicKey);

if('serviceWorker' in navigator) {
  console.log('서비스워커 지원됨');
  navigator.serviceWorker.register('/service_worker.js').then(function(reg){
    // console.log(reg);
    reg.pushManager.subscribe({
      userVisibleOnly: true,
      applicationServerKey : applicationServerKey
    }).then(function(sub){
      var str = JSON.stringify(sub);
      var subs = JSON.parse(str);
      vm.$store.state.pushdata.endpoint = subs.endpoint;
      vm.$store.state.pushdata.p256dh = subs.keys.p256dh;
      vm.$store.state.pushdata.auth = subs.keys.auth;
    })
  }).catch(function(err){
    console.log(err);
  })
}
