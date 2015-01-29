<% include '/WEB-INF/includes/header.gtpl?title=Normando Transportes - Solicite orçamento informando mercadoria, origem, destino e volume' %>

<!-- MAIN CONTENT AREA -->
                        
<% if (request.getAttribute('status') == "OK") { %>
<div class="alert alert-success">
	<button data-dismiss="alert" class="close" type="button">×</button>
	<h2>Orçamento Solicitado com Sucesso</h2>
	<p>Obrigado por solicitar seu orçamento com a Normando Transporte. Daremos retorno até o próximo dia útil.</p>
</div>
<%} else if (request.getAttribute('status') == "ERRO") {%>
<div class="alert alert-error">
	<button data-dismiss="alert" class="close" type="button">×</button>
	<h2>Preencha todos os campos</h2>
	<p>Para que seu pedido de orçamento seja enviado, por favor prencha todas as informações solicitadas.</p>
</div>
<% } %>

<div class="row show-grid">
    <div class="span12" data-original-title="">
<!-- BREADCRUMBS -->                    
        <div id="breadcrumb">
        <ul>
            <li class="home"><a href="#">home</a></li>
            <li>orçamento</li>
        </ul>
        </div>
        <div class="clear_both"></div>
        <div class="row show-grid">      
				  <div class="span10 offset1">	
	          <form name="orcamentoForm" id="validForm" method="POST" action="/orcamento">
	              <br/>
                <h3>Informações da Empresa</h3>
	              <div class="text-divider1"></div>
	              <div class="control-group">
	                  <label class="control-label" for="inputEmpresa">Empresa<sup>*</sup></label>
	                  <div class="controls">
	                      <input name="empresa" type="text" class="span4" id="inputEmpresa" placeholder="Informe o nome da empresa" required>
	                  </div>
	              </div>	        
	              <div class="control-group">
	                  <label class="control-label" for="inputName">Nome<sup>*</sup></label>
	                  <div class="controls">
	                      <input name="nome" type="text" class="span4" id="inputName" placeholder="Nome da pessoa de contato" required>
	                  </div>
	              </div>
	              <div class="row">
	                <div class="control-group span5">
                    <label class="control-label" for="inputEmail">Email<sup>*</sup></label>
                    <div class="controls">
                        <input name="email" type="email" class="span4" id="inputEmail" placeholder="Endereço de email" required>
                    </div>
                  </div>                    
                  <div class="control-group span5">
                      <label class="control-label" for="inputEmail">Telefone</label>
                      <div class="controls">
                          <input name="tel" type="text" class="span4" id="inputTel" placeholder="Telefone de contato">
                      </div>
	                </div>
	              </div>
                <h3>Informações da Mercadoria</h3>
	              <div class="text-divider1"></div>
                <div class="row">                               
	                <div class="control-group span5">
  	                <label class="control-label" for="selectMercadoria">Mercadoria<sup>*</sup></label>
                    <select name="selectMercadoria" id="selectMercadoria">
                      <option value="Piso/Revestimento">Piso/Revestimento</option>
                      <option value="Argamassa">Argamassa</option>
                      <option value="Impermeabilizante">Impermeabilizante</option>
                      <option value="Outra">Outra</option>                                            
                    </select>	                    
	                </div>
	                <div class="control-group span5" id="divOutraMercadoria">
	                    <label class="control-label" for="inputMercadoria">Outra mercadoria<sup>*</sup></label>
	                    <div class="controls">
	                        <input name="mercadoria" type="text" class="span4" id="inputMercadoria" placeholder="Informe a mercadoria a ser transportada">
	                    </div>
	                </div>	                
	              </div>
                <div class="row">                               
	                <div class="control-group span5">
	                    <label class="control-label" for="inputOrigem">Origem<sup>*</sup></label>
	                    <div class="controls">
	                        <input name="origem" type="text" class="span4" id="inputOrigem" placeholder="Local de retirada" required>
	                    </div>
	                </div>	            
	                <div class="control-group span5">
	                    <label class="control-label" for="inputOrigem">Destino<sup>*</sup></label>
	                    <div class="controls">
	                        <input name="destino" type="text" class="span4" id="inputDestino" placeholder="Local de entrega" required>
	                    </div>
	                </div>	            
	              </div>
                <div class="row">       	              
	                <div class="control-group span5">
	                    <label class="control-label" for="inputOrigem">Peso Bruto (Ton)<sup>*</sup></label>
	                    <div class="controls">
	                        <input name="peso" type="text" class="span4" id="inputPeso" placeholder="Peso da mercadoria em toneladas" required>
	                    </div>
	                </div>	      
	                <div class="control-group span5">
	                    <label class="control-label" for="inputOrigem">Valor Total (R\$)<sup>*</sup></label>
	                    <div class="controls">
	                        <input name="valor" type="text" class="span4" id="inputValor" placeholder="Valor Fiscal da Nota" required>
	                    </div>
	                </div>	      
                </div>
                <div class="row">                   
	                <div class="control-group span5">
	                    <label class="control-label" for="inputOrigem">Carga<sup>*</sup></label>
	                    <div class="controls">
	                        <select name="carga" id="selectCarga">
                            <option value="Por Conta do Cliente">Por conta do Cliente</option>
                            <option value="Por Conta da Transportadora">Por conta da Transportadora</option>
                          </select>
	                    </div>
	                </div>	      	            	
	                <div class="control-group span5">
	                    <label class="control-label" for="inputOrigem">Descarga<sup>*</sup></label>
	                    <div class="controls">
	                        <select name="descarga" id="selectDescarga">
                            <option value="Por Conta do Cliente">Por conta do Cliente</option>
                            <option value="Por Conta da Transportadora">Por conta da Transportadora</option>
                          </select>
	                    </div>
	                </div>	      	            	
	              </div>
                <h3>Informações Adicionais</h3>
	              <div class="text-divider1"></div>
	              <br/>                     	            
	              <div class="control-group">
	                  <div class="controls">
	                      <textarea name="info" rows="4" class="span8" id="info" placeholder="Observações e esclarecimentos adicionais"></textarea>
	                  </div>
	              </div>
					<div class="control-group">
						<label class="control-label" for="copia"></label>
						<div class="controls">
							<label class="checkbox" for="checkCopia">
								<input type="checkbox" name="copia" id="checkCopia" value="S" checked>
								Desejo receber uma cópia desta solicitação em meu e-mail
							</label>
						</div>
					</div>
	              <div class="control-group form-button-offset">
	                  <input type="submit" class="btn btn-warning" value="Solicitar orçamento" />
	              </div>
	          </form>
				  </div>
	   </div>
  </div>
</div>

<script type="text/javascript">
	(jQuery)(document).ready(function(){ 

    hideShowOutraMercadoria();

    (jQuery)("#selectMercadoria").change(function() {
	    hideShowOutraMercadoria();
    });

    (jQuery)("#inputTel").mask("(99) 9999?9-9999");
    (jQuery)("#inputTel").on("blur", function() {
        var last = (jQuery)(this).val().substr( (jQuery)(this).val().indexOf("-") + 1 );
        
        if( last.length == 3 ) {
            var move = (jQuery)(this).val().substr( (jQuery)(this).val().indexOf("-") - 1, 1 );
            var lastfour = move + last;
            
            var first = (jQuery)(this).val().substr( 0, 9 );
            
            (jQuery)(this).val( first + '-' + lastfour );
        }
    });

    (jQuery)("#inputPeso").maskMoney({thousands:'.', precision: 0});
    (jQuery)("#inputValor").maskMoney({symbol:'R\$ ', thousands:'.', decimal:',', symbolStay: true});

    (jQuery)('#inputEmpresa').keyup(function() {
        (jQuery)(this).val((jQuery)(this).val().toUpperCase());
    });
    (jQuery)('#inputNome').keyup(function() {
        (jQuery)(this).val((jQuery)(this).val().toUpperCase());
    });
    (jQuery)('#inputOrigem').keyup(function() {
        (jQuery)(this).val((jQuery)(this).val().toUpperCase());
    });
    (jQuery)('#inputDestino').keyup(function() {
        (jQuery)(this).val((jQuery)(this).val().toUpperCase());
    });
  });    

	function hideShowOutraMercadoria() {
    if ((jQuery)("#selectMercadoria").val() == "Outra") {
      (jQuery)("#divOutraMercadoria").show(); 
			(jQuery)("#inputMercadoria").prop("required", true);
    } else {
      (jQuery)("#divOutraMercadoria").hide(); 
			(jQuery)("#inputMercadoria").prop("required", false);
    }	
	}
</script>

<% include '/WEB-INF/includes/footer.gtpl' %>
