<% include '/WEB-INF/includes/header_intra.gtpl?title=Normando Transportes - Intranet - Motoristas' %>

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
        <li>motoristas</li>
      </ul>
    </div>
    <div class="clear_both"></div>
    <form class="formMotorista" method="post" action="/intranet/motorista">
      <fieldset>				
        <div class="tabbable tabs-left">
        <ul id="tab" class="nav nav-tabs" data-tabs="tabs">
           <li class="active">
               <a href="#tabMotorista" data-toggle="tab">Motorista</a>
           </li>
           <li >
               <a href="#tabCaminhao" data-toggle="tab">Caminhão</a>
           </li>
           <li >
               <a href="#tabRotas" data-toggle="tab">Rotas</a>
           </li>
        </ul>
        <div class="tab-content">
           <div class="tab-pane active" id="tabMotorista" >
              <!-- Form Name -->
              <legend>Motorista</legend>

              <!-- Text input-->
              <div class="control-group">
                <label class="control-label" for="nome">Nome</label>
                <div class="controls">
                  <input id="nome" name="nome" type="text" placeholder="" class="input-xxlarge" required="">
                  
                </div>
              </div>

               <div class="row">
                  <!-- Text input-->
                  <div class="control-group span4">
                    <label class="control-label" for="apelido">Apelido</label>
                    <div class="controls">
                      <input id="apelido" name="apelido" type="text" placeholder="Como prefere ser chamado?" class="input-xlarge">

                    </div>
                  </div>

                  <!-- Text input-->
                  <div class="control-group span3">
                    <label class="control-label" for="dataNascimento">Data de Nascimento</label>
                    <div class="controls">
                      <input id="dataNascimento" name="dataNascimento" type="text" placeholder="" class="input-small">
                    </div>
                  </div>
               </div>

              <!-- Text input-->
              <div class="control-group">
                <label class="control-label" for="endereço">Endereço</label>
                <div class="controls">
                  <input id="endereço" name="endereço" type="text" placeholder="" class="input-xxlarge">
                  
                </div>
              </div>

              <div class="row">
                <div class="control-group span5">
                  <!-- Text input-->
                  <div class="control-group">
                    <label class="control-label" for="cidade">Cidade</label>
                    <div class="controls">
                      <input id="cidade" name="cidade" type="text" placeholder="" class="input-xlarge">

                    </div>
                  </div>
                </div>
              <!-- Select Basic -->
                  <div class="control-group span3">
                    <label class="control-label" for="uf">UF</label>
                    <div class="controls">
                      <select id="uf" name="uf" class="input-mini">
                        <option>BA</option>
                        <option>SE</option>
                      </select>
                    </div>
                  </div>
              </div>



              <!-- Text input-->
              <div class="control-group">
                <label class="control-label" for="telefones">Telefones</label>
                <div class="controls">
                  <input id="telefones" name="telefones" type="text" placeholder="melhorar..." class="input-large"></input>
                    <a href="#" class="btn btn-small" onclick="addItem('mySelect',(jQuery)('#telefones').val(),(jQuery)('#telefones').val());"><i class="icon-plus"></i></a>
                    <a href="#" class="btn btn-small" onclick="removeSelectedItem('mySelect');"><i class="icon-minus"></i></a>
                    <br>
                  <select id="mySelect" size="3">
                  </select>
                  <div id="divTelefones">
                  </div>
                </div>
              </div>
              <div class="form-actions">
                <div class="pull-right">
                    <a href="#" class="btn btn-warning btn-large" onclick="nextTab('#tab')">Avançar <i class="icon icon-chevron-right"></i></a>
                </div>
              </div>              
           </div>
           <div class="tab-pane" id="tabCaminhao" >
              <legend>Caminhão</legend>

              <!-- Multiple Radios (inline) -->
              <div class="control-group">
                <label class="control-label" for="tipoCaminhao">Tipo do Caminhão</label>
                <div class="controls">
                  <label class="radio inline" for="tipoCaminhao-0">
                    <input type="radio" name="tipoCaminhao" id="tipoCaminhao-0" value="Truck" checked="checked">
                    Truck
                  </label>
                  <label class="radio inline" for="tipoCaminhao-1">
                    <input type="radio" name="tipoCaminhao" id="tipoCaminhao-1" value="Bi-truck">
                    Bi-truck
                  </label>
                  <label class="radio inline" for="tipoCaminhao-2">
                    <input type="radio" name="tipoCaminhao" id="tipoCaminhao-2" value="Bi-trem">
                    Bi-trem
                  </label>
                  <label class="radio inline" for="tipoCaminhao-3">
                    <input type="radio" name="tipoCaminhao" id="tipoCaminhao-3" value="Carreta simples">
                    Carreta simples
                  </label>
                  <label class="radio inline" for="tipoCaminhao-4">
                    <input type="radio" name="tipoCaminhao" id="tipoCaminhao-4" value="Carreta LS trucada">
                    Carreta LS trucada
                  </label>
                </div>
              </div>

              <!-- Multiple Radios (inline) -->
              <div class="control-group">
                <label class="control-label" for="proprio">Próprio?</label>
                <div class="controls">
                  <label class="radio inline" for="proprio-0">
                    <input type="radio" name="proprio" id="proprio-0" value="Não" checked="checked">
                    Não
                  </label>
                  <label class="radio inline" for="proprio-1">
                    <input type="radio" name="proprio" id="proprio-1" value="Sim">
                    Sim
                  </label>
                </div>
              </div>

              <!-- Multiple Radios (inline) -->
              <div class="control-group">
                <label class="control-label" for="excesso">Excesso?</label>
                <div class="controls">
                  <label class="radio inline" for="excesso-0">
                    <input type="radio" name="excesso" id="excesso-0" value="Sim" checked="checked">
                    Sim
                  </label>
                  <label class="radio inline" for="excesso-1">
                    <input type="radio" name="excesso" id="excesso-1" value="Não">
                    Não
                  </label>
                </div>
              </div>

              <!-- Text input-->
              <div class="control-group">
                <label class="control-label" for="nomeDonoFrota">Nome/Telefone do Dono da Frota</label>
                <div class="controls">
                  <input id="nomeDonoFrota" name="nomeDonoFrota" type="text" placeholder="" class="input-xxlarge">
                  
                </div>
              </div>

              <!-- Textarea -->
              <div class="control-group">
                <label class="control-label" for="qtdTiposCaminhaoDonoFrota">Quantidade e Tipos de Caminhão</label>
                <div class="controls">                     
                  <textarea id="qtdTiposCaminhaoDonoFrota" name="qtdTiposCaminhaoDonoFrota"></textarea>
                </div>
              </div>

              <div class="form-actions">
                <div class="pull-left">
                  <a href="#" class="btn btn-warning" onclick="prevTab('#tab')"><i class="icon icon-chevron-left"></i> Voltar</a>
                </div>
                <div class="pull-right">
                    <a href="#" class="btn btn-warning btn-large" onclick="nextTab('#tab')">Avançar <i class="icon icon-chevron-right"></i></a>
                </div>
              </div>              
           </div>
           <div class="tab-pane" id="tabRotas" >

              <legend>Rotas</legend>

              <!-- Text input-->
              <div class="control-group">
                <label class="control-label" for="destino">Destinos</label>
                <div class="controls">
                  <input id="destino" name="destino" type="text" placeholder="melhorar..." class="input-xlarge">
                </div>
              </div>

              <!-- Text input-->
              <div class="control-group">
                <label class="control-label" for="telefoneDonoFrota">Telefone do Dono da Frota</label>
                <div class="controls">
                  <input id="telefoneDonoFrota" name="telefoneDonoFrota" type="text" placeholder="" class="input-xlarge">
                  
                </div>
              </div>

              <!-- Multiple Radios (inline) -->
              <div class="control-group">
                <label class="control-label" for="frequenciaRegiao">Quando vem à região</label>
                <div class="controls">
                  <label class="radio inline" for="frequenciaRegiao-0">
                    <input type="radio" name="frequenciaRegiao" id="frequenciaRegiao-0" value="Às vezes" checked="checked">
                    Às vezes
                  </label>
                  <label class="radio inline" for="frequenciaRegiao-1">
                    <input type="radio" name="frequenciaRegiao" id="frequenciaRegiao-1" value="Frequentemente">
                    Frequentemente
                  </label>
                </div>
              </div>

              <!-- Multiple Radios (inline) -->
              <div class="control-group">
                <label class="control-label" for="autorizaSMS">Autoriza Receber SMS?</label>
                <div class="controls">
                  <label class="radio inline" for="autorizaSMS-0">
                    <input type="radio" name="autorizaSMS" id="autorizaSMS-0" value="Sim" checked="checked">
                    Sim
                  </label>
                  <label class="radio inline" for="autorizaSMS-1">
                    <input type="radio" name="autorizaSMS" id="autorizaSMS-1" value="Não">
                    Não
                  </label>
                </div>
              </div>

              <div class="form-actions">
                <div class="pull-left">
                  <button href="#" class="btn btn-warning" onclick="prevTab('#tab')"><i class="icon icon-chevron-left"></i> Voltar</button>
                </div>
                <div class="pull-right">
                  <input type="submit" class="btn btn-warning btn-large" value="Salvar">
                </div>
              </div>
           </div>
        </fieldset>
      </form>             
  </div>
</div>
<script>

(jQuery)("#dataNascimento").mask("99/99/9999");
(jQuery)("#telefones").mask("(99) 9999?9-9999");

function addItem(id, text, value)
{
    var item = "<option value='+value+'>" + text + "</option>";
    (jQuery)('#' + id).append(item);
}
function removeSelectedItem(id)
{
    (jQuery)('#'+id+' :selected').remove();
}

function removeItem(list)
{
  list.remove(list.selectedIndex)
}

function nextTab(elem) {
  (jQuery)(elem + ' li.active')
    .next()
    .find('a[data-toggle="tab"]')
    .click();
}
function prevTab(elem) {
  (jQuery)(elem + ' li.active')
    .prev()
    .find('a[data-toggle="tab"]')
    .click();
}
</script>
<% include '/WEB-INF/includes/footer_intra.gtpl' %>


