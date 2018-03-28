<template lang="html">
  <div id="testPage">
    <br><br><br><br>
    <b-card header="Test">
      <div class="chart-wrapper">
        <label for="partyId">계정번호</label>
        <input id="partyId" v-model="partyId" type="text">
        <b-button class="my-1" v-on:click="moveGenerate">테스트 무빙조건 생성</b-button><br>
        <b-button class="my-1" v-on:click="doAnalysis">현재까지 모든 무빙테이터 패턴 분석</b-button>
      </div>
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
      partyId2 : null
    }
  },
  methods : {
    doAnalysis : function(){
      this.$http({
        method : 'post',
        url : 'analysis.do'
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
