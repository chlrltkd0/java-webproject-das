<template lang="html">
  <div class="">
    <br><br><br><br>
    <h1>글쓰기</h1>
    <b-container fluid>
  <b-row class="my-3 justify-content-md-center">
    <b-col cols="1"><label for="title">제목 :</label></b-col>
    <b-col cols="7">
      <b-form-input id="title" type="text" v-model="title"></b-form-input>
    </b-col>
  </b-row>
  <b-row class="my-3 justify-content-md-center">
    <b-col cols="8">
      <b-form-textarea id="content"
                       v-model="content"
                       placeholder="Enter something"
                       :cols="6"
                       :rows="12"
                       :max-rows="12">
      </b-form-textarea>
    </b-col>
  </b-row>
  <b-row class="justify-content-md-center">
    <b-col sm="1">
      <b-button variant="success" v-on:click="write">등록하기</b-button>
    </b-col>
    <b-col sm="1">
      <b-button variant="danger" v-on:click="cancel">취소하기</b-button>
    </b-col>
  </b-row>
</b-container>
  </div>
</template>

<script>
export default {
  data : function() {
     return {
       title: '',
       content: ''
     }
   },
   methods : {
     cancel : function(){
       this.$router.go(-1);
     },
     write : function(){
       this.$http({
         method : 'post',
         url : 'writeBoard.do',
         params : {
           title : this.title,
           content : this.content,
           categoryIdx : this.$store.state.boardList.categoryIdx
         }
       }).then((response) => {
         if(response.data==true){
           this.$store.dispatch('getBoardList', {
             categoryIdx : this.$store.state.boardList.categoryIdx,
             page : 1
           });
           this.$router.push('/bbs');
         } else {
           alert('글을 등록하지 못했습니다.');
         }
       }).catch((error) => {
         alert('로그인 해주세요.');
         console.log(error);
       })
     }
   }
}
</script>

<style lang="css">
h1 {
  text-align : center;
}
</style>
