<script>

import Button from "$lib/components/Button.svelte";
import {authenticate} from "$lib/stores/requests.ts";

let name = "";
let password = "";

async function signIn(event) {
    event.preventDefault();
    let res = await authenticate(name, password);
}

</script>

    <h1>Log in to start</h1>

    <form method="POST" on:submit={signIn}>

        <input class="bordered" placeholder="Username" bind:value={name}>
        <input class="bordered" placeholder="Password" bind:value={password}>

        <Button
                --box-shadow="none"
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