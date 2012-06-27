<%@ taglib prefix="decorator" uri="/SiteMash" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<!--
Design by Free CSS Templates
http://www.freecsstemplates.org
Released for free under a Creative Commons Attribution 2.5 License

Name : Commercial
Description: A two-column, fixed-width design with simple color scheme.
Version : 1.0
Released : 20120520
-->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
</head>
<body>
<div id="content">
    <div class="contentbg">
        <div class="post">
            <h2 class="title">${title}</h2>
        </div>
        <div class="post">
            <div class="entry">
            <br/>
            <table>
                <tr>
                    <td>
                        <fmt:message key="vcard.fullName"/>
                        <span>&nbsp;&nbsp;&nbsp;</span>
                    </td>
                    <td>
                        ${vcard.fullName}

                    </td>
                </tr>

                <tr>
                    <td>
                        <fmt:message key="vcard.surname"/>
                        <span>&nbsp;&nbsp;&nbsp;</span>
                    </td>
                    <td>
                        ${vcard.name.surName}
                    </td>
                </tr>

                <tr>
                    <td>
                        <fmt:message key="vcard.givenName"/>
                        <span>&nbsp;&nbsp;&nbsp;</span>
                    </td>
                    <td>
                        ${vcard.name.givenName}
                    </td>
                </tr>
                <tr>
                    <td>
                        <fmt:message key="vcard.organization"/>
                        <span>&nbsp;&nbsp;&nbsp;</span>
                    </td>
                    <td>
                        ${vcard.organization}
                    </td>
                </tr>

                <tr>
                    <td>
                        <fmt:message key="vcard.photoUrl"/>
                        <span>&nbsp;&nbsp;&nbsp;</span>
                    </td>
                    <td>
                        ${vcard.photoUrl}
                    </td>
                </tr>

                <tr>
                    <td>
                        <fmt:message key="vcard.email"/>
                        <span>&nbsp;&nbsp;&nbsp;</span>
                    </td>
                    <td>
                        ${vcard.email}
                    </td>
                </tr>

                <tr>
                    <td>
                        <fmt:message key="vcard.phoneNoValue"/>
                        <span>&nbsp;&nbsp;&nbsp;</span>
                    </td>
                    <td>
                        ${vcard.phoneNoList[0].phoneNoValue}
                    </td>
                </tr>

                <tr>
                    <td>
                        <fmt:message key="vcard.addressLabel"/>
                        <span>&nbsp;&nbsp;&nbsp;</span>
                    </td>
                    <td>
                        ${vcard.addressList[0].addressLabel}
                    </td>
                </tr>

            </table>
                <div style="float:right;">
                        <a href="/OnlineAddressBook/app/export.htm?vcardId=${vcard.vcardId}">Export</a> <br/>
                        <a href="/OnlineAddressBook/app/vcard/update.htm?vcardId=${vcard.vcardId}">Update</a>
                 </div>
           </div>
        </div>

    </div>
</div>
</body>
</html>
