<script>
import { Pie } from 'vue-chartjs'

export default {
  extends: Pie,
  mounted () {
    this.renderChart({
      labels: ['서울', '부산', '대구', '광주'],
      datasets: [
        {
          backgroundColor: [
            'red',
            'black',
            'green',
            'blue'
          ],
          data: [430, 206, 808, 180]
        }
      ]
    }, {responsive: true, maintainAspectRatio: false})
  }
}
</script>
