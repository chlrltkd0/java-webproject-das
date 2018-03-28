<template lang="html">
  <div class="loading-overlay">
    <div class="wrapperDiv">

  	<div class="leftDiv">
      <gmap-map class="loading-overlay" v-if="this.$store.state.coords.lat != null" :center="{lat:this.$store.state.coords.lat, lng:this.$store.state.coords.lng}" :zoom="12">

        <gmap-marker :position="{lat:this.$store.state.coords.lat, lng:this.$store.state.coords.lng}"
          :clickable="true" :label="{color : 'black', fontFamily: 'Nanum Gothic', fontWeight:'bold', text: '내위치'}"></gmap-marker>

        <gmap-marker :key="index" v-for="(delivery, index) in this.$store.state.deliverylist" :position="{lat:delivery.sendingLatitude, lng:delivery.sendingLongitude}"
          :clickable="true" :label="{color : 'black', fontFamily: 'Nanum Gothic', fontWeight:'bold', text: '시작'}" v-on:click="drawDeliveryPath(delivery)"></gmap-marker>

        <gmap-marker :key="index" v-for="(delivery, index) in this.$store.state.deliverylist" :position="{lat:delivery.receivingLatitude, lng:delivery.receivingLongitude}"
          :clickable="true" :label="{color : 'black', fontFamily: 'Nanum Gothic', fontWeight:'bold', text: '도착'}" v-on:click="drawDeliveryPath(delivery)"></gmap-marker>

          <gmap-polyline v-for="pattern in this.$store.state.patternlist" :options="{strokeColor:'green', geodesic:true}" :path="[
            {lat: pattern.fromNode.location.latitude, lng: pattern.fromNode.location.longitude},
            {lat: pattern.toNode.location.latitude, lng: pattern.toNode.location.longitude}]">
          </gmap-polyline>

          <gmap-polyline  v-if="this.delivery != null" v-bind:options="{strokeColor : 'red'}"
           :path="[{lat: this.delivery.sendingLatitude, lng: this.delivery.sendingLongitude}, {lat: this.delivery.receivingLatitude, lng: this.delivery.receivingLongitude}]">
          </gmap-polyline>

          <gmap-circle v-for="pattern in this.$store.state.patternlist" :options="{fillOpacity:0.1}" :center="{lat: pattern.fromNode.location.latitude, lng: pattern.fromNode.location.longitude}" :radius="radius"></gmap-circle>
          <gmap-circle v-for="pattern in this.$store.state.patternlist" :options="{fillOpacity:0.1}" :center="{lat: pattern.toNode.location.latitude, lng: pattern.toNode.location.longitude}" :radius="radius"></gmap-circle>
      </gmap-map>
  	</div>

  	<div class="rightDiv">
      <br><br>

      <b-button type="button" class="my-1" variant="warning" v-on:click="getDeliveryAll">배달 전체</b-button>
      <b-button type="button" class="my-1" variant="warning" v-on:click="getDeliveryInMyPattern">이동패턴 안 배달</b-button><br>
      <label for="fromAddress">출발지  </label><input type="text" @keyup.enter="getDeliveryForSearch" v-model="fromAddress" id="fromAddress" class="my-1" /><br>
      <label for="toAddress">도착지  </label><input type="text" @keyup.enter="getDeliveryForSearch" v-model="toAddress" id="toAddress" class="my-1" /><br>
      <b-button type="button" class="my-1" variant="warning" v-on:click="getDeliveryForSearch">검  색</b-button>     <b-button type="button" class="my-1" variant="warning" v-on:click="getdelivery">세부검색</b-button>
      <b-button type="button" class="my-1" variant="warning" v-on:click="removeAllMarker">X</b-button><br>
      <DeliveryModal v-if="showDeliveryModal" v-on:close="showDeliveryModal = false"></DeliveryModal>

      <b-list-group>
        <b-list-group-item href="#" active class="flex-column align-items-start">
          <div class="d-flex w-100 justify-content-between">
            <h6 class="mb-1">시작위치</h6>
            <h6 class="mb-1">도착위치</h6>
          </div>
          </p>
        </b-list-group-item>

        <b-list-group-item v-for="(delivery, index) in this.$store.state.deliverylist" href="#" class="flex-column align-items-start" v-on:click="drawDeliveryPath(delivery)">
          <div class="d-flex justify-content-between">
            <small class="text-muted mb-3">{{delivery.sendingDt}} ~ {{delivery.receivingDt}}</small>
            <b-button type="button" class="my-3" size="sm" variant="outline-success" v-on:click="gotoDeliveryModal(delivery.id)">상세보기</b-button>
          </div>
          <h6 class="mb-3 "><span class="badge badge-primary">출발</span>{{delivery.sendingLoc.substr(delivery.sendingLoc.indexOf(' '))}}</h6>
          <h6 class="mb-3 "><span class="badge badge-primary">도착</span>{{delivery.receivingLoc.substr(delivery.receivingLoc.indexOf(' '))}}</h6>
          <span class="badge badge-warning">도착</span>{{delivery.chargeAmt}}
        </b-list-group-item>
      </b-list-group>
  	  </div>
    </div>
  </div>
</template>


<script>
import deliveryModal from './DeliveryModal.vue'

export default {
  data : function(){
    return {
      showDeliveryModal : false,
      radius : 1000,
      toAddress : null,
      fromAddress : null,
      delivery : null
    }
  },
  methods : {
    gotoDeliveryModal : function(id){
      this.$store.dispatch('getDelivery', id)
      this.showDeliveryModal = true;
    },
    drawDeliveryPath : function(delivery){
      this.delivery = delivery;
    },
    getDeliveryAll : function(){
      this.$store.dispatch('getDeliveryListForDelivery', null);
    },
    getDeliveryInMyPattern : function(){
      this.$store.dispatch('getPatternListInMyPattern');
    },
    getDeliveryForSearch : function(){
      this.$store.dispatch('getDeliveryListForDelivery', {
        sendingLoc : this.fromAddress,
        receivingLoc : this.toAddress
      });
    },
    removeAllMarker : function(){
      this.$store.commit('setDeliveryList', null);
    }
  },
  components : {
    DeliveryModal : deliveryModal
  }
}
</script>

<style lang="css">
html, body {
	margin: 0;
	padding: 0;
	width: 100%;
	height: 100%;
	/* font-size: 12px; */
}
.wrapperDiv {
	width: 100%;
	height: 100%;
}
.leftDiv {
	position: absolute;
	width: auto;
	height: auto;
	top: 80px;
	right: 0px;
	bottom: 0px;
	left: 0px;
	margin-right: 300px;
	overflow: auto;
}
.rightDiv {
	position: absolute;
	top: 80px;
	right: 0;
	width: 300px;
	height: 92%;
  overflow-y: auto;
}
.loading-overlay{
  width:100%;
  height:100%;
}
</style>
