package com.siteDoJogo.repository;

import com.siteDoJogo.model.SimpleUser;

public class test {
    public static void main(String[] args) {

    UserRepository user = new UserRepository();

        user.addUser("Gabriel", "123456");
        user.addUser("rato", "123456");
        user.addUser("voce", "123456");

        user.writeFile();



       var aqui =  user.getUserRepository();

       for (SimpleUser usuario : aqui) {
           System.out.println(usuario.getLogin() +
                   usuario.getId() + usuario.getPassword());
       }
    }


}
