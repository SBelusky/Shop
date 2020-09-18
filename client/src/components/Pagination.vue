<template>
    <div>
        <h1>
            Products | <span class="counter">evidovaných {{ products.length }} položiek</span>
        </h1>
        <v-app id="inspire">
            <v-data-table :search="search" :headers="headers" :items="products" sort-by="calories" class="elevation">
                <template v-slot:top>
                    <v-toolbar flat color="white">
                        <v-text-field
                            id="search-bar"
                            v-model="search"
                            append-icon="mdi-magnify"
                            label="Search"
                            single-line
                            hide-details
                            class="mb-6"
                        >
                        </v-text-field>
                        <v-spacer></v-spacer>
                        <v-btn color="primary" dark class="mb-6" v-bind="attrs" v-on="on" @click="newItem">New Item</v-btn>
                    </v-toolbar>
                </template>

                <template v-slot:item="{ item }">
                    <tr>
                        <td>
                            <v-icon small color="blue darken-2" class="mr-2 mdi-24px" @click="editItem(item)">
                                mdi-pencil
                            </v-icon>
                            <v-icon small color="blue darken-2" class="mr-2 mdi-24px" @click="deleteItem(item)">
                                mdi-delete
                            </v-icon>
                            <v-icon small color="blue darken-2" class="mr-2 mdi-24px" @click="viewItem(item)">
                                mdi-eye
                            </v-icon>
                        </td>
                        <td>{{ item.name }}</td>
                        <td>{{ item.merchant.name }}</td>
                        <td>{{ item.price }}</td>
                        <td>{{ item.createAt | moment }}</td>
                        <td>
                            <v-simple-checkbox v-model="item.available" disabled></v-simple-checkbox>
                        </td>
                    </tr>
                </template>
                <template v-slot:no-data>
                    <v-btn color="primary" @click="initialize">Reset</v-btn>
                </template>
            </v-data-table>
        </v-app>
    </div>
</template>

<script>
import axios from "axios";
import moment from "moment";

export default {
    data: () => ({
        search: "",
        dialog: false,
        headers: [
            { text: "Actions", value: "actions", sortable: false, class: "text-overline blue white--text" },
            { text: "Name", value: "name", class: ["text-overline", "blue", "white--text"] },
            { text: "Merchant", value: "merchant.name", class: "text-overline blue white--text" },
            { text: "Price", value: "price", class: "text-overline blue white--text" },
            { text: "Create at", value: "createAt", class: "text-overline blue white--text" },
            { text: "Available", value: "available", class: "text-overline blue white--text" }
        ],
        products: []
    }),

    methods: {
        editItem(item) {
            this.$router.push("/products/edit/" + item.id);
        },

        deleteItem(item) {
            const index = this.products.indexOf(item);
            if (confirm("Are you sure you want to delete this item?")) {
                axios.delete(`http://localhost:8080/product/` + item.id).then(response => {
                    this.$router.go(); //router.go -> refresh stránky
                });
            }
        },
        viewItem(item) {
            this.$router.push("/products/" + item.id);
        },
        newItem() {
            this.$router.push("/products/new");
        }
    },
    mounted() {
        axios.get("http://localhost:8080/product").then(response => (this.products = response.data));
    },
    filters: {
        moment: function(date) {
            return moment(date)
                .lang("sk")
                .format("L");
        }
    }
};
</script>

<style lang="scss" scoped>
.v-data-table tr:first-child {
    background-color: white;
}
.v-text-field {
    max-width: 400px;
}
h1 {
    font-size: 3em;
    text-align: left;
    margin-bottom: 1em;
}
.counter {
    font-size: 0.5em;
}
</style>
