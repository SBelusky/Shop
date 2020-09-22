<template>
    <div>
        <div>
            <nav class="level">
                <div class="level-left">
                    <div class="level-item mb-6">
                        <back-button href="product" />
                        <h1 class="title"><small class="grey-and-small-font ">edit</small> | {{ product.name }}</h1>
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
                                    <input class="input" type="text" :value="product.name" />
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
                                    <input class="input" type="text" :value="product.price" />
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
                                    <input class="input" type="text" :value="product.description" />
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
                                    <input class="input" type="text" :value="product.available" />
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <single-edit-links resource="product" :id="product.id" />
        </div>
    </div>
</template>

<script>
import axios from "axios";
import BackButton from "../components/BackButton.vue";

export default {
    components: {
        BackButton
    },
    data() {
        return {
            product: {}
        };
    },
    created() {
        axios.get("http://localhost:8080/product/" + this.$route.params.id).then(response => (this.product = response.data));
    }
};
</script>

<style lang="scss" scoped></style>
