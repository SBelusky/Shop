<template>
    <div>
        <nav class="level">
            <div class="level-left">
                <div class="level-item mb-6">
                    <back-button href="product" />
                    <h1 class="title"><small class="grey-and-small-font ">view</small> | {{ product.name }}</h1>
                </div>
            </div>
        </nav>
        <div class="columns">
            <div class="column is-half">
                <div class="field is-horizontal">
                    <div class="field-label is-normal">
                        <label class="label">Name:</label>
                    </div>
                    <div class="field-body">
                        <div class="field">
                            <p class="control is-expanded">
                                <input class="input" type="text" :value="product.name" disabled />
                            </p>
                        </div>
                    </div>
                </div>
                <div class="field is-horizontal">
                    <div class="field-label is-normal">
                        <label class="label">Price:</label>
                    </div>
                    <div class="field-body">
                        <div class="field">
                            <p class="control is-expanded">
                                <input class="input" type="text" :value="product.price" disabled />
                            </p>
                        </div>
                    </div>
                </div>
                <div class="field is-horizontal">
                    <div class="field-label is-normal">
                        <label class="label">Description:</label>
                    </div>
                    <div class="field-body">
                        <div class="field">
                            <p class="control is-expanded">
                                <input class="input" type="text" :value="product.description" disabled />
                            </p>
                        </div>
                    </div>
                </div>
                <div class="field is-horizontal">
                    <div class="field-label is-normal">
                        <label class="label">Merchant:</label>
                    </div>
                    <div class="field-body">
                        <div class="field">
                            <p class="control is-expanded">
                                <input class="input" type="text" :value="product.merchant.name" disabled />
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <single-edit-links resource="product" :id="product.id" />
    </div>
</template>

<script>
import axios from "axios";
import SingleEditLinks from "../components/SingleEditLinks.vue";
import BackButton from "../components/BackButton.vue";

export default {
    components: {
        SingleEditLinks,
        BackButton
    },
    data() {
        return {
            product: {} // {} sa značí pre objekt
        };
    },
    created() {
        axios
            .get("http://localhost:8080/product/" + this.$route.params.id)
            .then(response => (this.product = response.data))
            .catch(error => {
                this.$router.push("/404"); // poviem routeru aby ma presmeroval na 404 v prípade, že neexistuje id productu
            });
    }
};
</script>

<style lang="scss" scoped>
.title back-button {
    display: inline;
}
</style>
