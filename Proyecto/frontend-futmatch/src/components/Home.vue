<template>
  <html>
    <div class="texto">
      <h2>HAZ PARTE</h2>
      <h1>DEL JUEGO</h1>
      <p>Únete a la comunidad más grande de jugadores aficionados!</p>
      <button class="ui green button" @click="$router.push('/login')">
        LOGIN
      </button>
      <button class="ui grey button" @click="$router.push('/signup')">
        CREATE ACCOUNT
      </button>
    </div>
    <footer class="footer">
      <p>Todos los derechos reservados Grupo FutMatch P24 C4. 2021</p>
    </footer>
  </html>
</template>

<script>
export default {
  name: "Home",
};
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Major+Mono+Display&family=Readex+Pro:wght@700&display=swap");

html {
  background-color: black;
  background-image: url(../assets/home4.jpg);
  margin-bottom: 2rem;
  position: relative;
  background-size: 100%;
  height: 563px;
  max-width: 1400px;
}
h2 {
  font-size: 5rem;
  align-text: right;
  padding-top: 10%;
}
h1 {
  font-size: 7rem;
  align-text: right;
}
.texto {
  color: white;
  margin-left: 600px;
}
.p {
  font-size: 45rem;
}
.footer {
  text-align: right;
  font-weight: lighter;
  color: white;
  padding-top: 8%;
  padding-right: 3%;
}
</style>
