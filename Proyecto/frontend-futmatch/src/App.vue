<template>

  <div id="app" class="app">

    
    <div class="ui secondary menu">
      <div class="ui container">

          <div class="left menu">
            <router-link class="item" to="/user/home">
              <img class="ui small image" src="./assets/FUT_logo.png" alt="Ecommerce" />
            </router-link>
            
          </div>

          <div class="right menu">
            <button v-if="!is_auth" v-on:click="loadHome"> HOME </button>
            <button v-if="!is_auth" v-on:click="loadLogIn">LOGIN</button>
            <button v-if="is_auth" v-on:click="logOut">CERRAR SESIÓN</button>
          </div>

      </div>
    </div>
  
    <div class="main-component">
      <router-view  
        v-on:completedLogIn="completedLogIn"
        v-on:logOut="logOut"
        v-on:loadhome="loadHome"
      >
      </router-view>
    </div>

    <footer class="footer">
        <p>Todos los derechos reservados Grupo FutMatch P24 C4. 2021</p>
      </footer>

  </div>

    
</template>

<script>
export default {
  name: "App",

  computed: {
    is_auth: {
      get: function () {
        return this.$route.meta.requiresAuth;
      },
      set: function () {},
    },
  },

  methods: {
    loadLogIn: function () {
      this.$router.push({ name: "logIn" });
    },

    loadSignUp: function () {
      this.$router.push({ name: "SignUp" });
    },

    completedLogIn: function (data) {
      localStorage.setItem("username", data.username);
      localStorage.setItem("token_access", data.token_access);
      localStorage.setItem("token_refresh", data.token_refresh);
      alert("Autenticación Exitosa");
      this.loadConvocatorias();
    },

    completedSignUp: function (data) {
      alert("Registro Exitoso");
      this.completedLogIn(data);
    },

    loadConvocatorias: function () {
      this.$router.push({ name: "convocatorias" });
    },

    loadHome: function () {
      this.$router.push({ name: "home" });
    },

    logOut: function () {
      localStorage.clear();
      alert("Sesión Cerrada");
      this.loadHome();
    },
  },
};
</script>

<style lang="scss" scoped>

body{
    margin: 0 0 0 0;
  }

.ui.menu.secondary {
  background-color: #0005088e;
  }

  .item {
    color: #ffffff;
    &:hover {
      color: #21ba45;
    }
  }
  .menu.left {
    width: 40%;
    .ui.image {
      width: 40px;
    }
  }
  .menu.right {
    width: 40%;
    justify-content: flex-end;
    .logout,
    .cart {
      &:hover {
        cursor: pointer;
      }
    }
  
  }

.main-component{
    height: 75vh;
    margin: 0%;
    padding: 0%;

    background: #FDFEFE ;
  }

  .footer {
  text-align: right;
  font-weight: lighter;
  margin-top: 62px;
  margin-bottom: 60px;
  color: white;
}
</style>