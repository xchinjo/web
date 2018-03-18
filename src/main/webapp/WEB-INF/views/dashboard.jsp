<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>Web App</title>
  <!-- Bootstrap core CSS-->
  <link href="<spring:url value='resources/vendor/bootstrap/css/bootstrap.min.css'/>" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="<spring:url value='resources/vendor/font-awesome/css/font-awesome.min.css'/>" rel="stylesheet" type="text/css">
  <!-- Page level plugin CSS-->
  <link href="<spring:url value='resources/vendor/datatables/dataTables.bootstrap4.css'/>" rel="stylesheet">
  <!-- Custom styles for this template-->
  <link href="<spring:url value='resources/css/sb-admin.css'/>" rel="stylesheet">
  <link href="<spring:url value='resources/css/new-age.min.css'/>" rel="stylesheet">
 
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
  <!-- Navigation-->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
    <a class="navbar-brand" href="index">Web App</a>
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarResponsive">
      <ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Dashboard">
          <a class="nav-link" href="index">
            <i class="fa fa-fw fa-dashboard"></i>
            <span class="nav-link-text">Dashboard</span>
          </a>
        </li>
  
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Link">
          <a class="nav-link" href="https://cordatech.co">
            <i class="fa fa-fw fa-link"></i>
            <span class="nav-link-text">BJBraz</span>
          </a>
        </li>
      </ul>
      <ul class="navbar-nav sidenav-toggler">
        <li class="nav-item">
          <a class="nav-link text-center" id="sidenavToggler">
            <i class="fa fa-fw fa-angle-left"></i>
          </a>
        </li>
      </ul>
      <ul class="navbar-nav ml-auto">
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle mr-lg-2" id="messagesDropdown" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fa fa-fw fa-envelope"></i>
            <span class="d-lg-none">Messages
              <span class="badge badge-pill badge-primary">12 New</span>
            </span>
            <span class="indicator text-primary d-none d-lg-block">
              <i class="fa fa-fw fa-circle"></i>
            </span>
          </a>
          <div class="dropdown-menu" aria-labelledby="messagesDropdown">
            <h6 class="dropdown-header">New Messages:</h6>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">
              <strong>David Miller</strong>
              <span class="small float-right text-muted">11:21 AM</span>
              <div class="dropdown-message small">Hey there! This new version of SB Admin is pretty awesome! These messages clip off when they reach the end of the box so they don't overflow over to the sides!</div>
            </a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">
              <strong>Jane Smith</strong>
              <span class="small float-right text-muted">11:21 AM</span>
              <div class="dropdown-message small">I was wondering if you could meet for an appointment at 3:00 instead of 4:00. Thanks!</div>
            </a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">
              <strong>John Doe</strong>
              <span class="small float-right text-muted">11:21 AM</span>
              <div class="dropdown-message small">I've sent the final files over to you for review. When you're able to sign off of them let me know and we can discuss distribution.</div>
            </a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item small" href="#">View all messages</a>
          </div>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle mr-lg-2" id="alertsDropdown" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fa fa-fw fa-bell"></i>
            <span class="d-lg-none">Alerts
              <span class="badge badge-pill badge-warning">6 New</span>
            </span>
            <span class="indicator text-warning d-none d-lg-block">
              <i class="fa fa-fw fa-circle"></i>
            </span>
          </a>
          <div class="dropdown-menu" aria-labelledby="alertsDropdown">
            <h6 class="dropdown-header">New Alerts:</h6>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">
              <span class="text-success">
                <strong>
                  <i class="fa fa-long-arrow-up fa-fw"></i>Status Update</strong>
              </span>
              <span class="small float-right text-muted">11:21 AM</span>
              <div class="dropdown-message small">This is an automated server response message. All systems are online.</div>
            </a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">
              <span class="text-danger">
                <strong>
                  <i class="fa fa-long-arrow-down fa-fw"></i>Status Update</strong>
              </span>
              <span class="small float-right text-muted">11:21 AM</span>
              <div class="dropdown-message small">This is an automated server response message. All systems are online.</div>
            </a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">
              <span class="text-success">
                <strong>
                  <i class="fa fa-long-arrow-up fa-fw"></i>Status Update</strong>
              </span>
              <span class="small float-right text-muted">11:21 AM</span>
              <div class="dropdown-message small">This is an automated server response message. All systems are online.</div>
            </a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item small" href="#">View all alerts</a>
          </div>
        </li>
        <li class="nav-item">
          <form class="form-inline my-2 my-lg-0 mr-lg-2">
            <div class="input-group">
              <input class="form-control" type="text" placeholder="Search for...">
              <span class="input-group-append">
                <button class="btn btn-primary" type="button">
                  <i class="fa fa-search"></i>
                </button>
              </span>
            </div>
          </form>
        </li>
        <li class="nav-item">
          <a class="nav-link" data-toggle="modal" data-target="#exampleModal">
            <i class="fa fa-fw fa-sign-out"></i>Logout</a>
        </li>
      </ul>
    </div>
  </nav>
  <div class="content-wrapper">
    <div class="container-fluid">
      <!-- Breadcrumbs-->
      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="#">Dashboard</a>
        </li>
        <li class="breadcrumb-item active">My Dashboard</li>
      </ol>
      <!-- Icon Cards-->
      <div class="row">
        <div class="col-xl-3 col-sm-6 mb-3">
          <div class="card text-white bg-primary o-hidden h-100">
            <div class="card-body">
              <div class="card-body-icon">
                <i class="fa fa-fw fa-comments"></i>
              </div>
              <div class="mr-5">26 New Messages!</div>
            </div>
            <a class="card-footer text-white clearfix small z-1" href="#">
              <span class="float-left">View Details</span>
              <span class="float-right">
                <i class="fa fa-angle-right"></i>
              </span>
            </a>
          </div>
        </div>
        <div class="col-xl-3 col-sm-6 mb-3">
          <div class="card text-white bg-warning o-hidden h-100">
            <div class="card-body">
              <div class="card-body-icon">
                <i class="fa fa-fw fa-list"></i>
              </div>
              <div class="mr-5">11 New Tasks!</div>
            </div>
            <a class="card-footer text-white clearfix small z-1" href="#">
              <span class="float-left">View Details</span>
              <span class="float-right">
                <i class="fa fa-angle-right"></i>
              </span>
            </a>
          </div>
        </div>
        <div class="col-xl-3 col-sm-6 mb-3">
          <div class="card text-white bg-success o-hidden h-100">
            <div class="card-body">
              <div class="card-body-icon">
                <i class="fa fa-fw fa-shopping-cart"></i>
              </div>
              <div class="mr-5">123 New Orders!</div>
            </div>
            <a class="card-footer text-white clearfix small z-1" href="#">
              <span class="float-left">View Details</span>
              <span class="float-right">
                <i class="fa fa-angle-right"></i>
              </span>
            </a>
          </div>
        </div>
        <div class="col-xl-3 col-sm-6 mb-3">
          <div class="card text-white bg-danger o-hidden h-100">
            <div class="card-body">
              <div class="card-body-icon">
                <i class="fa fa-fw fa-support"></i>
              </div>
              <div class="mr-5">13 New Tickets!</div>
            </div>
            <a class="card-footer text-white clearfix small z-1" href="#">
              <span class="float-left">View Details</span>
              <span class="float-right">
                <i class="fa fa-angle-right"></i>
              </span>
            </a>
          </div>
        </div>
      </div>
      <!-- Area Chart Example-->
      <div class="card mb-3">
        <div class="card-header">
          <i class="fa fa-area-chart"></i> Area Chart Example</div>
        <div class="card-body">
          <canvas id="myAreaChart" width="100%" height="30"></canvas>
        </div>
        <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
      </div>
      <div class="row">
        <div class="container-fluid">
          
          <div class="card mb-3">
	        <div class="card-header">
	          <i class="fa fa-university"></i> Efetuar Saque </div>
	        <div class="card-body">
          		 <label>Cliente</label>
	          	 <select name="dataTable_length" id="client_id" aria-controls="dataTable" class="form-control form-control-sm">
	          	 	<option value="0">Selecione o Cliente</option>
		          	 <option value="1">Cliente 1</option>
		          	 <option value="2">Cliente 2</option>
		          	 <option value="3">Cliente 3</option>
		          	 <option value="4">Cliente 4</option>
		          	 <option value="5">Cliente 5</option>
	          	 </select>
          	 	 <label> Valor </label>
          		<input type="text" id="valor" class="form-control form-control-sm" placeholder="R$ 0.00" onkeypress='return event.charCode >= 48 && event.charCode <= 57' aria-controls="dataTable">
          		<div class="col-md-12 text-center mt-3">
					<button type="button" id="sacar" class="btn btn-info col-md-2 center-block">Sacar <i class="fa fa-money"></i></button>
				</div>
          		
          </div>
          <!-- /Card Columns-->
        </div>
         
      </div>
      <!-- Example DataTables Card-->
      <div class="card mb-3">
        <div class="card-header">
          <i class="fa fa-table"></i> Transa&ccedil;&otilde;es </div>
        <div class="card-body">
          <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
              <thead>
                <tr>
                  <th>Conta</th>
                  <th>Valor</th>
                  <th>Data</th>
                  <th>Notas de 100</th>
                  <th>Notas de 50</th>
                  <th>Notas de 20</th>
                  <th>Notas de 10</th>
                </tr>
              </thead>
              <tfoot>
                <tr>
                  <th>Conta</th>
                  <th>Valor</th>
                  <th>Data</th>
                  <th>Notas de 100</th>
                  <th>Notas de 50</th>
                  <th>Notas de 20</th>
                  <th>Notas de 10</th>
                </tr>
              </tfoot>
              <tbody>
                
              </tbody>
            </table>
          </div>
        </div>
        <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
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
    <a class="scroll-to-top rounded" href="#page-top">
      <i class="fa fa-angle-up"></i>
    </a>
    <!-- Logout Modal-->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">x</span>
            </button>
          </div>
          <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
          <div class="modal-footer">
            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
            <a class="btn btn-primary" href="logout">Logout</a>
          </div>
        </div>
      </div>
    </div>
    
    <!-- Confirmation Modal-->
    <div class="modal fade" id="TransactionModal" tabindex="-1" role="dialog" aria-labelledby="confirmTransacaoModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Transacao Efetuada</h5>
            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">x</span>
            </button>
          </div>
          <div class="modal-body">Transa��o Efetuada com sucesso.</div>
          <div class="modal-footer">
            <button class="btn btn-primary" type="button" data-dismiss="modal">Ok</button>
          </div>
        </div>
      </div>
    </div>
    
    <!-- Bootstrap core JavaScript-->
    <script src="<spring:url value='resources/vendor/jquery/jquery.min.js'/>"></script>
    <script src="<spring:url value='resources/vendor/bootstrap/js/bootstrap.bundle.min.js'/>"></script>
    <!-- Core plugin JavaScript-->
    <script src="<spring:url value='resources/vendor/jquery-easing/jquery.easing.min.js'/>"></script>
    <!-- Page level plugin JavaScript-->
    <script src="<spring:url value='resources/vendor/chart.js/Chart.min.js'/>"></script>
    <script src="<spring:url value='resources/vendor/datatables/jquery.dataTables.js'/>"></script>
    <script src="<spring:url value='resources/vendor/datatables/dataTables.bootstrap4.js'/>"></script>
    <!-- Custom scripts for all pages-->
    <script src="<spring:url value='resources/js/sb-admin.min.js'/>"></script>
    <!-- Custom scripts for this page-->
    <script src="<spring:url value='resources/js/sb-admin-datatables.min.js'/>"></script>
    <script src="<spring:url value='resources/js/sb-admin-charts.min.js'/>"></script>
  </div>
 <script>
  
  $( "#sacar" ).on( "click", function( event ) {
	  
	var valorSolicitado = $("#valor").val();
	var valorSaldo = 0;
	
	if(valorSolicitado >= 10){
		
			 var valor = $("#client_id" ).val();
		
	   		 $.ajax({
	    	  url: "/rest/eth/saldo/"+valor,
	    	  type: 'GET',
	    	  success: function( result ) {
	    		  console.log(result);
	    		  $("#client_id option:selected").text('Cliente ' + valor + ' Saldo: ' + result);
	    		  if(parseInt(valorSolicitado) > parseInt(result)){
	  	   			alert('Saldo insuficiente : ' + result + ' Valor Solicitado : ' + valorSolicitado );
	  	   			return;
	  	   		}else{
	  	   			
	  	   			
			  	   	var transacao = {
			  		            id: $("#id-name").val(),
			  		            origem:$("#client_id").val(),
			  		            valor:valorSolicitado
			  		}
			  		  
			  		console.log(transacao);
			  		console.log(JSON.stringify(transacao));
			  	    
			  	    $.ajax({
			  	    	  url: "/rest/eth/saque",
			  	    	  type: 'post',
			  	    	  data: JSON.stringify(transacao),
			  	          contentType: "application/json; charset=utf-8",
			  	    	  success: function( result ) {
			  	    	    $('#TransactionModal').modal('show');
			  	    	    $("#valor").val('');
			  	    	    
			  	    	    
			  	    	   	 $.ajax({
			  			    	  url: "/rest/eth/saldo/"+$("#client_id" ).val(),
			  			    	  type: 'GET',
			  			    	  success: function( result ) {
			  			    		  console(result);
			  			    		  $("#client_id option:selected").text('Cliente ' + valor + ' Saldo: ' + result);
			  			    	  }
			  			    });
			  	    	   	 
			  	    	   	listarTransacoes();
			  	    	    
		
			  	    	  }
			  	    	});
	  	    
	  	   			
	  	   		}//end if
	    	  }
	    	});
	   		 
	   		
	   		 
	}else{
		alert('Valor inv�lido : ' + valorSolicitado);
		return;
	}
	
	  

  });//end
  
  function listarTransacoes(){
	  
	  
	  
	    $.ajax({
	    	  url: "/rest/listTodasTrancoes",
	    	  type: 'GET',
	    	  success: function( result ) {
	    	    	console.log(result);
	    	    	$("#dataTable > tbody").children().remove();
	    	    	
	    	    	for (let i = 0; i < result.itens.length; i++) {
	    	    		var classe = 'even';
	    	    		
	    	    		if(i%2==0){
	    	    			classe = 'odd';
	    	    		}else{
	    	    			classe = 'even';
	    	    		}
	    	    		
	    	    	    $('#dataTable').append('<tr role="row" class="'+classe+'" ><td class="sorting_1">'+result.itens[i].origem+'</td><td>'+result.itens[i].valor+'</td><td>'+result.itens[i].dataTransacao+'</td><td>'+result.itens[i].qtdNotasCem+'</td><td>'+result.itens[i].qtdNotasCinquenta+'</td><td>'+result.itens[i].qtdNotasVinte+'</td><td>'+result.itens[i].qtdNotasDez+'</td></tr>');
	    	    	}

	    	  }
	    	});	  
	  
}
  
    
  $("#client_id" ).change(function() {
	  var valor = $("#client_id" ).val();
	  
	  if(valor > 0){
		   		 $.ajax({
		    	  url: "/rest/eth/saldo/"+valor,
		    	  type: 'GET',
		    	  success: function( result ) {
		    		  $("#client_id option:selected").text('Cliente ' + valor + ' Saldo: ' + result);
		    	  }
		    	});
	  }
  });//end
  
  listarTransacoes();
  
  </script>
</body>

</html>
