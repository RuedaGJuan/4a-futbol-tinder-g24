<template>
  <div id="app" class="app">
    <div class="ui secondary menu">
      <div class="ui container">
        <div class="left menu">
          <router-link class="item" to="/">
            <img
              class="ui small image"
              src="./assets/FUT_logo.png"
              alt="Ecommerce"
            />
          </router-link>
          <router-link class="item" to="/home">
            <h1>FUTMATCH</h1>
          </router-link>
        </div>
        <div class="right menu">
          <router-link
            class="item"
            to="/home"
            v-if="!is_auth"
            v-on:click="loadHome"
          >
            HOME
          </router-link>
          <router-link
            class="item"
            to="/login"
            v-if="!is_auth"
            v-on:click="loadLogIn"
          >
            LOGIN
          </router-link>
          <router-link
            class="item"
            to="/user/perfil"
            v-if="is_auth"
            v-on:click="loadPerfil"
            >MI PERFIL</router-link
          >
          <router-link
            class="item"
            to="/user/convocatorias"
            v-if="is_auth"
            v-on:click="loadConvocatorias"
            >CONVOCATORIAS</router-link
          >
          <router-link
            class="item"
            to="/home"
            v-if="is_auth"
            v-on:click="logOut"
            >CERRAR SESIÓN</router-link
          >
        </div>
      </div>
    </div>
  </div>
  <div class="main-component">
    <router-view
      v-on:completedLogIn="completedLogIn"
      v-on:completedSignUp="completedSignUp"
      v-on:logOut="logOut"
      v-on:loadHome="loadHome"
      v-on:loadPerfil="loadPerfil"
    >
    </router-view>
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
      this.$router.push({ name: "Login" });
    },

    loadSignUp: function () {
      this.$router.push({ name: "SignUp" });
    },

    completedLogIn: function (data) {
      localStorage.setItem("username", data.username);
      localStorage.setItem("token_access", data.token_access);
      localStorage.setItem("token_refresh", data.token_refresh);
      alert("Autenticación Exitosa");
      this.loadPerfil();
    },

    completedSignUp: function (data) {
      alert("Registro Exitoso");
      this.completedLogIn(data);
    },

    loadConvocatorias: function () {
      this.$router.push({ name: "Convocatorias" });
    },

    loadHome: function () {
      this.$router.push({ name: "Home" });
    },

    loadPerfil: function () {
      this.$router.push({ name: "Perfil" });
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
.app {
  background-color: black;
}
.ui.menu.secondary {
  background-color: #000508;

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
