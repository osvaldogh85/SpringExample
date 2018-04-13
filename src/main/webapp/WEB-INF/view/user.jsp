<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>User Validator</title>
<!-- Bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>

	<div class="container">

		<ul class="nav nav-tabs">
			<li role="presentation"><a href="?locale=en_us">us</a></li>
			<li role="presentation" class="active"><a href="?locale=es_es">es</a></li>
			<li role="presentation"><a href="?locale=de_de">de</a></li>
		</ul>

		<div class="page-header">
			<h1>
				${message}
			</h1>
		</div>
		<div class="panel panel-primary">
			<div class="panel-heading">User Validation</div>
			<div class="panel-body">
				<div class="container">
					<div class="row">
		
						<form:form modelAttribute="user" action="user" method="post"
							cssClass="form-horizontal" role="form">
							<div class="form-group">
								<form:label for="fullName" path="fullName"
									cssClass="col-sm-2 control-label">FullLast Name</form:label>
								<div class="col-sm-10">
									<form:input path="fullName" style="width: 300px;"
										cssClass="form-control"
										cssErrorClass="form-control alert-danger" />
									<form:errors path="fullName" />
								</div>
							</div>	
							
							<div class="form-group">
								<form:label for="nickName" path="nickName"
									cssClass="col-sm-2 control-label">User Name</form:label>
								<div class="col-sm-10">
									<form:input path="nombre" style="width: 300px;"
										cssClass="form-control"
										cssErrorClass="form-control alert-danger" />
									<form:errors path="nickName" />
								</div>
							</div>						
							

							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									<input type="submit" value="Validate User"
										class="btn btn-primary" role="button" />
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>

	</div>

</body>
</html>
