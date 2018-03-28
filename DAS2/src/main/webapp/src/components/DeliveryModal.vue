<template lang="html">
  <transition name="modal">
      <div class="modal-mask">
        <div class="modal-wrapper">
          <div class="modal-container">
            <div class="modal-header">
              <slot name="header">
                <h1>배달 상세 정보</h1>
              </slot>
            </div>
            <div class="modal-body">
              <b-container fluid>
                <b-row class="my-3">
                  <b-col md="3">배달번호</b-col>
                  <b-col md="3">{{this.$store.state.delivery.id}}</b-col>
                  <b-col md="3">발송자</b-col>
                  <b-col md="3">{{this.$store.state.delivery.senderId}}</b-col>
                </b-row>
                <b-row class="my-3">
                  <b-col md="3">수령자</b-col>
                  <b-col md="3">{{this.$store.state.delivery.receiverId}}</b-col>
                  <b-col md="3">배송자</b-col>
                  <b-col md="3">{{this.$store.state.delivery.delivererId}}</b-col>
                </b-row>
                <b-row class="my-3">
    							<b-col md="3">발송위치</b-col>
    							<b-col md="9">{{this.$store.state.delivery.sendingLoc}}</b-col>
                </b-row>
                <b-row class="my-3">
    							<b-col md="3">도착위치</b-col>
    							<b-col md="9">{{this.$store.state.delivery.receivingLoc}}</b-col>
    						</b-row>
    						<b-row class="my-3">
    							<b-col md="3">발송시간</b-col>
    							<b-col md="3">{{this.$store.state.delivery.sendingDt}}</b-col>
    							<b-col md="3">도착시간</b-col>
    							<b-col md="3">{{this.$store.state.delivery.recevingDt}}</b-col>
    						</b-row>
    						<b-row class="my-3">
                  <b-col md="2">금액 :</b-col>
                  <b-col md="2">{{this.$store.state.delivery.chargeAmt}}</b-col>
    							<b-col md="2">발송방식 :</b-col>
    							<b-col md="2">{{this.$store.state.delivery.sendingType}}</b-col>
    							<b-col md="2">수령방식 :</b-col>
    							<b-col md="2">{{this.$store.state.delivery.receivingType}}</b-col>
    						</b-row>
                <h2>물품 정보</h2>
                <b-row class="my-3">
    							<b-col md="2">물품 타입</b-col>
    							<b-col md="2">{{this.$store.state.delivery.itemType}}</b-col>
    							<b-col md="2">물품 가로 </b-col>
    							<b-col md="2">{{this.$store.state.delivery.itemWidth}}</b-col>
    							<b-col md="2">물품 세로 </b-col>
    							<b-col md="2">{{this.$store.state.delivery.itemLength}}</b-col>
    						</b-row>
    						<b-row class="my-3">
    							<b-col md="2">물품 높이 </b-col>
    							<b-col md="2">{{this.$store.state.delivery.itemHeight}}</b-col>
    							<b-col md="2">물품 무게 </b-col>
    							<b-col md="2">{{this.$store.state.delivery.itemWeight}}</b-col>
    							<b-col md="2">물품 가격 </b-col>
    							<b-col md="2">{{this.$store.state.delivery.itemValue}}</b-col>
    						</b-row>
              </b-container>
            </div>
            <div class="modal-footer fluid">
              <b-button v-if="this.$store.state.delivery.delivererList == null || this.$store.state.delivery.delivererList.length == 0"
                variant="success" v-on:click="applyForDeliverer">
                배송자 신청
              </b-button>
              <span v-if="this.$store.state.delivery.delivererList != null && this.$store.state.delivery.delivererList.length!=0"
                class="badge badge-success"><h3>이미 신청하셨습니다.</h3></span>
              <b-button class="modal-default-button" variant="danger" v-on:click="$emit('close')">
                취소
              </b-button>
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

    }
  },
  methods : {
    applyForDeliverer : function(){
      this.$store.dispatch('applyForDeliverer', this.$store.state.delivery.id);
      this.$emit('close');
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
  width: 40%;
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
