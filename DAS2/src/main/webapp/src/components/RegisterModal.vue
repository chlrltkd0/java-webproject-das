<template lang="html">
  <transition name="modal">
      <div class="modal-mask">
        <div class="modal-wrapper">
          <div class="modal-container">
            <div class="modal-header">
              <slot name="header">
                <h1>회원가입</h1>
              </slot>
            </div>
            <div class="modal-body">
              <b-container fluid>
                <b-row class="my-3">
                  <b-col sm="3"><label for="input-default">이메일</label></b-col>
                  <b-col sm="9">
                    <b-form-input id="input-email" v-on:change="emailchange" v-model="email" v-bind:state="emailcheck" type="email" placeholder=""></b-form-input>
                  </b-col>
                </b-row>
                <b-row class="my-3">
                  <b-col sm="3"><label for="input-default">닉네임</label></b-col>
                  <b-col sm="9">
                    <b-form-input id="input-nickname" v-model="nickname" type="text" placeholder=""></b-form-input>
                  </b-col>
                </b-row>
                <b-row class="my-3">
                  <b-col sm="3"><label for="input-default">비밀번호</label></b-col>
                  <b-col sm="9">
                    <b-form-input id="input-pw" v-on:input="pwchange" v-model="pw" v-bind:state="pwcheck" type="password" placeholder=""></b-form-input>
                  </b-col>
                </b-row>
                <b-row class="my-3">
                  <b-col sm="3"><label for="input-default">비번확인</label></b-col>
                  <b-col sm="9">
                    <b-form-input id="input-pw2" v-on:input="pwchange" v-model="pw2" v-bind:state="pwcheck" type="password" placeholder=""></b-form-input>
                  </b-col>
                </b-row>
              </b-container>
              <slot name="body">
              </slot>
            </div>
            <div class="modal-footer">
              <slot name="footer">
                <b-button class="modal-default-button" variant="success" v-on:click="register">
                  가입하기
                </b-button>
                <b-button class="modal-default-button" variant="danger" v-on:click="$emit('close')">
                  취소
                </b-button>
              </slot>
            </div>
          </div>
        </div>
      </div>
    </transition>
</template>


<script>
export default {
  data : function(){
    return {
      email : '',
      pw : '',
      pw2 : '',
      nickname : '',
      emailcheck : null,
      pwcheck : null,
    }
  },
  methods : {
    register : function(){
      if(this.emailcheck==true && this.pwcheck==true){
        axios({
          method : 'post',
          url : 'register.do',
          params : {
            email : this.email,
            password : this.pw,
            nickname : this.nickname
          }
        }).then((response) => {
          if(response.data==true){
            this.$emit('close');
            alert('가입이 완료되었습니다. 이메일을 확인해 주세요');
          }else{
            alert('서버측 에러로 가입이 실패하였습니다.');
          }
        }).catch((error) => {
          alert('서버측 에러로 가입이 실패하였습니다.');
        })
      } else {
        alert('이미 가입된 이메일 이거나 비밀번호가 규칙에 맞지않습니다.');
      }
    },
    emailchange : function(){
      axios({
        method : 'post',
        url : 'checkemail.do',
        params : { email : this.email }
      }).then((response) => {
        this.emailcheck = response.data;
      }).catch((error) => {
        this.emailcheck = false;
      })
    },

    pwchange : function(){
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
.modal-mask {
  position: fixed;
  z-index: 9998;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, .5);
  display: table;
  transition: opacity .3s ease;
}

.modal-wrapper {
  display: table-cell;
  vertical-align: middle;
}

.modal-container {
  width: 600px;
  margin: 0px auto;
  padding: 20px 30px;
  background-color: #fff;
  border-radius: 2px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, .33);
  transition: all .3s ease;
  font-family: Helvetica, Arial, sans-serif;
  text-align: center;
}

.modal-header h3 {
  margin-top: 0;
  color: #42b983;
}

.modal-body {
  margin: 20px 0;
}

.modal-default-button {
  float: right;
}

/*
 * The following styles are auto-applied to elements with
 * transition="modal" when their visibility is toggled
 * by Vue.js.
 *
 * You can easily play with the modal transition by editing
 * these styles.
 */

.modal-enter {
  opacity: 0;
}

.modal-leave-active {
  opacity: 0;
}

.modal-enter .modal-container,
.modal-leave-active .modal-container {
  -webkit-transform: scale(1.1);
  transform: scale(1.1);
}
</style>
