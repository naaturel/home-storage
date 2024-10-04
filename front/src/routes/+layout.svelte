<script>
    import {userStore} from "$lib/stores/UserStore.ts"
    import github_mark from '$lib/assets/github-mark-white.svg';
    import twitter_mark from '$lib/assets/twitter-mark-white.svg';
    import NavLink from "$lib/components/NavLink.svelte";


    $: greetings = () => {
        if($userStore === undefined){
            return "Not connected"
        } else {
            return `Hello, ${$userStore.name}`
        }
    }

</script>

<nav class="bordered">

    <NavLink --background-color="none" link="/"> Home </NavLink>
    <NavLink --background-color="none" link="/login"> Login </NavLink>
    <NavLink --background-color="none" link="/logout"> Logout </NavLink>
    <NavLink --background-color="none" link="/download"> Download </NavLink>
    <NavLink --background-color="none" link="/upload"> Upload </NavLink>

    <p> {greetings()} </p>

</nav>

<hr class="nav_delimiter"/>

<div class="container">
    <slot/>
</div>


<hr class="footer_delimiter"/>

<footer>
    <a href="https://github.com/naaturel">
            <img
                    src={github_mark}
                    height="40"
                    width="40"
                    alt="Github mark"/>
    </a>

    <a href="https://twitter.com/naaturel_">
        <img
                src="{twitter_mark}"
                height="40"
                width="40"
                alt="Twitter mark"/>
    </a>
    <!--<a href="https://github.com/naaturel">Github</a>
    <a href="https://twitter.com/naaturel_">Twitter</a>-->
</footer>