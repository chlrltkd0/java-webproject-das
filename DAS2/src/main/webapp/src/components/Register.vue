<template lang="html">
<div class="register">
  <div class="container">
  <br><br>
    <h2 class="text-center text-uppercase text-secondary mb-0">회원가입</h2>
    <hr class="star-dark mb-5">
    <div class="row">
      <div class="col-lg-6 mx-auto">
        <!-- To configure the contact form email address, go to mail/contact_me.php and update the email address in the PHP file on line 19. -->
        <!-- The form should work on most web servers, but if the form is not working you may need to configure your web server differently. -->
        <b-form action="register.do" name="sentMessage" id="contactForm" novalidate="novalidate">
          <div class="control-group">
            <div class="form-group controls mb-0 pb-2">
              <b-form-input type="text" v-model="id" v-on:change="checkId" id="inputId" placeholder="아이디"></b-form-input>
              <p class="help-block text-danger" id="idmessage"></p>
            </div>
          </div>
          <div class="control-group">
            <div class="controls mb-0 pb-2">
              <b-form-input type="password" v-model="pw" v-on:input="checkPw" id="inputPassword" placeholder="비밀번호"></b-form-input>
              <p class="help-block text-danger" id="pwmessage"></p>
            </div>
          </div>
          <div class="control-group">
            <div class="form-group controls mb-0 pb-2">
              <b-form-input type="password" v-model="pw2" v-on:input="checkPw" id="inputPasswordCheck" placeholder="비밀번호 확인"></b-form-input>
              <p class="help-block text-danger" id="pwmessagecheck"></p>
            </div>
          </div>
          <div class="control-group">
            <div class="form-group controls mb-0 pb-2">
              <input type="text" class="form-control" v-model="name" id="inputName" placeholder="이름">
              <p class="help-block text-danger" id="namemessage"></p>
            </div>
          </div>
          <br>
          <div class="form-group text-center">
            <button type="button" class="btn btn-primary btn-xl" id="sendMessageButton" v-on:click="register">회원가입</button>
            <button type="button" class="btn btn-danger btn-xl" id="sendMessageCancelButton" v-on:click="gotoBack">가입취소</button>
          </div>
        </b-form>
      </div>
    </div>
  </div>
</div>
</template>

<script>
export default {
  data : function(){
    return {
      id : '',
      pw : '',
      pw2 : '',
      name : '',
      idcheck : false,
      pwcheck : false
    }
  },
  methods : {
    gotoBack : function(){
      this.$router.go(-1);
    },
    checkId : function(){
      this.$http({
        method : 'post',
        url : 'checkid.do',
        params : { loginId : this.id }
      }).then((response) => {
        this.idcheck = response.data;
      }).catch((error) => {
        this.idcheck = false;
      })
    },
    register : function(){
      if(this.idcheck==true && this.pwcheck==true && this.name!=""){
        this.$http({
          method : 'post',
          url : 'register.do',
          params : {
            loginId : this.id,
            loginPwd : this.pw,
            name : this.name
          }
        }).then((response) => {
          if(response.data==true){
            alert("회원가입 성공 이메일을 확인해 주세요.");
            this.$router.push('/');
          } else {
            alert("회원가입이 실패하였습니다.");
          }
        }).catch((error) => {
          alert("에러가 발생하였습니다.");
        })
      } else {
        alert("아이디와 비밀번호를 확인해 주세요");
      }
    },
    checkPw : function(){
      if(this.pw == this.pw2 && this.pw.length > 8){
        this.pwcheck = true;
      } else {
        this.pwcheck = false;
      }
    }
  }
}
</script>

<style lang="css">
</style>
