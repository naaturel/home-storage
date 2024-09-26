<script>

import Button from "../../components/Button.svelte";

const buttonStyle = {
    "box-shadow" : "none",
    "text-decoration" : "underline",
    "margin-top" : "1vh",
}

</script>

    <h1>Log in to start</h1>

    <form>

        <input class="bordered" placeholder="Username">
        <input class="bordered" placeholder="Password">

        <Button {buttonStyle}> Log me in ! </Button>
        <a href="">Not registered yet ? Let's get started</a>
    </form>


<style>


    form
    {
        display: flex;
        flex-direction: column;
        justify-content: space-around;
        align-items: center;
        margin: 10vh;
    }

    input
    {
        color: #424242;
        font-size: 2.5vh;

        width: 20vw;
        height: 4.5vh;

        padding: 1vh;
        margin: 2.5vh;

        text-align: center;
    }

    a
    {
        margin-bottom: 3vh;
        margin-top: 3vh;
        font-size: 1.25vh;
        border-bottom: solid 1px #F5F5F5;
    }

</style>