<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="description" content="">
<meta name="author" content="">
<title>Web App</title>
<!-- Bootstrap core CSS-->
<link
	href="<spring:url value='resources/vendor/bootstrap/css/bootstrap.min.css'/>"
	rel="stylesheet">
<!-- Custom fonts for this template-->
<link
	href="<spring:url value='resources/vendor/font-awesome/css/font-awesome.min.css'/>"
	rel="stylesheet" type="text/css">
<!-- Page level plugin CSS-->
<link
	href="<spring:url value='resources/vendor/datatables/dataTables.bootstrap4.css'/>"
	rel="stylesheet">
<!-- Custom styles for this template-->
<link href="<spring:url value='resources/css/sb-admin.css'/>"
	rel="stylesheet">
<link href="<spring:url value='resources/css/new-age.min.css'/>"
	rel="stylesheet">

</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<!-- Navigation-->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top"
		id="mainNav">
		<a class="navbar-brand" href="index">Web App</a>
		<button class="navbar-toggler navbar-toggler-right" type="button"
			data-toggle="collapse" data-target="#navbarResponsive"
			aria-controls="navbarResponsive" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<%@include file="template.jsp"%>


	</nav>
	<div class="content-wrapper">
		<div class="container-fluid">
			<!-- Breadcrumbs-->
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="index.html">Dashboard</a>
				</li>
				<li class="breadcrumb-item active">Blank Page</li>
			</ol>
			<div class="row">
				<div class="col-12">
					<h1>Blank</h1>
					<p>This is an example of a blank page that you can use as a
						starting point for creating new ones.</p>
				</div>
			</div>
		</div>
		<!-- /.container-fluid-->
		<!-- /.content-wrapper-->
		<footer class="sticky-footer">
			<div class="container">
				<div class="text-center">
					<small>Alex Braz 2018</small>
				</div>
			</div>
		</footer>
		<!-- Scroll to Top Button-->
		<a class="scroll-to-top rounded" href="#page-top"> <i
			class="fa fa-angle-up"></i>
		</a>
		<!-- Logout Modal-->
		<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Ready to
							Leave?</h5>
						<button class="close" type="button" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">x</span>
						</button>
					</div>
					<div class="modal-body">Select "Logout" below if you are
						ready to end your current session.</div>
					<div class="modal-footer">
						<button class="btn btn-secondary" type="button"
							data-dismiss="modal">Cancel</button>
						<a class="btn btn-primary" href="logout">Logout</a>
					</div>
				</div>
			</div>
		</div>

		<!-- Confirmation Modal-->
		<div class="modal fade" id="TransactionModal" tabindex="-1"
			role="dialog" aria-labelledby="confirmTransacaoModalLabel"
			aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Transacao
							Efetuada</h5>
						<button class="close" type="button" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">x</span>
						</button>
					</div>
					<div class="modal-body">Transação Efetuada com sucesso.</div>
					<div class="modal-footer">
						<button class="btn btn-primary" type="button" data-dismiss="modal">Ok</button>
					</div>
				</div>
			</div>
		</div>

		<!-- Bootstrap core JavaScript-->
		<script
			src="<spring:url value='resources/vendor/jquery/jquery.min.js'/>"></script>
		<script
			src="<spring:url value='resources/vendor/bootstrap/js/bootstrap.bundle.min.js'/>"></script>
		<!-- Core plugin JavaScript-->
		<script
			src="<spring:url value='resources/vendor/jquery-easing/jquery.easing.min.js'/>"></script>
		<!-- Page level plugin JavaScript-->
		<script
			src="<spring:url value='resources/vendor/chart.js/Chart.min.js'/>"></script>
		<script
			src="<spring:url value='resources/vendor/datatables/jquery.dataTables.js'/>"></script>
		<script
			src="<spring:url value='resources/vendor/datatables/dataTables.bootstrap4.js'/>"></script>
		<!-- Custom scripts for all pages-->
		<script src="<spring:url value='resources/js/sb-admin.min.js'/>"></script>
		<!-- Custom scripts for this page-->
		<script
			src="<spring:url value='resources/js/sb-admin-datatables.min.js'/>"></script>
		<script
			src="<spring:url value='resources/js/sb-admin-charts.min.js'/>"></script>
	</div>

</body>

</html>
