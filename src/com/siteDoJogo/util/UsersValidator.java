package com.siteDoJogo.util;

import com.siteDoJogo.model.SimpleUser;
import com.siteDoJogo.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

 public class UsersValidator {

    private final List<SimpleUser> userRepository;

    public UsersValidator(List<SimpleUser> userRepository) {
        this.userRepository = userRepository;
    }

    public boolean validateNewUser(String login, String password) {
        for (SimpleUser user : userRepository) {
            if(user.getLogin().equalsIgnoreCase(login)) {
                System.out.println("Já existe esse login: " + login);

                //TODO lançar algum erro para ser pego no globalHandler
                return false;
            }
        }

        //TODO validar password

        return true;
    }
}
