<template>
    <div>
        <div>
            <nav class="level">
                <div class="level-left">
                    <div class="level-item mb-6">
                        <back-button href="product" />
                        <h1 class="title">New Product</h1>
                    </div>
                </div>
            </nav>
            <div class="columns">
                <div class="column is-half">
                    <div class="field is-horizontal">
                        <div class="field-label is-normal">
                            <label class="label has-text-left">Name:</label>
                        </div>
                        <div class="field-body ml-6">
                            <div class="field">
                                <p class="control is-expanded">
                                    <input class="input" type="text" />
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="field is-horizontal">
                        <div class="field-label is-normal ">
                            <label class="label has-text-left">Price:</label>
                        </div>
                        <div class="field-body ml-6">
                            <div class="field">
                                <p class="control is-expanded">
                                    <input class="input" type="text" />
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="field is-horizontal">
                        <div class="field-label is-normal">
                            <label class="label has-text-left">Description:</label>
                        </div>
                        <div class="field-body  ml-6">
                            <div class="field">
                                <p class="control is-expanded">
                                    <input class="input" type="text" />
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="field is-horizontal">
                        <div class="field-label is-normal">
                            <label class="label has-text-left mr-1">Merchant:</label>
                        </div>
                        <div class="field-body ml-6">
                            <div class="field">
                                <p class="control is-expanded">
                                    <input class="input" type="text" :value="product.available" />
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
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
    }
};
</script>

<style lang="scss" scoped></style>
