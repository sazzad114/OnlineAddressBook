package net.therap.utills;

import net.therap.domain.Address;
import net.therap.domain.Name;
import net.therap.domain.PhoneNo;
import net.therap.domain.Vcard;

/**
 * Created by IntelliJ IDEA.
 * User: sazzadur
 * Date: 6/27/12
 * Time: 11:16 AM
 * To change this template use File | Settings | File Templates.
 */
public class VcardUtills {

    public static byte[] vcardToByteArray(Vcard vcard) {
        String vcardString = new String("BEGIN:VCARD");
        vcardString += "\nVERSION:";
        vcardString += vcard.getVcardVersion();
        vcardString += "\nN:";

        if (vcard.getName().getSurName() != null) {
            vcardString += vcard.getName().getSurName();
        }

        vcardString += ";";

        if (vcard.getName().getGivenName() != null) {
            vcardString += vcard.getName().getGivenName();
        }

        vcardString += ";";

        if (vcard.getName().getAdditionalName() != null) {
            vcardString += vcard.getName().getAdditionalName();
        }

        vcardString += ";";

        if (vcard.getName().getPrefixName() != null) {
            vcardString += vcard.getName().getPrefixName();
        }

        vcardString += ";";

        if (vcard.getName().getSuffixName() != null) {
            vcardString += vcard.getName().getSuffixName();
        }

        vcardString += "\nFN:";

        if (vcard.getFullName() != null) {
            vcardString += vcard.getFullName();
        }

        vcardString += "\nORG:";
        if (vcard.getOrganization() != null) {
            vcardString += vcard.getOrganization();
        }

        vcardString += "\nTITLE:";
        if (vcard.getTitle() != null) {
            vcardString += vcard.getTitle();
        }

        vcardString += "\nPHOTO:";
        if (vcard.getPhotoUrl() != null) {
            vcardString += vcard.getPhotoUrl();
        }

        for (PhoneNo phoneNo : vcard.getPhoneNoList()) {
            vcardString += "\nTEL;";
            vcardString += "TYPE=";
            if (phoneNo.getPhoneNoType() != null) {
                vcardString += "\"" + phoneNo.getPhoneNoType() + "\"";
            }
            vcardString += ";VALUE=";
            if (phoneNo.getPhoneNoValue() != null) {
                vcardString += phoneNo.getPhoneNoValue();
            }
        }

        for (Address address : vcard.getAddressList()) {
            vcardString += "\nADR;";
            vcardString += "TYPE=";
            if (address.getAddressType() != null) {
                vcardString += address.getAddressType();
            }

            vcardString += "LABEL=";
            if (address.getAddressLabel() != null) {
                vcardString += "\"" + address.getAddressLabel() + "\"";
            }
            vcardString += "\n:";
            if (address.getPobox() != null) {
                vcardString += address.getPobox();
            }
            vcardString += ";";

            if (address.getExt() != null) {
                vcardString += address.getExt();
            }
            vcardString += ";";

            if (address.getStreet() != null) {
                vcardString += address.getStreet();
            }
            vcardString += ";";

            if (address.getLocality() != null) {
                vcardString += address.getLocality();
            }
            vcardString += ";";

            if (address.getRegion() != null) {
                vcardString += address.getRegion();
            }
            vcardString += ";";

            if (address.getCode() != null) {
                vcardString += address.getCode();
            }
            vcardString += ";";
            if (address.getCountry() != null) {
                vcardString += address.getCountry();
            }

        }

        vcardString += "\nEMAIL:";

        if (vcard.getEmail() != null) {
            vcardString += vcard.getEmail();
        }

        vcardString += "\nREV:";
        vcardString += vcard.getLastRevision().toString();
        vcardString += "\nEND:VCARD";
        return vcardString.getBytes();
    }

    public static Vcard byteArrayToVcard(byte[] vcardByteArray) {
        String vcardString = new String(vcardByteArray);
        Vcard vcardObj = new Vcard();
        String[] temp = vcardString.split("\n");

        for (int i = 1; i < temp.length - 1; i++) {
            temp[i] = temp[i].trim();
            if (temp[i].contains("VERSION:")) {

                String[] versionStrings = temp[i].split(":");
                vcardObj.setVcardVersion(versionStrings[1]);

            } else if (temp[i].contains("FN:")) {

                String[] fullNameStrings = temp[i].split(":");
                vcardObj.setFullName(fullNameStrings[1]);
            } else if (temp[i].contains("N:")) {

                String[] surNameStrings = temp[i].split("[:;]");
                Name name = new Name();
                name.setSurName(surNameStrings[1]);
                name.setGivenName(surNameStrings[2]);
              /*  name.setAdditionalName(surNameStrings[3]);
                name.setPrefixName(surNameStrings[4]);
                name.setSuffixName(surNameStrings[5]);*/
                vcardObj.setName(name);

            } else if (temp[i].contains("ORG:")) {

                String[] orgStrings = temp[i].split(":");
                vcardObj.setOrganization(orgStrings[1]);

            } else if (temp[i].contains("TITLE:")) {

                String[] titleStrings = temp[i].split(":");
                vcardObj.setTitle(titleStrings[1]);

            } else if (temp[i].contains("PHOTO:")) {

                String[] photoStrings = temp[i].split("O:");
                vcardObj.setPhotoUrl(photoStrings[1]);

            } else if (temp[i].contains("TEL;")) {

                String[] telStrings = temp[i].split("[=;\"]");
                PhoneNo phoneNo = new PhoneNo();
                phoneNo.setPhoneNoType(telStrings[3]);
                phoneNo.setPhoneNoValue(telStrings[6]);
                vcardObj.getPhoneNoList().add(phoneNo);
                phoneNo.setVcard(vcardObj);

            } else if (temp[i].contains("ADR;TYPE")) {

                String[] addressStrings = temp[i].split("[=;\"]");
                Address address = new Address();
               address.setAddressType(addressStrings[2]);
                String label = addressStrings[5];
                int j;
                for (j = 1; temp[i + j].indexOf(":") < 0; j++) {
                    label += " ";
                    label += temp[i + j];
                }
                address.setAddressLabel( label);

                if (temp[i + j].indexOf(":") >= 0) {

                    String[] valueStrings = temp[i + j].split("[:;]");
                    address.setPobox(valueStrings[1]);
                    address.setExt(valueStrings[2]);
                    address.setStreet(valueStrings[3]);
                    address.setLocality(valueStrings[4]);
                    address.setRegion(valueStrings[5]);
                    address.setCode(valueStrings[6]);
                    address.setCountry(valueStrings[7]);

                }
                vcardObj.getAddressList().add(address);
                address.setVcard(vcardObj);

            } else if (temp[i].contains("EMAIL:")) {

                String[] emailStrings = temp[i].split(":");
                vcardObj.setEmail(emailStrings[1]);

            }
            vcardObj.setLastRevision(new java.util.Date());
        }
        return vcardObj;
    }


}
