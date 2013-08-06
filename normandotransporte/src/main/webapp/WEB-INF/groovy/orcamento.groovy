import com.google.appengine.api.datastore.*
import util.*

def config = new Config(datastore)

if (params.empresa == "" || params.nome == "" || params.email == "" 
    || params.selectMercadoria == "" || params.origem == "" || params.destino == "" || params.peso == ""
    || params.valor == "" || params.carga == "" || params.descarga == "") {

  request.setAttribute 'status', "ERRO"
	
} else {

	tit = "[ORÇAMENTO] " + params.empresa
	outraMercadoria = params.selectMercadoria == "Outra" ? "(${params.mercadoria})" : ""
  msg = """\
Empresa: ${params.empresa}
Pessoa de Contato: ${params.nome}
Email: ${params.email}
Telefone: ${params.tel}
---
Mercadoria: ${params.selectMercadoria} $outraMercadoria
Origem: ${params.origem}	      
Destino: ${params.destino}
Peso (Ton): ${params.peso}
Valor: ${params.valor}
Carga: ${params.carga}
Descarga: ${params.descarga}
Informações adicionais: ${params.info}	  
"""
	mail.send from: config.mailSender,
  	to: "contato@normandotransportes.com.br",
	  subject: tit,
  	textBody: msg,
  	replyTo: params.email

	if (params.copia == "S") {
		mail.send from: config.mailSender,
			to: params.email,
			subject: tit,
			textBody: "Olá ${params.nome},\n\nEsta é a sua cópia da solicitação de orçamento enviada à Normando Transportes.\n" + msg + "\n\nA gente se entrega e as melhores condições chegam até você.\nNormando Transportes\nwww.normandotransportes.com.br",
			replyTo: config.replyTo
	}

  def e = new Entity("orcamento")
  e << params
  e.dateCreated = (new Clock()).getDateTime()
  e.save()
  
	request.setAttribute 'status', "OK"
}
forward '/WEB-INF/pages/orcamento.gtpl'
