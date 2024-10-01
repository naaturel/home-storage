<script>

    /** @type {import('./$types').Actions} */

    import Button from "$lib/components/Button.svelte";

    export const actions = {
        register: async (event) => {
            console.log(event)
        }
    };

</script>

<h1>Create an account</h1>

<form method="POST" action="?/register">

    <input class="bordered" name="name" placeholder="Username">
    <input class="bordered" type="password" placeholder="Password">
    <input class="bordered" name="password" type="password" placeholder="Confirm password">

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