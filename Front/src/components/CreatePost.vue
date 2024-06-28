<template>
    <Navigation />
        <div class="content">
            <div>
                <h1>Создание поста в категории "{{ topic.topicName}}"</h1>
                <form @submit.prevent="submitPost">
                    <label>Введите название поста:</label><br><br>
                    <textarea rows="2" v-model="title" @input="limitText"></textarea>
                    <p style="margin-left: 20px;">{{ remainingCharacters }} символов осталось</p>

                    <br>
                
                    <label for="content">Введите текст:</label><br><br>
                    <div class="editor-container">
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
                    <button type="submit">Отправить</button>
                </form>
            </div>
        </div>
    <Footer />
    
</template>

<script>
import { ref, computed } from 'vue';
import  Editor  from '@tinymce/tinymce-vue';
import axios from 'axios';
import { useRoute, useRouter } from 'vue-router';
import { useStore } from 'vuex';

export default {
    name: 'CreatePost',
  components: {
    Editor
  },
  data() {
    return {
        title: '',
        maxLength: 100,
        defaultText: '<p>Введите текст, какой бы вы хотели его увидеть на сайте...</p><p>Не стеснятесь пользоваться форматированием, оно сделает ваш пост приятным для чтения.</p>',
        defaultText2: '<p>Введите текст, какой бы вы хотели его увидеть на сайте...</p>\n<p>Не стеснятесь пользоваться форматированием, оно сделает ваш пост приятным для чтения.</p>',
        contentText: '<p>Введите текст, какой бы вы хотели его увидеть на сайте...</p>\n<p>Не стеснятейсь пользоваться форматированием, оно сделает ваш пост приятным для чтения.</p>',
        topic: {}
    };
  },
  computed: {
    remainingCharacters() {
        return this.maxLength - this.title.length;
    }
  },
  created(){
    this.fetchTopicName();
    this.handleBlur();
  },
  methods: {
    limitText() {
        if (this.title.length > this.maxLength) {
            this.title = this.title.slice(0, this.maxLength);
        }
    },
    async fetchTopicName(){
        const topicId = this.$route.params.topicId;
      try {
        const response = await axios.get(`http://localhost:8080/api/CreatePost/${topicId}`);
        this.topic = response.data;
      } catch (error) {
        console.error('Error fetching post:', error);
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
    }
  },
  setup() {
    const title = ref('');
    const contentText = ref('');
    const route = useRoute();
    const router = useRouter();
    const topicId = ref(route.params.topicId);
    //const userId = 2;
    const store = useStore();  // Получение доступа к хранилищу Vuex
    const userId = computed(() => store.getters.user.userId);  // Доступ к userId через геттер

    const submitPost = async () => {
        if (title.value == ''){
            alert("Введите название поста!");
        } else {

        const postData = {
            postName: title.value,
            contentText: contentText.value,
            topicId: topicId.value,
            userId: userId.value
        };

        console.log(postData);

        if (contentText.value.length <= 199){
            console.log(contentText.value);
            alert("Вы ввели меньше 200 символов поста!");
        } else {

        try {
            const response = await fetch('http://localhost:8080/api/Posts/create', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(postData),
        });
        if (response.ok) {
            const data = await response.json();
            console.log('Успешно отправлено:', data);
            alert("Пост успешно создан!")
            // Перенаправить пользователя на страницу списка постов
            router.push('/Home');
        } else {
            console.error('Ошибка при отправке:', response.statusText);
            alert("При отправке поста произошла ошибка!")
        }
        } catch (error){
            console.error('Ошибка отправки данных:', error);
            alert("При отправке поста произошла ошибка!")
        }

      console.log('Title:', title.value);
      console.log('Content:', contentText.value);
    }
    }
    };

    return {
      title,
      contentText,
      userId,
      submitPost
    };
  }
};

    
</script>

<style scoped>

.content {
    width: 98%;
    min-height: 76.6vh;
    background: #27272c;
    margin: auto;
    padding-top: 20px;
    padding-bottom: 15px;
    font-family: "Bitter", serif;
    color: rgb(242, 247, 217);
}

.red-form {
    background-color: red;
    color: white; /* Цвет текста */
  }

form {
    margin-left: 50px;
}

h1{
    margin-left: 30px;
}


textarea {
        width: 75%;
        min-width: 617px;
        height: 3em;
        resize: none; /* Запрещаем изменение размеров textarea */
        font-size: 12pt;
        background: #303036;
        border: rgb(189, 102, 21)  2px solid;
        font-family: "Bitter", serif;
        color: rgb(242, 247, 217);
        padding: 10px;
    }

.editor-container{
    
    min-width: 660px; /* Минимальная ширина контейнера */
 
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

</style>