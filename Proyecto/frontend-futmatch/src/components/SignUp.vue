<template>
  <body>
    <BasicLayouts>
      <div class="register">
        <h2>CREA TU PERFIL</h2>
        <form class="ui form" v-on:submit.prevent="processSignUp">
          <div class="field">
            <input type="text" v-model="user.username" placeholder="Usuario" />
          </div>
          <div class="field">
            <input
              type="password"
              v-model="user.password"
              placeholder="Contraseña"
            />
          </div>
          <div class="field">
            <input type="text" v-model="user.name" placeholder="Nombre" />
          </div>
          <div class="field">
            <input
              type="email"
              v-model="user.email"
              placeholder="Correo electrónico"
            />
          </div>
          <div class="field">
            <input type="text" v-model="user.age" placeholder="Edad" />
          </div>
          <button
            class="ui button fluid grey"
            type="submit"
            :class="{ loading }"
          >
            CREAR USUARIO
          </button>
        </form>
      </div>
      <footer class="footer">
        <p>Todos los derechos reservados Grupo FutMatch P24 C4. 2021</p>
      </footer>
    </BasicLayouts>
  </body>
</template>

<script>
import BasicLayouts from "../layouts/BasicLayouts.vue";
import gql from "graphql-tag";

export default {
  name: "SignUp",
  components: {
    BasicLayouts,
  },
  data: function () {
    return {
      user: {
        username: "",
        password: "",
        name: "",
        email: "",
        balance: 0,
      },
    };
  },

  methods: {
    processSignUp: async function () {
      await this.$apollo
        .mutate({
          mutation: gql`
            mutation ($userInput: SignUpInput!) {
              signUpUser(userInput: $userInput) {
                refresh
                access
              }
            }
          `,
          variables: {
            userInput: this.user,
          },
        })
        .then((result) => {
          let dataLogIn = {
            username: this.user.username,
            token_access: result.data.signUpUser.access,
            token_refresh: result.data.signUpUser.refresh,
          };

          this.$emit("completedSignUp", dataLogIn);
        })
        .catch((error) => {
          alert("ERROR: Fallo en el registro.");
        });
    },
  },
};
</script>

<style lang="scss" scoped>
@import url("https://fonts.googleapis.com/css2?family=Major+Mono+Display&family=Readex+Pro:wght@700&display=swap");
body {
  background-color: black;
  background-image: url(../assets/register3.jpg);
  background-size: 100%;
  height: 645px;
  max-width: 1400px;
}

.register {
  margin-left: 490px;
  text-align: center;
  h2 {
    margin: 90px 0 30px 0;
    color: white;
  }
  .ui.form {
    max-width: 300px;
    margin: 0 auto;
    margin-bottom: 10px;
    input.error {
      border-color: #faa;
      background-color: #ffeded;
    }
  }
}
.footer {
  text-align: right;
  font-weight: lighter;
  margin-top: 62px;
  margin-bottom: 60px;
  color: white;
}
</style>
