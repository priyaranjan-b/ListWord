<%@ tag body-content="empty"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!-- Input Params of this tag -->
<%@ attribute name="wordCountList" rtexprvalue="true" required="true"
	type="java.util.List" description="List of the World along with its repeatation count"%>
<%@ attribute name="message" rtexprvalue="true" required="true"
	type="java.lang.String" description="Display Message"%>

<c:if test="${not empty wordCountList}">
<!-- Display message only if some data are there in the list -->
	<h4><c:out value="${message}"/></h4>
	
	<c:forEach var="item" items="${wordCountList}">
		<c:out value="${item.word}" />
		<c:out value="(${item.count})"/>
		<br/>
	</c:forEach>
</c:if>