<template lang="html">
  <div class="delivery">
    <br><br><br><br>
		<div class="container">
			<div class="row">
				<div class="col-lg-8 mx-auto text-center">
					<br><h1>배달 상세정보</h1><br>
					<table class="table table.hover">
						<tr>
							<td>배달번호</td>
							<td>{{this.$store.state.delivery.id}}</td>
							<td>발송자 </td>
							<td>{{this.$store.state.delivery.senderId}}</td>
						</tr>
						<tr>
							<td>수령자</td>
							<td>{{this.$store.state.delivery.receiverId}}</td>
							<td>배송자</td>
							<td>{{this.$store.state.delivery.delivererId}}</td>
						</tr>
						<tr>
							<td>발송위치</td>
							<td>{{this.$store.state.delivery.sendingLoc}}</td>
							<td>도착위치</td>
							<td>{{this.$store.state.delivery.receivingLoc}}</td>
						</tr>
						<tr>
							<td>발송시간</td>
							<td>{{this.$store.state.delivery.sendingDt}}</td>
							<td>도착시간</td>
							<td>{{this.$store.state.delivery.recevingDt}}</td>
						</tr>
						<tr>
              <td>금 액 :</td>
              <td>{{this.$store.state.delivery.chargeAmt}}</td>
							<td>발송방식 :</td>
							<td>{{this.$store.state.delivery.sendingType}}</td>
							<td>수령방식 :</td>
							<td>{{this.$store.state.delivery.receivingType}}</td>
						</tr>
					</table>
					<hr/>
					<br><h3>물품 정보</h3><br>
					<table class="table table.hover">
						<tr>
							<td>물품 타입</td>
							<td>{{this.$store.state.delivery.itemType}}</td>
							<td>물품 가로 </td>
							<td>{{this.$store.state.delivery.itemWidth}}</td>
							<td>물품 세로 </td>
							<td>{{this.$store.state.delivery.itemLength}}</td>
						</tr>
						<tr>
							<td>물품 높이 </td>
							<td>{{this.$store.state.delivery.itemHeight}}</td>
							<td>물품 무게 </td>
							<td>{{this.$store.state.delivery.itemWeight}}</td>
							<td>물품 가격 </td>
							<td>{{this.$store.state.delivery.itemValue}}</td>
						</tr>
					</table>

          <div v-if="this.$store.state.delivery.delivererId == 0">
            <div v-if="this.$store.state.delivery.senderId == this.$store.state.party.id">
              <b-container class="table table.hover" fluid>
                <h3>배송 신청자</h3>
                <b-row v-for="(party, index) in this.$store.state.delivery.delivererList" class="my-3">
                  <b-col sm="2">{{index}}</b-col>
                  <b-col sm="2">{{party.name}}</b-col>
                  <b-col sm="2">{{party.score}}</b-col>
                  <b-col sm="2">{{party.grade}}</b-col>
                  <b-col sm="2">{{party.securityDeposite}}</b-col>
                  <b-col sm="2"><b-button variant="success" v-on:click="selectDeliverer(party.id)">배송자 선택</b-button></b-col>
                </b-row>
              </b-container>
            </div>
          </div>

          <div v-if="this.$store.state.delivery.delivererId != 0">
            <b-btn v-b-toggle="'collapse1'" class="m-1">상대위치 지도확인</b-btn>
            <b-btn v-b-toggle="'collapse2'" class="m-1">채팅하기</b-btn>
            <b-collapse id="collapse1" v-on:show="startGetCoords" v-on:hide="stopGetCoords">
              <b-card>
                <gmap-map class="loading-overlay" v-if="this.$store.state.coords.lat != null" :center="{lat:this.$store.state.coords.lat, lng:this.$store.state.coords.lng}" :zoom="12" style="width:100%;  height: 400px;">
                  <gmap-marker v-if="this.senderLocation != null" :position="{lat:this.senderLocation.latitude, lng:this.senderLocation.longitude}"
                    :clickable="true" :label="{color : 'black', fontFamily: 'Nanum Gothic', fontWeight:'bold', text: '발송자'}"></gmap-marker>
                  <gmap-marker v-if="this.delivererLocation != null" :position="{lat:this.delivererLocation.latitude, lng:this.delivererLocation.longitude}"
                    :clickable="true" :label="{color : 'black', fontFamily: 'Nanum Gothic', fontWeight:'bold', text: '배송자'}"></gmap-marker>
                  <gmap-marker v-if="this.receiverLocation != null" :position="{lat:this.receiverLocation.latitude, lng:this.receiverLocation.longitude}"
                    :clickable="true" :label="{color : 'black', fontFamily: 'Nanum Gothic', fontWeight:'bold', text: '수령자'}"></gmap-marker>
                </gmap-map>
              </b-card>
            </b-collapse>
            <b-collapse id="collapse2" v-on:show="startChat" v-on:hide="stopChat">
              <b-card>
                <b-list-group>
                  <div id="chatarea">
                    <b-list-group-item v-for="(chat, index) in this.chatList" :key="index" class="d-flex justify-content-between align-items-center">
                      <b-col md="3">{{chat.cname}}</b-col>
                      <b-col md="8">{{chat.message}}</b-col>
                      <b-col md="3">{{chat.ctime}}</b-col>
                    </b-list-group-item>
                  </div>
                  <div class="input-group mb-3">
                    <input type="text" class="form-control" placeholder="채팅 입력" v-model="chatmessage" v-on:keyup.enter="doChat">
                    <div class="input-group-append">
                      <button class="btn" type="button" v-on:click="doChat">전송</button>
                    </div>
                  </div>
                </b-list-group>
              </b-card>
            </b-collapse>

  					<div v-if="this.$store.state.delivery.sendingVO != null">
  						<br><h3>접수 정보</h3><br>
  						<table class="table table.hover">
  							<tr>
  								<td>배송 번호</td>
  								<td>{{this.$store.state.delivery.sendingVO.id}}</td>
  								<td>배송자 </td>
  								<td></td>
  								<td>보낸 시각 </td>
  								<td>{{this.$store.state.delivery.sendingVO.sendingDt}}</td>
  							</tr>
  							<tr>
  								<td>접수자 확인</td>
  								<td>{{this.$store.state.delivery.sendingVO.senderConfirm}}</td>
  								<td>배송자 확인</td>
  								<td>{{this.$store.state.delivery.sendingVO.delivererConfirm}}</td>
  								<td>보안 정보 </td>
  								<td>{{this.$store.state.delivery.sendingVO.securityInfo}}</td>
  							</tr>
  						</table>
  						<b-button type="button" v-if="this.$store.state.delivery.sendingVO.senderConfirm == false && this.$store.state.party.id == this.$store.state.delivery.senderId"
                v-on:click="confirmSendingForSender" variant="primary">접수확인(발송자)</b-button>
  						<b-button type="button" v-if="this.$store.state.delivery.sendingVO.delivererConfirm == false && this.$store.state.party.id == this.$store.state.delivery.delivererId"
                v-on:click="confirmSendingForDeliverer" variant="primary">접수확인(배송자)</b-button>
  					</div>
  					<div v-if="this.$store.state.delivery.receivingVO != null">
  						<br><h3>수령 정보</h3><br>
  						<table class="table table.hover">
  							<tr>
  								<td>배송 번호</td>
  								<td>{{this.$store.state.delivery.receivingVO.id}}</td>
  								<td>배송자 </td>
  								<td></td>
  								<td>수령 시각 </td>
  								<td>{{this.$store.state.delivery.receivingVO.receivingDt}}</td>
  							</tr>
  							<tr>
  								<td>배송자 확인</td>
  								<td>{{this.$store.state.delivery.receivingVO.delivererConfirm}}</td>
  								<td>수령자 확인</td>
  								<td>{{this.$store.state.delivery.receivingVO.receiverConfirm}}</td>
  								<td>보안 정보 </td>
  								<td>{{this.$store.state.delivery.receivingVO.securityInfo}}</td>
  							</tr>
  						</table>
  						<b-button type="button" v-if="this.$store.state.delivery.receivingVO.delivererConfirm == false && this.$store.state.party.id == this.$store.state.delivery.delivererId"
                v-on:click="confirmReceivingForDeliverer" variant="primary">접수확인(배송자)</b-button>
  						<b-button type="button" v-if="this.$store.state.delivery.receivingVO.receiverConfirm == false && this.$store.state.party.id == this.$store.state.delivery.receiverId"
                v-on:click="confirmReceivingForReceiver" variant="primary">접수확인(수령자)</b-button>
  					</div>
            <div v-if="this.$store.state.delivery.receivingVO.receiverConfirm"><h1>배송 종료</h1></div>
          </div>
				</div>
			</div>
		</div>
    <br><br>
	</div>
</template>

<script>
export default {
  data : function(){
    return {
      chatmessage : '',
      chatList : [],
      testnumber : 1,
      chatInterval : null,
      coordsInterval : null,
      senderLocation : null,
      delivererLocation : null,
      receiverLocation : null
    }
  },
  beforeDestroy : function(){
    clearInterval(this.chatInterval);
    clearInterval(this.coordsInterval);
  },
  methods : {
    timeConvert : function(time){
      var date = new Date(time);
      return date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds();
    },
    startGetCoords : function(){
      this.coordsInterval = setInterval(this.requestCoords, 60000);
    },
    stopGetCoords : function(){
      clearInterval(this.coordsInterval);
    },
    requestCoords : function(){
      this.$http({
        method : 'post',
        url : 'getDeliveryCoords.do',
        params : {
          id : this.$store.state.delivery.id
        }
      }).then((response) => {
        this.senderLocation = response.data.sender;
        this.delivererLocation = response.data.deliverer;
        this.receiverLocation = response.data.receiver;
      }).catch((error) => {
        console.log(error);
      })
    },
    startChat : function(){
      this.chatInterval = setInterval(this.requestChat, 2000);
    },
    stopChat : function(){
      clearInterval(this.chatInterval);
    },
    doChat : function(){
      this.$http({
        method : 'post',
        url : 'chat.do',
        params : {
          deliveryId : this.$store.state.delivery.id,
          message : this.chatmessage
        }
      }).then((response) => {
        if(response.data==false){
          console.log("에러발생 채팅전송 실패");
        }
      }).catch((error) => {
        console.log(error);
        console.log("에러발생 채팅전송 실패");
      })
      this.chatmessage = '';
    },
    requestChat : function(){
      this.$http({
        method : 'post',
        url : 'getchatlist.do',
        params : {
          deliveryId : this.$store.state.delivery.id,
          id : this.chatList.length==0 ? 0 : this.chatList[this.chatList.length-1].id
        }
      }).then((response) => {
        var arr = response.data;
        for(var index in arr){
          if(arr[index].partyId==this.$store.state.delivery.senderId){
            arr[index].cname = '발송자';
          } else if(arr[index].partyId==this.$store.state.delivery.delivererId){
            arr[index].cname = '배송자';
          } else if(arr[index].partyId==this.$store.state.delivery.receiverId){
            arr[index].cname = '수령자';
          }
          arr[index].ctime = this.timeConvert(arr[index].regDt);
          this.chatList.push(arr[index]);
        }
      }).catch((error) => {
        console.log(error);
        console.log('에러발생 채팅받기 실패');
      })
    },
    selectDeliverer : function(pid){
      this.$http({
        method : 'post',
        url : 'setDeliverer.do',
        params : {
          id : this.$store.state.delivery.id,
          delivererId : pid
        }
      }).then((response) => {
        if(response.data!=null){
          this.$store.commit('setDelivery', response.data);
          alert('배송자 선택완료');
        }
      }).catch((error) => {
        console.log(error);
        alert('에러발생');
      })
    },
    confirmSendingForSender : function(){
      this.$http({
        method : 'post',
        url : 'confirmSendingForSender.do',
        params : { id : this.$store.state.delivery.id }
      }).then((response) => {
        if(response.data==true){
          this.$store.commit('setTrueSS');
          alert('발송자 확인이 완료되었습니다.');
        } else {
          alert('발송자 확인이 실패하였습니다.');
        }
      }).catch((error) => {
        console.log(error);
        alert('에러발생');
      })
    },
    confirmSendingForDeliverer : function(){
      this.$http({
        method : 'post',
        url : 'confirmSendingForDeliverer.do',
        params : { id : this.$store.state.delivery.id }
      }).then((response) => {
        if(response.data==true){
          this.$store.commit('setTrueSD');
          alert('배송자 확인이 완료되었습니다.');
        } else {
          alert('배송자 확인이 실패하였습니다.');
        }
      }).catch((error) => {
        console.log(error);
        alert('에러발생');
      })
    },
    confirmReceivingForDeliverer : function(){
      this.$http({
        method : 'post',
        url : 'confirmReceivingForDeliverer.do',
        params : { id : this.$store.state.delivery.id }
      }).then((response) => {
        if(response.data==true){
          this.$store.commit('setTrueRD');
          alert('배송자 확인이 완료되었습니다.');
        } else {
          alert('배송자 확인이 실패하였습니다.');
        }
      }).catch((error) => {
        console.log(error);
        alert('에러발생');
      })
    },
    confirmReceivingForReceiver : function(){
      this.$http({
        method : 'post',
        url : 'confirmReceivingForReceiver.do',
        params : { id : this.$store.state.delivery.id }
      }).then((response) => {
        if(response.data==true){
          this.$store.commit('setTrueRR');
          alert('수령자 확인이 완료되었습니다.');
        } else {
          alert('수령자 확인이 실패하였습니다.');
        }
      }).catch((error) => {
        console.log(error);
        alert('에러발생');
      })
    }
  }
}
</script>

<style lang="css">
#chatarea {
  height : 300px;
  overflow : auto;
}
</style>
