<template lang="html">
  <div class="my-nav">
    <nav class="navbar navbar-expand-lg bg-secondary fixed-top text-uppercase" id="mainNav">
      <div class="container">
        <a class="navbar-brand js-scroll-trigger" v-on:click="gotoMain">Delivery Agency</a>
        <b-navbar toggleable="md">
        <b-navbar-toggle target="nav_collapse"></b-navbar-toggle>
          <b-collapse is-nav id="nav_collapse">
            <b-navbar-nav class="ml-auto">
              <b-nav-item-dropdown text="게시판" class="nav-link py-3 px-0 px-lg-3" left>
                <b-dropdown-item v-for="category in this.$store.state.boardCategorys" v-on:click="getBoardList(category.idx)">{{category.name}}</b-dropdown-item>
              </b-nav-item-dropdown>
              <b-nav-item class="nav-link py-3 px-0 px-lg-3" v-on:click="gotoRequestDelivery">배송신청</b-nav-item>
              <b-nav-item class="nav-link py-3 px-0 px-lg-3" v-on:click="gotoApplyDelivery">배달하기</b-nav-item>
            </b-navbar-nav>
            <b-navbar-nav class="ml-auto">
              <b-nav-item-dropdown v-if="this.$store.state.party != null" v-bind:text="this.$store.state.party.name + ' (' + this.$store.state.party.cash + ')'" right>
                <b-dropdown-item v-on:click="gotoMyPage">마이 페이지</b-dropdown-item>
                <b-dropdown-item v-on:click="gotoDeliveryListForSender">나의 배송신청 목록</b-dropdown-item>
                <b-dropdown-item v-on:click="gotoDeliveryListForWaitDeliverer">나의 배송자신청 대기 목록</b-dropdown-item>
                <b-dropdown-item v-on:click="gotoDeliveryListForDeliverer">내가 배달중인 목록</b-dropdown-item>
                <b-dropdown-item v-on:click="gotoLogout">로그아웃</b-dropdown-item>
              </b-nav-item-dropdown>
              <b-nav-item-dropdown v-if="this.$store.state.party != null && this.$store.state.party.grade >= 10" text="관리자 메뉴" right>
                <b-dropdown-item v-on:click="gotoManage">홈페이지 관리</b-dropdown-item>
                <b-dropdown-item v-on:click="gotoManageMember">회원 관리</b-dropdown-item>
                <b-dropdown-item v-on:click="gotoAdmin">차트</b-dropdown-item>
                <b-dropdown-item v-on:click="gotoTestPage">테스트 페이지</b-dropdown-item>
              </b-nav-item-dropdown>
              <b-nav-item v-if="this.$store.state.party == null" v-on:click="gotoRegister" class="py-3 px-0 px-lg-3">회원가입</b-nav-item>
              <b-nav-item v-if="this.$store.state.party == null" v-on:click="gotoLogin" class="py-3 px-0 px-lg-3">로그인</b-nav-item>
            </b-navbar-nav>
          </b-collapse>
        </b-navbar>
      </div>
    </nav>
  </div>
</template>

<script>

export default {
  data : function(){
    return {
      login : false
    }
  },
  created : function(){
    this.$store.dispatch('isLogin');
  },
  methods : {
    gotoAdmin : function(){
      this.$router.push('/adminchart');
    },
    gotoRequestDelivery : function(){
      this.$router.push('/requestdelivery');
    },
    gotoMain : function(){
      this.$router.push('/');
    },
    gotoApplyDelivery : function(){
      if(this.$store.state.party!=null){
        this.$store.dispatch('getPatternList');
      }
      this.$router.push('/deliverymap');
    },
    gotoDeliveryListForSender : function(){
      this.$store.dispatch('getDeliveryList', {
        senderId : this.$store.state.party.id
      });
      this.$router.push('/deliverylist');
    },
    gotoDeliveryListForWaitDeliverer : function(){
      this.$store.dispatch('getDeliveryListForWaitDeliverer');
      this.$router.push('/deliverylist');
    },
    gotoDeliveryListForDeliverer : function(){
      this.$store.dispatch('getDeliveryList', {
        delivererId : this.$store.state.party.id
      });
      this.$router.push('/deliverylist');
    },
    gotoLogin : function(){
      this.$router.push('/login');
    },
    gotoRegister : function(){
      this.$router.push('/register');
    },
    gotoLogout : function(){
      this.$store.dispatch('logout');
      this.$router.push('/');
    },
    getBoardList : function(data){
      this.$store.dispatch('getBoardList', {
        categoryIdx : data,
        page : 1
      });
      this.$router.push('/bbs');
    },
    gotoManageMember : function(){
      this.$router.push('/managemember');
    },
    gotoTestPage : function(){
      this.$router.push('/testpage');
    },
    gotoManage : function(){
      this.$router.push('/manage');
    },
    gotoMyPage : function(){
      this.$router.push('/mypage');
    }
  }
}
</script>

<style lang="css">
</style>
