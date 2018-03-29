<script>
import { Pie, mixins } from 'vue-chartjs'

const { reactiveProp } = mixins;

export default {
  extends: Pie,
  props:["chartData"],
  mixins: [mixins.reactiveProp],
  mounted () {
    this.renderChart(this.chartData, {responsive: true, maintainAspectRatio: false});
  }
}
</script>
