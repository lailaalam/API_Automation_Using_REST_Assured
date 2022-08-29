package model;

public class CreateNewUserModel {
    public String name;//="customer"+Math.random()*(100-10)+100;
    public String email;//=Math.random()*(9999-1000)+9999+"@gmail.com";
    public String password;//=Math.random()*(100-10)+100+"a";
    public String phone_number;//="012345"+Math.random()*(90000-10000)+90000;
    public String nid;//=Math.random()*(999-100)+999+"1";
    public String role;//="Customer";

    public CreateNewUserModel(String name, String email, String password, String phone_number, String nid, String role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone_number = phone_number;
        this.nid = nid;
        this.role = role;
       // System.out.println(name);
    }



}
