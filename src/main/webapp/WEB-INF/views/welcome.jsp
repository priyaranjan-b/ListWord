<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@taglib prefix="pr"   tagdir="/WEB-INF/tags/printWords"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Word Splitter</title>
<style>
.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	width: 250px;
}
</style>
</head>
<body>
	<h2>Enter complete sentence here to get list of Word sorted by name and count</h2>
	<form:form method="POST" action="processSentence" modelAttribute="inputParam">
		<form:errors path="*" cssClass="errorblock" element="div" />
		<table>
			<tr>
				<td>Enter Sentence Here: </td>
				<td><form:textarea path="sentence" rows="3" cols="50"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>
	
	<!-- Calling pr:printWordCount to list down all the words-->
	<pr:printWordCount wordCountList="${wordSortedByName}" message="Alphabetical list (with counts in parentheses)"/>
	<pr:printWordCount wordCountList="${wordSortedByCount}" message="Frequency list (with counts in parentheses)"/>
</body>
</html>