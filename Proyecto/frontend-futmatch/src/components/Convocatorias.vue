<template>
  <body>
    <div class="crear-convocatorias">
      <h2>CREAR CONVOCATORIA</h2>
      <form class="ui form" v-on:submit.prevent="processConvocatoria">
        <div class="field">
          <input
            type="text"
            v-model="createConvocatoria.fecha"
            placeholder="Fecha"
          />
        </div>
        <div class="field">
          <input
            type="text"
            v-model="createConvocatoria.hora"
            placeholder="Hora"
          />
        </div>
        <div class="field">
          <input
            type="text"
            v-model="createConvocatoria.localidad"
            placeholder="Localidad"
          />
        </div>
        <button class="ui button fluid grey" type="submit" >
          CREAR CONVOCATORIA
        </button>
      </form>
    </div>

    <div class="ver-convocatorias">
      <h2>CONVOCATORIA VIGENTES</h2>
      <p>Filtros de búsqueda:</p>

      <div class="two fields">
        <div class="field">
          <select class="ui tiny selection dropdown">
            <option value="LC">Localidad</option>
            <option value="SB">Suba</option>
            <option value="UQ">Usaquén</option>
            <option value="KN">Kennedy</option>
            <option value="CH">Chapinero</option>
            <option value="CS">Ciudad Bolivar</option>
            <option value="SC">San Cristobal</option>
            <option value="PA">Puente Aranda</option>
          </select>
        </div>
        <div class="field">
          <div class="ui calendar" id="example1">
            <div class="ui input left icon">
              <i class="calendar icon"></i>
              <input type="text" placeholder="Date" value="2017-06-01" />
            </div>
          </div>
        </div>
      </div>
      <div class="ui inverted segment">
        <div
          class="ui inverted relaxed divided animated list"
          v-for="convocatoria of convocatoriaTodas"
          :key="convocatoria.id"
        >
          <div class="item">
            <div class="right floated content">
              <div class="ui green button">Unirme</div>
            </div>
            <div class="content">
              <div class="header">Fecha: {{ convocatoria.fecha }}</div>
              <div class="content">Hora: {{ convocatoria.hora }}</div>
              <div class="content">Localidad: {{ convocatoria.localidad }}</div>
            </div>
          </div>
        </div>
      </div>
    </div>

    <footer class="footer">
      <p>Todos los derechos reservados Grupo FutMatch P24 C4. 2021</p>
    </footer>
  </body>
</template>

<script>
import gql from "graphql-tag";
export default {
  name: "Convocatorias",

  data: function () {
    return {
      createConvocatoria: {
        fecha: "",
        hora: "",
        localidad: "",
      },
    };
  },
  methods: {
    processConvocatoria: async function () {
      if (
        localStorage.getItem("token_access") === null ||
        localStorage.getItem("token_refresh") === null
      ) {
        this.$emit("logOut");
        return;
      }
      localStorage.setItem("token_access", "");
      await this.$apollo
        .mutate({
          mutation: gql`
            mutation ($refresh: String!) {
              refreshToken(refresh: $refresh) {
                access
              }
            }
          `,
          variables: {
            refresh: localStorage.getItem("token_refresh"),
          },
        })
        .then((result) => {
          localStorage.setItem("token_access", result.data.refreshToken.access);
        })
        .catch((error) => {
          this.$emit("logOut");
          return;
        });
      await this.$apollo
        .mutate({
          mutation: gql`
            mutation ($convocatoria: ConvocatoriaInput!) {
              createConvocatoria(convocatoria: $convocatoria) {
                id
                jugEquip1
                jugEquip2
                fecha
                hora
                localidad
              }
            }
          `,
          variables: {
            convocatoria: this.createConvocatoria,
          },
        })
        .then((result) => {
          alert("Convocatoria creada de manera Correcta");
        })
        .catch((error) => {
          alert("Error al crear la convocatoria");
        });
    },
  },
  apollo: {
    convocatoriaTodas: {
      query: gql`
        query ($fecha: String) {
          convocatoriaTodas(fecha: $fecha) {
            id
            fecha
            hora
            localidad
          }
        }
      `,
      variables() {
        return {};
      },
    },
  },
  created: function () {
    this.$apollo.queries.convocatoriaTodas.refetch();
  },
};
</script>

<style lang="scss" scoped>
@import url("https://fonts.googleapis.com/css2?family=Major+Mono+Display&family=Readex+Pro:wght@700&display=swap");

body {
  background-color: black;
  background-image: url(../assets/convocatorias1.jpg);
  background-size: 100%;
  height: 670px;
  padding-left: 120px;
  padding-top: 60px;
}
.ui.inverted.segment {
  max-height: 300px;
  overflow: scroll;
}
.two.fields {
  display: flex;
}
.ui.calendar {
  margin-left: 0.5rem;
}
.ver-convocatorias {
  margin-left: 620px;
  margin-top: -240px;
  max-width: 410px;
  p {
    color: white;
  }
  h2 {
    // margin: 90px 0 30px 0;
    color: white;
    text-align: center;
  }
  h4 {
    color: white;
  }
}
.crear-convocatorias {
  margin-left: 58px;
  margin-top: 34px;
  max-width: 300px;
  h2 {
    // margin: 90px 0 30px 0;
    color: white;
    text-align: center;
  }
  .ui.form {
    margin: 0 auto;

    input.error {
      border-color: #faa;
      background-color: #ffeded;
    }
  }
}

.footer {
  text-align: left;
  font-weight: lighter;
  margin-top: -20px;
  color: white;
}
</style>
