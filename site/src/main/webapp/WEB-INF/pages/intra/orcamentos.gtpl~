<% include '/WEB-INF/includes/header_intra.gtpl?title=Normando Transportes - Intranet - Orçamentos' %>

<!-- MAIN CONTENT AREA -->
<div class="row show-grid">
    <div class="span12" data-original-title="">
    <!-- BREADCRUMBS -->                    
        <div id="breadcrumb">
        <ul>
            <li class="home"><a href="#">intranet</a></li>
            <li>orcamentos</li>
        </ul>
        </div>
        <div class="clear_both"></div>

        <h2>${request.orcamentos.size()} Orcamentos</h2>
        <table class="table table-bordered table-striped footable" data-filter="#filter">
	        <thead>
		        <th data-sort-ignore="true" data-class="expand" >#</th>	       
		        <th>Nome</th>
		        <th data-hide="phone,tablet">Empresa</th>
		        <th data-hide="all">Email</th>
		        <th data-hide="all">Tel</th>
		        <th>Mercadoria</th>
		        <th data-hide="all">selectMercadoria</th>
		        <th>Origem</th>
		        <th>Destino</th>
		        <th data-hide="all">Carga</th>
		        <th data-hide="all">Descarga</th>
		        <th data-type="numeric">Peso</th>
		        <th data-hide="phone,tablet" data-type="numeric">Valor</th>
		        <th data-hide="all">Info</th>
	        </thead>	
        <%request.orcamentos.eachWithIndex { o, i -> %>
	        <tr>
		        <td data-class="expand">${i+1}</td>	      
		        <td>$o.nome</td>
		        <td>$o.empresa</td>
		        <td>$o.email</td>
		        <td>$o.tel</td>
		        <td>$o.mercadoria</td>
		        <td>$o.selectMercadoria</td>
		        <td>$o.origem</td>
		        <td>$o.destino</td>
		        <td>$o.carga</td>
		        <td>$o.descarga</td>
		        <td>$o.peso</td>
		        <td>$o.valor</td>
		        <td>$o.info</td>
	        </tr>
        <%}%>
        </table>
	 </div>
</div>

<% include '/WEB-INF/includes/footer_intra.gtpl' %>
