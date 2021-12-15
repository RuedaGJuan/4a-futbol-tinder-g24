<template>
  <body>
    <div class="texto">
      <h2>
        ¡Hola
        <span>{{ userDetailById.name }}</span
        >!
      </h2>

      <div>
        <h5>Los datos de tu perfil son los siguientes:</h5>
        <h5>
          Nombre:
          <span> {{ jugadorByNombre.nombre }}</span>
        </h5>
        <h5>
          Usuario:
          <span>{{ userDetailById.username }}</span>
        </h5>
        <h5>
          Correo electrónico:
          <span> {{ userDetailById.email }}</span>
        </h5>

        <h5>
          Edad:
          <span>{{ jugadorByNombre.edad }}</span>
        </h5>
        <button class="ui grey button">MODIFICAR</button>
      </div>
    </div>

    <footer class="footer">
      <p>Todos los derechos reservados Grupo FutMatch P24 C4. 2021</p>
    </footer>
  </body>
</template>

<script>
import gql from "graphql-tag";
import jwt_decode from "jwt-decode";

export default {
  name: "Perfil",

  data: function () {
    return {
      userId: jwt_decode(localStorage.getItem("token_refresh")).user_id,
      userDetailById: {
        username: "",
        name: "",
        email: "",
      },
      jugadorByNombre: {
        nombre: "",
        edad: "",
      },
    };
  },

  apollo: {
    userDetailById: {
      query: gql`
        query ($userId: Int!) {
          userDetailById(userId: $userId) {
            username
            name
            email
          }
        }
      `,
      variables() {
        return {
          userId: this.userId,
        };
      },
    },

    jugadorByNombre: {
      query: gql`
        query ($nombre: String!) {
          jugadorByNombre(nombre: $nombre) {
            nombre
            edad
          }
        }
      `,
      variables() {
        return {
          nombre: this.userDetailById.name,
        };
      },
    },
  },

  created: function () {
    this.$apollo.queries.userDetailById.refetch();
    this.$apollo.queries.jugadorByNombre.refetch();
  },
};
</script>

<style lang="scss" scoped>
@import url("https://fonts.googleapis.com/css2?family=Major+Mono+Display&family=Readex+Pro:wght@700&display=swap");
body {
  background-color: rgba(38, 42, 47, 0.87);
  background-image: url(../assets/perfil2.jpg);
  background-size: 100%;
  height: 580px;
}

.texto {
  margin-left: 790px;
  color: white;
  padding-top: 1.6%;
  h2 {
    font-size: 5rem;
  }
  h5 {
    font-size: 1.2rem;
    margin-left: 30px;
  }
  button {
    margin-left: 250px;
  }
}

.footer {
  text-align: right;
  font-weight: lighter;
  color: white;
  padding-top: 3.2%;
  padding-right: 3%;
}
</style>
