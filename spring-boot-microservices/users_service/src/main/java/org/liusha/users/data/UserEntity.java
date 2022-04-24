package org.liusha.users.data;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
@Data
public class UserEntity implements Serializable {
    private static final Long serialVersionUID = -953297098295050686L;

    @Id @GeneratedValue private Long id;
    @Column(nullable = false, length = 50) private String firstName;
    @Column(nullable = false, length = 50) private String lastName;
    @Column(nullable = false, length = 200, unique = true) private String email;
    @Column(nullable = false, unique = true) private String userID;
    @Column(nullable = false, unique = true) private String encryptedPassword;
}
