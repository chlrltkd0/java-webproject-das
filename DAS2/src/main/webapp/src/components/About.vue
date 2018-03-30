<template lang="html">
  <div class="about">
    <header class="masthead bg-warning text-white text-center">
  <div class="container">
    <h1 class="text-uppercase mb-0">DELIVERY AGENCY</h1>
    <hr class="mb-5">
    <h2 class="font-weight-light mb-0">내가 니 물건을 안전하게 갖다줄게!</h2>
  </div>
</header>
    <div class="bg-dark text-white mb-0" id="about">
         <div class="container">
           <br><br><br>
           <h2 class="text-center text-uppercase text-white">About</h2>
           <br>
           <div class="row">
             <div class="col-lg-4 ml-auto">
               <h2 class="text-center text-uppercase text-white">편리한 배송 수단</h2>
               <p class="lead">탭 한 번으로 배송 요청부터을 시작하세요. 요청한 물건을 배송자가 미리 확인한 목적지까지 가져다줍니다십니다. 도착하면 번거로운 결제 절차 없이 수령하시면 됩니다</p>
             </div>
             <div class="col-lg-4 ml-auto">
               <h2 class="text-center text-uppercase text-white">언제 어디서나 요청가능</h2>
               <p class="lead">출퇴근 길, 시내 반대편에 볼 일이 있을 때, 아침 일찍 공항에 가야 할 때, 늦은 밤 술 약속이 있을 때 목적지가 어디든 예약이 필요 없는 배송 서비스를 요청하세요.</p>
             </div>
             <div class="col-lg-4 mr-auto">
               <h2 class="text-center text-uppercase text-white">다양한 배송 옵션</h2>
               <p class="lead">이코노미 차량을 상시 가격으로 언제나 이용하실 수 있습니다. 특별한 행사, 혹은 행사가 아니더라도 조금 더 넉넉한 공간이 필요할 때는 블랙 세단이나 SUV를 부르세요.</p>
             </div>
           </div>
           <div class="text-center mt-4">
             <a class="btn btn-xl btn-outline-light" href="#">
               <i class="fa fa-download mr-2"></i>
               어플 다운로드
             </a>
           </div>
         </div>
         <br>
       </div>
  </div>
</template>

<script>
export default {
  data : function(){
    return {
      date : new Date(),
      time : ''
    }
  },
  created : function(){
    this.$store.dispatch('partyUpdate');
  }
}
</script>

<style lang="css">
</style>
