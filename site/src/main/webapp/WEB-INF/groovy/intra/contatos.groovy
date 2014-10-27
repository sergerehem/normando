println "cheguei"

import com.google.appengine.api.datastore.*
/*
if (user == null) {
	request.continueTo = request.requestURL+"?"+request.queryString
	forward "/intranet/login"
} 
*/
request.contatos = datastore.execute {
	select all from 'contato'
}

forward "/WEB-INF/pages/intra/contatos.gtpl"

