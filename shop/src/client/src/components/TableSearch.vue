<!-- 
watch -> 108. videjko, watcher sleduje zmeny na stránke, vie zobraziť aká bola hodnota pred zmenou a aká bola po zmene,
názov metódy v watchry musí sedieť s premennou
-->
<template>
    <div class="level-left">
        <div class="level-item">
            <div class="field has-addons">
                <p class="control">
                    <input class="input" type="text" :placeholder="placeholder" v-model="searchQuery" />
                </p>
                <p class="control">
                    <button v-on:click="resetInput" class="button is-danger" :disabled="searchQuery.length == 0">
                        Reset
                    </button>
                </p>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    props: {
        count: {
            type: Number,
            default: 0
        },
        placeholder: {
            type: String,
            default: ""
        }
    },
    data() {
        return {
            searchQuery: ""
        };
    },
    methods: {
        resetInput: function() {
            this.searchQuery = "";
        }
    },
    watch: {
        searchQuery(value) {
            this.$emit("searchQueryChanged", value);
        }
    }
};
</script>

<style lang="scss" scoped>
.control input {
    width: 20em;
}
</style>
