package com.demo.restapi;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import  javax.persistence.Id;



@Data  //Lombok annotation to create getters,setters, hash and toString based on the fields in class
@Entity  //JPA Annotation to make objects ready for storage in a JPA-based data storage
/**
 * Base Data Class of this Rest API
 * Storing values prename, lastname, email of
 */
public class User {
    private @Id @GeneratedValue Long id;
    private String prename;
    private String lastname;
    private String email;

    //Empty Constructor
    User(){}

    /**
     * Full Constructor
     * @param pre Prename of the User
     * @param last Lastname of the User
     * @param email Email of the User
     */
    User(String pre, String last, String email){
        this.prename = pre;
        this.lastname = last;
        this.email = email;
    }
}
