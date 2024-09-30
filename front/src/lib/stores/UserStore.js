import {writable} from "svelte/store";
import {User} from "$lib/models/User.js";

function createStore(){

    const { set, update, subscribe } = writable(new User({}));

    return {
        subscribe,
        /**
         * @param {{password: string, name: string, id: `${string}-${string}-${string}-${string}-${string}`}|User} user
         */
        authenticate: (user) => {
            set(user)
        }
    };
}

export const userStore = createStore();



