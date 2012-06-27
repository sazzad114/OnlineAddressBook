package net.therap.domain;

import org.hibernate.annotations.Cascade;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: sazzadur
 * Date: 6/26/12
 * Time: 12:07 PM
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "SAZ_VCARD")
public class Vcard {

    private long vcardId;
    private User user;

    private String vcardVersion;   //must to be set in service.
    @Valid
    private Name name;
    @Pattern(regexp = "([a-zA-Z][a-zA-Z]*\\s)*[a-zA-Z]*", message = "allow only alpha character and no consecutive spaces")
    @Size(min = 2, max = 50, message = "within 5 to 50 characters")
    private String fullName;
    @Pattern(regexp = "([a-zA-Z][a-zA-Z]*\\s)*[a-zA-Z]*", message = "allow only alpha character and no consecutive spaces")
    @Size(min = 2, max = 50, message = "within 5 to 50 characters")
    private String organization;
    private String title;
    private String photoUrl;
    @Valid
    private List<PhoneNo> phoneNoList = new ArrayList<PhoneNo>();
    @Valid
    private List<Address> addressList = new ArrayList<Address>();

    @Email(message = "email should follow the format email@domain.com")
    @Size(min = 10, max = 50, message = "within 10 to 50 characters")
    private String email;
    private Date lastRevision;  //must to be set in service
    private long version;

    @Id
    @SequenceGenerator(name = "SAZ_VCARD_SEQ", sequenceName = "SAZ_VCARD_SEQ")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SAZ_VCARD_SEQ")
    @Column(name = "VCARD_ID")
    public long getVcardId() {
        return vcardId;
    }

    public void setVcardId(long vcardId) {
        this.vcardId = vcardId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Embedded
    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    @Column(name = "VCARD_VERSION",nullable = false)
    public String getVcardVersion() {
        return vcardVersion;
    }

    public void setVcardVersion(String vcardVersion) {
        this.vcardVersion = vcardVersion;
    }



    @Column(name = "VCARD_FULLNAME",nullable = false)
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Column(name = "VCARD_ORGANIZATION")
    public String getOrganization() {
        return organization;
    }
    @Column(name = "VCARD_TITLE")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    @Column(name = "VCARD_PHOTO_URL")
    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    @OneToMany(cascade = {CascadeType.ALL, CascadeType.REMOVE}, fetch = FetchType.LAZY, mappedBy = "vcard")
    @Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
    public List<PhoneNo> getPhoneNoList() {
        return phoneNoList;
    }

    public void setPhoneNoList(List<PhoneNo> phoneNoList) {
        this.phoneNoList = phoneNoList;
    }

    @OneToMany(cascade = {CascadeType.ALL, CascadeType.REMOVE}, fetch = FetchType.LAZY, mappedBy = "vcard")
    @Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    @Column(name = "VCARD_EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "VCARD_LAST_REVISION")
    public Date getLastRevision() {
        return lastRevision;
    }

    public void setLastRevision(Date lastRevision) {
        this.lastRevision = lastRevision;
    }

    @Version
    @Column(name = "VERSION")
    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }
}
