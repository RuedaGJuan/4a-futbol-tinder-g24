<template>
  <div class="ui secondary menu">
    <div class="ui container">
      <div class="left menu">
        <router-link class="item" to="/">
          <img
            class="ui small image"
            src="../assets/FUT_logo.png"
            alt="Ecommerce"
          />
        </router-link>
        <router-link class="item" to="/">
          <h1>FUTMATCH</h1>
        </router-link>
      </div>
      <div class="right menu">
        <router-link class="item" to="/" v-if="!token"> HOME </router-link>
        <router-link class="item" to="/login" v-if="!token">
          LOGIN
        </router-link>
        <template v-if="token">
          <router-link class="item" to="/orders">CERRAR SESIÓN</router-link>
        </template>
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
