package net.therap.domain;

import org.hibernate.annotations.Cascade;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: sazzadur
 * Date: 6/26/12
 * Time: 12:22 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "SAZ_USER")
public class User {
   private  long userId;
   @Pattern(regexp = "([a-zA-Z][a-zA-Z]*\\s)*[a-zA-Z]*", message = "allow only alpha character and no consecutive spaces")
   @Size(min = 5, max = 50, message = "within 5 to 50 characters")
   private String name;
   @Email(message = "email should follow the format email@domain.com")
   @Size(min = 10, max = 50, message = "within 10 to 50 characters")
   private String email;
   @Pattern(regexp = "([a-zA-Z][a-zA-Z]*\\s)*[a-zA-Z]*", message = "allow only alpha character and no consecutive spaces")
   @Size(min = 5, max = 50, message = "within 5 to 50 characters")
   private String occupation;
   @Size(min = 20, max = 300, message = "within 20 to 100 characters")
   private String aboutMe;
   @Pattern(regexp = "[^\\s]*", message = "space is not allowed")
   @Size(min = 8, max = 30, message = "within 8 to 30 characters")
   private String password;
   @Pattern(regexp = "[^\\s]*", message = "space is not allowed")
   @Size(min = 8, max = 30, message = "within 8 to 30 characters")
   private String confirmPassword;
   private List<Vcard> vcardList = new ArrayList<Vcard>();

    @Id
    @SequenceGenerator(name = "SAZ_USER_SEQ", sequenceName = "SAZ_USER_SEQ")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SAZ_USER_SEQ")
    @Column(name = "USER_ID")

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Column(name = "USER_NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
   @Column(name = "EMAIL",nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

     @Column(name = "OCCUPATION",nullable = false)
    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    @Column(name = "ABOUT_ME",nullable = false)
    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

     @Column(name = "PASSWORD",nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Transient
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY, mappedBy = "user")
    @Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
    public List<Vcard> getVcardList() {
        return vcardList;
    }

    public void setVcardList(List<Vcard> vcardList) {
        this.vcardList = vcardList;
    }
}
