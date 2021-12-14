package spring.security.jwtauth.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

//Data annotation will produces getter and setter
@Data
@Entity
@Table(name = "jwt_auth_table")
public class User implements Serializable {

    private static final long serialVersionUID = -6640485728691293342L;

    //unique id of every user
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private UUID uuid;

    @Column(name = "email_id", nullable = false, unique = true)
    private String emailId;

    @Column(name = "password", nullable = false)
    private String Password;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

}