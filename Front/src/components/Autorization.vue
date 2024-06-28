<template>
    <Navigation />
    <div class="content">
        <div class="choice-block">
            <transition>
            <div v-show="isShow" class="main-block-left-half">
                <h1 class="left-half">Добро пожаловать назад!</h1>
                <p><b>Если вы участник форума, то войдите в свой аккаунт</b></p>
                <button class="entry" @click="isShow = !isShow"><b>SIGN IN</b></button>
            </div>
            </transition>
            <transition>
            <div v-show="!isShow" class="autorization-block">
                <h1 class="left-half">Войдите в аккаунт</h1>
                <form @submit.prevent="handleLogin">
                <input type="text" placeholder="Логин" v-model="login" required />
                <input type="password" placeholder="Пароль" v-model="password" required />
                <button class="enter" type="submit"><b>SIGN IN</b></button>
                <!--<button class="enter" @click="loadUser"><b>SIGN IN</b></button>-->
                </form>
            </div>
            </transition>
            <transition>
            <div v-show="isShow" class="main-block-right-half">
                <h1 class="right-half">Создать аккаунт</h1>
                <form @submit.prevent="signUp">
                    <input type="text" placeholder="Логин" v-model="login2" required minlength="3" maxlength="20" title:="От 3 до 20 символов."/>
                    <input type="email" v-model="email2" placeholder="Почта" required  pattern="[a-zA-Z0-9@.]*" title="Только цифры и латиница"/>
                    <input type="password" v-model="password2" placeholder="Пароль" required pattern="[a-zA-Z0-9]*" minlength="3" maxlength="20" title="Только цифры и латиница. От 3 до 20 символов." />
                    <button class="create" type="submit"><b>SIGN UP</b></button>
                </form>
            </div>
            </transition>
            <transition>
            <div v-show="!isShow" class="registration-block">
                <h1 class="right-half">Нет аккаунта? Так создайте его!</h1>
                <button @click="isShow = !isShow" class="register"><b>SIGN UP</b></button>
            </div>
            </transition>
        </div>
        <!--<div v-show="!isShow" class="autorization-block">
                <h1 class="left-half">Вход в аккаунт</h1>
                <input type="text" placeholder="Логин">
                <input type="text" placeholder="Пароль">
                <button class="enter"><b>SIGN IN</b></button>
        </div>-->
        <!--<div>
            <button @click="loadUser">Load Users</button>
        </div>-->
    </div>
    
    <Footer />
</template>

<script>
import userService from '@/services/userService';
import axios from 'axios';
import { mapActions, mapGetters } from 'vuex';

export default { 
    name: "SwitchDiv",
    data() {
        return {
            isShow: true,
            login: '',
            login2: '',
            email2: '',
            password: '',
            password2: '',
            error: '',
            isLoginAvailable: true,
            isEmailAvailable: true
        };
    },
    props: {
        msg: String 
    },
    computed: {
    ...mapGetters(['isAuthenticated'])
    },
    methods: {
        /*async loadUser(){
            try {
                const user = await userService.getUser();
                console.log(user);
                alert("Успех! Вывод пользователей!");
            } catch (error) {
                console.error("Ошибка загрузки пользователей:", error);
                alert("Ошибка GET запроса на вывод пользователей!");
            }
        },
        */
        async checkLoginAvailability() {
            try {
                const response = await axios.get('http://localhost:8080/api/Entry/checkLogin', {
                    params: { userLogin: this.login2 }
                });
                this.isLoginAvailable = response.data;
            } catch (error) {
                console.error("Ошибка проверки логина:", error);
            }
        },
        async checkEmailAvailability() {
            try {
                const response = await axios.get('http://localhost:8080/api/Entry/checkEmail', {
                    params: { userEmail: this.email2 }
                });
                this.isEmailAvailable = response.data;
            } catch (error) {
                console.error("Ошибка проверки почты:", error);
            }
        },
        async signUp() {
            await this.checkLoginAvailability();
            await this.checkEmailAvailability();

            if (!this.isLoginAvailable) {
                alert("Логин уже занят");
                return;
            }

            if (!this.isEmailAvailable) {
                alert("Почта уже занята");
                return;
            }
            if (this.isAuthenticated == true){
                alert("Для регистрации нужно выйти из системы!")
            }
            else{
                const formData = {
                userLogin: this.login2,
                userPassword: this.password2,
                userEmail: this.email2,
                statusId: {
                    statusId: 1
                }
            };

            axios.post("http://localhost:8080/api/Entry/create", formData)
                .then(response => {
                console.log(response.data);
                alert("Вы успешно зарегистрировались! Теперь выполните вход на сайт!")
                })
                .catch(error => {
                console.error("Ошибка при отправке данных:", error);
                });
            }
            }
            ,
        /*async signIn() {
            try {
                const response = await axios.post('http://localhost:8080/api/Entry', {
                userLogin: this.login,
                userPassword: this.password
            });

            if (response.data.success) {
                this.$router.push('#/Home'); // Перенаправить пользователя на страницу постов
                alert("Вы успешно вошли!")
            } else {
                this.showAlert('Вы ввели неверные данные!');
            }
            } catch (err) {
                if (err.response && err.response.status === 401) {
                    this.showAlert('Вы ввели неверные данные!');
                } else {
                this.showAlert('Произошла ошибка. Пожалуйста, попробуйте снова.');
                }
            }
        },*/
        showAlert(message) {
            alert(message);
        },
        
        ...mapActions({
            loginAction: 'login'
        }),
        async handleLogin() {
            try {
                const success = await this.loginAction({ login: this.login, password: this.password });
                if (success) {
                     // Перенаправить пользователя на страницу постов
                    alert("Вы успешно вошли!");
                } else {
                    this.showAlert('Вы ввели неверные данные!');
                }
            } catch (err) {
                this.showAlert(err.message);
            }
        }
    }
}
</script>

<style scoped>
.v-enter-to {
  transition: opacity 1s ease;
}

.v-enter-from {
  opacity: 0;
}

.v-leave-to {
    opacity: 0;
}

.v-leave-from {
  opacity: 0;
}

.content {
    width: 98%;
    min-height: 71vh;
    background: #27272c;
    margin: auto;
    padding-top: 20px;
    padding-bottom: 19px;
    display: flex;
    justify-content: space-around;
    padding-top: 70px;
}
.choice-block{
    width: 50%;
    min-width: 700px;
    height: 60vh;
    display: flex;
    border-radius: 10px;
}

.main-block-left-half {
    width: 50%;
    height: auto;
    background: rgb(202, 115, 0);
    border-top-left-radius: 10px;
    border-bottom-left-radius: 10px;
    display: block;
    align-content: center;
    text-align: center;
    padding: 20px;
    position: relative;
}

.main-block-right-half {
    width: 50%;
    height: auto;
    background: rgb(26, 26, 26);
    border-top-right-radius: 10px;
    border-bottom-right-radius: 10px;
    display: block;
    align-content: center;
    text-align: center;
    padding: 20px;
    font-family: "Bitter", serif;
}

.autorization-block{
    width: 50%;
    height: auto;
    background: rgb(202, 115, 0);
    border-top-left-radius: 10px;
    border-bottom-left-radius: 10px;
    display: block;
    align-content: center;
    text-align: center;
    padding: 20px;
}

.registration-block{
    width: 50%;
    height: auto;
    background: rgb(26, 26, 26);
    border-top-right-radius: 10px;
    border-bottom-right-radius: 10px;
    display: block;
    align-content: center;
    text-align: center;
    padding: 20px;
    font-family: "Bitter", serif;
}

h1.left-half {
    font-family: "Bitter", serif;
    color: rgb(26, 26, 26);
    
}

h1.right-half {
    font-family: "Bitter", serif;
    color: rgb(242, 247, 217);
    
}

p {
    font-family: "Bitter", serif;
    color: rgb(26, 26, 26);
    font-size: 14pt;
}

.entry {
    background-color: rgb(202, 115, 0);
    width: 180px;
    height: 50px;
    border-radius: 30px;
    border-color: rgb(26, 26, 26);
    border-style: solid;
    font-family: "Bitter", serif;
    color: rgb(26, 26, 26);
    font-size: 14pt;
    margin-top: 20px;
}

button.entry:hover {
	background: rgb(26, 26, 26);
    color: rgb(242, 247, 217);
    border-color: rgb(242, 247, 217);
}

.create {
    background-color: rgb(26, 26, 26);
    width: 180px;
    height: 50px;
    border-radius: 30px;
    border-color: rgb(242, 247, 217);
    border-style: solid;
    font-family: "Bitter", serif;
    color: rgb(242, 247, 217);
    font-size: 14pt;
    margin-top: 20px;
}

button.create:hover {
	background: rgb(202, 115, 0);
    color: rgb(26, 26, 26);
    border-color: rgb(26, 26, 26);
}

.enter {
    background-color: rgb(202, 115, 0);
    width: 180px;
    height: 50px;
    border-radius: 30px;
    border-color: rgb(26, 26, 26);
    border-style: solid;
    font-family: "Bitter", serif;
    color: rgb(26, 26, 26);
    font-size: 14pt;
    margin-top: 20px;
}

button.enter:hover {
	background: rgb(26, 26, 26);
    color: rgb(242, 247, 217);
    border-color: rgb(242, 247, 217);
}

.register {
    background-color: rgb(26, 26, 26);
    width: 180px;
    height: 50px;
    border-radius: 30px;
    border-color: rgb(242, 247, 217);
    border-style: solid;
    font-family: "Bitter", serif;
    color: rgb(242, 247, 217);
    font-size: 14pt;
    margin-top: 20px;
}

button.register:hover {
	background: rgb(202, 115, 0);
    color: rgb(26, 26, 26);
    border-color: rgb(26, 26, 26);
}

input {
    display: block;
    margin: auto;    
    height: 25px;
    width: 250px;
    margin-top: 10px;
    border-style: none;
    outline: none;
}
</style>