<template>
  <div class="information">
    <h1>
      ¡Bienvenido
      <span>{{ userDetailById.name }}</span
      >!
    </h1>

    <div class="details">
      <h3>Su información es la siguiente</h3>

      <h2>
        Nombre de usuario:
        <span>{{ userDetailById.username }}</span>
      </h2>

      <h2>
        Correo electrónico: 
        <span> {{ userDetailById.email }}</span>
      </h2>
      <h2>
        Nombre: 
        <span> {{  jugadorByNombre.nombre }}</span>
      </h2>
      <h2>
        Edad:
        <span>{{ jugadorByNombre.edad }}</span>
      </h2>
    </div>
  </div>
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
  }

};
</script>

<style>
.information {
  margin: 0;
  padding: 0%;
  width: 100%;
  height: 100%;
  background-image: url(../assets/home4.jpg);
  background-size: 100%;
  height: 563px;
  max-width: 1400px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

.information h1 {
  font-size: 40px;
  color: white;
}

.information h2 {
  font-size: 30px;
  color: white;
}

.information span {
  color: white;
  font-weight: bold;
}

.details h3 {
  font-size: 20px;
  color: white;
  text-align: center;
}

.details h2 {
  font-size: 20px;
  color: white;
}
.details {
  border: 3px solid rgba(111, 219, 33, 0.3);
  border-radius: 20px;
  padding: 30px 80px;
  margin: 30px 0 0 0;
}
</style>
