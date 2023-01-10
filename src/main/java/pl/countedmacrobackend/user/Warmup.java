package pl.countedmacrobackend.user;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component("userWarmup")
class Warmup implements ApplicationListener<ContextRefreshedEvent> {

    private final UserService userService;

    Warmup(final UserService userService) {
        this.userService = userService;
    }

    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        userService.saveRole(new Role(null, "ROLE_USER"));
        userService.saveRole(new Role(null, "ROLE_MANAGER"));
        userService.saveRole(new Role(null, "ROLE_ADMIN"));
        userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));
        userService.saveRole(new Role(null, "ROLE_DEVELOPER"));

        userService.saveUser(new User(null, "John Travolta", "john", "1234", new ArrayList<>()));
        userService.saveUser(new User(null, "Will Smith", "will", "1234", new ArrayList<>()));
        userService.saveUser(new User(null, "Jim Carry", "jim", "1234", new ArrayList<>()));
        userService.saveUser(new User(null, "Arnold Schwarzenegger", "arnold", "1234", new ArrayList<>()));

        userService.addRoleToUser("john", "ROLE_USER");
        userService.addRoleToUser("john", "ROLE_MANAGER");
        userService.addRoleToUser("will", "ROLE_MANAGER");
        userService.addRoleToUser("jim", "ROLE_ADMIN");
        userService.addRoleToUser("arnold", "ROLE_DEVELOPER");
        userService.addRoleToUser("arnold", "ROLE_ADMIN");
        userService.addRoleToUser("arnold", "ROLE_USER");
    }
}
