package pl.countedmacrobackend.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepo;
    private final RoleRepository roleRepo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepo.findByEmail(username);
        if (optionalUser.isEmpty()) {
            log.error("User not found in the database.");
            throw new UsernameNotFoundException("User not found in the database.");
        } else {
            log.info("User found in the database: {}", username);
        }
        User user = optionalUser.get();
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
    }

    @Override
    public User userRegistration(User user) throws Exception {
        Optional<User> optionalUser = userRepo.findByEmail(user.getEmail());
        if (optionalUser.isPresent()) {
            throw new Exception("The given email is already taken.");
        } else {
            log.info("Saving new user {} to the database.", user.getEmail());
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            Role role = roleRepo.findByName("ROLE_USER");
            user.addRole(role);
            return userRepo.save(user);
        }
    }

    @Override
    public User saveUser(User user) {
        log.info("Saving new user {} to the database.", user.getEmail());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role {} to the database.", role.getName());
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String email, String roleName) {
        log.info("Adding role {} to user {}.", roleName, email);
        Optional<User> optionalUser = userRepo.findByEmail(email);
        if (optionalUser.isPresent()) {
            Role role = roleRepo.findByName(roleName);
            optionalUser.get().getRoles().add(role);
        }
    }

    @Override
    public User getUser(String email) {
        log.info("Fetching user {}.", email);
        Optional<User> optionalUser = userRepo.findByEmail(email);
        return optionalUser.orElse(null);
    }

    @Override
    public List<User> getUsers() {
        log.info("Fetching all users.");
        return userRepo.findAll();
    }
}
