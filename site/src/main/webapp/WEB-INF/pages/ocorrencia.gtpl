<% include '/WEB-INF/includes/header.gtpl?title=Normando Transportes - Registre sua ocorrencia' %>

<!-- MAIN CONTENT AREA -->
                        
<% if (request.getAttribute('status') == "OK") { %>
<div class="alert alert-success">
	<button data-dismiss="alert" class="close" type="button">×</button>
	<h2>Ocorrência registrada com sucesso</h2>
	<p>Nosso time está trabalhando para resolver a ocorrência que você acaba de registrar. Daremos retorno o mais rápido possível.</p>
</div>
<%} else if (request.getAttribute('status') == "ERRO") {%>
<div class="alert alert-error">
	<button data-dismiss="alert" class="close" type="button">×</button>
	<h2>Preencha todos os campos</h2>
	<p>Para que sua ocorrência seja registrada, por favor prencha todas as informações solicitadas.</p>
</div>
<% } %>

<div class="row show-grid">
    <div class="span12" data-original-title="">
<!-- BREADCRUMBS -->                    
        <div id="breadcrumb">
        <ul>
            <li class="home"><a href="#">home</a></li>
            <li>ocorrência</li>
        </ul>
        </div>
        <div class="clear_both"></div>

				<div class="span8">	
	        <form name="contactForm" id="validForm" method="POST" action="/ocorrencia">
	            <div class="control-group">
	                <label class="control-label" for="inputName">Nome<sup>*</sup></label>
	                <div class="controls">
	                    <input name="nome" type="text" class="span4" id="inputName" placeholder="Informe seu nome" required>
	                </div>
	            </div>
	            <div class="control-group">
	                <label class="control-label" for="inputEmail">Email<sup>*</sup></label>
	                <div class="controls">
	                    <input name="email" type="email" class="span4" id="inputEmail" placeholder="Endereço de email" required>
	                </div>
	            </div>
	            <div class="control-group">
	                <label class="control-label" for="inputResumo">Resumo<sup>*</sup></label>
	                <div class="controls">
	                    <input name="resumo" type="text" class="span4" id="inputResumo" placeholder="Informe o resumo da sua ocorrência" required>
	                </div>
	            </div>
	            <div class="control-group">
	                <label for="textarea" class="control-label">Ocorrencia<sup>*</sup></label>
	                <div class="controls">
	                    <textarea name="ocorrencia" rows="4" class="span8" id="textarea" placeholder="Descreva em detalhes a sua ocorrência. Falta/avaria de mercadoria,
problemas no descarrego com chapa e ou motorista, elogio, reclamações, etc. Teremos o maior prazer em resolvê-la para você." required></textarea>
	                </div>
	            </div>
				<div class="control-group">
					<label class="control-label" for="copia"></label>
					<div class="controls">
						<label class="checkbox" for="checkCopia">
							<input type="checkbox" name="copia" id="checkCopia" value="S" checked>
							Desejo receber uma cópia desta ocorrencia em meu e-mail
						</label>
					</div>
				</div>	            
	            <div class="control-group form-button-offset">
  	            <div class="pull-right">
	                <input type="submit" class="btn btn-warning" value="Enviar" />
	              </div>
	            </div>
	        </form>
				</div>
	 </div>
</div>

<% include '/WEB-INF/includes/footer.gtpl' %>

