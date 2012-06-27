package net.therap.domain;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by IntelliJ IDEA.
 * User: sazzadur
 * Date: 6/26/12
 * Time: 12:16 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "SAZ_PHONENO")
public class PhoneNo {
    private long phoneNoId;
    //@Pattern(regexp = "([a-zA-Z][a-zA-Z]*\\s)*[a-zA-Z]*", message = "allow only alpha character and no consecutive spaces")
    //@Size(min = 5, max = 50, message = "within 5 to 50 characters")
    private String phoneNoType;
    @Pattern(regexp = "([a-zA-Z0-9][a-zA-Z0-9]*\\s)*[a-zA-Z0-9]*", message = "allow only alpha numeric character and no consecutive spaces")
    @Size(min = 5, max = 50, message = "within 5 to 50 characters")
    private String phoneNoValue;
    private Vcard vcard;
    private long version;

    @Id
    @SequenceGenerator(name = "SAZ_PHONE_SEQ", sequenceName = "SAZ_PHONE_SEQ")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SAZ_PHONE_SEQ")
    @Column(name = "PHONE_ID")
    public long getPhoneNoId() {
        return phoneNoId;
    }

    public void setPhoneNoId(long phoneNoId) {
        this.phoneNoId = phoneNoId;
    }

    @Column(name = "PHONE_TYPE")
    public String getPhoneNoType() {
        return phoneNoType;
    }

    public void setPhoneNoType(String phoneNoType) {
        this.phoneNoType = phoneNoType;
    }

    @Column(name = "PHONE_VALUE")
    public String getPhoneNoValue() {
        return phoneNoValue;
    }

    public void setPhoneNoValue(String phoneNoValue) {
        this.phoneNoValue = phoneNoValue;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VCARD_ID")
    public Vcard getVcard() {
        return vcard;
    }

    public void setVcard(Vcard vcard) {
        this.vcard = vcard;
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
