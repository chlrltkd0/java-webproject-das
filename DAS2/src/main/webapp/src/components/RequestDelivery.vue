<template lang="html">
  <div class="RequestDelivery">
    <section id="board">
        <div class="container">
          <br><br>
            <h2 class="text-center text-uppercase text-secondary mb-0">배달 신청</h2>
            <hr class="star-dark mb-5">
            <div class="row">
              <div class="col-lg-8 mx-auto">
                <form>
                  <div class="control-group">
                    <b-form-input v-model="receiverLoginId" v-on:input="inputest" list="browsers"/>
                    <datalist id="browsers">
                      <option v-for="party in partyList">{{party.loginId}}</option>
                    </datalist>
                  </div>
                  <div style="padding: 8px; border: 1px solid gray; border-radius: 12px;" class="control-group">
                    <label>보내는 주소</label>
                    <div class="row">
                    	<div class="col-xs-2 col-md-2">
  				              <input type="text" class="form-control input-lg" id="inputSendingPostcode"  placeholder="우편번호">
  				            </div>
  				            <div class="col-xs-8 col-md-8">
  				              <input type="text" class="form-control input-lg" id="inputSendingLoc"  placeholder="주소">
  				            </div>
  				            <div class="col-xs-2 col-md-2">
  				              <b-button type="button" v-on:click="mapSearch('send')">주소찾기</b-button>
  				            </div>
                    </div>
                    <label>받는 주소</label>
                    <div class="row">
                    	<div class="col-xs-2 col-md-2">
  				              <input type="text" class="form-control input-lg" id="inputReceivingPostcode" placeholder="우편번호">
  				            </div>
  				            <div class="col-xs-8 col-md-8">
  				              <input type="text" class="form-control input-lg" id="inputReceivingLoc"  placeholder="주소">
  				            </div>
  				            <div class="col-xs-2 col-md-2">
  				              <b-button type="button" v-on:click="mapSearch('receive')">주소찾기</b-button>
  				            </div>
                    </div>
  				          <div id="wrap" align="center" style="display:none;border:1px solid;width:500px;height:300px;margin:5px 0;position:relative">
  					          <img src="//t1.daumcdn.net/localimg/localimages/07/postcode/320/close.png" id="btnFoldWrap" style="cursor:pointer;position:absolute;right:0px;top:-1px;z-index:1" v-on:click="foldDaumPostcode()" alt="접기 버튼">
  				          </div>
                  </div>
                  <div class="control-group my-3">
                    <div class="row">
                      <div class="col-xs-2 col-md-2">
  				              <label for="sendingDt">보낼시각</label>
  				            </div>
                    	<div class="col-xs-5 col-md-5">
  				              <b-form-input id="sendingDt" v-model="sendingDt" type="date"/>
  				            </div>
  				            <div class="col-xs-5 col-md-5">
  				              <b-form-input v-model="sendingTime" type="time"/>
  				            </div>
                    </div>
                  </div>
                  <div class="control-group my-3">
                    <div class="row">
                      <div class="col-xs-2 col-md-2">
                        <label for="receivingDt">받을시각</label>
                      </div>
                    	<div class="col-xs-5 col-md-5">
  				              <b-form-input v-model="receivingDt" type="date"/>
  				            </div>
  				            <div class="col-xs-5 col-md-5">
  				              <b-form-input v-model="receivingTime" type="time"/>
  				            </div>
                    </div>
                  </div>
                  <div class="control-group my-3">
                    <div class="row">
                      <div class="col-xs-4 col-md-4">
                        <b-form-input v-model="chargeAmt" type="text" placeholder="수수료"/>
                      </div>
                    	<div class="col-xs-4 col-md-4">
                        <b-form-select v-model="sendingType" :options="sendingOptions" class="mb-3">
                        </b-form-select>
  				            </div>
  				            <div class="col-xs-4 col-md-4">
                        <b-form-select v-model="receivingType" :options="receivingOptions" class="mb-3" />
  				            </div>
                    </div>
                  </div>
                  <h2 class="text-center text-uppercase text-secondary mb-0">물건 정보</h2>
            		  <hr class="star-dark mb-5">
            		  <div class="control-group">
                    <div class="col-xs-2 col-md-2">

                    </div>
                    <div class="form-group controls mb-0 pb-2">
                      <b-form-select v-model="itemType" :options="itemOptions" class="mb-3" />
                    </div>
                  </div>
                  <div class="control-group">
                    <div class="form-group controls mb-0 pb-2">
                      <input type="text" class="form-control" v-model="itemWidth" id="inputItemWidth" placeholder="가로" required="required" data-validation-required-message="가로을 입력해 주세요.">
                    </div>
                  </div>
                  <div class="control-group">
                    <div class="form-group controls mb-0 pb-2">
                      <input type="text" class="form-control" v-model="itemLenght" id="inputItemLenght" placeholder="세로" required="required" data-validation-required-message="세로을 입력해 주세요.">
                    </div>
                  </div>
                  <div class="control-group">
                    <div class="form-group controls mb-0 pb-2">
                      <input type="text" class="form-control" v-model="itemHeight" id="inputItemHeight" placeholder="높이" required="required" data-validation-required-message="높이을 입력해 주세요.">
                    </div>
                  </div>
                  <div class="control-group">
                    <div class="form-group controls mb-0 pb-2">
                      <input type="text" class="form-control" v-model="itemWeight" id="inputItemWeight" placeholder="무게" required="required" data-validation-required-message="무게을 입력해 주세요.">
                    </div>
                  </div>
                  <div class="control-group">
                    <div class="form-group controls mb-0 pb-2">
                      <input type="text" class="form-control" v-model="itemValue" id="inputItemValue" placeholder="가격" required="required" data-validation-required-message="가격을 입력해 주세요.">
                    </div>
                  </div>
                  <div class="form-group text-center">
                    <button type="button" class="btn btn-primary btn-xl" v-on:click="requestDeliveryProc" id="sendMessageButton">배송신청</button>
                    <button type="button" class="btn btn-danger btn-xl" v-on:click="gotoBack" id="sendMessageCancelButton">취소</button>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </section>
  </div>
</template>

<script>
export default {
  data : function(){
    return {
      receiverId : '',
      sendingDt : '',
      sendingTime : '',
      receivingDt : '',
      receivingTime : '',
      sendingType : '',
      receivingType : '',
      chargeAmt : '',
      itemType : '',
      itemWidth : '',
      itemHeight : '',
      itemLenght : '',
      itemWeight : '',
      itemValue : '',
      sendingOptions : [
        {value : null, text : '발송방식'},
        {value : '방문발송', text : '방문발송'},
        {value : '직접발송', text : '직접발송'}
      ],
      receivingOptions : [
        {value : null, text : '수령방식'},
        {value : '방문수령', text : '방문수령'},
        {value : '직접수령', text : '직접수령'}
      ],
      itemOptions : [
        {value : null, text : '아이템타입'},
        {value : '의류', text : '의류'},
        {value : '서류', text : '서류'},
        {value : '책', text : '책'},
        {value : '박스', text : '박스'},
        {value : '쇼핑백', text : '쇼핑백'},
        {value : '전자기기', text : '전자기기'},
        {value : '음식', text : '음식'}
      ],
      partyList : []
    }
  },
  methods : {
    inputest : function(){
      if(this.receiverLoginId.length>=2){
        this.$http({
          method : 'post',
          url : 'getReceiverList.do',
          params : {
            word : this.receiverLoginId
          }
        }).then((response) => {
          if(response.data!=null){
            this.partyList = response.data
          }
        }).catch((error) => {
          console.log(error);
          console.log('에러가 발생하였습니다.');
        })
      }
    },
    gotoBack : function(){
      this.$router.go(-1);
    },
    requestDeliveryProc : function(){
      var stime = new Date(this.sendingDt + " " + this.sendingTime).getTime();
      var rtime = new Date(this.receivingDt + " " + this.receivingTime).getTime();
      for(var index in this.partyList){
        if(this.receiverLoginId==this.partyList[index].loginId){
          this.receiverId = this.partyList[index].id;
        }
      }
      this.$http({
        method : 'post',
        url : 'requestdelivery.do',
        params : {
          receiverId : this.receiverId,
          sendingLoc : this.$store.state.temp.fromAddress,
          receivingLoc : this.$store.state.temp.toAddress,
          tmpSendingDt : stime,
          tmpReceivingDt : rtime,
          chargeAmt : this.chargeAmt,
          sendingType : this.sendingType,
          receivingType : this.receivingType,
          itemType : this.itemType,
          itemWidth : this.itemWidth,
          itemHeight : this.itemHeight,
          itemLenght : this.itemLenght,
          itemWeight : this.itemWeight,
          itemValue : this.itemValue
        }
      }).then((response) => {
        if(response.data==true){
          console.log("정상적으로 등록되었습니다.");
          this.$router.push("/");
        } else {
          console.log('실패하였습니다.');
        }
      }).catch((error) => {
        console.log(error);
        console.log('에러가 발생하였습니다.')
      })
    },
    foldDaumPostcode : function() {
      var element_wrap = document.getElementById('wrap');
      element_wrap.style.display = 'none';
    },
    mapSearch : function(option) {
      var element_wrap = document.getElementById('wrap');
    	// 현재 scroll 위치를 저장해놓는다.
    	var currentScroll = Math.max(document.body.scrollTop, document.documentElement.scrollTop);
    	new daum.Postcode({
    		shorthand: false,
    		oncomplete: (data) => {
    			// 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

    			// 각 주소의 노출 규칙에 따라 주소를 조합한다.
    			// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
    			var fullAddr = data.address; // 최종 주소 변수
    			var extraAddr = ''; // 조합형 주소 변수

    			// 기본 주소가 도로명 타입일때 조합한다.
    			if(data.addressType === 'R'){
    				//법정동명이 있을 경우 추가한다.
    				if(data.bname !== ''){
    					extraAddr += data.bname;
    				}
    				// 건물명이 있을 경우 추가한다.
    				if(data.buildingName !== ''){
    					extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
    				}
    				// 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
    				fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
    			}

    			// 우편번호와 주소 정보를 해당 필드에 넣는다.
    			if(option=='send'){
    				document.getElementById('inputSendingPostcode').value = data.zonecode; //5자리 새우편번호 사용
    				document.getElementById('inputSendingLoc').value = data.jibunAddress; // .value = fullAddr; 도로명주소
            this.$store.commit('setFromAddress', data.jibunAddress);
    			} else {
    				document.getElementById('inputReceivingPostcode').value = data.zonecode; //5자리 새우편번호 사용
    				document.getElementById('inputReceivingLoc').value = data.jibunAddress; // .value = fullAddr; 도로명주소
            this.$store.commit('setToAddress', data.jibunAddress);
    			}

    			// iframe을 넣은 element를 안보이게 한다.
    			// (autoClose:false 기능을 이용한다면, 아래 코드를 제거해야 화면에서 사라지지 않는다.)
    			element_wrap.style.display = 'none';

    			// 우편번호 찾기 화면이 보이기 이전으로 scroll 위치를 되돌린다.
    			document.body.scrollTop = currentScroll;
    		},
    		// 우편번호 찾기 화면 크기가 조정되었을때 실행할 코드를 작성하는 부분. iframe을 넣은 element의 높이값을 조정한다.
    		onresize : function(size) {
    			element_wrap.style.height = size.height+'px';
    		},
    		width : '100%',
    		height : '100%'
    	}).embed(element_wrap);

    	// iframe을 넣은 element를 보이게 한다.
    	element_wrap.style.display = 'block';
    }
  }
}
</script>

<style lang="css">

</style>
