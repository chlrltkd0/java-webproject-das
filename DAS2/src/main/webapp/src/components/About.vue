<template lang="html">
  <div class="about">
    <header class="masthead bg-warning text-white text-center">
  <div class="container">
    <h1 class="text-uppercase mb-0">DELIVERY AGENCY</h1>
    <hr class="star-light">
    <h2 class="font-weight-light mb-0">내가 니 물건을 안전하게 갖다줄게!</h2>
  </div>
</header>
    <div class="bg-primary text-white mb-0" id="about">
         <div class="container">
           <h2 class="text-center text-uppercase text-white">Application</h2>
           <hr class="star-light mb-5">
           <div class="row">
             <div class="col-lg-4 ml-auto">
               <p class="lead">Freelancer is a free bootstrap theme created by Start Bootstrap. The download includes the complete source files including HTML, CSS, and JavaScript as well as optional LESS stylesheets for easy customization.</p>
             </div>
             <div class="col-lg-4 mr-auto">
               <p class="lead">Whether you're a student looking to showcase your work, a professional looking to attract clients, or a graphic artist looking to share your projects, this template is the perfect starting point!</p>
             </div>
           </div>
           <div class="text-center mt-4">
             <a class="btn btn-xl btn-outline-light" href="#">
               <i class="fa fa-download mr-2"></i>
               Download Now!
             </a>
           </div>
         </div>
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
    this.$http({
      method : 'post',
      url : 'getBoardCategoryList.do'
    }).then((response) => {
      console.log(response.data);
      this.$store.commit('setBoardCategorys', response.data);
    }).catch((error) => {
      console.log(error);
      alert('서버측 문제로 홈페이지 정보를 제대로 받아오지 못했습니다.');
    })
  }
}
</script>

<style lang="css">
</style>
