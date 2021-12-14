<template>

  <div id="app" class="app">

    
      <div class="ui container">

        <div class="left menu">
          <router-link class="item" to="/user/home">
            <img  class="ui small image"  src="./assets/FUT_logo.png" alt="Ecommerce"/>
          </router-link>
          <router-link class="item" to="/user/home">
            <h1>FUTMATCH</h1>
          </router-link>
        </div>

        <div class="right menu">
          <button v-if="!is_auth" v-on:click="loadHome"> Inicio </button>
          <button v-if="!is_auth" v-on:click="loadLogIn" > Iniciar Sesión </button>
          <button v-if="is_auth" v-on:click="logOut"> Cerrar Sesión </button>
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
.ui.menu.secondary {
  background-color: #0005088e;

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
}
</style>