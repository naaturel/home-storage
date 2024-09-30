<script>

    export let link = ""

    export let action = {
        default: async (event) => {
            console.log(event)
        }
    }


</script>

<a class="bordered" href={link}>
    <slot/>
</a>

<style>

    a
    {


        color: #F5F5F5;

        display: flex;
        justify-content: center;
        align-items: center;

        padding: 1vh 2vh;

        background-color: var(--background-color, rgb(128, 82, 218));

        border: var(--border, none);

        width: var(--width, fit-content);
        height: var(--height, 3vh);

        box-shadow: var(--box-shadow, 0 0 5px black);
        text-decoration: var(--text-decoration, none);
        margin-top: var(--margin-top, 0vh);

    }

    a:hover
    {
        transform: scale(1.1);
        color: #424242;
        background-color: #F5F5F5;
    }


</style>
