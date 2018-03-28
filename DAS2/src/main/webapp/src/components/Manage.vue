<template lang="html">
  <div class="">
    <br><br><br><br><br><br><br><br>
    <b-row align-h="center">
      <b-col md="6">
        <b-card>
          <b-table :fields="fields" :items="this.$store.state.boardCategorys">
            <template slot="idx" slot-scope="data">
              <div v-on:click="getCategory(data.value)">{{data.value}}</div>
            </template>
          </b-table>
        </b-card>
      </b-col>
      <b-col md="4">
        <b-card>
          <b-row>
            <b-col sm="3">
              <label for="name">게시판번호</label>
            </b-col>
            <b-col sm="9">
              <b-form-group>
                <b-form-input type="text" id="idx" v-model="boardCategory.idx" disabled></b-form-input>
              </b-form-group>
            </b-col>
          </b-row>
          <b-row>
            <b-col sm="3">
              <label for="name">게시판이름</label>
            </b-col>
            <b-col sm="9">
              <b-form-group>
                <b-form-input type="text" id="name" v-model="boardCategory.name"></b-form-input>
              </b-form-group>
            </b-col>
          </b-row>
          <b-row>
            <b-col sm="3">
              <label for="name">게시판설명</label>
            </b-col>
            <b-col sm="9">
              <b-form-group>
                <b-form-input type="text" id="describe" v-model="boardCategory.describe"></b-form-input>
              </b-form-group>
            </b-col>
          </b-row>
          <b-row>
            <b-col sm="3">
              <label for="name">정렬 순서</label>
            </b-col>
            <b-col sm="9">
              <b-form-group>
                <b-form-input type="text" id="seq" v-model="boardCategory.seq"></b-form-input>
              </b-form-group>
            </b-col>
          </b-row>
          <b-row>
            <b-col sm="3">
              <label for="name">읽기 등급</label>
            </b-col>
            <b-col sm="9">
              <b-form-group>
                <b-form-input type="text" id="readAuthority" v-model="boardCategory.readAuthority"></b-form-input>
              </b-form-group>
            </b-col>
          </b-row>
          <b-row>
            <b-col sm="3">
              <label for="name">쓰기 등급</label>
            </b-col>
            <b-col sm="9">
              <b-form-group>
                <b-form-input type="text" id="writeAuthority" v-model="boardCategory.writeAuthority"></b-form-input>
              </b-form-group>
            </b-col>
          </b-row>
          <b-row>
            <b-col sm="3">
              <label for="name">댓글 등급</label>
            </b-col>
            <b-col sm="9">
              <b-form-group>
                <b-form-input type="text" id="commentAuthority" v-model="boardCategory.commentAuthority"></b-form-input>
              </b-form-group>
            </b-col>
          </b-row>
          <b-row align-h="center">
            <b-col sm="3">
              <b-button variant="primary" v-on:click="insertCategory">추가하기</b-button>
            </b-col>
            <b-col sm="3">
              <b-button variant="primary" v-on:click="updateCategory">수정하기</b-button>
            </b-col>
            <b-col sm="3">
              <b-button variant="primary" v-on:click="deleteCategory">삭제하기</b-button>
            </b-col>
          </b-row>
        </b-card>
      </b-col>
    </b-row>
  </div>

</template>

<script>
export default {
  data : function(){
    return {
      boardCategory : {
        idx : null,
        name : null,
        describe : null,
        seq : null,
        readAuthority : null,
        writeAuthority : null,
        commentAuthority : null
      }
    }
  },
  created : function(){
    this.getCategoryList();
  },
  methods : {
    getCategoryList : function(){
      this.$http({
        method : 'post',
        url : 'getBoardCategoryList.do'
      }).then((response) => {
        this.$store.commit("setBoardCategorys", response.data);
      }).catch((error) => {
        console.log(error);
        alert('서버측 문제로 홈페이지 정보를 제대로 받아오지 못했습니다.');
      })
    },
    getCategory : function(data){
      this.$http({
        method : 'post',
        url : 'getBoardCategory.do',
        params : { idx : data }
      }).then((response) => {
        this.boardCategory = response.data;
      }).catch((error) => {
        console.log(error);
        alert('서버측 문제로 홈페이지 정보를 제대로 받아오지 못했습니다.');
      })
    },
    insertCategory : function(){
      this.$http({
        method : 'post',
        url : 'insertBoardCategory.do',
        params : this.boardCategory
      }).then((response) => {
        this.$store.commit("setBoardCategorys", response.data);
      }).catch((error) => {
        console.log(error);
      })
    },
    updateCategory : function(){
      this.$http({
        method : 'post',
        url : 'updateBoardCategory.do',
        params : this.boardCategory
      }).then((response) => {
        this.$store.commit("setBoardCategorys", response.data);
      }).catch((error) => {
        console.log(error);
      })
    },
    deleteCategory : function(){
      this.$http({
        method : 'post',
        url : 'deleteBoardCategory.do',
        dataType : 'json',
        params : this.boardCategory
      }).then((response) => {
        this.$store.commit("setBoardCategorys", response.data);
      }).catch((error) => {
        console.log(error);
      })
    }
  }
}
</script>

<style lang="css">
</style>
