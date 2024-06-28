<template>
    <Navigation />
    <div class="content">
        <div>
            <h1>{{ post.postName }}</h1>
            <p><div v-html="postContent.contentText" class="text"></div></p>
        </div>
        <div class="separator"></div>
        <div class="comments">
            <div v-if="comments.length > 0">
                <h2>Комментарии:</h2>
                <div v-for="(comment, index) in comments" :key="comments.commentId" :class="{'comment-block': true, 'comment-block-2': index % 2 !== 0}">
                    <div class="comment-header">
                        <span class="username">{{ comment.userId.userLogin }}</span>
                        <span class="date">{{ comment.commentDate }}</span>
                    </div>
                    <p><div v-html="comment.commentText" class="comment-body"></div></p>
                </div>
            </div>
            <div v-else class="label-info"> Комментариев пока нет</div>
        </div>
        
            <button v-if="isAuthenticated"  @click="isShow = !isShow" v-show="isShow" >Оставить комментарий</button>
            <div v-else class="label-info">Авторизуйтесь на сайте, чтобы оставить комментарий!</div>
            <form @submit.prevent="submitPost">
            <div v-show="!isShow" class="editor-container">
                <Editor
                            api-key="9vn7dcjf3ic2qihj0sumi8dtlv3edb95xdalftaahx46xt0r"
                            v-model="contentText"
                            :init="{
                            height: 470,
                            width: '97%',
                            menubar: true,
                            plugins: 'link image code lists',
                            toolbar:
                                'undo redo | formatselect | bold italic | \
                                alignleft aligncenter alignright | \
                                bullist numlist outdent indent | removeformat | help',
                            //content_css: 'content.css'
                            content_style: 'body { background: #303036; font-size: 20px; color: rgb(242, 247, 217); }'
                        }"
                         @focus="handleFocus"
                         @blur="handleBlur"
                    />
            </div>
            <br>
            <button v-show="!isShow" type="submit">Отправить</button>
            </form>
            <div class="Btn-Back">
                <button @click="goBack" class="Btn-Bac1">Назад</button>
            </div>
            
    </div>
    <Footer />
</template>

<script>
import axios from 'axios';
import { ref, computed } from 'vue';
import  Editor  from '@tinymce/tinymce-vue';
import { useRoute } from 'vue-router';
import { mapGetters, useStore } from 'vuex';


export default {
  name: 'Post',
  components: {
    Editor
  },
  data() {
    return {
      post: {},
      postContent: {},
      comments: [],
      isShow: true,
      contentText: '<p>Введите комментарий</p>\n<p>Не стеснятейсь пользоваться форматированием.</p>',
      defaultText: '<p>Введите комментарий</p><p>Не стеснятейсь пользоваться форматированием.</p>',
      defaultText2: '<p>Введите комментарий</p>\n<p>Не стеснятейсь пользоваться форматированием.</p>'
    };
  },
  setup(){
    const contentText = ref('');
    const store = useStore();  // Получение доступа к хранилищу Vuex
    const userId = computed(() => store.getters.user.userId);  // Доступ к userId через геттер
    const route = useRoute();
    const postId = ref(route.params.postId);
    const defaultText = '<p>Введите комментарий</p><p>Не стеснятейсь пользоваться форматированием.</p>';
    const defaultText2 = '<p>Введите комментарий</p>\n<p>Не стеснятейсь пользоваться форматированием.</p>';

    const submitPost = async () => {
        if (contentText.value == '' || contentText.value.length >= 501 || contentText.value == defaultText || contentText.value == defaultText2){
            alert("Вы ввели пустой или превысили ограничение комментария в 500 символов!")
        } else{
            const postData = {
            commentText: contentText.value,
            postId: postId.value,
            userId: userId.value
        };

        try {
            const response = await fetch('http://localhost:8080/api/Posts/comment/create', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(postData)
            });

            if (response.ok) {
                const data = await response.json();
                console.log('Успешно отправлено:', data);
                alert("Комментарий успешно создан!")
                //Перезагрузит страницу
                window.location.reload();
            } else {
                console.error('Ошибка при отправке:', response.statusText);
                alert("При отправке комменатрия произошла ошибка");
            }
        } catch (error){
            onsole.error('Ошибка отправки данных:', error);
            alert("При отправке комментария произошла ошибка!")
        }
        console.log('userId:', userId.value);
        console.log('postId:', postId.value);
        console.log('Content:', contentText.value);
        }
    }
    return {
        contentText,
        userId,
        postId,
        submitPost
    };
  },
  created() {
    this.fetchPost();
    this.fetchPostContent();
    this.fetchPostComments();
    this.handleBlur();

    this.incrementViews();
  },
  computed: {
    ...mapGetters(['isAuthenticated', 'user'])
  },
  methods: {
    async fetchPost() {
      const postId = this.$route.params.postId;
      try {
        const response = await axios.get(`http://localhost:8080/api/Posts/${postId}`);
        this.post = response.data;
      } catch (error) {
        console.error('Error fetching post:', error);
      }
    },
    async fetchPostContent() {
      const postId = this.$route.params.postId;
      try {
        const response = await axios.get(`http://localhost:8080/api/Posts/content/${postId}`);
        this.postContent = response.data;
      } catch (error) {
        console.error('Error fetching post content:', error);
      }
    },
    async fetchPostComments(){
        const postId = this.$route.params.postId;
        try{
            const response = await axios.get(`http://localhost:8080/api/Posts/comment/${postId}`);
            this.comments = response.data;
        } catch (error) {
            console.log("Ошибка вывода комментариев!", error);
        }
    },
    handleFocus() {
      if (this.contentText === this.defaultText || this.contentText === this.defaultText2) {
        this.contentText = '';
      }
    },
    handleBlur() {
      if (this.contentText === '') {
        this.contentText = this.defaultText;
      }
    },
    async incrementViews() {
      try {
        await axios.put(`http://localhost:8080/api/Posts/${this.postId}/incrementViews`);
      } catch (error) {
        console.error('Error incrementing views:', error);
      }
    },
    goBack() {
      this.$router.go(-1);
    }
  }
};
</script>

<style scoped>

.content {
    width: 98%;
    min-height: 80vh;
    background: #27272c;
    margin: auto;
    padding-top: 20px;
    padding-bottom: 15px;
    font-family: "Bitter", serif;
    color: rgb(242, 247, 217);
}

h1 {
    margin-left: 30px;
}

h2{
    margin-left: 30px;
}

.text {
    margin-left: 30px;
}

.separator{
    width: 99%;
    height: 2px;
    background-color: rgb(189, 102, 21);
    margin: auto;
    margin-top: 50px;
}

.comment-block {
  background-color: #232327;
  border: 1px solid rgb(189, 102, 21);
  border-radius: 10px;
  padding: 15px;
  margin: 20px 0;
  color: rgb(242, 247, 217);
  max-width: 850px;
  margin-left: 50px;
}

.comment-block-2 {
  background-color: #303036;
  border: 1px solid rgb(189, 102, 21);
  border-radius: 10px;
  padding: 15px;
  margin: 20px 0;
  color: rgb(242, 247, 217);
  max-width: 850px;
  margin-left: 50px;
}

.comment-header {
  display: flex;
  justify-content: space-between;
  margin-bottom: 10px;
}

.username {
  font-weight: bold;
  color: rgb(189, 102, 21);
}

.date {
  font-size: 0.9em;
  color: rgb(189, 102, 21);
}

.comment-body p {
  margin: 0;
}

button {
    font-family: "Bitter", serif;
    color: rgb(242, 247, 217);
    font-size: 14px;
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
    margin-left: 50px;
    margin-top: 20px;
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

.editor-container{
    margin-left: 50px;
    margin-top: 20px;
}

.Btn-Back{
    text-align: right;
    margin-bottom: 10px; /* Отступ снизу */
    margin-right: 50px;
}

.label-info {
    margin-left: 50px;
    margin-top: 20px;
}
</style>
