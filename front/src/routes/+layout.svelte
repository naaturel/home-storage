<script>
    import Button from "$lib/components/Button.svelte";
    import github_mark from '$lib/assets/github-mark-white.svg';
    import twitter_mark from '$lib/assets/twitter-mark-white.svg';

</script>

<nav class="bordered">

    <Button --background-color="none" link="/"> Home </Button>
    <Button --background-color="none" link="/login"> Login </Button>
    <Button --background-color="none" link="/logout"> Logout </Button>
    <Button --background-color="none" link="/download"> Download </Button>
    <Button --background-color="none" link="/upload"> Upload </Button>

</nav>

<hr class="nav_delimiter"/>

<div class="container">
    <slot/>
</div>


<hr class="footer_delimiter"/>

<footer>
    <img
            src={github_mark}
            height="40"
            width="40"
            alt="Github mark"/>

    <img
            src="{twitter_mark}"
            height="40"
            width="40"
            alt="Twitter mark"/>

    <!--<a href="https://github.com/naaturel">Github</a>
    <a href="https://twitter.com/naaturel_">Twitter</a>-->
</footer>