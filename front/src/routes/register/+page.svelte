<script>

    import Button from "$lib/components/Button.svelte";
    import {register} from "$lib/stores/requests.ts";

    let name = "";
    let password = "";
    let passwordConfirmation = "";
    $: error = "";

    async function signUp(event) {
        event.preventDefault();

        if (password !== passwordConfirmation) {
            error = "Both password and password confirmation must be the same"
            return;
        }
        let res = await register(name, password);
    }


</script>

<h1>Create an account</h1>

<div class="error">{error}</div>

<form method="POST" on:submit={signUp}>

    <input class="bordered" name="name" placeholder="Username" bind:value={name}>
    <input class="bordered" type="password" placeholder="Password" bind:value={password}>
    <input class="bordered" name="password" type="password" placeholder="Confirm password" bind:value={passwordConfirmation}>

    <Button --box-shadow="none"
            --margin-top="5vh"
            --border="solid 1px black"
            --width="18vw">
        Sign me in !
    </Button>

    <a href="/login">Already got an account ?</a>

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