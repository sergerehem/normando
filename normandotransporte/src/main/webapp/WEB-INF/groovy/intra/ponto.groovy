import com.google.appengine.api.datastore.Entity
import util.Clock


if (user == null) {
	request.continueTo = request.requestURL+"?"+request.queryString
	forward "/intranet/login"
} 

def clock = new Clock()

def pontoId = (params.op == "registrar" ? params.email : user.email)+":"+clock.date
def p = datastore.execute {
	select single from "ponto"
	where id == pontoId
}

if (params.op == "registrar") {
		if (p == null) {println "new"
			p = new Entity("ponto")
			p.id = pontoId
			p.email = params.email
			p.mes = clock.month
			p.data = clock.date
			p.t1 = ""
			p.t2 = ""
			p.t3 = ""
			p.t4 = ""
			p['t'+params.turno] = params.hora[0..4]
			p.turno = params.turno
		} else {println "atu"
			p['t'+params.turno] = params.hora[0..4]
			p.turno = params.turno
		}
		p.save()
}

request.pontoDoDia = p
request.pontoDoMes = datastore.execute {
	select all from "ponto"
	where email == user.email
	and mes == clock.month
}

forward "/WEB-INF/pages/ponto.gtpl"
