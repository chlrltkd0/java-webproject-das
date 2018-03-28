<template lang="html">
  <div id="testPage">
    <br><br><br><br>
    <b-card header="Test">
      <b-row align-h="center">
        <b-col md="1"><label>사용자ID</label></b-col>
        <b-col md="1"><b-form-input v-model="partyId" type="text"></b-form-input></b-col>
        <b-col md="2"><b-form-input id="sendingDt" v-model="date" type="date"/></b-col>
        <b-col md="2"><b-button class="my-1" v-on:click="dayAnalysis">특정사용자 특정날짜 분석</b-button></b-col>
      </b-row>
      <br>
      <b-row align-h="center">
        <b-col md="2"><label>모든 유저</label></b-col>
        <b-col md="2"><b-form-input id="sendingDt" v-model="date" type="date"/></b-col>
        <b-col md="2"><b-button class="my-1" v-on:click="dayAnalysisAll">특정날짜 분석</b-button></b-col>
      </b-row>
      <br>
      <b-row align-h="center">
        <b-col md="3"><b-form-select v-model="selected" :options="options" class="mb-3"></b-form-select></b-col>
        <b-col md="2"><b-button class="my-1" v-on:click="patternAnalysisAll">모든 사용자 패턴 설정</b-button></b-col>
      </b-row>
    </b-card>
    <b-card header="pushTest">
      <div class="chart-wrapper">
        <label for="partyId2">계정번호</label>
        <input id="partyId2" v-model="partyId2" type="text">
        <b-button class="my-1" v-on:click="sendPush">푸시 !</b-button><br>
      </div>
    </b-card>
  </div>

</template>

<script>
export default {
  data : function(){
    return {
      partyId : null,
      partyId2 : null,
      date : null,
      selected: null,
      options: [
        { value: null, text: '범위를 선택해 주세요' },
        { value: '7', text: '최근 일주일' },
        { value: '30', text: '최근 1달' },
        { value: '180', text: '최근 6달' },
        { value: '360', text: '최근 1년' }
      ]
    }
  },
  methods : {
    dayAnalysis : function(){
      this.$http({
        method : 'post',
        url : 'dayAnalysis.do',
        params : {
          date : this.date,
          partyId : this.partyId
        }
      }).then((response) => {
        if(response.data==true){
          alert('분석 완료')
        }
      }).catch((error) => {
        console.log(error);
      })
    },
    dayAnalysisAll : function(){
      this.$http({
        method : 'post',
        url : 'dayAnalysisAll.do',
        params : {
          date : this.date
        }
      }).then((response) => {
        if(response.data==true){
          alert('분석 완료')
        }
      }).catch((error) => {
        console.log(error);
      })
    },
    patternAnalysisAll : function(){
      this.$http({
        method : 'post',
        url : 'patternAnalysisAll.do',
        params : {
          range : this.selected
        }
      }).then((response) => {
        if(response.data==true){
          alert('분석 완료')
        }
      }).catch((error) => {
        console.log(error);
      })
    },
    sendPush : function(){
      this.$http({
        method : 'post',
        url : 'push.do',
        params : {
          id : this.partyId2
        }
      }).then((response) => {

      }).catch((error) => {
        console.log(error);
      })
    }
  }
}
</script>

<style lang="css">
</style>
