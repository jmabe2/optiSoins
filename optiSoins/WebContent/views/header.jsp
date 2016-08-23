<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html">
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css">
    <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
    <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
     <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/flatpickr-gh-pages/dist/flatpickr.min.css">
     <script src="${pageContext.request.contextPath}/js/flatpickr-gh-pages/dist/flatpickr.js"></script>
     <script src="${pageContext.request.contextPath}/js/flatpickr-gh-pages/src/flatpickr.l10n.fr.js"></script>
    <title>optiSoins</title>
</head>
<body>
<header id="header" class="header">
    
	 <div class="container">
	 <h1>
	    <img src="${pageContext.request.contextPath}/pictures/logo.png">
        optiSoins
     </h1>
     </div>
<jsp:include page="menu.jsp"/>
</header>
<div class="container">

