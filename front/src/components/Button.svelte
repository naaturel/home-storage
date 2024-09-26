<script>
    export let buttonStyle = {}
    export let link = "/"

    const htmlStyleFormatting = () => {
        return Object.entries(buttonStyle).reduce((acc, [key, value]) => `${acc} ${key}: ${value};`, '');
    };

    $: styleHTML = htmlStyleFormatting(buttonStyle);

</script>

    <a class="bordered" href={link} style={styleHTML}>
        <slot/>
    </a>

<style>

    a
    {
        color: #F5F5F5;

        display: flex;
        justify-content: center;
        align-items: center;

        width: fit-content;
        height: 3vh;

        padding: 1vh 2vh;

        box-shadow: 0 0 5px black;

    }

    a:hover
    {
        transform: scale(1.1);
        color: #424242;
        background-color: #F5F5F5;
    }


</style>