export class User {

    constructor({id = crypto.randomUUID(), name = "", password = ""}) {
        this.id = id;
        this.name= name;
        this.password = password;
    }

}