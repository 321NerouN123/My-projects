import './assets/main.css'

import { createApp } from 'vue'
import App from './App.vue'
import About from './components/About.vue' // Импортируем компонент About
import Navigation from './components/Navigation.vue'
import Content from './components/Content.vue'
import Footer from './components/Footer.vue'
import Autorization from './components/Autorization.vue'
import PostsNewsForum from './components/PostsNewsForum.vue'
import PostsNewsGames from './components/PostsNewsGames.vue'
import PostsNewsCompany from './components/PostsNewsCompany.vue'
import PostsPresentationGames from './components/PostsPresentationGames.vue'
import PostsApplicationFeedback from './components/PostsApplicationFeedback.vue'
import PostsPresentationProgramms from './components/PostsPresentationProgramms.vue'
import PostsNewGames from './components/PostsNewGames.vue'
import PostsDevelopmentGames from './components/PostsDevelopmentGames.vue'
import PostsFindGame from './components/PostsFindGame.vue'
import PostsQuestionGame from './components/PostsQuestionGame.vue'
import PostsQuestionProgramm from './components/PostsQuestionProgramm.vue'
import PostsDevelopment from './components/PostsDevelopment.vue'
import PostsDesign from './components/PostsDesign.vue'
import PostsInteractivity from './components/PostsInteractivity.vue'
import Post from './components/Post.vue'
import CreatePost from './components/CreatePost.vue'
import MyEditor from './components/MyEditor.vue'

import router from './router'
import store from './store';




const app = createApp(App)

app.use(router)
app.use(store)

app.component('About', About) // Регистрируем компонент About как глобальный
app.component('Navigation', Navigation)
app.component('Content', Content)
app.component('Footer', Footer)
app.component('Autorization', Autorization)
app.component('PostsNewsForum', PostsNewsForum)
app.component('PostsNewsGames', PostsNewsGames)
app.component('PostsNewsCompany', PostsNewsCompany)
app.component('PostsPresentationGames', PostsPresentationGames)
app.component('PostsApplicationFeedback', PostsApplicationFeedback)
app.component('PostsPresentationProgramms', PostsPresentationProgramms)
app.component('PostsNewGames', PostsNewGames)
app.component('PostsDevelopmentGames', PostsDevelopmentGames)
app.component('PostsFindGame', PostsFindGame)
app.component('PostsQuestionGame', PostsQuestionGame)
app.component('PostsQuestionProgramm', PostsQuestionProgramm)
app.component('PostsDevelopment', PostsDevelopment)
app.component('PostsDesign', PostsDesign)
app.component('PostsInteractivity', PostsInteractivity)
app.component('Post', Post)
app.component('CreatePost', CreatePost)
app.component('MyEditor', MyEditor)


app.mount('#app')