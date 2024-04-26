package food.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Entity
@Data
@Table(name = "Customer")
@AllArgsConstructor
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
    }

    public User(Long id, String username, String password, String fullName, String street,
                String city, String state, String zip, String phoneNumber, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }

    public User(String username, String password) {
        this(null, username, password, null,null, null, null, null, null);
    }

    public User() {
        this(null, null);
    }
}
