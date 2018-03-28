<template lang="html">
  <div class="">
    <br><br><br><br>
    <b-container fluid>
      <b-row class= "my-3 justify-content-md-center">
        <b-col sm="2">제목</b-col>
        <b-col sm="4">{{this.$store.state.board.title}}</b-col>
      </b-row>
      <b-row class= "my-3 justify-content-md-center">
        <b-col sm="2">작성자</b-col>
        <b-col sm="2">{{this.$store.state.board.writer}}</b-col>
        <b-col sm="2">작성자번호</b-col>
        <b-col sm="2">{{this.$store.state.board.writerIdx}}</b-col>
      </b-row>
      <b-row class= "my-3 justify-content-md-center">
        <b-col sm="2">작성시간</b-col>
        <b-col sm="2">{{this.$store.state.board.regDate}}</b-col>
        <b-col sm="2">수정시간</b-col>
        <b-col sm="2">{{this.$store.state.board.modifiyDate}}</b-col>
      </b-row>
      <b-row class= "my-3 justify-content-md-center">
        <b-col sm="2">좋아요</b-col>
        <b-col sm="2">{{this.$store.state.board.likePoint}}</b-col>
        <b-col sm="2">싫어요</b-col>
        <b-col sm="2">{{this.$store.state.board.hatePoint}}</b-col>
      </b-row>
      <b-row class= "my-3 justify-content-md-center">
        <b-col sm="2">댓글수</b-col>
        <b-col sm="2">{{this.$store.state.board.comments}}</b-col>
        <b-col sm="2">조회수</b-col>
        <b-col sm="2">{{this.$store.state.board.hit}}</b-col>
      </b-row>
      <b-row class= "my-3 justify-content-md-center">
        <b-col sm="8">{{this.$store.state.board.content}}</b-col>
      </b-row>
      <b-row class= "my-3 justify-content-md-center">
        <b-col sm="2"><b-button v-on:click="back">목록</b-button></b-col>
        <b-col v-if="this.$store.state.userinfo!=null && this.$store.state.board.writerIdx==this.$store.state.userinfo.idx" sm="2">
          <b-button>수정하기</b-button></b-col>
      </b-row>

    </b-container>
  </div>
</template>

<script>
export default {
  methods : {
    back : function(){
      this.$router.go(-1);
    }
  }
}
</script>

<style lang="css">
b-container {
  border : 1px;
}
</style>
