<template>
    <div id="customer-view">
        <h1>
            Customers | <span class="counter">{{ data.length }} customers</span>
        </h1>
        <div class="level">
            <table-search placeholder="Find by name/surname/e-mail" :count="data.length" @searchQueryChanged="search = $event" />
            <div class="level-right">
                <p class="level-item"><a class="button is-success">New customer</a></p>
            </div>
        </div>
        <div class="table-container">
            <table class="table is-fullwidth is-stripped is-bordered">
                <tr class="th">
                    <th>Action</th>
                    <th>Name</th>
                    <th>Surname</th>
                    <th>Email</th>
                    <th>Address</th>
                    <th>Age</th>
                    <th>Phone Number</th>
                </tr>
                <tr id="rowsInTable" v-for="(i, index) in filteredItems" :key="index">
                    <table-edit-links />
                    <td>{{ i.name }}</td>
                    <td>{{ i.surname }}</td>
                    <td>{{ i.email }}</td>
                    <td>{{ i.address }}</td>
                    <td>{{ i.age }}</td>
                    <td>{{ i.phoneNumber }}</td>
                </tr>
            </table>
        </div>
    </div>
</template>
<script>
import axios from "axios";
import TableSearch from "../components/TableSearch.vue";
import tableMixin from "../mixins/tableMixin.js";
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
    methods: {
        extractData({
            id: id,
            name: name,
            surname: surname,
            email: email,
            address: address,
            age: age,
            phoneNumber: phoneNumber
        }) {
            return { id, name, surname, email, address, age, phoneNumber };
        }
    },
    mounted() {
        axios.get("http://localhost:8080/customer").then(response => (this.data = response.data));
    }
};
</script>

<style scoped>
.customer-view {
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
