<script>
import { Bar, mixins } from 'vue-chartjs'

const { reactiveProp } = mixins;

export default {
  extends: Bar,
  mixins: [mixins.reactiveProp],
  props: ['barChartData'],
  mounted () {
    // Overwriting base render method with actual data.
    this.renderChart(this.chartData, {responsive: true, maintainAspectRatio: false});
  }
}
</script>
