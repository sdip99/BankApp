<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix='form' uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix='spring' uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="lbl.title"></spring:message></title>
<style type="text/css">
.err {
	color: red
}
</style>
</head>
<body>
	<div class="container">
		<%@ include file="header.jsp"%>

		<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xl-12 col-12">
				<h2 class="page-header">Fill Up The Account Form</h2>
			</div>
			<div class="row">
				<div class="col-6">
					<form:form action="updateAccount" modelAttribute="account"
						cssClass="form-horizontal" role="form">
						<div class="form-group row">
							<Label for="accNum" class="col-6 col-form-label"><spring:message
									code="lbl.accNum" /></Label>
							<div class="col-6">
								<form:input path='accNum' cssClass="form-control" />
								<form:errors path='accNum' cssClass="alert-danger" />
							</div>
						</div>

						<div class="form-group row">
							<Label for="accHolderName" class="col-6 col-form-label"><spring:message
									code="lbl.accHolderName" /></Label>
							<div class="col-6">
								<form:input path='accHolderName' cssClass="form-control" />
								<form:errors path='accHolderName' cssClass="alert-danger" />
							</div>
						</div>

						<div class="form-group row">
							<Label for="accBal" class="col-6 col-form-label"><spring:message
									code="lbl.accBal" /></Label>
							<div class="col-6">
								<form:input path='accBal' cssClass="form-control" />
								<form:errors path='accBal' cssClass="alert-danger" />
							</div>
						</div>

						<div class="form-group row">
							<Label for="accType" class="col-6 col-form-label"><spring:message
									code="lbl.accType" /></Label>
							<div class="col-6">
								<form:select path='accType' cssClass="form-control">
									<form:option value="">Select</form:option>
									<form:option value="SAVING">Saving</form:option>
									<form:option value="CURRENT">Current</form:option>
								</form:select>
								<form:errors path='accType' cssClass="alert-danger" />
							</div>
						</div>

						<div class="form-group row">
							<Label for="dob" class="col-6 col-form-label"><spring:message
									code="lbl.dob" /></Label>
							<div class="col-6">
								<form:input path='dob' cssClass="form-control" />
								<form:errors path='dob' cssClass="alert-danger" />
							</div>
						</div>

						<div class="form-group row">
							<Label for="psCode" class="col-6 col-form-label"><spring:message
									code="lbl.psCode" /></Label>
							<div class="col-6">
								<form:input path='psCode' cssClass="form-control" />
								<form:errors path='psCode' cssClass="alert-danger" />
							</div>
						</div>

						<div class="form-group row">
							<div class="offset-6 col-6">
								<input type='submit' value="Save Account" name='btnSubmit' class="btn btn-primary">
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>

		<%@ include file="footer.jsp"%>
	</div>

</body>
</html>