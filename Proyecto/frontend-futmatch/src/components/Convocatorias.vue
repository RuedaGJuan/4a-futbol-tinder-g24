<template>
  <body>
    <BasicLayouts>
      <div class="ver-convocatorias">
        <h2>CONVOCATORIAS VIGENTES</h2>
        <div class="ui grey inverted segment">
          <div class="ui inverted relaxed divided animated list">
            <div class="item">
              <div class="right floated content">
                <div class="ui green button">Unirme</div>
              </div>
              <div class="content">
                <div class="header">Snickerdoodle</div>
                An excellent companion
              </div>
            </div>
            <div class="item">
              <div class="right floated content">
                <div class="ui green button">Unirme</div>
              </div>
              <div class="content">
                <div class="header">Poodle</div>
                A poodle, its pretty basic
              </div>
            </div>
            <div class="item">
              <div class="right floated content">
                <div class="ui green button">Unirme</div>
              </div>
              <div class="content">
                <div class="header">Paulo</div>
                He's also a dog
              </div>
            </div>
            <div class="item">
              <div class="right floated content">
                <div class="ui green button">Unirme</div>
              </div>
              <div class="content">
                <div class="header">Paulo</div>
                He's also a dog
              </div>
            </div>
            <div class="item">
              <div class="right floated content">
                <div class="ui green button">Unirme</div>
              </div>
              <div class="content">
                <div class="header">Paulo</div>
                He's also a dog
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="crear-convocatorias">
        <h2>CREAR CONVOCATORIA</h2>
        <form class="ui form" v-om:submit.prevent="processConvocatoria">
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
          <button
            class="ui button fluid grey"
            type="submit"
            :class="{ loading }"
          >
            CREAR CONVOCATORIA
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
import gql from "graphql-tag";
import BasicLayouts from "../layouts/BasicLayouts.vue";

export default {
  name: "Convocatorias",
  BasicLayouts,

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
};
</script>

<style lang="scss" scoped>
body {
  background-color: black;
  background-image: url(../assets/convocatorias1.jpg);
  background-size: 100%;
  height: 759px;
  max-width: 1700px;
}
.ver-convocatorias {
  margin-left: 40px;
  max-width: 400px;
  text-align: left;
  .ui.grey.inverted.segment {
    opacity: 50%;
  }
  h2 {
    margin: 90px 0 30px 0;
    color: white;
    text-align: center;
  }
  content {
    position: left;
  }
}
.crear-convocatorias {
  margin-left: 700px;
  text-align: center;
  margin-top: -420px;
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
  margin-top: 140px;
  margin-bottom: 60px;
  color: white;
}
</style>
