import com.google.appengine.api.datastore.*
import static com.google.appengine.api.datastore.FetchOptions.Builder.*

if (user == null) {
	request.continueTo = request.requestURL+"?"+request.queryString
	forward "/intranet/login"
} 
/*
request.orcamentos = datastore.execute {
	"select all from 'orcamento'"
}
*/
 
// query the scripts stored in the datastore
// "savedscript" corresponds to the entity table containing the scripts' text
def query = new Query("orcamento")
 
// sort results by descending order of the creation date
// filters the entities so as to return only scripts by a certain author
if (params) {
	params.each() { k,v ->
		query.addFilter(k, Query.FilterOperator.EQUAL, v)
		println "$k $v"	
	}
}
PreparedQuery preparedQuery = datastore.prepare(query)
 
// return only the first 10 results
request.orcamentos = preparedQuery.asList( withLimit(10) )
request.filter = params
forward "/WEB-INF/pages/intra/orcamentos.gtpl"


/*

<%request.orcamentos.eachWithIndex { o, i -> %>
	<tr>
	<%o.getProperties().sort().each { k,v -> %>
	<%if (i==0) {%> <td>\$o.${k}</td><%} else {%><td>#$i ${k}=${v}</td><%}%>
	<%}%>
	</tr>
<%}%>

*/
