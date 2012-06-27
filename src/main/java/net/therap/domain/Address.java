package net.therap.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Created by IntelliJ IDEA.
 * User: sazzadur
 * Date: 6/26/12
 * Time: 12:16 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "SAZ_ADDRESS")
public class Address {
    private long addressId;
    //@Pattern(regexp = "([a-zA-Z][a-zA-Z]*\\s)*[a-zA-Z]*", message = "allow only alpha character and no consecutive spaces")
   //@Size(min = 5, max = 50, message = "within 5 to 50 characters")
    private String addressType;

   @Size(min = 5, max = 50, message = "within 5 to 50 characters")
    private String addressLabel;
    //@Pattern(regexp = "([a-zA-Z0-9][a-zA-Z0-9]*\\s)*[a-zA-Z0-9]*", message = "allow only alpha numeric character and no consecutive spaces")
    //@Size(min = 5, max = 50, message = "within 5 to 50 characters")
    private String pobox;
    //@Pattern(regexp = "([a-zA-Z0-9][a-zA-Z0-9]*\\s)*[a-zA-Z0-9]*", message = "allow only alpha numeric character and no consecutive spaces")
    //@Size(min = 5, max = 50, message = "within 5 to 50 characters")
    private String ext;
    //@Pattern(regexp = "([a-zA-Z0-9][a-zA-Z0-9]*\\s)*[a-zA-Z0-9]*", message = "allow only alpha numeric character and no consecutive spaces")
    //@Size(min = 5, max = 50, message = "within 5 to 50 characters")
    private String street;
    //@Pattern(regexp = "([a-zA-Z0-9][a-zA-Z0-9]*\\s)*[a-zA-Z0-9]*", message = "allow only alpha numeric character and no consecutive spaces")
    //@Size(min = 5, max = 50, message = "within 5 to 50 characters")
    private String locality;
    //@Pattern(regexp = "([a-zA-Z0-9][a-zA-Z0-9]*\\s)*[a-zA-Z0-9]*", message = "allow only alpha numeric character and no consecutive spaces")
    //@Size(min = 5, max = 50, message = "within 5 to 50 characters")
    private String region;
    //@Pattern(regexp = "([a-zA-Z0-9][a-zA-Z0-9]*\\s)*[a-zA-Z0-9]*", message = "allow only alpha numeric character and no consecutive spaces")
    //@Size(min = 5, max = 50, message = "within 5 to 50 characters")
    private String code;
    //@Pattern(regexp = "([a-zA-Z0-9][a-zA-Z0-9]*\\s)*[a-zA-Z0-9]*", message = "allow only alpha numeric character and no consecutive spaces")
    //@Size(min = 5, max = 50, message = "within 5 to 50 characters")
    private String country;
    private Vcard vcard;
    private long version;

    @Id
    @SequenceGenerator(name = "SAZ_ADDRESS_SEQ", sequenceName = "SAZ_ADDRESS_SEQ")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SAZ_ADDRESS_SEQ")
    @Column(name = "ADDRESS_ID")
    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    @Column(name = "ADDRESS_TYPE")
    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public String getAddressLabel() {
        return addressLabel;
    }

    @Column(name = "ADDRESS_LABEL")
    public void setAddressLabel(String addressLabel) {
        this.addressLabel = addressLabel;
    }
    @Column(name = "ADDRESS_POBOX")
    public String getPobox() {
        return pobox;
    }

    public void setPobox(String pobox) {
        this.pobox = pobox;
    }
    @Column(name = "ADDRESS_EXT")
    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    @Column(name = "ADDRESS_STREET")
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Column(name = "ADDRESS_LOCALITY")
    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    @Column(name = "ADDRESS_REGION")
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
    @Column(name = "ADDRESS_CODE")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    @Column(name = "ADDRESS_COUNTRY")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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
