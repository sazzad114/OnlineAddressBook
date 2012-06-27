package net.therap.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by IntelliJ IDEA.
 * User: sazzadur
 * Date: 6/27/12
 * Time: 8:00 AM
 * To change this template use File | Settings | File Templates.
 */

@Embeddable
public class Name {
    @Pattern(regexp = "([a-zA-Z][a-zA-Z]*\\s)*[a-zA-Z]*", message = "allow only alpha character and no consecutive spaces")
   @Size(min = 2, max = 50, message = "within 5 to 50 characters")
    private String surName;
    @Pattern(regexp = "([a-zA-Z][a-zA-Z]*\\s)*[a-zA-Z]*", message = "allow only alpha character and no consecutive spaces")
   @Size(min = 2, max = 50, message = "within 5 to 50 characters")
    private String givenName;
    //@Pattern(regexp = "([a-zA-Z][a-zA-Z]*\\s)*[a-zA-Z]*", message = "allow only alpha character and no consecutive spaces")
   //@Size(min = 5, max = 50, message = "within 5 to 50 characters")
    private String additionalName;
    //@Pattern(regexp = "([a-zA-Z][a-zA-Z]*\\s)*[a-zA-Z]*", message = "allow only alpha character and no consecutive spaces")
   //@Size(min = 5, max = 50, message = "within 5 to 50 characters")
    private String prefixName;
    //@Pattern(regexp = "([a-zA-Z][a-zA-Z]*\\s)*[a-zA-Z]*", message = "allow only alpha character and no consecutive spaces")
   //@Size(min = 5, max = 50, message = "within 5 to 50 characters")
    private String suffixName;

    @Column(name = "SUR_NAME")
    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    @Column(name = "GIVEN_NAME")
    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    @Column(name = "ADDITIONAL_NAME")
    public String getAdditionalName() {
        return additionalName;
    }

    public void setAdditionalName(String additionalName) {
        this.additionalName = additionalName;
    }

    @Column(name = "PREFIX_NAME")
    public String getPrefixName() {
        return prefixName;
    }

    public void setPrefixName(String prefixName) {
        this.prefixName = prefixName;
    }

   @Column(name = "SUFFIX_NAME")
    public String getSuffixName() {
        return suffixName;
    }

    public void setSuffixName(String suffixName) {
        this.suffixName = suffixName;
    }


}
