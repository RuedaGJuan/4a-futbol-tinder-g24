<template>
  <div id="Convocatorias" class="convocatorias">
    
    <div class="ver-convocatorias" >
      <h2>CONVOCATORIAS REGISTRADAS</h2>
      <div class="lista-convocatorias" >
      <div class="ui grey inverted segment">
        <ul class="ui inverted relaxed divided animated list">
          <li class="item" >
            
            <div class="content">
              <ul class="header" v-for="convocatoria of convocatoriaTodas" :key="convocatoria.id">
                <div class="right floated content">
              <div class="ui green button">Unirme</div>
            </div>
                <li>Fecha: {{convocatoria.fecha}}</li>
                <li>Hora: {{convocatoria.hora}}</li>
                <li>Localidad: {{convocatoria.localidad}}</li>
              </ul>
            </div>
          </li>
        </ul>
      </div>
      </div>
    </div>

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
        <button class="ui button fluid grey" type="submit">CREAR CONVOCATORIA </button>
      </form>
    </div>
     
    
  </div>
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
        return {
          
        };
      },
    },
  },

  created: function () {
    this.$apollo.queries.convocatoriaTodas.refetch();
  }
};
</script>

<style lang="scss" scoped>
.convocatorias {
  background-color: black;
  background-image: url(../assets/convocatorias1.jpg);
  background-size: 100%;
  min-width: 100%;
  min-height: 160%;
 
  padding-left: 70px;
  display: flex;
  flex-direction: row-reverse;
  align-items: flex-start;
  justify-content: space-around;
}
.crear-convocatorias {
  margin-left: 0px;
  max-width: 300px;
  margin-top: 100px;

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
.ver-convocatorias {
  margin-left: 50px;
  padding-left: 30px;
  margin-top: 100px;
  max-height: 400px;
  max-width: 400px;
  
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
.lista-convocatorias{
  max-height: 400px;
overflow: scroll;
  }

.footer {
  text-align: right;
  font-weight: lighter;
  margin-top: 140px;
  margin-bottom: 60px;
  color: white;
}
</style>
