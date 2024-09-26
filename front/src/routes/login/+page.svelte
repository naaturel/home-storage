<script>

import Button from "$lib/components/Button.svelte";

</script>

    <h1>Log in to start</h1>

    <form>

        <input class="bordered" placeholder="Username">
        <input class="bordered" placeholder="Password">

        <Button --box-shadow="none"
                --text-decoration="underline"
                --margin-top="5vh"
                --border="solid 1px black"
                --width="18vw">
            Log me in !
        </Button>

        <a href="/register">Not registered yet ? Let's get started</a>
    </form>

<style>

    a
    {

        margin-bottom: 3vh;
        margin-top: 3vh;
        font-size: 1.25vh;
        border-bottom: solid 1px #F5F5F5;
    }

</style>