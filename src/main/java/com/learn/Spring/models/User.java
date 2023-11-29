package com.learn.Spring.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id", unique = true)
    private Long id;

    @Column(name = "user_name", length = 100, nullable = false, unique= true)
    @NotBlank
    @Size(min=2, max = 100)
    private String userName; 

    @Column(name = "password", length = 50, nullable = false) 
    @NotBlank
    @Size(min=8, max=50)
    @JsonProperty(access = Access.WRITE_ONLY)
    private String password;

    public User() {
    }

    public User(Long id, @NotBlank @Size(min = 2, max = 100) String userName,
            @NotBlank @Size(min = 8, max = 50) String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

  

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((userName == null) ? 0 : userName.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (userName == null) {
            if (other.userName != null)
                return false;
        } else if (!userName.equals(other.userName))
            return false;
        if (password == null) {
            if (other.password != null)
                return false;
        } else if (!password.equals(other.password))
            return false;
        return true;
    }
    

}
