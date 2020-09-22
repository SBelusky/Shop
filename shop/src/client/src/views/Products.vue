<template>
    <div id="products-view">
        <h1>
            Products | <span class="counter">{{ data.length }} products</span>
        </h1>
        <div class="level">
            <table-search placeholder="Find by name" :count="data.length" @searchQueryChanged="search = $event" />
            <div class="level-right">
                <p class="level-item"><router-link to="/products/new" class="button is-success">New Product</router-link></p>
            </div>
        </div>
        <div class="table-container">
            <table class="table is-fullwidth is-stripped is-bordered">
                <tr class="th">
                    <th>Action</th>
                    <th>Merchant</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>Created at</th>
                    <th>Available</th>
                </tr>
                <tr id="rowsInTable" v-for="(i, index) in filteredItems" :key="index">
                    <td>
                        <table-edit-links resource="product" :id="i.id" />
                    </td>
                    <td>
                        <a class="no-wrap link-fk-in-table" :href="'merchant/' + i.merchant.id">{{ i.merchant.name }} ➔</a>
                    </td>
                    <td>{{ i.name }}</td>
                    <td>{{ i.description }}</td>
                    <td>{{ i.price }}</td>
                    <td>{{ i.createAt | moment }}</td>
                    <td>{{ trueFalse(i.available) }}</td>
                </tr>
            </table>
        </div>
    </div>
</template>

<script>
import axios from "axios";
import TableSearch from "../components/TableSearch.vue";
import tableMixin from "../mixins/tableMixin.js";
import moment from "moment";
import TableEditLinks from "../components/TableEditLinks.vue";

export default {
    mixins: [tableMixin],
    components: {
        TableSearch,
        TableEditLinks
    },
    data() {
        return {
            searchColumn: "name"
        };
    },
    filters: {
        moment: function(date) {
            return moment(date)
                .lang("sk")
                .format("L");
        }
    },
    methods: {
        extractData({
            id: id,
            mechantId: mechant,
            name: name,
            description: description,
            price: price,
            createdAt: createdAt,
            available: available
        }) {
            return { id, mechant, name, description, price, createdAt, available };
        },
        trueFalse(number) {
            if (number === 0) return "false";
            else return "true";
        }
    },
    mounted() {
        axios.get("http://localhost:8080/product").then(response => (this.data = response.data));
    }
};
</script>

<style lang="scss" scoped>
.products-view {
    width: 100%;
}
h1 {
    font-size: 3em;
    text-align: left;
    margin-bottom: 1em;
}
tr:nth-child(even) {
    background-color: #f5f5f5;
}
#rowsInTable td {
    word-wrap: break-word;
    max-width: 20em;
}
#rowsInTable:hover {
    background-color: #dcdcdc;
}
.counter {
    font-size: 0.5em;
}
.table th {
    background-color: hsl(204, 86%, 53%);
    color: #f2f2f2;
}
.table th:first-child {
    width: 100px;
}
</style>
