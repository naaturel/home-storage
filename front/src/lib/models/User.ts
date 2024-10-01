export class User {

    private id: `${string}-${string}-${string}-${string}-${string}`;
    private name: string;
    private password: string;

    constructor({id = crypto.randomUUID(), name = "", password = ""}) {
        this.id = id;
        this.name= name;
        this.password = password;
    }

}