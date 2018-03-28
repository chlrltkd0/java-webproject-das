<template lang="html">
  <div class="patternlist">
  		<div class="container">
  		<br><br><br>
  		<h2 class="text-center text-uppercase text-secondary mb-0">이동패턴 추가</h2>
          <hr class="star-dark mb-5">
  			<div class="row">
  				<div class="col-lg-10 mx-auto text-center">
            <b-table v-if="this.$store.state.patternlist != null" hover :items="this.$store.state.patternlist" :fields="fields" caption-top>
              <template slot="fromNode" slot-scope="data"><i v-on:click="gotoPattern(data.item.id)">{{data.item.fromNode.location.address}}</i></template>
              <template slot="toNode" slot-scope="data"><i v-on:click="gotoPattern(data.item.id)">{{data.item.toNode.location.address}}</i></template>
            </b-table>
  					<b-button type="button" v-on:click="gotoAddPattern" variant="primary">이동 패턴 추가</b-button>
  				</div>
  			</div>
  		</div>
      <br>
  	</div>
</template>

<script>
export default {
  data : function(){
    return {
      fields: [
        {key:'fromNodeId', label:"번호"},
        {key:'fromNode', label:"출발위치"},
        {key:'toNode', label:"도착위치"},
        {key:'toNodeId', label:'번호'}
      ]
    }
  },
  methods : {
    gotoAddPattern : function(){
      this.$router.push('/addmovepattern');
    }
  }
}
</script>

<style lang="css">

</style>
