import {writable} from "svelte/store";
import {User} from "../models/User";

function createStore(){

    const { set, update, subscribe } = writable(new User({}));
    return { set, subscribe };

}

export const userStore = createStore();



