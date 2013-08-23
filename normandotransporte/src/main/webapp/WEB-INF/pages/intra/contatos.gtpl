<% include '/WEB-INF/includes/header_intra.gtpl?title=Normando Transportes - Intranet - Contatos' %>




<!-- MAIN CONTENT AREA -->
<div class="row show-grid">
    <div class="span12" data-original-title="">
<!-- BREADCRUMBS -->                    
      <div id="breadcrumb">
      <ul>
          <li class="home"><a href="#">intranet</a></li>
          <li>contatos</li>
      </ul>
      </div>
      <div class="clear_both"></div>
    
      <h1>${request.contatos.size()} Contatos</h1>
      
      <form id="custom-search-form" class="form-search form-horizontal pull-right">
          <div class="input-append span12">
              <input id="filter" type="text" class="search-query" placeholder="Search">
              <button type="submit" class="btn"><i class="icon-search"></i></button>
          </div>
      </form>

      <table class="table table-bordered table-striped footable" data-filter="#filter">
	      <thead>
		      <th>#</th>	      
		      <th>Nome</th>
		      <th>Email</th>
		      <th>Assunto</th>
		      <th>Mensagem</th>
	      </thead>	
      <%request.contatos.eachWithIndex { c, i -> %>
	      <tr>
		      <td>$i</td>
		      <td>$c.nome</td>
		      <td>$c.email</td>
		      <td>$c.assunto</td>
		      <td>$c.mensagem</td>
	      </tr>
      <%}%>
      </table>
	 </div>
</div>

<% include '/WEB-INF/includes/footer_intra.gtpl' %>
