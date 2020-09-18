<template>
    <div>
        <span>
            <a @click="deleteResource"><i class="far fa-trash-alt"></i></a>
        </span>
        <span>
            <router-link :to="`/${resource}s/edit/${id}`"><i class="far fa-edit"></i></router-link>
        </span>
        <span>
            <router-link :to="`/${resource}s/${id}`"><i class="far fa-eye"></i></router-link>
        </span>
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
                    this.$router.go(); //router.go -> refresh stránky
                });
            }
        }
    }
};
</script>

<style lang="scss" scoped>
a {
    margin: 0 0.2em;
}
</style>
