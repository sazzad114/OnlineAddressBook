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
<head></head>
<body>
<div id="content">
    <div class="contentbg">
        <div class="post">
            <h2 class="title">${title}</h2>
        </div>
        <div class="post">

          <c:forEach items="${vcardList}" var="vcard">
                <div class="entry">

                    <a href="/OnlineAddressBook/app/vcard/view.htm?vcardId=${vcard.vcardId}">${vcard.fullName}</a>

                    <div style="float:right;">
                        <a href="/OnlineAddressBook/app/vcard/delete.htm?vcardId=${vcard.vcardId}">delete</a>
                    </div>

                </div>
        </c:forEach>


        </div>
    </div>
</div>
</body>
</html>
