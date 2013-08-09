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
	        <form name="contactForm" id="validForm" method="POST" action="/contato_submit">
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
	                <label class="control-label" for="inputAssunto">Assunto<sup>*</sup></label>
	                <div class="controls">
	                    <input name="assunto" type="text" class="span4" id="inputAssunto" placeholder="Informe o assunto da sua mensagem" required>
	                </div>
	            </div>
	            <div class="control-group">
	                <label for="textarea" class="control-label">Mensagem<sup>*</sup></label>
	                <div class="controls">
	                    <textarea name="mensagem" rows="4" class="span8" id="textarea" required></textarea>
	                </div>
	            </div>
							<div class="control-group">
								<label class="control-label" for="copia"></label>
								<div class="controls">
									<label class="checkbox" for="checkCopia">
										<input type="checkbox" name="copia" id="checkCopia" value="S" checked>
										Desejo receber uma cópia deste contato em meu e-mail
									</label>
								</div>
							</div>
	            <div class="control-group form-button-offset">
	                <input type="submit" class="btn btn-warning" value="Enviar" />
	            </div>
	        </form>
				</div>
	 </div>
</div>

<% include '/WEB-INF/includes/footer.gtpl' %>

