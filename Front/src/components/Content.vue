<template>
    <div class="content">
        
        <p class="logotext">Форум Pixel Island - место встречи инди-разработчиков </p>
        <div class="section">
            <h3>Новости</h3>
        </div>
        <div class="topic-body">
            <img class="image" src="../assets/icons8-news-45.png">
            <div class="topic">
                <a href="#/PostsNewsForum"><h3>Новости форума</h3></a>
                <div class="topic-meta-stat">
                    <div class="text-meta-stat">Темы: {{ countPosts1 }}</div>
                    <div class="text-meta-stat">Сообщения: {{ countComments1 }}</div>
                </div>
            </div>
            <div class="topic-meta-last-body">
                <div class="topic-meta-last-name">Последнее: <div class="topic-meta-last-name-info">
                        
                        <template v-for="(post, index) in lastPost1" :key="lastPost1.postId">
                            <router-link :to="{ name: 'Post', params: { postId: post.postId } }">
                            <a href="#/Post"><div v-if="index == 0" class="limit">{{ post.postName }}</div></a>
                            </router-link>
                        </template>
                        
                    </div>
                </div>
                <div class="topic-meta-last-user">
                    <template v-for="(post, index) in lastPost1" :key="lastPost1.postId">
                        <div v-if="index == 0">{{ post.userId.userLogin }}</div>
                    </template>
                    <div class="topic-meta-last-data">
                        <template v-for="(post, index) in lastPost1" :key="lastPost1.postId">
                            <div v-if="index == 0">{{ post.postDate }}</div>
                        </template></div>
                </div>
            </div>
        </div>
        <div class="topic-body">
            <img class="image" src="../assets/icons8-google-news-45.png">
            <div class="topic">
                <a href="#/PostsNewsCompany"><h3>Новости компаний</h3></a>
                <div class="topic-meta-stat">
                    <div class="text-meta-stat">Темы: {{ countPosts2 }}</div>
                    <div class="text-meta-stat">Сообщения: {{ countComments2 }}</div>
                </div>
            </div>
            <div class="topic-meta-last-body">
                <div class="topic-meta-last-name">Последнее: 
                    <div class="topic-meta-last-name-info">
                        
                        <template v-for="(post, index) in lastPost2" :key="lastPost2.postId">
                            <router-link :to="{ name: 'Post', params: { postId: post.postId } }">
                            <a href="#/Post"><div v-if="index == 0" class="limit">{{ post.postName }}</div></a>
                            </router-link>
                        </template>
                        
                    </div>
                </div>
                <div class="topic-meta-last-user">
                    <template v-for="(post, index) in lastPost2" :key="lastPost2.postId">
                        <div v-if="index == 0">{{ post.userId.userLogin }}</div>
                    </template>
                    <div class="topic-meta-last-data">
                        <template v-for="(post, index) in lastPost2" :key="lastPost2.postId">
                            <div v-if="index == 0">{{ post.postDate }}</div>
                        </template></div>
                </div>
            </div>
        </div>
        <div class="topic-body2">
            <img class="image" src="../assets/icons8-games-folder-45.png">
            <div class="topic">
                <a href="#/PostsNewsGames"><h3>Новости из игр</h3></a>
                <div class="topic-meta-stat">
                    <div class="text-meta-stat">Темы: {{ countPosts3 }}</div>
                    <div class="text-meta-stat">Сообщения: {{ countComments3 }}</div>
                </div>
            </div>
            <div class="topic-meta-last-body">
                <div class="topic-meta-last-name">Последнее: 
                    <div class="topic-meta-last-name-info">
                        
                        <template v-for="(post, index) in lastPost3" :key="lastPost3.postId">
                            <router-link :to="{ name: 'Post', params: { postId: post.postId } }">
                            <a href="#/Post"><div v-if="index == 0" class="limit">{{ post.postName }}</div></a>
                            </router-link>
                        </template>
                        
                    </div>
                </div>
                <div class="topic-meta-last-user">
                    <template v-for="(post, index) in lastPost3" :key="lastPost3.postId">
                        <div v-if="index == 0">{{ post.userId.userLogin }}</div>
                    </template>
                    <div class="topic-meta-last-data">
                        <template v-for="(post, index) in lastPost3" :key="lastPost3.postId">
                            <div v-if="index == 0">{{ post.postDate }}</div>
                        </template></div>
                </div>
                            
            </div>
        </div>
        <div class="section-2">
            <h3>Презентация продуктов</h3>
        </div>
        <div class="topic-body">
            <img class="image" src="../assets/icons8-presentation-game-45.png">
            <div class="topic">
                <a href="#/PostsPresentationGames"><h3>Презентация игр</h3></a>
                <div class="topic-meta-stat">
                    <div class="text-meta-stat">Темы: {{ countPosts4 }}</div>
                    <div class="text-meta-stat">Сообщения: {{ countComments4 }}</div>
                </div>
            </div>
            <div class="topic-meta-last-body">
                <div class="topic-meta-last-name">Последнее: 
                    <div class="topic-meta-last-name-info">
                        
                        <template v-for="(post, index) in lastPost4" :key="lastPost4.postId">
                            <router-link :to="{ name: 'Post', params: { postId: post.postId } }">
                            <a href="#/Post"><div v-if="index == 0" class="limit">{{ post.postName }}</div></a>
                            </router-link>
                        </template>
                        
                    </div>
                </div>
                <div class="topic-meta-last-user">
                    <template v-for="(post, index) in lastPost4" :key="lastPost4.postId">
                        <div v-if="index == 0">{{ post.userId.userLogin }}</div>
                    </template>
                    <div class="topic-meta-last-data">
                        <template v-for="(post, index) in lastPost4" :key="lastPost4.postId">
                            <div v-if="index == 0">{{ post.postDate }}</div>
                        </template></div>
                </div>
            </div>
        </div>
        <div class="topic-body">
            <img class="image" src="../assets/icons8-open-email-45.png">
            <div class="topic">
                <a href="#/PostsApplicationFeedback"><h3>Обратная связь по приложению</h3></a>
                <div class="topic-meta-stat">
                    <div class="text-meta-stat">Темы: {{ countPosts5 }}</div>
                    <div class="text-meta-stat">Сообщения: {{ countComments5 }}</div>
                </div>
            </div>
            <div class="topic-meta-last-body">
                <div class="topic-meta-last-name">Последнее: 
                    <div class="topic-meta-last-name-info">
                        
                        <template v-for="(post, index) in lastPost5" :key="lastPost5.postId">
                            <router-link :to="{ name: 'Post', params: { postId: post.postId } }">
                            <a href="#/Post"><div v-if="index == 0" class="limit">{{ post.postName }}</div></a>
                            </router-link>
                        </template>
                        
                    </div>
                </div>
                <div class="topic-meta-last-user">
                    <template v-for="(post, index) in lastPost5" :key="lastPost5.postId">
                        <div v-if="index == 0">{{ post.userId.userLogin }}</div>
                    </template>
                    <div class="topic-meta-last-data">
                        <template v-for="(post, index) in lastPost5" :key="lastPost5.postId">
                            <div v-if="index == 0">{{ post.postDate }}</div>
                        </template></div>
                </div>
            </div>
        </div>
        <div class="topic-body2">
            <img class="image" src="../assets/icons8-presentation-45.png">
            <div class="topic">
                <a href="#/PostsPresentationProgramms"><h3>Презентация приложений</h3></a>
                <div class="topic-meta-stat">
                    <div class="text-meta-stat">Темы: {{ countPosts6 }}</div>
                    <div class="text-meta-stat">Сообщения: {{ countComments6 }}</div>
                </div>
            </div>
            <div class="topic-meta-last-body">
                <div class="topic-meta-last-name">Последнее: <div class="topic-meta-last-name-info">
                        
                        <template v-for="(post, index) in lastPost6" :key="lastPost6.postId">
                            <router-link :to="{ name: 'Post', params: { postId: post.postId } }">
                            <a href="#/Post"><div v-if="index == 0" class="limit">{{ post.postName }}</div></a>
                            </router-link>
                        </template>
                        
                    </div>
                </div>
                <div class="topic-meta-last-user">
                    <template v-for="(post, index) in lastPost6" :key="lastPost6.postId">
                        <div v-if="index == 0">{{ post.userId.userLogin }}</div>
                    </template>
                    <div class="topic-meta-last-data">
                        <template v-for="(post, index) in lastPost6" :key="lastPost6.postId">
                            <div v-if="index == 0">{{ post.postDate }}</div>
                        </template></div>
                </div>
            </div>
        </div>
        <div class="section-2">
            <h3>Игры</h3>
        </div>
        <div class="topic-body">
            <img class="image" src="../assets/icons8-apple-arcade-45.png">
            <div class="topic">
                <a href="#/PostsNewGames"><h3>Новинки игр</h3></a>
                <div class="topic-meta-stat">
                    <div class="text-meta-stat">Темы: {{ countPosts7 }}</div>
                    <div class="text-meta-stat">Сообщения: {{ countComments7 }}</div>
                </div>
            </div>
            <div class="topic-meta-last-body">
                <div class="topic-meta-last-name">Последнее: <div class="topic-meta-last-name-info">
                        
                        <template v-for="(post, index) in lastPost7" :key="lastPost7.postId">
                            <router-link :to="{ name: 'Post', params: { postId: post.postId } }">
                            <a href="#/Post"><div v-if="index == 0" class="limit">{{ post.postName }}</div></a>
                            </router-link>
                        </template>
                        
                    </div>
                </div>
                <div class="topic-meta-last-user">
                    <template v-for="(post, index) in lastPost7" :key="lastPost7.postId">
                        <div v-if="index == 0">{{ post.userId.userLogin }}</div>
                    </template>
                    <div class="topic-meta-last-data">
                        <template v-for="(post, index) in lastPost7" :key="lastPost7.postId">
                            <div v-if="index == 0">{{ post.postDate }}</div>
                        </template></div>
                </div>
            </div>
        </div>
        <div class="topic-body">
            <img class="image" src="../assets/icons8-backend-development-45.png">
            <div class="topic">
                <a href="#/PostsDevelopmentGames"><h3>Разработка игр</h3></a>
                <div class="topic-meta-stat">
                    <div class="text-meta-stat">Темы: {{ countPosts8 }}</div>
                    <div class="text-meta-stat">Сообщения: {{ countComments8 }}</div>
                </div>
            </div>
            <div class="topic-meta-last-body">
                <div class="topic-meta-last-name">Последнее: <div class="topic-meta-last-name-info">
                        
                        <template v-for="(post, index) in lastPost8" :key="lastPost8.postId">
                            <router-link :to="{ name: 'Post', params: { postId: post.postId } }">
                            <a href="#/Post"><div v-if="index == 0" class="limit">{{ post.postName }}</div></a>
                            </router-link>
                        </template>
                        
                    </div>
                </div>
                <div class="topic-meta-last-user">
                    <template v-for="(post, index) in lastPost8" :key="lastPost8.postId">
                        <div v-if="index == 0">{{ post.userId.userLogin }}</div>
                    </template>
                    <div class="topic-meta-last-data">
                        <template v-for="(post, index) in lastPost8" :key="lastPost8.postId">
                            <div v-if="index == 0">{{ post.postDate }}</div>
                        </template></div>
                </div>
            </div>
        </div>
        <div class="topic-body2">
            <img class="image" src="../assets/icons8-search-more-45.png">
            <div class="topic">
                <a href="#/PostsFindGame"><h3>Найти игру</h3></a>
                <div class="topic-meta-stat">
                    <div class="text-meta-stat">Темы: {{ countPosts9 }}</div>
                    <div class="text-meta-stat">Сообщения: {{ countComments9 }}</div>
                </div>
            </div>
            <div class="topic-meta-last-body">
                <div class="topic-meta-last-name">Последнее: <div class="topic-meta-last-name-info">
                        
                        <template v-for="(post, index) in lastPost9" :key="lastPost9.postId">
                            <router-link :to="{ name: 'Post', params: { postId: post.postId } }">
                            <a href="#/Post"><div v-if="index == 0" class="limit">{{ post.postName }}</div></a>
                            </router-link>
                        </template>
                        
                    </div>
                </div>
                <div class="topic-meta-last-user">
                    <template v-for="(post, index) in lastPost9" :key="lastPost9.postId">
                        <div v-if="index == 0">{{ post.userId.userLogin }}</div>
                    </template>
                    <div class="topic-meta-last-data">
                        <template v-for="(post, index) in lastPost9" :key="lastPost9.postId">
                            <div v-if="index == 0">{{ post.postDate }}</div>
                        </template></div>
                </div>
            </div>
        </div>
        <div class="section-2">
            <h3>Вопрос-ответ</h3>
        </div>
        <div class="topic-body">
            <img class="image" src="../assets/icons8-puzzled-45.png">
            <div class="topic">
                <a href="#/PostsQuestionGame"><h3>Вопрос по игре</h3></a>
                <div class="topic-meta-stat">
                    <div class="text-meta-stat">Темы: {{ countPosts10 }}</div>
                    <div class="text-meta-stat">Сообщения: {{ countComments10 }}</div>
                </div>
            </div>
            <div class="topic-meta-last-body">
                <div class="topic-meta-last-name">Последнее: <div class="topic-meta-last-name-info">
                        
                        <template v-for="(post, index) in lastPost10" :key="lastPost10.postId">
                            <router-link :to="{ name: 'Post', params: { postId: post.postId } }">
                            <a href="#/Post"><div v-if="index == 0" class="limit">{{ post.postName }}</div></a>
                            </router-link>
                        </template>
                        
                    </div>
                </div>
                <div class="topic-meta-last-user">
                    <template v-for="(post, index) in lastPost10" :key="lastPost10.postId">
                        <div v-if="index == 0">{{ post.userId.userLogin }}</div>
                    </template>
                    <div class="topic-meta-last-data">
                        <template v-for="(post, index) in lastPost10" :key="lastPost10.postId">
                            <div v-if="index == 0">{{ post.postDate }}</div>
                        </template></div>
                </div>
            </div>
        </div>
        <div class="topic-body2">
            <img class="image" src="../assets/icons8-help-45.png">
            <div class="topic">
                <a href="#/PostsQuestionProgramm"><h3>Вопрос по приложению</h3></a>
                <div class="topic-meta-stat">
                    <div class="text-meta-stat">Темы: {{ countPosts11 }}</div>
                    <div class="text-meta-stat">Сообщения: {{ countComments11 }}</div>
                </div>
            </div>
            <div class="topic-meta-last-body">
                <div class="topic-meta-last-name">Последнее: <div class="topic-meta-last-name-info">
                        
                        <template v-for="(post, index) in lastPost11" :key="lastPost11.postId">
                            <router-link :to="{ name: 'Post', params: { postId: post.postId } }">
                            <a href="#/Post"><div v-if="index == 0" class="limit">{{ post.postName }}</div></a>
                            </router-link>
                        </template>
                        
                    </div>
                </div>
                <div class="topic-meta-last-user">
                    <template v-for="(post, index) in lastPost11" :key="lastPost11.postId">
                        <div v-if="index == 0">{{ post.userId.userLogin }}</div>
                    </template>
                    <div class="topic-meta-last-data">
                        <template v-for="(post, index) in lastPost11" :key="lastPost11.postId">
                            <div v-if="index == 0">{{ post.postDate }}</div>
                        </template>
                    </div>
                </div>
            </div>
        </div>
        <div class="section-2">
            <h3>Остальное</h3>
        </div>
        <div class="topic-body">
            <img class="image" src="../assets/icons8-development-45.png">
            <div class="topic">
                <a href="#/PostsDevelopment"><h3>Программирование</h3></a>
                <div class="topic-meta-stat">
                    <div class="text-meta-stat">Темы: {{ countPosts12 }}</div>
                    <div class="text-meta-stat">Сообщения: {{ countComments12 }}</div>
                </div>
            </div>
            <div class="topic-meta-last-body">
                <div class="topic-meta-last-name">Последнее: <div class="topic-meta-last-name-info">
                        
                        <template v-for="(post, index) in lastPost12" :key="lastPost12.postId">
                            <router-link :to="{ name: 'Post', params: { postId: post.postId } }">
                            <a href="#/Post"><div v-if="index == 0" class="limit">{{ post.postName }}</div></a>
                            </router-link>
                        </template>
                        
                    </div>
                </div>
                <div class="topic-meta-last-user">
                    <template v-for="(post, index) in lastPost12" :key="lastPost12.postId">
                        <div v-if="index == 0">{{ post.userId.userLogin }}</div>
                    </template>
                    <div class="topic-meta-last-data">
                        <template v-for="(post, index) in lastPost12" :key="lastPost12.postId">
                            <div v-if="index == 0">{{ post.postDate }}</div>
                        </template>
                    </div>
            </div>
        </div>
        </div>
        <div class="topic-body">
            <img class="image" src="../assets/icons8-design-45.png">
            <div class="topic">
                <a href="#/PostsDesign"><h3>Дизайн</h3></a>
                <div class="topic-meta-stat">
                    <div class="text-meta-stat">Темы: {{ countPosts13 }}</div>
                    <div class="text-meta-stat">Сообщения: {{ countComments13 }}</div>
                </div>
            </div>
            <div class="topic-meta-last-body">
                <div class="topic-meta-last-name">Последнее: <div class="topic-meta-last-name-info">
                        
                        <template v-for="(post, index) in lastPost13" :key="lastPost13.postId">
                            <router-link :to="{ name: 'Post', params: { postId: post.postId } }">
                            <a href="#/Post"><div v-if="index == 0" class="limit">{{ post.postName }}</div></a>
                            </router-link>
                        </template>
                        
                    </div>
                </div>
                <div class="topic-meta-last-user">
                    <template v-for="(post, index) in lastPost13" :key="lastPost13.postId">
                        <div v-if="index == 0">{{ post.userId.userLogin }}</div>
                    </template>
                    <div class="topic-meta-last-data">
                        <template v-for="(post, index) in lastPost13" :key="lastPost13.postId">
                            <div v-if="index == 0">{{ post.postDate }}</div>
                        </template>
                    </div>
            </div>
        </div>
        </div>
        <div class="topic-body">
            <img class="image" src="../assets/icons8-podium-45.png">
            <div class="topic">
                <a href="#/PostsInteractivity"><h3>Интерактивы и конкурсы</h3></a>
                <div class="topic-meta-stat">
                    <div class="text-meta-stat">Темы: {{ countPosts14 }}</div>
                    <div class="text-meta-stat">Сообщения: {{ countComments14 }}</div>
                </div>
            </div>
            <div class="topic-meta-last-body">
                <div class="topic-meta-last-name">Последнее: <div class="topic-meta-last-name-info">
                        
                        <template v-for="(post, index) in lastPost14" :key="lastPost14.postId">
                            <router-link :to="{ name: 'Post', params: { postId: post.postId } }">
                            <a href="#/Post"><div v-if="index == 0" class="limit">{{ post.postName }}</div></a>
                            </router-link>
                        </template>
                        
                    </div>
                </div>
                <div class="topic-meta-last-user">
                    <template v-for="(post, index) in lastPost14" :key="lastPost14.postId">
                        <div v-if="index == 0">{{ post.userId.userLogin }}</div>
                    </template>
                    <div class="topic-meta-last-data">
                        <template v-for="(post, index) in lastPost14" :key="lastPost14.postId">
                            <div v-if="index == 0">{{ post.postDate }}</div>
                        </template>
                    </div>
            </div>
            </div>
        </div>
        
        
        
    </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      topicId1: 7,
      topicId2: 3,
      topicId3: 4,
      topicId4: 10,
      topicId5: 20,
      topicId6: 9,
      topicId7: 13,
      topicId8: 14,
      topicId9: 21,
      topicId10: 15,
      topicId11: 16,
      topicId12: 17,
      topicId13: 18,
      topicId14: 19,
      countPosts1: 0,
      countPosts2: 0,
      countPosts3: 0,
      countPosts4: 0,
      countPosts5: 0,
      countPosts6: 0,
      countPosts7: 0,
      countPosts8: 0,
      countPosts9: 0,
      countPosts10: 0,
      countPosts11: 0,
      countPosts12: 0,
      countPosts13: 0,
      countPosts14: 0,
      lastPost1: [],
      lastPost2: [],
      lastPost3: [],
      lastPost4: [],
      lastPost5: [],
      lastPost6: [],
      lastPost7: [],
      lastPost8: [],
      lastPost9: [],
      lastPost10: [],
      lastPost11: [],
      lastPost12: [],
      lastPost13: [],
      lastPost14: [],
      limit: 2,
      countComments1: 0,
      countComments2: 0,
      countComments3: 0,
      countComments4: 0,
      countComments5: 0,
      countComments6: 0,
      countComments7: 0,
      countComments8: 0,
      countComments9: 0,
      countComments10: 0,
      countComments11: 0,
      countComments12: 0,
      countComments13: 0,
      countComments14: 0
    };
  },
  created() {
    this.getCountPosts1();
    this.getCountComments1();
    this.getLastPostInfo1();
    
    this.getCountPosts2();
    this.getCountComments2();
    this.getLastPostInfo2();

    this.getCountPosts3();
    this.getCountComments3();
    this.getLastPostInfo3();

    this.getCountPosts4();
    this.getCountComments4();
    this.getLastPostInfo4();

    this.getCountPosts5();
    this.getCountComments5();
    this.getLastPostInfo5();

    this.getCountPosts6();
    this.getCountComments6();
    this.getLastPostInfo6();

    this.getCountPosts7();
    this.getCountComments7();
    this.getLastPostInfo7();

    this.getCountPosts8();
    this.getCountComments8();
    this.getLastPostInfo8();

    this.getCountPosts9();
    this.getCountComments9();
    this.getLastPostInfo9();

    this.getCountPosts10();
    this.getCountComments10();
    this.getLastPostInfo10();

    this.getCountPosts11();
    this.getCountComments11();
    this.getLastPostInfo11();

    this.getCountPosts12();
    this.getCountComments12();
    this.getLastPostInfo12();

    this.getCountPosts13();
    this.getCountComments13();
    this.getLastPostInfo13();

    this.getCountPosts14();
    this.getCountComments14();
    this.getLastPostInfo14();
  },
  methods: {
    async getCountPosts1() {
      try {
        const response = await axios.get('http://localhost:8080/api/Posts/count', {
            params:{
                topicId: this.topicId1
            }
        });
        this.countPosts1 = response.data;
      } catch (error) {
        console.error('Error fetching entities:', error);
      }
    },
    async getCountComments1(){
        try {
        const response = await axios.get('http://localhost:8080/api/Posts/comment/count', {
            params:{
                topicId: this.topicId1
            }
        });
        this.countComments1 = response.data;
      } catch (error) {
        console.error('Error fetching entities:', error);
      }
    },
    async getLastPostInfo1(){
        try{
            const response = await axios.get('http://localhost:8080/api/Posts/lastPost', {
            params:{
                topicId: this.topicId1
            }
        });
            this.lastPost1 = response.data;
        } catch (error){
            console.error('Ошибка получения информаци о последнем посте:', error);
        }
    },
    async getCountPosts2() {
      try {
        const response = await axios.get('http://localhost:8080/api/Posts/count', {
            params:{
                topicId: this.topicId2
            }
        });
        this.countPosts2 = response.data;
      } catch (error) {
        console.error('Error fetching entities:', error);
      }
    },
    async getCountComments2(){
        try {
        const response = await axios.get('http://localhost:8080/api/Posts/comment/count', {
            params:{
                topicId: this.topicId2
            }
        });
        this.countComments2 = response.data;
      } catch (error) {
        console.error('Error fetching entities:', error);
      }
    },
    async getLastPostInfo2(){
        try{
            const response = await axios.get('http://localhost:8080/api/Posts/lastPost', {
            params:{
                topicId: this.topicId2
            }
        });
            this.lastPost2 = response.data;
        } catch (error){
            console.error('Ошибка получения информаци о последнем посте:', error);
        }
    },
    async getCountPosts3() {
      try {
        const response = await axios.get('http://localhost:8080/api/Posts/count', {
            params:{
                topicId: this.topicId3
            }
        });
        this.countPosts3 = response.data;
      } catch (error) {
        console.error('Error fetching entities:', error);
      }
    },
    async getLastPostInfo3(){
        try{
            const response = await axios.get('http://localhost:8080/api/Posts/lastPost', {
            params:{
                topicId: this.topicId3
            }
        });
            this.lastPost3 = response.data;
        } catch (error){
            console.error('Ошибка получения информаци о последнем посте:', error);
        }
    },
    async getCountComments3(){
        try {
        const response = await axios.get('http://localhost:8080/api/Posts/comment/count', {
            params:{
                topicId: this.topicId3
            }
        });
        this.countComments3 = response.data;
      } catch (error) {
        console.error('Error fetching entities:', error);
      }
    },
    async getCountPosts4() {
      try {
        const response = await axios.get('http://localhost:8080/api/Posts/count', {
            params:{
                topicId: this.topicId4
            }
        });
        this.countPosts4 = response.data;
      } catch (error) {
        console.error('Error fetching entities:', error);
      }
    },
    async getCountComments4(){
        try {
        const response = await axios.get('http://localhost:8080/api/Posts/comment/count', {
            params:{
                topicId: this.topicId4
            }
        });
        this.countComments4 = response.data;
      } catch (error) {
        console.error('Error fetching entities:', error);
      }
    },
    async getLastPostInfo4(){
        try{
            const response = await axios.get('http://localhost:8080/api/Posts/lastPost', {
            params:{
                topicId: this.topicId4
            }
        });
            this.lastPost4 = response.data;
        } catch (error){
            console.error('Ошибка получения информаци о последнем посте:', error);
        }
    },
  async getCountPosts5() {
      try {
        const response = await axios.get('http://localhost:8080/api/Posts/count', {
            params:{
                topicId: this.topicId5
            }
        });
        this.countPosts5 = response.data;
      } catch (error) {
        console.error('Error fetching entities:', error);
      }
    },
    async getCountComments5(){
        try {
        const response = await axios.get('http://localhost:8080/api/Posts/comment/count', {
            params:{
                topicId: this.topicId5
            }
        });
        this.countComments5 = response.data;
      } catch (error) {
        console.error('Error fetching entities:', error);
      }
    },
    async getLastPostInfo5(){
        try{
            const response = await axios.get('http://localhost:8080/api/Posts/lastPost', {
            params:{
                topicId: this.topicId5
            }
        });
            this.lastPost5 = response.data;
        } catch (error){
            console.error('Ошибка получения информаци о последнем посте:', error);
        }
    },
    async getCountPosts6() {
      try {
        const response = await axios.get('http://localhost:8080/api/Posts/count', {
            params:{
                topicId: this.topicId6
            }
        });
        this.countPosts6 = response.data;
      } catch (error) {
        console.error('Error fetching entities:', error);
      }
    },
    async getCountComments6(){
        try {
        const response = await axios.get('http://localhost:8080/api/Posts/comment/count', {
            params:{
                topicId: this.topicId6
            }
        });
        this.countComments6 = response.data;
      } catch (error) {
        console.error('Error fetching entities:', error);
      }
    },
    async getLastPostInfo6(){
        try{
            const response = await axios.get('http://localhost:8080/api/Posts/lastPost', {
            params:{
                topicId: this.topicId6
            }
        });
            this.lastPost6 = response.data;
        } catch (error){
            console.error('Ошибка получения информаци о последнем посте:', error);
        }
    },
    async getCountPosts7() {
      try {
        const response = await axios.get('http://localhost:8080/api/Posts/count', {
            params:{
                topicId: this.topicId7
            }
        });
        this.countPosts7 = response.data;
      } catch (error) {
        console.error('Error fetching entities:', error);
      }
    },
    async getCountComments7(){
        try {
        const response = await axios.get('http://localhost:8080/api/Posts/comment/count', {
            params:{
                topicId: this.topicId7
            }
        });
        this.countComments7 = response.data;
      } catch (error) {
        console.error('Error fetching entities:', error);
      }
    },
    async getLastPostInfo7(){
        try{
            const response = await axios.get('http://localhost:8080/api/Posts/lastPost', {
            params:{
                topicId: this.topicId7
            }
        });
            this.lastPost7 = response.data;
        } catch (error){
            console.error('Ошибка получения информаци о последнем посте:', error);
        }
    },
    async getCountPosts8() {
      try {
        const response = await axios.get('http://localhost:8080/api/Posts/count', {
            params:{
                topicId: this.topicId8
            }
        });
        this.countPosts8 = response.data;
      } catch (error) {
        console.error('Error fetching entities:', error);
      }
    },
    async getCountComments8(){
        try {
        const response = await axios.get('http://localhost:8080/api/Posts/comment/count', {
            params:{
                topicId: this.topicId8
            }
        });
        this.countComments8 = response.data;
      } catch (error) {
        console.error('Error fetching entities:', error);
      }
    },
    async getLastPostInfo8(){
        try{
            const response = await axios.get('http://localhost:8080/api/Posts/lastPost', {
            params:{
                topicId: this.topicId8
            }
        });
            this.lastPost8 = response.data;
        } catch (error){
            console.error('Ошибка получения информаци о последнем посте:', error);
        }
    },
    async getCountPosts9() {
      try {
        const response = await axios.get('http://localhost:8080/api/Posts/count', {
            params:{
                topicId: this.topicId9
            }
        });
        this.countPosts9 = response.data;
      } catch (error) {
        console.error('Error fetching entities:', error);
      }
    },
    async getCountComments9(){
        try {
        const response = await axios.get('http://localhost:8080/api/Posts/comment/count', {
            params:{
                topicId: this.topicId9
            }
        });
        this.countComments9 = response.data;
      } catch (error) {
        console.error('Error fetching entities:', error);
      }
    },
    async getLastPostInfo9(){
        try{
            const response = await axios.get('http://localhost:8080/api/Posts/lastPost', {
            params:{
                topicId: this.topicId9
            }
        });
            this.lastPost9 = response.data;
        } catch (error){
            console.error('Ошибка получения информаци о последнем посте:', error);
        }
    },
    async getCountPosts10() {
      try {
        const response = await axios.get('http://localhost:8080/api/Posts/count', {
            params:{
                topicId: this.topicId10
            }
        });
        this.countPosts10 = response.data;
      } catch (error) {
        console.error('Error fetching entities:', error);
      }
    },
    async getCountComments10(){
        try {
        const response = await axios.get('http://localhost:8080/api/Posts/comment/count', {
            params:{
                topicId: this.topicId10
            }
        });
        this.countComments10 = response.data;
      } catch (error) {
        console.error('Error fetching entities:', error);
      }
    },
    async getLastPostInfo10(){
        try{
            const response = await axios.get('http://localhost:8080/api/Posts/lastPost', {
            params:{
                topicId: this.topicId10
            }
        });
            this.lastPost10 = response.data;
        } catch (error){
            console.error('Ошибка получения информаци о последнем посте:', error);
        }
    },
    async getCountPosts11() {
      try {
        const response = await axios.get('http://localhost:8080/api/Posts/count', {
            params:{
                topicId: this.topicId11
            }
        });
        this.countPosts11 = response.data;
      } catch (error) {
        console.error('Error fetching entities:', error);
      }
    },
    async getCountComments11(){
        try {
        const response = await axios.get('http://localhost:8080/api/Posts/comment/count', {
            params:{
                topicId: this.topicId11
            }
        });
        this.countComments11 = response.data;
      } catch (error) {
        console.error('Error fetching entities:', error);
      }
    },
    async getLastPostInfo11(){
        try{
            const response = await axios.get('http://localhost:8080/api/Posts/lastPost', {
            params:{
                topicId: this.topicId11
            }
        });
            this.lastPost11 = response.data;
        } catch (error){
            console.error('Ошибка получения информаци о последнем посте:', error);
        }
    },
    async getCountPosts12() {
      try {
        const response = await axios.get('http://localhost:8080/api/Posts/count', {
            params:{
                topicId: this.topicId12
            }
        });
        this.countPosts12 = response.data;
      } catch (error) {
        console.error('Error fetching entities:', error);
      }
    },
    async getCountComments12(){
        try {
        const response = await axios.get('http://localhost:8080/api/Posts/comment/count', {
            params:{
                topicId: this.topicId12
            }
        });
        this.countComments12 = response.data;
      } catch (error) {
        console.error('Error fetching entities:', error);
      }
    },
    async getLastPostInfo12(){
        try{
            const response = await axios.get('http://localhost:8080/api/Posts/lastPost', {
            params:{
                topicId: this.topicId12
            }
        });
            this.lastPost12 = response.data;
        } catch (error){
            console.error('Ошибка получения информаци о последнем посте:', error);
        }
    },
    async getCountPosts13() {
      try {
        const response = await axios.get('http://localhost:8080/api/Posts/count', {
            params:{
                topicId: this.topicId13
            }
        });
        this.countPosts13 = response.data;
      } catch (error) {
        console.error('Error fetching entities:', error);
      }
    },
    async getCountComments13(){
        try {
        const response = await axios.get('http://localhost:8080/api/Posts/comment/count', {
            params:{
                topicId: this.topicId13
            }
        });
        this.countComments13 = response.data;
      } catch (error) {
        console.error('Error fetching entities:', error);
      }
    },
    async getLastPostInfo13(){
        try{
            const response = await axios.get('http://localhost:8080/api/Posts/lastPost', {
            params:{
                topicId: this.topicId13
            }
        });
            this.lastPost13 = response.data;
        } catch (error){
            console.error('Ошибка получения информаци о последнем посте:', error);
        }
    },
    async getCountPosts14() {
      try {
        const response = await axios.get('http://localhost:8080/api/Posts/count', {
            params:{
                topicId: this.topicId14
            }
        });
        this.countPosts14 = response.data;
      } catch (error) {
        console.error('Error fetching entities:', error);
      }
    },
    async getCountComments14(){
        try {
        const response = await axios.get('http://localhost:8080/api/Posts/comment/count', {
            params:{
                topicId: this.topicId14
            }
        });
        this.countComments14 = response.data;
      } catch (error) {
        console.error('Error fetching entities:', error);
      }
    },
    async getLastPostInfo14(){
        try{
            const response = await axios.get('http://localhost:8080/api/Posts/lastPost', {
            params:{
                topicId: this.topicId14
            }
        });
            this.lastPost14 = response.data;
        } catch (error){
            console.error('Ошибка получения информаци о последнем посте:', error);
        }
    }
}
  
};
</script>

<style scoped>

p.logotext {
    font-family: "Bitter", serif;
    color: rgb(242, 247, 217);
    font-size: 25px;
    padding: 10px;
    margin-top: 0px;
    text-align: center;
}

h3 {
    font-family: "Bitter", serif;
    color: rgb(242, 247, 217);
    margin: 0;
    margin-left: 15px;
}

h4 {
    font-family: "Bitter", serif;
    color: rgb(242, 247, 217);
    margin: 0;
    margin-left: 15px;
    
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

.text-meta-stat{
    font-family: "Bitter", serif;
    color: rgb(242, 247, 217);
    margin-left: 15px;
}


.content {
    width: 98%;
    min-height: 80vh;
    background: #27272c;
    margin: auto;
    padding-top: 20px;
    padding-bottom: 15px;
    
}

.section {
    width: 95%;
    height: 30px;
    background: rgb(26, 24, 23);
    margin-left: 40px;
    border: 5px groove hsl(19, 100%, 40%);
    display: flex;
    align-items: center;
    margin-top: 0px;
    
}

.section-2 {
    width: 95%;
    height: 30px;
    background: rgb(26, 24, 23);
    margin-left: 40px;
    border-left: 5px groove rgb(202, 64, 0);
    border-right: 5px groove rgb(202, 64, 0);
    border-bottom: 5px groove rgb(202, 64, 0);
    display: flex;
    align-items: center;
    margin-top: 0px;
}

.topic-body {
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

.topic-body2 {
    width: 95%;
    height: 60px;
    background: rgb(65, 57, 57);
    margin-left: 40px;
    border-left: 5px groove rgb(207, 107, 13);
    border-right: 5px groove rgb(207, 107, 13);
    border-bottom: 5px groove rgb(202, 64, 0);
    display: flex;
    align-items: center;
    
}

.topic {
    width: 70%;
    height: 60px;
    border-left: 2px solid;
    border-right: 2px solid;
    border-color: #bd6615;
    margin-left: 15px;
    display: block;
    align-content: center;
}

.topic-meta-stat {
    display: flex;
    align-items: center;
}

.topic-meta-last-body {
    width: 30%;
    height: 60px;
    background: rgb(65, 57, 57);
    display: block;
    align-content: center;
    max-width: 25%;
}

.topic-meta-last-name {
    
    font-family: "Bitter", serif;
    color: rgb(242, 247, 217);
    margin-left: 10px;
    display: flex;
}

.topic-meta-last-name-info {
    white-space: nowrap; /* Текст не переносится */
    overflow: hidden; /* Обрезаем всё за пределами блока */
    text-overflow: ellipsis; /* Добавляем многоточие */
    font-family: "Bitter", serif;
    color: rgb(242, 247, 217);
    margin-left: 10px;
}

.topic-meta-last-user {
    
    font-family: "Bitter", serif;
    color: rgb(242, 247, 217);
    margin-left: 10px;
    display: flex;
}

.topic-meta-last-data {
    font-family: "Bitter", serif;
    color: rgb(242, 247, 217);
    margin-left: 10px;
}

.image {
    width: 45px;
    height: 45px;
    margin-left: 15px;
    
}
.limit{
    text-overflow: ellipsis;
  white-space: nowrap;
  overflow: hidden;
}
</style>
