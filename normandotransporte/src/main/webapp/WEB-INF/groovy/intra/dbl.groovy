import com.google.appengine.api.datastore.*

if (user == null) {
	request.continueTo = request.requestURL+"?"+request.queryString
	forward "/intranet/login"
} else {
	if (!params) {
		println "e=@entidade"
	} else {
		e = datastore.execute {
			select all from params.e
		}
		println "<table border='1'>"
		e.each { e ->
			println "<tr>"
			e.getProperties().each { k,v ->
				println "<td>${k}=${v}</td>" 
			}
			println "</tr>"
		}
		println "</table>"
	}
}	
