import Vue from "vue";
import App from "./App.vue";
import "./registerServiceWorker";
import router from "./router";
import "bulma/bulma.sass";
import moment from "moment";
import "./assets/style.css";
import "@fortawesome/fontawesome-free/css/all.css";
import axios from "axios";
import vuetify from "./plugins/vuetify";

Vue.prototype.moment = moment;
Vue.prototype.$http = axios;

new Vue({
    vuetify,
    router,
    render: h => h(App)
}).$mount("#app");
