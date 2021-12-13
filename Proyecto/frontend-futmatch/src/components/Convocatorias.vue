<template>
  <body>
    <BasicLayouts>
      <div class="ver-convocatorias">
        <h2>CONVOCATORIA VIGENTES</h2>
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
        <form class="ui form">
          <div class="field">
            <input type="text" placeholder="ID jugadores Equipo 1" />
          </div>
          <div class="field">
            <input type="text" placeholder="ID jugadores Equipo 1" />
          </div>
          <div class="field">
            <input type="text" placeholder="Fecha" />
          </div>
          <div class="field">
            <input type="text" placeholder="Hora" />
          </div>
          <div class="field">
            <input type="text" placeholder="Localidad" />
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
import BasicLayouts from "../layouts/BasicLayouts.vue";
export default {
  components: {
    name: "Convocatorias",
    BasicLayouts,
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
