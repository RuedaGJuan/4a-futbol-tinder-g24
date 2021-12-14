<template>
  <div class="ui secondary menu">
    <div class="ui container">
      <div class="left menu">
        <router-link class="item" to="/user/home">
          <img
            class="ui small image"
            src="../assets/FUT_logo.png"
            alt="Ecommerce"
          />
        </router-link>
        <router-link class="item" to="/user/home">
          <h1>FUTMATCH</h1>
        </router-link>
      </div>
      <div class="right menu">
        <button class="button" @click="$router.push('/user/login')" v-if="!is_auth"> HOME </button>
        <router-link class="item" to="/user/login" v-if="!is_auth">
          LOGIN
        </router-link>
        
          <router-link class="item" to="/user/home"  v-if="is_auth">CERRAR SESIÓN</router-link>
        
      </div>
    </div>
  </div>

  

</template>

<script>
export default {
  name: "Menu",
};
</script>

<style lang="scss" scoped>
.ui.menu.secondary {
  background-color: #0005088e;

  .item {
    color: #ffffff;
    &:hover {
      color: #21ba45;
    }
  }
  .menu.left {
    width: 40%;
    .ui.image {
      width: 40px;
    }
  }
  .menu.right {
    width: 40%;
    justify-content: flex-end;
    .logout,
    .cart {
      &:hover {
        cursor: pointer;
      }
    }
  }
}
</style>
