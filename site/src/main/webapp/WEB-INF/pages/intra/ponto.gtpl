<% include '/WEB-INF/includes/header_intra.gtpl' %>
<!-- ?title=Normando Transportes - Intranet - Sistema de Controle de Ponto -->

<!-- MAIN CONTENT AREA -->
                        
<% if (request.getAttribute('status') == "OK") { %>
<div class="alert alert-success">
	<button data-dismiss="alert" class="close" type="button">×</button>
	<h2>Mensagem Enviada com Sucesso</h2>
	<p>Obrigado por entrar em contato com a Normando Transporte. Daremos retorno em até dois dias úteis.</p>
</div>
<%} else if (request.getAttribute('status') == "ERRO") {%>
<div class="alert alert-error">
	<button data-dismiss="alert" class="close" type="button">×</button>
	<h2>Preencha todos os campos</h2>
	<p>Para que sua mensagem seja enviada, por favor prencha todas as informações solicitadas.</p>
</div>
<% } %>

<div class="row show-grid">
    <div class="span12" data-original-title="">
<!-- BREADCRUMBS -->                    
        <div id="breadcrumb">
        <ul>
            <li class="home"><a href="#">intranet</a></li>
            <li>ponto</li>
        </ul>
        </div>
        <div class="clear_both"></div>

				<div class="span8">	
				<form class="form-horizontal" method="POST" action="/intranet/ponto">
					<fieldset>
						<!-- Form Name -->
						<legend>Relógio de Ponto - <span id="data"></span> - $user.nickname</legend>
						<canvas id="clock"></canvas>  <!-- The time gets inserted here -->
						<input type="hidden" name="op" id="hiddenOp" value="registrar"/>
						<input type="hidden" name="email" id="hiddenEmail" value="${user.nickname}"/>
						<input type="hidden" name="data" id="hiddenData"/>
						<input type="hidden" name="hora" id="hiddenHora"/>
						<!-- Select Multiple -->
						<div class="control-group">
						  <br/>
							<div class="controls">
								<%
								def disabled(t,i) {
									(t!=null && t["t$i"].trim() != "") ? "disabled" : ""
								}
								def color(t,i) {
									(t!=null && t["t$i"].trim() != "") ? "dark-gray" : "black"
								}								
								def show(t,i) {
									(t!=null && t["t$i"].trim() != "") ? t["t$i"].trim() : ""
								}
								pDia = request.pontoDoDia
								%>
								<table class="table">
								<tr><td><input type="radio" style="font-size: 20px" name="turno" value="1" ${disabled(pDia,1)} ${pDia==null ? 'checked':''}/></td><td><label style="font-size: 16px; color: ${color(pDia,1)};">TURNO 1 - ENTRADA</label></td><td><label style="font-size: 16px; color: ${color(pDia,1)};">${show(pDia,1)}</label></td></tr>
                <tr><td><input type="radio" style="font-size: 20px" name="turno" value="2" ${disabled(pDia,2)} ${pDia?.turno=='1' ? 'checked':''}/></ td><td><label style="font-size: 16px; color: ${color(pDia,2)};">TURNO 1 - SAÍDA</label></td><td><label style="font-size: 16px; color: ${color(pDia,2)};">${show(pDia,2)}</label></td></tr>								
                <tr><td><input type="radio" style="font-size: 20px" name="turno" value="3" ${disabled(pDia,3)} ${pDia?.turno=='2' ? 'checked':''}/></td><td><label style="font-size: 16px; color: ${color(pDia,3)};">TURNO 2 - ENTRADA</label></td><td><label style="font-size: 16px; color: ${color(pDia,3)};">${show(pDia,3)}</label></td></tr>								
                <tr><td><input type="radio" style="font-size: 20px" name="turno" value="4" ${disabled(pDia,4)} ${pDia?.turno=='3' ? 'checked':''}/></td><td><label style="font-size: 16px; color: ${color(pDia,4)};">TURNO 2 - SAÍDA</label></td><td><label style="font-size: 16px; color: ${color(pDia,4)};">${show(pDia,4)}</label></td></tr>       
								 </table>
                <div class="control-group form-button-offset">
                    <input type="submit" class="btn btn-warning" value="Registrar Horário" />
                </div>
							</div>
						</div>
					</fieldset>
				</form>
				<%if(request.mesAno){%>
				<div class="row">
					<div class="span8">
            <select id="selectMes">
              <option value="">---</option>      
					  <%
					  if (request.meses) { 
					  %>
      
              <%
					    request.meses.each { mes ->
	  				  %>
              <option value="mes">$mes</option>
              <%
              }  
						}
						%>					  
            </select>
            <div id="divTablePonto">
              <a href="/intranet/ponto?mes=08">PONTO DO MES DE AGOSTO ${request.meses}</a>
				        <table class="table table-bordered table-striped footable">
						    <thead>
						      <tr><th colspan="5" class="text-center">${request.mesAno}</th></tr>
							    <tr><th rowspan="2" class="text-center" style="vertical-align:middle;">DIA</th><th colspan="2" class="text-center">TURNO 1</th><th colspan="2" class="text-center">TURNO 2</th></tr>
							    <tr><th>ENTRADA</th><th>SAIDA</th><th>ENTRADA</th><th>SAIDA</th></tr>							
						    </thead>							
						    <tbody>
						    <%
						    pMes = request.pontoDoMes
						    pMes.each { p ->
						    %>
						    <tr><td>${(p.data as String)[0..1]}</td><td>${p?.t1}</td><td>${p?.t2}</td><td>${p?.t3}</td><td>${p?.t4}</td></tr>					
						    <%
						    }
						    %>
						    </tbody>						  
						  </table>
						</div>
				</div>
				<%}%>				
			</div>
	 </div>
</div>
			
<script>
window.onload = displayTime;  // Start displaying the time when document loads.

(jQuery)('#selectMes').change(function() {
  var mes =(jQuery)(':selected').text(); 
  alert(mes);
  if (mes=="---") {
    (jQuery)("#divTablePonto").hide();
  } else {  
//    alert('show');
    (jQuery)("#divTablePonto").show();
  }
});

function httpGet(theUrl)
{
    var xmlHttp = null;

    xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "GET", theUrl, false );
    xmlHttp.send( null );
    return xmlHttp.responseText;
}

// Define a function to display the current time
function displayTime() {
	var day = httpGet('/intranet/clock?t=data');
	(jQuery)("#data").text(day);
	(jQuery)("#hiddenData").val(day);		
	var now = httpGet('/intranet/clock?t=hora');
	(jQuery)("#hiddenHora").val(now);
	//Get the Context 2D or 3D
	var canvas = document.getElementById('clock');
  if (canvas.getContext) {
  	var context = canvas.getContext("2d");
	  context.clearRect(0, 0, 500, 200);
	  context.font = "60px Arial";
	  context.fillStyle = "black";
	  context.fillText(now, 35, 90);
	  setTimeout(displayTime, 1000);               // Run again in 1 second
	}
}

function changeMonth() { 
  alert(document.selectMes.options[document.selectMes.selectedIndex].value); 
//  document.testStar.src = imageArray[Index]; 
//  document.testStar.alt = altArray[Index];	 
}
</script>


<% include '/WEB-INF/includes/footer_intra.gtpl' %>
