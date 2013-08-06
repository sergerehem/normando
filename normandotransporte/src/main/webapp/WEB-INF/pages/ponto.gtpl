<% include '/WEB-INF/includes/header.gtpl' %>

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
            <li class="home"><a href="#">home</a></li>
            <li>contato</li>
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
							<div class="controls">
								<%
								def disabled(t,i) {
									(t!=null && t["t$i"].trim() != "") ? "disabled" : ""
								}
								def show(t,i) {
									(t!=null && t["t$i"].trim() != "") ? t["t$i"].trim() : ""
								}
								pDia = request.pontoDoDia
								%>
								<input type="radio" name="turno" value="1" ${disabled(pDia,1)} ${pDia==null ? 'checked':''}>1. Manhã - Entrada ${show(pDia,1)}</option><br/>
								<input type="radio" name="turno" value="2" ${disabled(pDia,2)} ${pDia?.turno=='1' ? 'checked':''}>2. Manhã - Saída ${show(pDia,2)}</option><br/>
								<input type="radio" name="turno" value="3" ${disabled(pDia,3)} ${pDia?.turno=='2' ? 'checked':''}>3. Tarde - Entrada ${show(pDia,3)}</option><br/>
								<input type="radio" name="turno" value="4" ${disabled(pDia,4)} ${pDia?.turno=='3' ? 'checked':''}>4. Tarde - Saída ${show(pDia,4)}</option>
							</div>
	              <div class="control-group form-button-offset">
	                  <input type="submit" class="btn btn-warning" value="Registrar Horário" />
	              </div>
						</div>
					</fieldset>
				</form>
				<div class="row">
					<div class="span8">
						<table border="1">
							<tr><td>DATA</td><td>ENT</td><td>SAI</td><td>ENT</td><td>SAI</td></tr>
						<%
						pMes = request.pontoDoMes
						pMes.each { p ->
						%>
							<tr><td>$p.data</td><td>${p?.t1}</td><td>${p?.t2}</td><td>${p?.t3}</td><td>${p?.t4}</td></tr>					
						<%
						}
						%>
						</table>
				</div>
			</div>
			</div>
	 </div>
</div>
			
<script>
window.onload = displayTime;  // Start displaying the time when document loads.

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
	/*
		(jQuery).get('/intranet/clock', function(dateTime) {
			var now = dateTime;
		});
	*/
	var day = httpGet('/intranet/clock?t=data');
	(jQuery)("#data").text(day);
	(jQuery)("#hiddenData").val(day);		
	var now = httpGet('/intranet/clock?t=hora');
	(jQuery)("#hiddenHora").val(now);
	//Get the Context 2D or 3D
	var context = clock.getContext("2d");
	context.clearRect(0, 0, 500, 200);
	context.font = "60px Arial";
	context.fillStyle = "black";
	context.fillText(now, 35, 90);
	setTimeout(displayTime, 1000);               // Run again in 1 second
}
</script>


<% include '/WEB-INF/includes/footer.gtpl' %>
