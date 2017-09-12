

export class CredentialsModel {

  username: string = "";
  password: string = "";

  constructor(username: string, password: string) {
    this.username = username;
    this.password = password;
  }

  toString(): string {
    return "{\"username\":\"" + this.username +
      "\",\n\"password\":\"" + this.password + "\"}";
  }

}
