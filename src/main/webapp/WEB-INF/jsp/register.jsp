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
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <title>OnlineAddressBook</title>
    <link href="http://fonts.googleapis.com/css?family=Abel" rel="stylesheet" type="text/css"/>
    <link href="/OnlineAddressBook/resources/css/style.css" rel="stylesheet" type="text/css" media="screen"/>
    <script type="text/javascript" src="/OnlineAddressBook/resources/js/jquery-1.7.1.min.js"></script>
    <script type="text/javascript" src="/OnlineAddressBook/resources/js/jquery.dropotron-1.0.js"></script>
</head>
<body>
<div id="wrapper">
    <div id="header-wrapper">
        <div id="header">
            <div id="logo">
                <h1><a href="main.jsp">ONLINE ADDRESS BOOK</a></h1>

                <p>Your Online Memory...</p>
            </div>
        </div>
    </div>
    <!-- end #menu -->
    <div id="splash"><img src="/OnlineAddressBook/resources/img/pics01.jpg" width="980" height="300" alt=""/></div>
    <div id="page">
        <div id="content">
            <div class="contentbg">


                <div class="post">
                    <h2 class="title">${title}</h2>
                </div>

                <div class="post">
                    <br/>


                    <form:form action="" commandName="userCommand" method="post">
                        <table>
                            <tr>
                                <td>
                                    <fmt:message key="user.name"/>
                                    <span>&nbsp;&nbsp;&nbsp;</span>
                                </td>
                                <td>
                                    <form:input path="name"/><br/>
                                    <span class="error"><form:errors path="name"/></span>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <fmt:message key="user.email"/>
                                    <span>&nbsp;&nbsp;&nbsp;</span>
                                </td>
                                <td>
                                    <form:input path="email"/><br/>
                                    <span class="error"><form:errors path="email"/></span>
                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <fmt:message key="user.password"/>
                                    <span>&nbsp;&nbsp;&nbsp;</span>
                                </td>
                                <td>
                                    <form:password path="password"/><br/>
                                    <span class="error"><form:errors path="password"/></span>
                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <fmt:message key="user.confirmPassword"/>
                                    <span>&nbsp;&nbsp;&nbsp;</span>
                                </td>
                                <td>
                                    <form:password path="confirmPassword"/><br/>
                                    <span class="error"><form:errors path="confirmPassword"/></span>
                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <fmt:message key="user.occupation"/>
                                    <span>&nbsp;&nbsp;&nbsp;</span>
                                </td>
                                <td>
                                    <form:input path="occupation"/><br/>
                                    <span class="error"><form:errors path="occupation"/></span>
                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <fmt:message key="user.aboutMe"/>
                                    <span>&nbsp;&nbsp;&nbsp;</span>
                                </td>
                                <td>
                                    <form:textarea path="aboutMe" cols="40" rows="5"/><br/>
                                    <span class="error"><form:errors path="aboutMe"/></span>
                                </td>
                            </tr>


                        </table>


                        <input type="submit" value="<fmt:message key="user.submit"/>"/>
                    </form:form>
                </div>

                <div style="clear: both;">&nbsp;</div>
            </div>
        </div>
        <!-- end #content -->
        <div style="clear: both;">&nbsp;</div>
    </div>
    <!-- end #page -->
</div>
<div id="footer">
    <p>All rights reserved by OnlineAddressBook</p>
</div>
<!-- end #footer -->
</body>
</html>


<%--
  Created by IntelliJ IDEA.
  User: sazzadur
  Date: 6/26/12
  Time: 4:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Simple jsp page</title></head>
<body>Place your content here</body>
</html>