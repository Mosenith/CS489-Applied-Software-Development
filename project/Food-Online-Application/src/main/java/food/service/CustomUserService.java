package food.service;

import food.domain.User;
import food.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CustomUserService implements UserDetailsService {
//    @Autowired
    private UserRepository userRepository;

    public CustomUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }

        return new org.springframework.security.core.userdetails.User
                (user.getUsername(), user.getPassword(), getAuthority(user));
    }

    private List<SimpleGrantedAuthority> getAuthority(User user) {
        System.out.println(user.getRole());
        if(user.getRole().equals("admin")) {
            return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
        } else {
            return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
        }
    }

    // add some user data
    public void addUserData() {
        User user1 = new User(null, "miu1", "root1", "Chris Alven", "1000N 4th",
                "Fairfield", "Iowa", "52557", "111-2222");
        user1.setRole("user");

        User user2 = new User(null, "miu2", "root2", "Simon Love", "1222N 3th",
                "Iowa City", "Iowa", "52227", "999-7777");
        user2.setRole("user");


        userRepository.save(user1);
        userRepository.save(user2);
    }
}
