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
    private final List<SimpleUser> userRepository = new ArrayList<>();

    public UserRepository() {

        Path path = Path.of("database/users.txt");

        try(Scanner scanner = new Scanner(path)) {

            while (scanner.hasNextLine()) {
                var teste = scanner.nextLine().split(",");
                userRepository.add(new SimpleUser(Long.parseLong(teste[0]),teste[1],teste[2]));
            }



        } catch (IOException e) {
            System.out.println("Aquivo ainda não foi criado");
        }

    }


    public void addUser(String login, String password) {


        userRepository.add(
                new SimpleUser(
                        login,
                        password));
    }


    public List<SimpleUser> getUserRepository() {
        return userRepository;
    }

    public void writeFile() {

        try {

            Path path = Path.of("database/users.txt");

            // apagar depois que melhorar a logica de repetição
            //            try {
//                Files.deleteIfExists(path);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }

            Files.createDirectories(path.getParent());

            Files.writeString(path,
                    userRepository.stream()
                            .map(SimpleUser::write)
                            .collect(Collectors.joining("\n")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
