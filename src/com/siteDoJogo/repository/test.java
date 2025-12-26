package com.siteDoJogo.repository;

public class test {
    public static void main(String[] args) {

    UserRepository user = new UserRepository();

        user.addUser("Gabriel", "123456");
        user.addUser("rato", "123456");
        user.addUser("voce", "123456");

        user.writeJson();


    }


}
