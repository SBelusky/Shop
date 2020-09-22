<template>
    <div id="app" class="columns">
        <main-menu class="column is-2" />
        <router-view class="column is-9 mt-6 ml-6" />
    </div>
</template>

<script>
import Vue from "vue";
import MainMenu from "./components/MainMenu.vue";

export default {
    components: {
        MainMenu
    }
};
</script>
<style></style>
