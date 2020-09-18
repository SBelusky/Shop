// pokiaľ by mi nechcelo zobraziť komponent na dobre zadaej ceste tak je potrebné údaje v {} presunúť vyššie
// adresy v routery sú utriedený zoznam - preto keĎ chcem použiť adresu "*" musí byť na konci

//router
import Vue from "vue";
import VueRouter, { RouteConfig } from "vue-router";

//test
import Test from "../views/tests/Test.vue";

//home, about, 404
import Home from "../views/Home.vue";
import About from "../views/About.vue";
import NotFound from "../views/errors/NotFound.vue";
//customer
import Customers from "../views/Customers.vue";
//import CustomerEditForm from "../views/CustomerEditForm.vue";

//product
import Product from "../views/Products.vue";
import ProductSingle from "../views/ProductSingle.vue";
import ProductCreate from "../views/ProductCreate.vue";
import ProductEdit from "../views/ProductEdit.vue";

Vue.use(VueRouter);

const routes: Array<RouteConfig> = [
    // TEST
    {
        path: "/test",
        component: Test
    },
    // HOME, ABOUT
    {
        path: "/",
        redirect: "/home"
    },
    {
        path: "/home",
        name: "Home",
        component: Home
    },
    {
        path: "/about",
        component: About
    },
    // CUSTOMER
    {
        path: "/customers",
        component: Customers
    },
    // PRODUCT
    {
        path: "/products",
        component: Product
    },
    {
        path: "/products/new",
        component: ProductCreate
    },
    {
        path: "/products/:id", //dvojbodkami zainstime ze parameter id bude premenna
        component: ProductSingle
    },
    {
        path: "/products/edit/:id",
        component: ProductEdit
    },
    // 404
    {
        path: "/404",
        component: NotFound
    },
    {
        path: "*",
        redirect: "/404"
    }
];

const router = new VueRouter({
    mode: "history",
    base: process.env.BASE_URL,
    routes
});

export default router;
