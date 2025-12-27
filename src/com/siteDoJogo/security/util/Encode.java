package com.siteDoJogo.security.util;

public class Encode {


    public static String encodePassword(String passwordKey, String home, String password) {

        var key = EnvLoader.envLoaderVariable(passwordKey);
        var homeKey = EnvLoader.envLoaderVariable(home);

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            for (int j = 0; j < homeKey.length(); j++) {
                if(c == homeKey.charAt(j)) {
                    result.append(key.charAt(j));
                    result.append(key.charAt(j / 2));
                }
            }
        }
    return result.toString();

    }

    public static String decodePassword(String passwordKey, String home, String password) {

        var key = EnvLoader.envLoaderVariable(passwordKey);
        var homeKey = EnvLoader.envLoaderVariable(home);

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < password.length(); i+=2) {
            char c = password.charAt(i);
            for (int j = 0; j < key.length(); j++) {
                if(c == key.charAt(j)) {
                    result.append(homeKey.charAt(j));
                }
            }
        }
        return result.toString();
    }
}
