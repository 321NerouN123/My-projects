<template>
    <div class="navigation">
        <div class="logo"><img class="logo-img" src="../assets/logo-icon.png"></div>
        <ol>
            <li><a href="#/Home">Главная</a></li>
            <li><a href="#/About">О сайте</a></li>
            <li v-if="isAuthenticated">
                <a href=""><span @click="handleLogout">Выход</span></a>
            </li>
            <li v-else><a href="#/Entry">Войти</a></li>
            <li v-if="isAuthenticated">{{ user.userLogin }}</li>
            <li v-else>Гость</li>
           <!--<li>Гость</li>-->
        </ol>
        <div class="search">
            <input type="text" placeholder="Поиск..." v-model="postName" @input="searchPosts">
            <ul v-if="showSuggestions && suggestions.length" class="suggestions-list">
                <p v-for="post in suggestions" :key="post.postId" @click="goToPost(post.postId)">
                    {{ post.postName }}
                </p>
            </ul>
            <img class="image" src="../assets/loopa-icon.png">   
        </div>
    </div>
</template>

<script>
import { mapGetters, mapActions } from 'vuex';
import axios from 'axios';

export default {
    data() {
        return {
            postName: '',
            suggestions: [],
            showSuggestions: false
        };
    },
  computed: {
    ...mapGetters(['isAuthenticated', 'user'])
  },
  methods: {
    ...mapActions(['logout']),
        handleLogout() {
        this.logout(); // Вызов действия logout из Vuex
    },
    searchPosts() {
            if (this.postName.length > 2) {
                axios.get('http://localhost:8080/api/Posts/searchPosts', {
                    params: { postName: this.postName }
                })
                .then(response => {
                    this.suggestions = response.data;
                    this.showSuggestions = true;
                })
                .catch(error => {
                    console.error("Error fetching posts:", error);
                });
            } else {
                this.suggestions = [];
                this.showSuggestions = false;
            }
        },
        goToPost(postId) {
            this.$router.push({ name: 'Post', params: { postId: postId } });
            this.resetSearch();
        },
        resetSearch() {
            this.postName = '';
            this.suggestions = [];
            this.showSuggestions = false;
        }
  }
};
</script>

<style scoped>

.navigation {
    width: auto;
    height: auto;
    background: rgb(37, 37, 37);
    display: flex;
    padding: 15px;
    padding-left: 35px;
    align-items: center;
    border-top-left-radius: 6px;
    border-top-right-radius: 6px;
    border-top: 5px solid;
    border-bottom: 5px solid;
    border-color: #bd6615;
}

ol {
    display: flex;
    list-style-type: none;
}

li {
    color: rgb(248, 255, 212);
    font-family: "Bitter", serif;
    font-size: 25px;
    margin-left: 10px;
    padding-right: 30px;
}

.image {
    width: 20px;
    height: 20px;
    margin-top: 5px;
    margin-right: 5px;
    cursor: pointer;
}

.logo-img {
    width: 60px;
    height: 60px;
}

.search {
    position: relative;
    display: flex;
    align-items: center;
    background: rgb(75, 70, 70);
    border: 1px solid rgb(202, 115, 0);
    margin-left: auto;
    margin-right: 50px;
    padding: 5px;
    border-radius: 4px;
}

input {
    background: rgb(75, 70, 70);
    outline: none;
    border: none;
    color: rgb(248, 255, 212);
    font-family: "Bitter", serif;
    width: 230px;
    height: 30px;
    padding-left: 10px;
}

a:link, a:visited {
    font-family: "Bitter", serif;
    color: rgb(242, 247, 217);
    text-decoration: none;
}

a:hover, a:active {
    text-decoration: underline;  
}

.suggestions-list {
    position: absolute;
    top: 100%;
    left: 0;
    width: 100%;
    list-style-type: none;
    padding: 0px;
    margin: 0;
    background: rgb(75, 70, 70);
    border: 1px solid #ccc;
    border-top: none;
    max-height: 200px;
    overflow-y: auto;
    z-index: 1000;
    border: 1px solid rgb(202, 115, 0);
    
}

.suggestions-list p {
    padding: 10px;
    cursor: pointer;
    background-color: rgb(75, 70, 70);
    color: rgb(248, 255, 212);
    font-family: "Bitter", serif;
    font-size: 12pt;
    margin: 0;
}

.suggestions-list p:hover {
    background-color: rgb(63, 59, 59);
}
</style>
