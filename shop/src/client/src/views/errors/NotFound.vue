<template>
    <div class="error-page ">
        <main>
            <h1>
                4<span><i class="fas fa-ghost"></i></span>4
            </h1>
            <h2>Error: 404 page not found</h2>
            <p><strong>Sorry</strong>, the page you're looking for <strong>cannot be accessed</strong></p>
        </main>
    </div>
</template>

<script>
export default {};
</script>

<style lang="scss" scoped>
@import url("https://fonts.googleapis.com/css?family=Montserrat:400,400i,700");

.error-page {
    background-color: white;
    font-family: "Montserrat", sans-serif;
}

*,
*:after,
*:before {
    box-sizing: border-box;
}

main {
    align-items: center;
    display: flex;
    flex-direction: column;
    height: 50vh;
    justify-content: center;
    text-align: center;
}

h1 {
    color: #dc143c;
    font-size: 12.5rem;
    letter-spacing: 0.1em;
    margin: 0.025em 0;
    text-shadow: 0.05em 0.05em 0 rgba(0, 0, 0, 0.25);
    white-space: nowrap;

    @media (max-width: 30rem) {
        font-size: 8.5rem;
    }

    & > span {
        animation: spooky 2s alternate infinite linear;
        color: #4682b4;
        display: inline-block;
    }
}

h2 {
    color: white;
    margin-bottom: 0.4em;
    padding: 0.5em;
    background-color: rgba(220, 20, 60, 0.6);
    font-weight: bold;
}

p {
    color: black;
    margin-top: 0;
}

@keyframes spooky {
    from {
        transform: translatey(0.15em) scaley(0.95);
    }

    to {
        transform: translatey(-0.15em);
    }
}
</style>
