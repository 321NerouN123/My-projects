<template>
    <Navigation />
    <div class="content">
        <div class="topside-bar">
            <div class="caption">
                <b>Вопрос по игре</b>
                <p>Данный раздел повсящен любому вопросу по любой игре</p>
            </div>
            <div class="butt">
                <!--<button onclick="document.location='#/CreatePost'"><a href="#/CreatePost">Создать пост</a></button>-->
                <router-link :to="{ name: 'CreatePost', params: { topicId: 15 } }">
                        <!--<a href="#/CreatePost"><h2>Создать пост</h2></a>-->
                        <button onclick="document.location='#/CreatePost'"> <a href="#/CreatePost">Создать пост</a></button>
                </router-link>
            </div>
        </div>
        <div id="app">
            <div v-for="(post, index) in posts" :key="posts.postId" :class="{'topic-body': true, 'last-block': index === posts.length - 1}">
                <div class="topic-left">
                    <router-link :to="{ name: 'Post', params: { postId: post.postId } }">
                        <div class="limit"><a href="#/Post"><h2>{{ post.postName }}</h2></a></div>
                    </router-link>
                    <div class="topic-meta-stat">
                        
                        <div class="topic-meta-last-static-author">Автор: </div>
                        <div class="topic-meta-last-user">{{ post.userId.userLogin }}</div>
                    </div>
                </div>
                <div class="topic-middle">
                    <div class="topic-meta-count-msg">
                        <div class="static">Ответов:</div>
                        <div class="msg-views">{{ post.commentsCount }}</div> 
                    </div>
                    
                    <div class="topic-meta-count-msg">
                        <div class="static">Просмотров:</div>
                        <div class="msg-views">{{ post.postViews }}</div> 
                    </div>
                </div>
                <div class="topic-right">
                    <div class="topic-meta-date-msg">
                        <div class="static-date">Дата создания:</div>
                        <div class="msg-date">{{ post.postDate }}</div> 
                    </div>
                </div>
            </div>
        </div>
        <div class="Btn-Back">
                <button @click="goBack" class="Btn-Bac1">Назад</button>
        </div>
    </div>
    <Footer />
</template>
  
<script>

import axios from 'axios';

export default {
  name: 'App',
  data() {
    return {
      posts: [],
      topicId: 15,
      //countComments: 0
    };
  },
  created() {
    this.fetchPosts();
    //this.getCountComments();
  },
  methods: {
    async fetchPosts() {
      try {
        const posts = await this.getPostsByTopicId(this.topicId);
        for (const post of posts) {
          post.commentsCount = await this.getCommentsCountByPostId(post.postId);
        }
        this.posts = posts;
      } catch (error) {
        console.error('Error fetching entities:', error);
      }
    },
    async getPostsByTopicId(topicId) {
      try {
        const response = await axios.get('http://localhost:8080/api/Posts/allPostByTopicId', {
          params: { topicId }
        });
        return response.data;
      } catch (error) {
        console.error('Error fetching posts:', error);
        throw error;
      }
    },
    async getCommentsCountByPostId(postId) {
      try {
        const response = await axios.get(`http://localhost:8080/api/Posts/${postId}/comments/count`);
        return response.data;
      } catch (error) {
        console.error('Error fetching comments count:', error);
        throw error;
      }
    },
    goBack() {
      this.$router.go(-1);
    }
  }
  
};

</script>

<style scoped>
.last-block {
    width: 95%;
    height: 60px;
    background: rgb(65, 57, 57);
    margin-left: 40px;
    
    border-left: 5px groove rgb(207, 107, 13);
    border-right: 5px groove rgb(207, 107, 13);
    border-bottom: 5px groove rgb(207, 107, 13);
    display: flex;
    align-items: center;
}
.entity-block {
  border: 1px solid black;
  padding: 10px;
  margin: 10px 0;
}
.content {
    width: 98%;
    min-height: 71vh;
    background: #27272c;
    margin: auto;
    padding-bottom: 59px;
    display:block;
    
    padding-top: 30px;
}

.caption {
    font-family: "Bitter", serif;
    color: rgb(242, 247, 217);
    font-size: 24px;
    text-align: left;
    width: 98%;
    padding-left: 40px;
}

p {
    font-size: 20px;
    color: rgba(242, 247, 217, 0.863);
    margin-top: 10px;
}

.topic-body {
    width: 95%;
    height: 60px;
    background: rgb(65, 57, 57);
    margin-left: 40px;
    border-top: 5px groove rgb(207, 107, 13);
    border-left: 5px groove rgb(207, 107, 13);
    border-right: 5px groove rgb(207, 107, 13);
    
    display: flex;
    align-items: center;
    
}

.topic-left {
    width: 79%;
    height: 60px;
    margin-left: 5px;
    display: block;
    align-content: center;
    border-right: 2px solid rgb(207, 107, 13);
}

.topic-middle {
    width: 10%;
    min-width: 160px;
    height: 60px;
    margin-left: 5px;
    display: block;
    align-content: center;
    border-right: 2px solid rgb(207, 107, 13);
}

.topic-right{
    width: 10%;
    min-width: 160px;
    height: 60px;
    margin-left: 5px;
    align-content: center;
    justify-content: space-between;
    
}

.topic-meta-stat {
    display: flex;
    font-family: "Bitter", serif;
    color: rgba(202, 64, 0, 0.877);
    margin-left: 15px;
    
}


.topic-meta-last-user{
    margin-left: 5px;
}

.topic-meta-count-msg {
    display: flex;         /* Включает Flexbox для контейнера */
    justify-content: space-between; /* Распределяет свободное пространство между элементами */
}

.topic-meta-date-msg {
    display: block;
    align-content: center;
    
}

.msg-views {
    margin-right: 5px;
    font-family: "Bitter", bold;
    color: rgb(242, 247, 217);
}

.msg-date {
    margin-right: 5px;
    font-family: "Bitter", bold;
    color: rgb(242, 247, 217);
    text-align: center;
}

.static {
    font-family: "Bitter", bold;
    color: rgb(242, 247, 217);
}

.static-date {
    font-family: "Bitter", bold;
    color: rgb(242, 247, 217);
    text-align: center;
}


h2{
    margin: 0;
    margin-left: 15px;
    font-size: 20px;
}

a:link{
    font-family: "Bitter", bold;
    color: rgb(242, 247, 217);
    text-decoration: none;
}

a:visited {
    font-family: "Bitter", serif;
    color: rgb(242, 247, 217);
    text-decoration: none;
}

a:active {
    text-decoration: none; 
}

a:hover {
    text-decoration: underline;  
}

.topside-bar{
    display: flex;
    
}

.butt{
    margin-right: 45px;
    
}

button {
    font-family: "Bitter", serif;
    color: rgb(242, 247, 217);
    font-size: 15px;
    margin: auto;
    border-width: 5px;
    border-style: outset;
    border-color: rgb(189, 102, 21);
    border-radius: 9px;
    width: 190px;
    height: 40px;
    background: rgb(111,111,111);
    background: linear-gradient(180deg, rgba(111,111,111,1) 0%, rgba(47,47,47,1) 78%, rgba(33,31,31,1) 100%);
    box-shadow: inset 0px 0px 20px 0px #2c1400;
    transition: all 200ms ease; 
    
}

button:hover {
	box-shadow: inset 0px 0px 20px 0px #682f00;
    cursor: pointer;
}
button:active {
	position:relative;
	top:5px;  
}

button a:hover{
    text-decoration: none;
}

.Btn-Back{
    text-align: right;
    margin-bottom: 10px; /* Отступ снизу */
    margin-right: 43px;
    margin-top: 40px;
}

.limit{
    text-overflow: ellipsis;
  white-space: nowrap;
  overflow: hidden;
}
</style>
