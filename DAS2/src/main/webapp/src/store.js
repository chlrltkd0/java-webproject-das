import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex);

export const store = new Vuex.Store({
  state : {
    pushdata : {
      endpoint : '',
      p256dh : '',
      auth : ''
    },
    temp : {
      toAddress : '',
      fromAddress : ''
    },
    coords : {
      lat : null,
      lng : null
    },
    party : null,
    deliverylist : null,
    delivery : null,
    patternlist : null,
    boardList : null,
    board : null,
    boardCategorys : null,
    chart : {
      deliveryvolume : {
        data : [200, 400, 600, 200, 300, 80, 40],
        labels : []
      }
    }
  },

  mutations : {
    setData : function(state){
      state.chart.deliveryvolume.data[0] = 100;
    },
    setToAddress : function(state, payload){
      state.temp.toAddress = payload;
    },
    setFromAddress : function(state, payload){
      state.temp.fromAddress = payload;
    },
    setParty : function(state, payload){
      state.party = payload;
    },
    setDeliveryList : function(state, payload){
      state.deliverylist = payload;
    },
    setDelivery : function(state, payload){
      state.delivery = payload;
    },
    setTrueSS : function(state){
      state.delivery.sendingVO.senderConfirm = true;
    },
    setTrueSD : function(state){
      state.delivery.sendingVO.delivererConfirm = true;
    },
    setTrueRD : function(state){
      state.delivery.receivingVO.delivererConfirm = true;
    },
    setTrueRR : function(state){
      state.delivery.receivingVO.receiverConfirm = true;
    },
    setPatternList : function(state, payload){
      state.patternlist = payload;
    },
    setLocation : function(state, payload){
      state.coords.lat = payload.latitude;
      state.coords.lng = payload.longitude;
    },
    setBoardList : function(state, payload){
      return state.boardList = payload;
    },
    setCurrentPage : function(state, payload){
      state.boardList.page = payload;
    },
    setBoard : function(state, payload){
      state.board = payload;
    },
    setBoardCategorys : function(state, payload){
      state.boardCategorys = payload;
    }
  },
  actions : {
    setCoords : function(context){
      if(navigator.geolocation){
        console.log(navigator.geolocation);
        navigator.geolocation.getCurrentPosition(
          (position) => {
            console.log(position);
          context.commit('setLocation', position.coords);
          console.log(1234);
          },
          (error) => {
            console.log(error);
            context.commit('setLocation', {latitude:37.5533118, longitude:126.9705856});
            // alert('GPS에서 오류가 발생하였습니다. - default 서울역 세팅');
          })
      } else {
        context.commit('setLocation', {latitude:37.5533118, longitude:126.9705856});
        alert('GPS를 지원히지 않습니다. - default 서울역 세팅');
      }
    },
    getDeliveryList : function(context, param){
      axios({
        method : 'post',
        url : 'deliverylist.do',
        params : param
      }).then((response) => {
        context.commit('setDeliveryList', response.data);
      }).catch((error) => {
        console.log(error);
        alert('값을 제대로 가져오지 못했습니다.');
      });
    },
    getDeliveryListForDelivery : function(context, param){
      axios({
        method : 'post',
        url : 'deliverylistfordelivery.do',
        params : param
      }).then((response) => {
        context.commit('setDeliveryList', response.data);
      }).catch((error) => {
        console.log(error);
        alert('값을 제대로 가져오지 못했습니다.');
      });
    },
    getDeliveryListForWaitDeliverer : function(context){
      axios({
        method : 'post',
        url : 'deliverylistforwaitdeliverer.do'
      }).then((response) => {
        context.commit('setDeliveryList', response.data);
      }).catch((error) => {
        console.log(error);
        alert('값을 제대로 가져오지 못했습니다.');
      });
    },
    getPatternList : function(context) {
      axios({
        method : 'post',
        url : 'patternlist.do'
      }).then((response) => {
        context.commit('setPatternList', response.data);
      }).catch((error) => {
        console.log(error);
        alert('값을 제대로 가져오지 못했습니다.');
      });
    },
    getPatternListInMyPattern : function(context){
      axios({
        method : 'post',
        url : 'deliveryInMyPattern.do'
      }).then((response) => {
        context.commit('setDeliveryList', response.data);
      }).catch((error) => {
        console.log(error);
        alert('값을 제대로 가져오지 못했습니다.');
      });
    },
    logout : function(context) {
      axios({
        method : 'post',
        url : 'logout.do'
      }).then(function(){});
      context.commit('setParty', null);
    },
    applyForDeliverer : function(context, param){
      axios({
        method : 'post',
        url : 'applyForDeliverer.do',
        params : {
          id : param
        }
      }).then((response) => {
        if(response.data==true){
          alert('배송자 신청이 완료되었습니다.');
        }
      }).catch((error) => {
        console.log(error);
        alert('값을 제대로 가져오지 못했습니다.');
      });
    },
    getDelivery : function(context, param){
      axios({
        method : 'post',
        url : 'delivery.do',
        params : { id : param }
      }).then((response) => {
        if(response.data != null){
          context.commit('setDelivery', response.data);
        } else {
          alert('그런값이 없습니다.')
        }
      }).catch((error) => {
        console.log(error);
        alert('값을 제대로 가져오지 못했습니다.');
      })
    },
    sendPushData : function(context, param){
      axios({
        method : 'post',
        url : 'setPushData.do',
        params : {
          endPoint : context.state.pushdata.endpoint,
          p256dh : context.state.pushdata.p256dh,
          auth : context.state.pushdata.auth
        }
      }).then((response) => {

      }).catch((error) => {
        console.log(error);
        alert('값을 제대로 가져오지 못했습니다.');
      })
    },
    getBoardList : function(context, payload){
      axios({
        method : 'post',
        url : 'getBoardList.do',
        params : {
          categoryIdx : payload.categoryIdx,
          keyword : payload.keyword,
          page : payload.page
        }
      }).then((response) => {
        context.commit('setBoardList', response.data);
      })
    }
  }
})
