
import Vuex from 'vuex';
import axios from 'axios';



export default new Vuex.Store({
    state: {
      user: JSON.parse(localStorage.getItem('user')) || null, // Восстанавливаем пользователя из localStorage, если он есть // Здесь будет храниться информация о текущем пользователе
      previousRoute: null
    },
    mutations: {
      // Мутации для изменения состояния
      setUser(state, user) {
        state.user = user;
        localStorage.setItem('user', JSON.stringify(user));
      },
      clearUser(state) {
        state.user = null;
        localStorage.removeItem('user');
    },
    setPreviousRoute(state, route) {
        state.previousRoute = route;
    }
    },
    actions: {
      async login({ commit }, { login, password }) {
        try {const response = await axios.post('http://localhost:8080/api/Entry', {
            userLogin: login,
            userPassword: password
        });

        if (response.data.success) {
            const user = response.data.user; // предположим, что информация о пользователе возвращается в response.data.user
            commit('setUser', user);
            return true;
          } else {
            return false;
          }

        } catch (err) {
            if (err.response && err.response.status === 401) {
                return false;
              } else {
                throw new Error('Произошла ошибка. Пожалуйста, попробуйте снова.');
              }
        }
        
      },
      logout({ commit }) {
        commit('clearUser');
        
      },
      setPreviousRoute({ commit }, route) {
        commit('setPreviousRoute', route);
      }
    },
    getters: {
      // Геттеры для получения данных из состояния
      isAuthenticated: state => !!state.user,
      user: state => state.user,
      previousRoute: state => state.previousRoute
    }
  });