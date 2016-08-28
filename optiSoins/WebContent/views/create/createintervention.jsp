<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="../header.jsp"/>

<form action="${pageContext.request.contextPath}/intervention" method="post">
	
	<input type="hidden" name="action" value="savecreate">
	<jsp:include page="../form/formintervention.jsp" />
	<button type="submit">Enregistrer</button><br>

</form>

<script type="text/javascript">
		$(".datepicker").flatpickr();
	</script>
	
<jsp:include page="../footer.jsp"/>
