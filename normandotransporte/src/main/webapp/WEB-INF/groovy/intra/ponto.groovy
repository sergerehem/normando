import com.google.appengine.api.datastore.Entity
import util.Clock

def meses = ["","JANEIRO","FEVEREIRO","MARÇO","ABRIL","MARÇO","JUNHO","JULHO","AGOSTO","SETEMBRO","OUTUBRO","NOVEMBRO","DEZEMBRO"]

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
    datastore.withTransaction {
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
}

request.pontoDoDia = p
if (p) {
  request.mesAno = meses[p.mes as int]+"/"+p.data[6..9]
}
request.pontoDoMes = datastore.execute {
	select all from "ponto"
	where email == user.email
	and mes == clock.month
}
forward "/WEB-INF/pages/intra/ponto.gtpl"
