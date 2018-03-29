<script>
import { Line , mixins } from 'vue-chartjs'

const { reactiveProp } = mixins;

export default {
  extends: Line,
  mixins: [mixins.reactiveProp],
  props: ['chartData'],
  data : function(){
    return {
      options : {responsive: true, maintainAspectRatio: false}
    }
  },
  mounted () {
    this.renderChart(this.chartData, this.options);
  }
}
</script>
