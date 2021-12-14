<template>
  <html>
    
      <div class="texto">
        <div class=titulo>
        <h2>HAZ PARTE</h2>
        <h1>DEL JUEGO</h1>
        
        <p>
          Únete a la comunidad más grande de jugadores aficionados!
        </p>
        <button class="ui green button" @click="$router.push('/user/login')">
          LOGIN
        </button>
        <button class="ui grey button" @click="$router.push('/user/signup')">
          CREATE ACCOUNT
        </button>
        </div>
      </div>
      
    
  </html>
</template>

<script>


export default {
  name: "Home",
  components: {
   
  },
};
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Major+Mono+Display&family=Readex+Pro:wght@700&display=swap");

html {
  background-color: black;
  background-image: url(../assets/home2.jpg);
  background-size: 100%;
  min-width: 100%;
  min-height: 140%;
  position: relative;
}
h2 {
  font-size: 5rem;
  align-items: right;
  
}
h1 {
  font-size: 7rem;
  align-items: right;
}
.titulo{
  padding: 100px 0 0 60px;
}
.texto {
  margin-left: 460px;
  color: white;
  margin-top: 0px;
}
.p {
  font-size: 45rem;
  margin-left: 860px;
}
.footer {
  text-align: right;
  font-weight: lighter;
  color: white;
  margin-top: 120px;
}
</style>
