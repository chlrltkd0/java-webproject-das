<template lang="html">
  <div class="animated fadeIn">
    <br><br><br><br>
      <b-card-group>
        <b-card header="지역별 배송 횟수">
          <div class="chart-wrapper">
            <pie-example/>
            <br>
            <b-form-select v-model="selected" :options="comboboxoptions" class="mb-3" />
          </div>
        </b-card>
        <b-card header="배달 완료 추이">
          <div class="chart-wrapper">
            <line-example :chart-data="chartData"/>
            <b-container fluid>
               <b-row class="my-3 d-flex justify-content-between">
                 <b-col sm="5"><b-form-input v-model="line.start" type="date"></b-form-input></b-col>
                 <b-col sm="5"><b-form-input v-model="line.end" type="date"></b-form-input></b-col>
                 <b-col sm="2"><b-button type="button" v-on:click="getDeliveryVolume">검색</b-button></b-col>
               </b-row>
             </b-container>
          </div>
        </b-card>
        <b-card header="Bar Chart">
          <div class="chart-wrapper">
            <bar-example/>
          </div>
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
        start : '',
        end : ''
      },
      comboboxoptions: [
        { value: null, text: '국가별' },
        { value: 'a', text: '구별' },
        { value: 'b', text: '시별' },
        { value: {'C': '3PO'}, text: 'This is an option with object value' },
        { value: 'd', text: 'This one is disabled', disabled: true }
      ],
      chartData : {
        labels: [],
        datasets: [
          {
            label: '배달 완료 횟수',
            backgroundColor: '#f87979',
            data: []
          }
        ]
      },
    }
  },
  methods : {
    getDeliveryVolume : function(){
      var getLabels = [];
      var getData = [];

      this.$http({
        method : 'post',
        url : 'getDeliveryVolume.do',
        params : {
          startDate : this.line.start,
          endDate : this.line.end
        }
      }).then((response) => {
        console.log(response.data);
        for(var index in response.data){
          getLabels.push(response.data[index].date);
          getData.push(response.data[index].count.toString());
          this.chartData = {
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
