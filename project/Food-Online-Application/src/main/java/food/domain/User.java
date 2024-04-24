package food.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Entity
@Data
//@NoArgsConstructor(force = true) // (access = AccessLevel.PRIVATE, force = true)
public class User { // implements UserDetails {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    private String fullName;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;
    private String role;

    private String token;
    // Data fields needed for implementing methods from UserDetails interface
//    private boolean accountNonExpired;
//    private boolean accountNonLocked;
//    private boolean credentialsNonExpired;
//    private boolean enabled;


    public User(Long id, String username, String password, String fullName, String street,
                String city, String state, String zip, String phoneNumber) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
//        this.accountNonExpired = accountNonExpired;
//        this.accountNonLocked = accountNonLocked;
//        this.credentialsNonExpired = credentialsNonExpired;
//        this.enabled = enabled;
    }

    public User(String username, String password) {
        this(null, username, password, null,null, null, null, null, null);
    }

    public User() {
        this(null, null);
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role; // since all registered users are just a user (no admin)
    }

    //    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        String[] userRoles = getRoles().stream()
//                .map((role) -> role.getRoleName())
//                .toArray(String[]::new);
//        Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRoles);
//        return authorities;
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return username;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return accountNonExpired;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return accountNonLocked;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return credentialsNonExpired;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return enabled;
//    }
//
//    public UserDetails orElseThrow(Object o) {
//    }
}
