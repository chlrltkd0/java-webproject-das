<template lang="html">
  <div class="login">
    <br><br><br><br><br><br>
  	<h1>Login</h1>
    <div class="col-lg-4 mx-auto">
      <b-form>
      	<b-input type="text" class="my-3" v-model="loginId" placeholder="아이디" required="required" />
        <b-input type="password" class="my-3" v-model="loginPwd" @keyup.enter="login" placeholder="비밀번호" required="required" />
        <b-button variant="primary" v-on:click="login">로그인</b-button>
      </b-form>
      <br><br><br><br><br>
    </div>
  </div>
</template>
<script>
export default {
  data : function(){
    return {
      loginId : '',
      loginPwd : ''
    }
  },
  methods : {
    login : function(){
      this.$http({
        method : 'post',
        url : 'login.do',
        params : {
          loginId : this.loginId,
          loginPwd : this.loginPwd
        }
      }).then((response) => {
        if(response.data!=""){
          this.$store.commit('setParty', response.data);
          this.$store.dispatch('sendPushData');
          this.$router.push('/');
        } else {
          alert('아이디 비밀번호가 올바르지 않습니다.');
        }
      }).catch((error) => {
        console.log(error);
        alert('에러가 발생하였습니다.')
      });
    }
  }
}
</script>

<style lang="css">
</style>
