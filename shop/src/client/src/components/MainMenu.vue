<template>
    <aside class="menu">
        <ul class="menu-list is-hidden-mobile">
            <li>
                <a>
                    <img src="https://bulma.io/images/bulma-logo.png" width="112" height="28" />
                </a>
            </li>
            <li class="mt-3">
                <router-link to="/home"><span>Home</span></router-link>
            </li>
            <li>
                <router-link to="/about"><span>About</span></router-link>
            </li>
            <li>
                <router-link to="/customers"><span>Customers</span></router-link>
            </li>
            <li>
                <a><span>Merchant</span></a>
            </li>
            <li>
                <router-link to="/products"><span>Product</span></router-link>
            </li>
            <li>
                <router-link to="/test"><span>Test</span></router-link>
            </li>
        </ul>
    </aside>
</template>

<script></script>

<style lang="scss" scoped>
@import "bulma/bulma.sass";

.menu {
    text-align: left;
    background-color: #f5f5f5;
    height: 80vh;
    font-size: 1em;
    @include from($fullhd + 700px) {
        font-size: 2em;
    }
}
.menu span:hover {
    color: #00d1b2;
}
.menu a.router-link-active {
    font-weight: 700;
    color: #00d1b2;
}
</style>
