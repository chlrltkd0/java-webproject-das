<template lang="html">
  <div class="mx-auto center">
    <br><br><br><br><br><br><br><br>
    <b-row align-h="center">
      <b-col md="4">
        <b-card>
          <div slot="header">
            <strong>개인 정보</strong>
          </div>
          <b-row>
            <b-col sm="3">
              <label for="name">번호</label>
            </b-col>
            <b-col sm="3">
              <b-form-group>
                <b-form-input type="text" id="id" v-model="party.id" disabled></b-form-input>
              </b-form-group>
            </b-col>
            <b-col sm="3">
              <label for="name">등급</label>
            </b-col>
            <b-col sm="3">
              <b-form-group>
                <b-form-input type="text" id="grade" v-model="party.grade"></b-form-input>
              </b-form-group>
            </b-col>
          </b-row>
          <b-row>
            <b-col sm="3">
              <label for="name">이름</label>
            </b-col>
            <b-col sm="9">
              <b-form-group>
                <b-form-input type="text" id="name" v-model="party.name"></b-form-input>
              </b-form-group>
            </b-col>
          </b-row>
          <b-row>
            <b-col sm="3">
              <label for="name">아이디</label>
            </b-col>
            <b-col sm="9">
              <b-form-group>
                <b-form-input type="text" id="loginId" v-model="party.loginId" disabled></b-form-input>
              </b-form-group>
            </b-col>
          </b-row>
          <b-row>
            <b-col sm="3">
              <label for="name">비  번</label>
            </b-col>
            <b-col sm="9">
              <b-form-group>
                <b-form-input type="text" id="loginPwd" v-model="party.loginPwd"></b-form-input>
              </b-form-group>
            </b-col>
          </b-row>
          <b-row>
            <b-col sm="3">
              <label for="name">캐  시</label>
            </b-col>
            <b-col sm="9">
              <b-form-group>
                <b-form-input type="text" id="cash" v-model="party.cash"></b-form-input>
              </b-form-group>
            </b-col>
          </b-row>
          <b-row>
            <b-col sm="3">
              <label for="name">점  수</label>
            </b-col>
            <b-col sm="9">
              <b-form-group>
                <b-form-input type="text" id="score" v-model="party.score"></b-form-input>
              </b-form-group>
            </b-col>
          </b-row>
          <b-row>
            <b-col sm="3">
              <label for="name">보증금</label>
            </b-col>
            <b-col sm="9">
              <b-form-group>
                <b-form-input type="text" id="securityDeposit" v-model="party.securityDeposit"></b-form-input>
              </b-form-group>
            </b-col>
          </b-row>
          <b-row>
            <b-col sm="3">
              <label for="name">가입일</label>
            </b-col>
            <b-col sm="9">
              <b-form-group>
                <b-form-input type="text" id="regDt" v-model="party.regDt" disabled></b-form-input>
              </b-form-group>
            </b-col>
          </b-row>
          <b-row>
            <b-col sm="3">
              <label for="name">마지막</label>
            </b-col>
            <b-col sm="9">
              <b-form-group>
                <b-form-input type="text" id="lastLoginDt" v-model="party.lastLoginDt" disabled></b-form-input>
              </b-form-group>
            </b-col>
          </b-row>
          <b-row align-h="center">
            <b-col sm="3">
              <b-button variant="primary" v-on:click="updatePartyInfo">수정하기</b-button>
            </b-col>
            <b-col sm="3">
              <b-button variant="primary">갱신하기</b-button>
            </b-col>
          </b-row>
        </b-card>
      </b-col>
      <b-col md="6">
        <b-card>
          <b-table v-if="partyList" :fields="fields" :items="partyList.partyList" v-on:click="">
            <template slot="id" slot-scope="data">
              <div v-on:click="getPartyInfo(data.value)">{{data.value}}</div>
            </template>
          </b-table>
          <div id="paging">
            <b-pagination v-if="partyList" align="center" size="md" :total-rows="partyList.partyCount" v-on:change="getPartyInfoList" :per-page="10" limit="10">
            </b-pagination>
          </div>
        </b-card>
      </b-col>
    </b-row>
  </div>
</template>

<script>
export default {
  data : function() {
    return {
      party : {
        id : null,
        name : null,
        loginId : null,
        loginPwd : null,
        cash : null,
        grade : null,
        score : null,
        securityDeposit : null,
        regDt : null,
        lastLoginDt : null
      },
      partyList : null,
      fields: ['id', 'name', 'loginId',  'grade',  'score']
    }
  },
  created : function(){
    this.getPartyInfoList(1);
  },
  methods : {
    getPartyInfo : function(data){
      this.$http({
        method : 'post',
        url : 'getPartyInfo.do',
        params : { id : data },
      }).then((response) => {
        this.party = response.data;
      }).catch((error) => {
        console.log(error);
      })
    },
    getPartyInfoList : function(data){
      this.$http({
        method : 'post',
        url : 'getPartyInfoList.do',
        params : { page : data }
      }).then((response) => {
        this.partyList = response.data;
      }).catch((error) => {
        console.log(error);
      })
    },
    updatePartyInfo : function(){
      this.$http({
        method : 'post',
        url : 'updatePartyInfo.do',
        params : {
          id : this.party.id,
          name : this.party.name,
          loginId : this.party.loginId,
          loginPwd : this.party.loginPwd,
          cash : this.party.cash,
          grade : this.party.grade,
          score : this.party.score,
          securityDeposit : this.party.securityDeposit
        }
      }).then((response) => {
        if(response.data==false){
          alert('실패');
        };
      }).catch((error) => {
        console.log(error);
      })
    }
  }

}
</script>

<style lang="css">
</style>
