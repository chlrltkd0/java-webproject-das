<template lang="html">
  <transition name="modal">
      <div class="modal-mask">
        <div class="modal-wrapper">
          <div class="modal-container">
            <div class="modal-header">
              <slot name="header">
                <h1>로그인</h1>
              </slot>
            </div>
            <div class="modal-body">
              <b-container fluid>
                <b-row class="my-2">
                  <b-col sm="3"><label for="input-email">아이디</label></b-col>
                  <b-col sm="9">
                    <b-form-input id="input-email" v-model="email" type="email" placeholder=""></b-form-input>
                  </b-col>
                </b-row>
                <b-row class="my-3">
                  <b-col sm="3"><label for="input-pw">비밀번호</label></b-col>
                  <b-col sm="9">
                    <b-form-input id="input-pw" v-model="password" type="password" placeholder=""></b-form-input>
                  </b-col>
                </b-row>
              </b-container>
              <slot name="body">
              </slot>
            </div>
            <div class="modal-footer">
              <slot name="footer">
                <b-button class="modal-default-button" variant="success" v-on:click="login">
                  로그인
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
  data : function() {
    return {
      email: '',
      password: ''
    }
  },
  methods : {
    login : function(){
      axios({
        method : 'post',
        url : 'login.do',
        params : {
          email : this.email,
          password : this.password
        }
      }).then((response) => {
        if(response.data==""){
          alert('아이디 비밀번호가 올바르지 않습니다.')
        } else {
          this.$store.commit('setuserinfo', response.data);
          this.$router.push('/');
          this.$emit('close');
          axios({
            method : 'post',
            url : 'getBoardCategoryList.do'
          }).then((response) => {
            console.log(response.data);
            this.$store.commit('setboardcategorys', response.data);
          }).catch((error) => {
            console.log(error);
            alert('서버측 문제로 홈페이지 정보를 제대로 받아오지 못했습니다.');
          })
        }
      }).catch(function(error){
        console.log(error)
        alert('서버측 에러로 로그인 할 수 없습니다.')
      })
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
