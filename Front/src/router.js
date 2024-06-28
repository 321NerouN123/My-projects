import { createRouter, createWebHashHistory,  } from "vue-router";
import store from './store';
import About from "./components/About.vue";

import Home from "./Home.vue";
import Autorization from "./components/Autorization.vue";
import PostsNewsForum from "./components/PostsNewsForum.vue";
import PostsNewsGames from "./components/PostsNewsGames.vue";
import PostsNewsCompany from "./components/PostsNewsCompany.vue";
import PostsPresentationGames from "./components/PostsPresentationGames.vue";
import PostsApplicationFeedback from "./components/PostsApplicationFeedback.vue";
import PostsPresentationProgramms from "./components/PostsPresentationProgramms.vue";
import PostsNewGames from "./components/PostsNewGames.vue";
import PostsDevelopmentGames from "./components/PostsDevelopmentGames.vue";
import PostsFindGame from "./components/PostsFindGame.vue";
import PostsQuestionGame from './components/PostsQuestionGame.vue'
import PostsQuestionProgramm from './components/PostsQuestionProgramm.vue'
import PostsDevelopment from './components/PostsDevelopment.vue'
import PostsDesign from './components/PostsDesign.vue'
import PostsInteractivity from './components/PostsInteractivity.vue'
import Post from "./components/Post.vue";
import CreatePost from "./components/CreatePost.vue";

const routes =  [
        { path: '/Home', component: Home, alias: '/'},
        { path: '/About', component: About },
        { path: '/Entry', component: Autorization },
        { path: '/PostsNewsForum', component: PostsNewsForum },
        { path: '/PostsNewsGames', component: PostsNewsGames },
        { path: '/PostsNewsCompany', component: PostsNewsCompany },
        { path: '/PostsPresentationGames', component: PostsPresentationGames },
        { path: '/PostsApplicationFeedback', component: PostsApplicationFeedback },
        { path: '/PostsPresentationProgramms', component: PostsPresentationProgramms },
        { path: '/PostsNewGames', component: PostsNewGames },
        { path: '/PostsDevelopmentGames', component: PostsDevelopmentGames },
        { path: '/PostsFindGame', component: PostsFindGame },
        { path: '/PostsQuestionGame', component: PostsQuestionGame },
        { path: '/PostsQuestionProgramm', component: PostsQuestionProgramm },
        { path: '/PostsDevelopment', component: PostsDevelopment },
        { path: '/PostsDesign', component: PostsDesign },
        { path: '/PostsInteractivity', component: PostsInteractivity },
        { path: '/Post', component: Post },
        { path: '/Post/:postId', name: 'Post', component: Post },
        { path: '/CreatePost/:topicId', name: 'CreatePost', component: CreatePost,
             meta: {
                requiresAuth: true // Добавляем мета-свойство для проверки авторизации
            } 
        }
    ]

    const router = createRouter({
        history: createWebHashHistory(),
        routes
    });
    

    router.beforeEach((to, from, next) => {
        if (to.matched.some(record => record.meta.requiresAuth)) {
            if (!store.getters.isAuthenticated) {
                alert("Авторизуйтесь на сайте, для доступа к этой странице!");
                next('/Entry');
            } else {
                next();
            }
        } else {
        next();
        }
    });

    export default router;

