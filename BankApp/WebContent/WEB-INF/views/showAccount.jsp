<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix='form' uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix='spring' uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="lbl.title" /></title>
</head>
<body>
	<h2>Account Details:</h2>
	<p>
		<spring:message code="lbl.accNum" />
		: ${account.accNum}
	</p>
	<p>
		<spring:message code="lbl.accHolderName" />
		: ${account.accHolderName}
	</p>
	<p>
		<spring:message code="lbl.accBal" />
		: ${account.accBal}
	</p>
	<p>
		<spring:message code="lbl.accType" />
		: ${account.accType}
	</p>
	<p>
		<spring:message code="lbl.dob" />
		: ${account.dob}
	</p>
	<p>
		<spring:message code="lbl.psCode" />
		: ${account.psCode}
	</p>
</body>
</html>