package pl.countedmacrobackend.service;

import pl.countedmacrobackend.domain.Role;
import pl.countedmacrobackend.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
}
