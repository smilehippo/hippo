<%--
  Created by IntelliJ IDEA.
  User: clude
  Date: 9/28/16
  Time: 5:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
    <title>${title}</title>
    <meta name="decorator" content="masterpage"/>

    <script type="text/javascript">
        window.vuewname = 'pages/auth/SignIn';
    </script>
</head>
<body>
<div id="app"></div>
<div>${tpl}</div>
<script src="http://127.0.0.1:8888/dist/build.js"></script>
</body>
</html>
