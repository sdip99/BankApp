<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix='spring' uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="lbl.title" /></title>
</head>
<body>
	<div class="container">
		<%@ include file="header.jsp"%>

		<div class="row">
			<div class="col-12">
				<a href="<c:url value='/newAccountform' />" class="btn btn-lg btn-primary">Add New Account</a>
			</div>
		</div><br/>
		<table class="table table-bordered table-hover">
			<thead class="bg-success">
				<tr>
					<th><spring:message code="lbl.accNum"></spring:message></th>
					<th><spring:message code="lbl.accHolderName"></spring:message></th>
					<th><spring:message code="lbl.accBal"></spring:message></th>
					<th>Action</th>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach var="acc" items="${ accList }">
					<c:url var="updateLink" value="/editAcc">
						<c:param name="accNum" value="${acc.accNum }"></c:param>
					</c:url>
					<c:url var="deleteLink" value="/deleteAcc">
						<c:param name="accNum" value="${acc.accNum }"></c:param>
					</c:url>
					<tr>
						<td>${acc.accNum }</td>
						<td>${acc.accHolderName }</td>
						<td>${acc.accBal }</td>
						<td><a href="${updateLink }" class="btn btn-warning">Edit</a>
						<a href="${deleteLink }" class="btn btn-danger"
							onCLick="if(!(confirm('Are you sure to delete?'))) return false">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br />
		<br /> <a href="newAccountform">Create New Account</a><br/> <a href="./">Go
			Back</a>

		<%@ include file="footer.jsp"%>
	</div>

</body>
</html>