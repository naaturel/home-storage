<script>
    import Button from "../components/Button.svelte";
</script>

<nav class="bordered">

    <Button link="/"> Home </Button>
    <Button link="/login"> Login </Button>
    <Button link="/logout"> Logout </Button>
    <Button link="/download"> Download </Button>
    <Button link="/upload"> Upload </Button>

</nav>

<hr/>

<div class="container">
    <slot/>
</div>


<hr/>

<footer>
    <a href="https://github.com/naaturel">Github</a>
    <a href="https://twitter.com/naaturel_">Twitter</a>
</footer>

<!--
Primary : #F5F5F5
Secondary : #B9E937
Tertiary : #00B906
Secondary : #424242
-->