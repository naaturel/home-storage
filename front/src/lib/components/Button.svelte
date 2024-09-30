<script>

    export let action = {
        default: async (event) => {
            console.log(event)
        }
    }

</script>

    <button class="bordered">
        <slot/>
    </button>

<style>

    button
    {

        color: #F5F5F5;

        display: flex;
        justify-content: center;
        align-items: center;

        padding: 1vh 2vh;

        background-color: var(--background-color, rgb(128, 82, 218));

        border: var(--border, none);

        width: var(--width, fit-content);
        height: var(--height, 6vh);

        box-shadow: var(--box-shadow, 0 0 5px black);
        text-decoration: var(--text-decoration, none);
        margin-top: var(--margin-top, 0vh);

    }

    button:hover
    {
        transform: scale(1.1);
        color: #424242;
        background-color: #F5F5F5;
    }


</style>
