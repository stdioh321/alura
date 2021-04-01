package br.com.stdioh.testes;

import br.com.stdioh.testes.model.User;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MySystem {

    private List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(String id) {
        User tmpUser = users.stream().filter(user -> user.getId().equals(id)).findAny().orElse(null);
        if (tmpUser != null) users.remove(tmpUser);
    }
}
