import com.google.appengine.api.datastore.*

if (user == null) {
	redirect "/intranet/login"
} else {
	if (!params) {
		println "kn=@keyname&kv=@keyvalue&e=@entidade&c=@chave&v=@valor"
	} else {
		if (!params.kn) {
println "serge"
			def e = new Entity(params.e)
			e[params.c] = params.v
			e.save()	
			println "entidade $params.e salva com campo $params.c = $params.v"
		} else {
			e = datastore.execute {
				select single from params.e
				where params.kn == params.kv
			}
			e[params.c] = params.v
			e.save()
			println "entidade $params.e salva com campo $params.c = $params.v onde $params.kn = $params.kv"
		}
	}
}	
