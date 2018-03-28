<template lang="html">
  <div class="deliverylist">
    <br><br><br><br><br><br><br><br>
		<div class="container">
			<div class="row">
				<div class="col-lg-10 mx-auto text-center">
          <form action="deliveryList.do" method="get">
						<label for="src">출발지</label>
						<input type="text" id="src" name="src" value=""/>
						<label for="dst">목적지</label>
						<input type="text" id="dst" name="dst" value=""/>
						<input type="submit" value="검색">
					</form>
          <b-table v-if="this.$store.state.deliverylist" hover :items="this.$store.state.deliverylist" :fields="fields" caption-top>
            <template slot="sendingLoc" slot-scope="data"><i v-on:click="gotoDelivery(data.item.id)">{{data.item.sendingLoc}}</i></template>
            <template slot="receivingLoc" slot-scope="data"><i v-on:click="gotoDelivery(data.item.id)">{{data.item.receivingLoc}}</i></template>
            <template slot="state" slot-scope="data">
              <h6>
                <span v-if="data.item.delivererId == 0" class="badge badge-danger">배송자 선택 전</span>
                <span v-if="data.item.delivererId != 0" class="badge badge-warning">배송자 선택완료</span>
              </h6>
            </template>
          </b-table>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
export default {
  data : function(){
    return {
      category : '자유게시판',
      keyword : '',
      selected : '',
      options : ['제목', '내용', '작성자', '댓글'],
      fields: [
        {key:'id', label:"번호"},
        {key:'sendingLoc', label:"출발지"},
        {key:'receivingLoc', label:"도착지"},
        {key:'state', label:'상태'}
      ]
    }
  },
  methods : {
    gotoDelivery : function(id){
      this.$store.dispatch('getDelivery', id)
      this.$router.push('/delivery');
    }
  }
}
</script>

<style lang="css">
</style>
