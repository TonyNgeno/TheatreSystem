package com.theatre.model;

import javax.persistence.*;

@Entity
@Table(name = "userdetails")
@NamedQueries({
        @NamedQuery(name = "UserDetail.findAll", query = "SELECT u FROM UserDetail u"),
        @NamedQuery(name = "UserDetail.findAllUsersOrdered", query = "SELECT u FROM UserDetail u ORDER BY u.bioData.idNo DESC"),
        @NamedQuery(name = "UserDetail.findById", query = "SELECT u FROM UserDetail u WHERE  u.bioData.idNo = :idNo"),
        @NamedQuery(name = "UserDetail.findByEmail", query = "SELECT u FROM UserDetail u WHERE u.contact.email = :email"),
        @NamedQuery(name = "UserDetail.findByUsername", query = "SELECT u FROM UserDetail u WHERE u.username = :username"),})
public class UserDetail extends BaseEntity {

    @Embedded
    private BioData bioData;

    @Embedded
    private Contact contact;

    @Column
    private String username;

    @Column
    private String password;

    @Transient
    private String confirmpassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public BioData getBioData() {
        return bioData;
    }

    public void setBioData(BioData bioData) {
        this.bioData = bioData;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmpassword() {
        return confirmpassword;
    }

    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }
}
