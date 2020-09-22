<template>
    <div>
        <div class="field is-grouped">
            <a class="control">
                <router-link :to="`/products/new`" class="button is-link is-outlined">
                    <i class="far fa-plus-square"></i>Create new
                </router-link>
            </a>
            <a class="control">
                <router-link
                    :to="`/${resource}s/edit/${id}`"
                    onclick="document.location.href=this.getAttribute('href');"
                    class="button is-outlined"
                >
                    <i class="far fa-edit"></i>Edit
                </router-link>
            </a>
            <p class="control">
                <a @click="deleteResource" class="button is-danger is-outlined"> <i class="far fa-trash-alt"></i>Delete</a>
            </p>
        </div>
    </div>
</template>

<script>
import axios from "axios";

export default {
    props: ["resource", "id"],
    methods: {
        deleteResource() {
            if (window.confirm("Are you sure to delete this product?")) {
                axios.delete(`http://localhost:8080/${this.resource}/` + this.id).then(response => {
                    this.$router.push(`/${this.resource}s`);
                });
            }
        }
    }
};
</script>

<style lang="scss" scoped>
.control i {
    margin-right: 0.5em;
    position: relative;
    top: calc(50% - 11px);
}
</style>
