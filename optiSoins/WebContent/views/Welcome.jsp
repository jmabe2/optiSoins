<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<jsp:include page="header.jsp"/>


<body>
	Hello <c:out value="${sessionScope['loginUser'].nom}"></c:out>

<jsp:include page="footer.jsp"/>