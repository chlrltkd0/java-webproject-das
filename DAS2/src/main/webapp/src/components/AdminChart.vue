<template lang="html">
  <div class="animated fadeIn">
    <br><br><br><br>
      <b-card-group>
        <b-card header="지역별 배송 횟수">
          <div class="chart-wrapper">
            <pie-example :chart-data="pieChartData"/>
            <br>
            <b-row class="my-3 d-flex justify-content-between">
              <b-col sm="8"><b-form-select v-model="pieSelected" :options="pieOptions" class="mb-3" /></b-col>
              <b-col sm="4"><b-button type="button" v-on:click="getLocationRanking">검색</b-button></b-form-input></b-col>
            </b-row>
          </div>
        </b-card>
        <b-card header="수익">
          <div class="chart-wrapper">
            <line-example :chart-data="lineChartData"/>
            <b-container fluid>
               <b-row class="my-3 d-flex justify-content-between">
                 <b-col sm="5"><b-form-input v-model="line.start" type="date"></b-form-input></b-col>
                 <b-col sm="5"><b-form-input v-model="line.end" type="date"></b-form-input></b-col>
                 <b-col sm="2"><b-button type="button" v-on:click="getSales">검색</b-button></b-col>
               </b-row>
             </b-container>
          </div>
        </b-card>
        <b-card header="배송 횟수">
          <div class="chart-wrapper">
            <bar-example :chart-data="barChartData"/>
          </div>
          <b-row class="my-3 d-flex justify-content-between">
            <b-col sm="8"><b-form-select v-model="barSelected" :options="barOptions" class="mb-3" /></b-col>
            <b-col sm="4"><b-button type="button" v-on:click="getDeliveryVolume">검색</b-button></b-form-input></b-col>
          </b-row>
        </b-card>
      </b-card>
      </b-card-group>
    </div>
</template>

<script>
import BarExample from './charts/BarExample'
import LineExample from './charts/LineExample'
import PieExample from './charts/PieExample'

export default {
  data : function(){
    return {
      line : {
        start : null,
        end : null
      },
      pieSelected : null,
      pieOptions: [
        { value: null, text: '선택하세요' },
        { value: '1', text: '국가' },
        { value: '2', text: '시' },
        { value: '3', text: '구'},
        { value: '4', text: '동'},
        { value: '5', text: '상세주소1'},
        { value: '6', text: '상세주소2'}
      ],
      barSelected : null,
      barOptions: [
        { value: null, text: '선택하세요' },
        { value: '1', text: '요일별' },
        { value: '2', text: '월별' }
      ],
      lineChartData : {
        labels: [],
        datasets: [
          {
            label: '수익',
            backgroundColor: 'red',
            data: []
          }
        ]
      },
      barChartData : {
        labels: ['월요일', '화요일', '수요일', '목요일', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'],
        datasets: [
          {
            label: '거 래 량',
            backgroundColor: '#f87000',
            data: [40, 20, 12, 39, 10, 40, 39, 80, 40, 20, 12, 1]
          }
        ]
      },
      pieChartData : {
        labels: ['서울', '부산', '대구', '광주','남원','용인'],
        datasets: [
          {
            backgroundColor: [
              '#dba34e',
              '#dc714a',
              '#968e86',
              '#76b3e0',
              '#a9ab5f',
              '#5c584f'
            ],
            data: [430, 206, 808, 180,100,100]
          }
        ]
      }
    }
  },
  methods : {
    getSales : function(){
      var getLabels = [];
      var getData = [];
      this.$http({
        method : 'post',
        url : 'getSales.do',
        params : {
          startDate : this.line.start,
          endDate : this.line.end
        }
      }).then((response) => {
        console.log(response.data);
        for(var index in response.data){
          getLabels.push(response.data[index].key);
          getData.push(response.data[index].value.toString());
          this.lineChartData = {
            labels: getLabels,
            datasets: [
              {
                label: '배달 완료 량',
                backgroundColor: '#f87979',
                data: getData
              }
            ]
          }
        }
      }).catch((error) => {
        console.log(error);
      })
    },
    getDeliveryVolume : function(){
      var getLabels = [];
      var getData = [];
      this.$http({
        method : 'post',
        url : 'getDeliveryVolume.do',
        params : {
          option : this.barSelected
        }
      }).then((response) => {
        console.log(response.data);
        for(var index in response.data){
          getLabels.push(response.data[index].key);
          getData.push(response.data[index].value.toString());
          this.barChartData = {
            labels: getLabels,
            datasets: [
              {
                label: '수익',
                backgroundColor: 'red',
                data: getData
              }
            ]
          }
        }
      }).catch((error) => {
        console.log(error);
      })
    },
    getLocationRanking : function(){
      var getLabels = [];
      var getData = [];
      this.$http({
        method : 'post',
        url : 'getLocationRanking.do',
        params : {
          range : this.pieSelected
        }
      }).then((response) => {
        console.log(response.data);
        for(var index in response.data){
          getLabels.push(response.data[index].key);
          getData.push(response.data[index].value.toString());
          this.pieChartData = {
            labels: getLabels,
            datasets: [
              {
                backgroundColor: [
                  '#dba34e',
                  '#dc714a',
                  '#968e86',
                  '#76b3e0',
                  '#a9ab5f',
                  '#5c584f'
                ],
                data: getData
              }
            ]
          }
        }
      }).catch((error) => {
        console.log(error);
      })
    }
  },
  name: 'charts',
  components: {
    BarExample,
    LineExample,
    PieExample
  }
}
</script>

<style lang="css">
</style>
