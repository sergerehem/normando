import com.google.appengine.api.datastore.*
import java.text.SimpleDateFormat

def sdfDate = new SimpleDateFormat("dd/MM/yyyy")
sdfDate.setTimeZone(TimeZone.getTimeZone("GMT-3"));
def sdfTime = new SimpleDateFormat("kk:mm:ss")
sdfTime.setTimeZone(TimeZone.getTimeZone("GMT-3"));
def date = new Date()
def data = sdfDate.format(date)
def hora = sdfTime.format(date)

if (params.empresa == "" || params.nome == "" || params.email == "" || params.tel == ""
    || params.selectMercadoria == "" || params.origem == "" || params.destino == "" || params.peso == ""
    || params.valor == "" || params.carga == "" || params.descarga == "") {

  request.setAttribute 'status', "ERRO"
	
} else {

   msg = """\
Empresa: ${params.empresa}
Pessoa de Contato: ${params.nome}
Email: ${params.email}
Telefone: ${params.tel}
---
Mercadoria: ${params.mercadoria}
Origem: ${params.origem}	      
Destino: ${params.destino}
Peso (Ton): ${params.peso}
Valor: ${params.valor}
Carga: ${params.carga}
Descarga: ${params.descarga}
Informações adicionais: ${params.info}	  
"""
	      
	mail.send from: "serge.rehem@normandotransportes.com.br",
  	to: "contato@normandotransportes.com.br",
	  subject: "[ORÇAMENTO] " + params.empresa,
  	textBody: msg,
  	cc: [params.email],
  	replyTo: "contato@normandotransportes.com.br"

  def e = new Entity("orcamento")
  e << params
  e.data_hora = "$data $hora"
  e.save()
  
	request.setAttribute 'status', "OK"
}

forward '/WEB-INF/pages/orcamento.gtpl'
