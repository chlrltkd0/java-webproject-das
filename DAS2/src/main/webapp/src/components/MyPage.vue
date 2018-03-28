<template lang="html">
  <div class="mx-auto center">
    <br><br><br><br><br><br>
    <!-- <b-row align-h="center">
      <b-col md="8">
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
                <b-form-input type="text" id="id" v-model="this.$store.state.party.id" disabled></b-form-input>
              </b-form-group>
            </b-col>
            <b-col sm="3">
              <label for="name">등급</label>
            </b-col>
            <b-col sm="3">
              <b-form-group>
                <b-form-input type="text" id="grade" v-model="this.$store.state.party.grade" disabled></b-form-input>
              </b-form-group>
            </b-col>
          </b-row>
          <b-row>
            <b-col sm="3">
              <label for="name">이름</label>
            </b-col>
            <b-col sm="9">
              <b-form-group>
                <b-form-input type="text" id="name" v-model="this.$store.state.party.name" disabled></b-form-input>
              </b-form-group>
            </b-col>
          </b-row>
          <b-row>
            <b-col sm="3">
              <label for="name">아이디</label>
            </b-col>
            <b-col sm="9">
              <b-form-group>
                <b-form-input type="text" id="loginId" v-model="this.$store.state.party.loginId" disabled></b-form-input>
              </b-form-group>
            </b-col>
          </b-row>
          <b-row>
            <b-col sm="3">
              <label for="name">비  번</label>
            </b-col>
            <b-col sm="9">
              <b-form-group>
                <b-form-input type="text" id="loginPwd" v-model="this.$store.state.party.loginPwd"></b-form-input>
              </b-form-group>
            </b-col>
          </b-row>
          <b-row>
            <b-col sm="3">
              <label for="name">캐  시</label>
            </b-col>
            <b-col sm="9">
              <b-form-group>
                <b-form-input type="text" id="cash" v-model="this.$store.state.party.cash" disabled></b-form-input>
              </b-form-group>
            </b-col>
          </b-row>
          <b-row>
            <b-col sm="3">
              <label for="name">점  수</label>
            </b-col>
            <b-col sm="9">
              <b-form-group>
                <b-form-input type="text" id="score" v-model="this.$store.state.party.score" disabled></b-form-input>
              </b-form-group>
            </b-col>
          </b-row>
          <b-row>
            <b-col sm="3">
              <label for="name">보증금</label>
            </b-col>
            <b-col sm="9">
              <b-form-group>
                <b-form-input type="text" id="securityDeposit" v-model="this.$store.state.party.securityDeposit" disabled></b-form-input>
              </b-form-group>
            </b-col>
          </b-row>
          <b-row>
            <b-col sm="3">
              <label for="name">가입일</label>
            </b-col>
            <b-col sm="9">
              <b-form-group>
                <b-form-input type="text" id="regDt" v-model="this.$store.state.party.regDt" disabled></b-form-input>
              </b-form-group>
            </b-col>
          </b-row>
          <b-row>
            <b-col sm="3">
              <label for="name">마지막</label>
            </b-col>
            <b-col sm="9">
              <b-form-group>
                <b-form-input type="text" id="lastLoginDt" v-model="this.$store.state.party.lastLoginDt" disabled></b-form-input>
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
    </b-row> -->
    <b-row  class="my-3" align-h="center">
      <b-col md="5">
        <b-card>
          <gmap-map class="loading-overlay" v-if="this.$store.state.coords.lat != null" :center="{lat:this.$store.state.coords.lat, lng:this.$store.state.coords.lng}" :zoom="12" style="width:100%;  height: 400px;">
            <gmap-polyline v-for="moving in this.movingList" :options="{strokeColor:'red', geodesic:true}" :path="[
              {lat: moving.fromStaying.location.latitude, lng: moving.fromStaying.location.longitude},
              {lat: moving.toStaying.location.latitude, lng: moving.toStaying.location.longitude}]">
            </gmap-polyline>
          </gmap-map>
        </b-card>
      </b-col>
      <b-col md="3">
        <b-card>
          <b-list-group>
            <b-list-group-item v-for="action in dayPathList" variant="light" class="flex-column align-items-start" href="#" v-on:click="">
              <div class="d-flex justify-content-between">
                <h4 v-if="action.toStaying==null"><span class="badge badge-danger">머뭄</span></h4>
                <h4 v-if="action.toStaying!=null"><span class="badge badge-primary">이동</span></h4>
                <h5><span>{{action.startTimeConvert}} ~ {{action.endTimeConvert}}</span></h5>
                <h5><span>{{action.time}}</span></h5>
              </div>
              <h6 v-if="action.location!=null" >{{action.location.address}}</h6>
            </b-list-group-item>
            <b-list-group-item class="flex-column align-items-start" v-on:click="">
              <b-row>
                <b-col md="8">
                  <b-form-input id="sendingDt" v-model="date" type="date"/>
                </b-col>
                <b-col md="4">
                  <b-button type="button" v-on:click="getDayPath">조회 하기</b-button>
                </b-col>
              </b-row>
            </b-list-group-item>
          </b-list-group>
        </b-card>
      </b-col>
    </b-row>
    <b-row align-h="center">
      <b-col md="8">
        <b-card>
          <b-row align-h="center">
            <b-col md="8">
            </b-col>
            <b-col md="3">
              <div>
                <b-form-select v-model="selected" :options="options" class="mb-3">
                </b-form-select>
             </div>
            </b-col>
            <b-col md="1">
              <div>
                <b-button v-on:click="getPatternList" class="mb-3">검색</b-button>
             </div>
            </b-col>
          </b-row>
          <b-row>
            <b-col>
              <b-list-group>
                <b-list-group-item variant="primary" class="flex-column align-items-start" href="#" v-on:click="">
                  <div class="d-flex justify-content-between">
                    <b-col md="4"><h4>출발지</h4></b-col>
                    <b-col md="1"><h4>~</h4></b-col>
                    <b-col md="4"><h4>도착지</h4></b-col>
                    <b-col md="1"><h4>횟수</h4></b-col>
                    <b-col md="2"><h4><span class="badge badge-primary">반복여부</span></h4></b-col>
                  </div>
                </b-list-group-item>
                <b-list-group-item v-for="pattern in patternList" variant="light" class="flex-column align-items-start" href="#" v-on:click="">
                  <div class="d-flex justify-content-between">
                    <b-col md="4"><h4>{{pattern.fromLocation.address}}</h4></b-col>
                    <b-col md="1"><h4>~</h4></b-col>
                    <b-col md="4"><h4>{{pattern.fromLocation.address}}</h4></b-col>
                    <b-col md="1"><h4>{{pattern.repeatCount}}</h4></b-col>
                    <b-col md="2">
                      <h4>
                        <span v-for="repeat in pattern.repeatList" class="badge badge-danger">{{repeat}}</span>
                      </h4>
                    </b-col>
                  </div>
                </b-list-group-item>
              </b-list-group>
            </b-col>
          </b-row>
        </b-card>
      </b-col>
    </b-row>
  </div>
</template>

<script>
export default {
  data : function(){
    return {
      date : null,
      movingList : null,
      dayPathList : null,
      patternList : null,
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
    timeConvert : function(time){
      var date = new Date(time);
      return date.getHours() + "시 " + date.getMinutes() + "분";
    },

    minuteConvert : function(time){
      return Math.round(time/60000) + "분";
    },
    getPatternList : function(){
      if(this.selected!=null){
        this.$http({
          method : 'post',
          url : 'getPatternList.do',
          params : {
            id : this.$store.state.party.id,
            range : this.selected
          }
        }).then((response) => {
          if(response.data!=null){
            this.patternList = response.data;
          }
        }).catch((error) => {
          console.log(error);
        })
      }
    },
    getDayPath : function(){
      console.log("getDayPath");
      this.$http({
        method : 'post',
        url : 'getDayPath.do',
        params : {
          id : this.$store.state.party.id,
          date : this.date
        }
      }).then((response) => {
        console.log('then');
        this.dayPathList = [];
        this.movingList = null;
        if(response.data!=''){
          this.dayPathList = [],
          this.movingList = response.data;
          for(var i in this.movingList){
            if(i==0){
              this.movingList[i].fromStaying.startTimeConvert = this.timeConvert(this.movingList[i].fromStaying.startTime);
              this.movingList[i].fromStaying.endTimeConvert = this.timeConvert(this.movingList[i].fromStaying.endTime);
              this.movingList[i].fromStaying.time = this.minuteConvert(this.movingList[i].fromStaying.endTime - this.movingList[i].fromStaying.startTime);
              this.dayPathList.push(this.movingList[i].fromStaying);
            }
            this.movingList[i].startTimeConvert = this.timeConvert(this.movingList[i].startTime);
            this.movingList[i].endTimeConvert = this.timeConvert(this.movingList[i].endTime);
            this.movingList[i].time = this.minuteConvert(this.movingList[i].endTime - this.movingList[i].startTime);

            this.movingList[i].toStaying.startTimeConvert = this.timeConvert(this.movingList[i].toStaying.startTime);
            this.movingList[i].toStaying.endTimeConvert = this.timeConvert(this.movingList[i].toStaying.endTime);
            this.movingList[i].toStaying.time = this.minuteConvert(this.movingList[i].toStaying.endTime - this.movingList[i].toStaying.startTime);

            this.dayPathList.push(this.movingList[i]);
            this.dayPathList.push(this.movingList[i].toStaying);
          }
        }
      }).then((error) => {
        console.log(error);
      })
    }
  }
}
</script>

<style lang="css">

</style>
