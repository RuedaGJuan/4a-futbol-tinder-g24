<template>
  <html>
    <BasicLayouts>
      <div class="login">
        <h2>INICIA SESIÓN</h2>
        <form class="ui form" v-on:submit.prevent="processLogInUser">
          <div class="field">
            <input type="text" v-model="user.username" placeholder="Usuario">
          </div>

          <div class="field">
            <input
              type="password" v-model="user.password" placeholder="Contraseña">
          </div>

          <button
            class="ui button fluid green"  type="submit" :class="{ loading }"
          >
            ENTRAR
          </button>
        </form>
      </div>
      <footer class="footer">
        <p>Todos los derechos reservados Grupo FutMatch P24 C4. 2021</p>
      </footer>
    </BasicLayouts>
  </html>
</template>

<script>
import BasicLayouts from "../layouts/BasicLayouts.vue";
import gql from "graphql-tag";

export default {
  name: "LogIn",
  components: {
    BasicLayouts,
  },
  data: function () {
    return {
      user: {
        username: "",
        password: "",
      },
    };
  },

  methods: {
    processLogInUser: async function () {
      await this.$apollo
        .mutate({
          mutation: gql`
            mutation ($credentials: CredentialsInput!) {
              logIn(credentials: $credentials) {
                refresh
                access
              }
            }
          `,
          variables: {
            credentials: this.user,
          },
        })
        .then((result) => {
          let dataLogIn = {
            username: this.user.username,
            token_access: result.data.logIn.access,
            token_refresh: result.data.logIn.refresh,
          };

          this.$emit("completedLogIn", dataLogIn);
        })
        .catch((error) => {
          alert("ERROR 401: Credenciales Incorrectas.");
        });
    },
  },
};
</script>

<style lang="scss" scoped>
@import url("https://fonts.googleapis.com/css2?family=Major+Mono+Display&family=Readex+Pro:wght@700&display=swap");
html {
  background-color: black;
  background-image: url(../assets/home2.jpg);
  margin-bottom: 2rem;
  position: relative;
  background-size: 100%;
  height: 645px;
  max-width: 1400px;
}
.login {
  margin-left: 260px;
  margin-top: 120px;
  text-align: center;
  h2 {
    font-size: 2rem;
    margin: 50px 0 30px 0;
    color: white;
  }
  .ui.form {
    max-width: 300px !important;
    margin: 0 auto;
    margin-bottom: 100px;
    input.error {
      border-color: #faa;
      background-color: #ffeded;
    }
  }
}
.footer {
  text-align: right;
  font-weight: lighter;
  color: white;
  margin-top: 190px;
}
</style>
