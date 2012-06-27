<%@ taglib prefix="decorator" uri="/SiteMash" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                    <h2 class="title">Log In :</h2>
                </div>

                <div class="post">
                    <br/>
                    <fieldset style="width:120px; padding-right:120px;border-color:#dbdada;border-width:1px">

                        <form action="/OnlineAddressBook/app/login.htm" method="post">

                            <ul style="list-style-type:none;">
                                <li>
                                    <label>Email : </label>
                                    <input type="text" name="email"/>
                                </li>
                                <li>
                                    <br/>
                                    <label>Password : </label>
                                    <input type="password" name="password"/>
                                </li>
                                <br/>

                                <c:if test="${param['errorcode'] == 1}">
                                    <span class="error"> invalid email or password </span>
                                </c:if>
                                <li>
                                    <input type="submit" value="Log in"/>
                                </li>

                            </ul>

                        </form>
                    </fieldset>
                    <div class="post">
                        If you are not a registered user, please register <a href="/OnlineAddressBook/app/register.htm"><span>here</span></a>!
                    </div>
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




