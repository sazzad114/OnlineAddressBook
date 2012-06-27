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
            <br/>


            <form:form action="" commandName="vcardCommand" method="post">
                <table>
                    <tr>
                        <td>
                            <fmt:message key="vcard.fullName"/>
                            <span>&nbsp;&nbsp;&nbsp;</span>
                        </td>
                        <td>
                            <form:input path="fullName"/><br/>
                            <span class="error"><form:errors path="fullName"/></span>
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <fmt:message key="vcard.surname"/>
                            <span>&nbsp;&nbsp;&nbsp;</span>
                        </td>
                        <td>
                            <form:input path="name.surName"/><br/>
                            <span class="error"><form:errors path="name.surName"/></span>
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <fmt:message key="vcard.givenName"/>
                            <span>&nbsp;&nbsp;&nbsp;</span>
                        </td>
                        <td>
                            <form:input path="name.givenName"/><br/>
                            <span class="error"><form:errors path="name.givenName"/></span>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <fmt:message key="vcard.organization"/>
                            <span>&nbsp;&nbsp;&nbsp;</span>
                        </td>
                        <td>
                            <form:input path="organization"/><br/>
                            <span class="error"><form:errors path="organization"/></span>
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <fmt:message key="vcard.photoUrl"/>
                            <span>&nbsp;&nbsp;&nbsp;</span>
                        </td>
                        <td>
                            <form:input path="photoUrl"/><br/>
                            <span class="error"><form:errors path="photoUrl"/></span>
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <fmt:message key="vcard.email"/>
                            <span>&nbsp;&nbsp;&nbsp;</span>
                        </td>
                        <td>
                            <form:input path="email"/><br/>
                            <span class="error"><form:errors path="email"/></span>
                        </td>
                    </tr>

                    <%--<tr>
                        <td>
                            <fmt:message key="vcard.phoneNoType"/>
                            <span>&nbsp;&nbsp;&nbsp;</span>
                        </td>
                        <td>
                            <form:input path="phoneNoList[0].phoneNoType"/><br/>
                            <span class="error"><form:errors path="phoneNoList[0].phoneNoType"/></span>
                        </td>
                    </tr>--%>

                    <tr>
                        <td>
                            <fmt:message key="vcard.phoneNoValue"/>
                            <span>&nbsp;&nbsp;&nbsp;</span>
                        </td>
                        <td>
                            <form:input path="phoneNoList[0].phoneNoValue"/><br/>
                            <span class="error"><form:errors path="phoneNoList[0].phoneNoValue"/></span>
                        </td>
                    </tr>

                    <%--<tr>
                        <td>
                            <fmt:message key="vcard.addressType"/>
                            <span>&nbsp;&nbsp;&nbsp;</span>
                        </td>
                        <td>
                            <form:input path="addressList[0].addressType"/><br/>
                            <span class="error"><form:errors path="addressList[0].addressType"/></span>
                        </td>
                    </tr>--%>

                    <tr>
                        <td>
                            <fmt:message key="vcard.addressLabel"/>
                            <span>&nbsp;&nbsp;&nbsp;</span>
                        </td>
                        <td>
                            <form:input path="addressList[0].addressLabel"/><br/>
                            <span class="error"><form:errors path="addressList[0].addressLabel"/></span>
                        </td>
                    </tr>

                </table>


                <input type="submit" value="<fmt:message key="vcard.submit"/>"/>
            </form:form>

        </div>

        <div style="clear: both;">&nbsp;</div>
    </div>
</div>
<!-- end #content -->
<div style="clear: both;">&nbsp;</div>
</body>
</html>
