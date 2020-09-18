<template>
    <div>
        <router-link class="button is-light mr-6 inline" :to="`/${href}s`">
            ← Back
        </router-link>
    </div>
</template>

<script>
export default {
    props: ["href"]
};
</script>

<style lang="scss" scoped>
.inline {
    display: inline;
}
</style>
