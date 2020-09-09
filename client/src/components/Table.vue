<template>
  <div id="tablexyx">
    <table class="table">
      <thead>
        <tr>
          <th scope="col">Action</th>
          <th scope="col">Name</th>
          <th scope="col">Surname</th>
          <th scope="col">Email</th>
          <th scope="col">Address</th>
          <th scope="col">Age</th>
          <th scope="col">Phone Number</th>
        </tr>
      </thead>
      <tbody>
        <tr
          v-for="(i, index) in customers"
          :key="index"
        >
          <th scope="row"><a href="">Edit</a></th>
          <td>{{ i.name }}</td>
          <td>{{ i.surname }}</td>
          <td>{{ i.email }}</td>
          <td>{{ i.address }}</td>
          <td>{{ i.age }}</td>
          <td>{{ i.phoneNumber }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>
<script>
import axios from "axios";
const URL = "http://localhost:8080/customer";

export default {
  data() {
    return {
      limit: 5,
      query: "",
      customers: null
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
    axios
      .get("http://localhost:8080/customer")
      .then(response => (this.customers = response.data));
  }
};
</script>

<style></style>
