<template lang="html">
  <div id="testPage">
    <br><br><br><br>
    <b-card header="Test">
      <b-row align-h="center">
        <b-col md="1">
          <label>사용자ID</label>
        </b-col>
        <b-col md="1">
          <div>
            <b-form-input v-model="partyId" type="text"></b-form-input>
          </div>
        </b-col>
        <b-col md="2">
          <b-form-input id="sendingDt" v-model="date" type="date"/>
        </b-col>
        <b-col md="2">
          <b-button class="my-1" v-on:click="doAnalysis">특정사용자 특정날짜 분석</b-button>
        </b-col>
      </b-row>

      <b-button class="my-1" v-on:click="moveGenerate">테스트 무빙조건 생성</b-button><br>
      <b-button class="my-1" v-on:click="doAnalysis">현재까지 모든 무빙테이터 패턴 분석</b-button>
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
      selected: null
    }
  },
  methods : {
    doAnalysis : function(){
      this.$http({
        method : 'post',
        url : 'analysis.do',
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
    moveGenerate : function(){
      this.$http({
        method : 'post',
        url : 'moveGenerate.do',
        params : {
          id : this.partyId
        }
      }).then((response) => {
        if(response.data==true){
          alert('생성 성공');
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
