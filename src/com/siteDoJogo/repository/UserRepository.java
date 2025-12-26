package com.siteDoJogo.repository;

import com.siteDoJogo.model.SimpleUser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UserRepository {
    private List<SimpleUser> userRepository = new ArrayList<>();


    public UserRepository() {
    }

    public void addUser(String login, String password) {
        userRepository.add(
                new SimpleUser(
                        login,
                        password));
    }

    public UserRepository(String userRepository) {
        try (Scanner scanner = new Scanner(Path.of("database/users.json"))) {

            var teste = scanner.tokens();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeJson() {

        try {

            Path path = Path.of("src/com/siteDoJogo/database/users.json");

            Files.createDirectories(path.getParent());

            Files.writeString(path,
                    userRepository.stream()
                            .map(SimpleUser::toJSON)
                            .collect(Collectors.joining(",","[","]")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
