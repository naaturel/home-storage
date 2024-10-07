import {userStore} from "./UserStore";
import SHA256 from 'crypto-js/sha256';

const baseUrl = "http://localhost:8000";

export async function register(name: string, password : string){
    return await handlePostRequest(
        craftUrl("/api/user/register"),
        JSON.stringify({name:name, password:SHA256(password).toString()}));
}

export async function authenticate(name: string, password : string){

    return await handlePostRequest(
        craftUrl("/api/user/authenticate"),
        JSON.stringify({name:name, password:SHA256(password).toString()}));
}

function craftUrl(path : String){
    return baseUrl + path;
}

async function handlePostRequest(url:string, data : string){
    return await fetch(url, {
        method:"POST",
        body : data,
        headers: new Headers({'content-type': 'application/json'})

    })
        .then(response => {
            if(response.status === 500) throw new Error(`${response.text()}`);
            if(!response.ok) throw new Error(`${response.status} : ${response.body}`);
            return response
        })
        .then(response => {
            return response.json();
        })
        .then(data => userStore.set(data))
        .catch(error => {
            return `Exception: ${error.message}`;
        });
}
