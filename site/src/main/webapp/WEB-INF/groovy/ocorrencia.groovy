import com.google.appengine.api.datastore.*
import util.*

def config = new Config()

if (params.email == "" || params.nome == "" || params.resumo == "" || params.ocorrencia == "") {
	request.setAttribute 'status', "ERRO"
} else {
	tit = "[OCORRENCIA] " + params.resumo
	msg = "Nome: ${params.nome}\nEmail: ${params.email}\n---\n${params.ocorrencia}"
	mail.send from: config.mailSender,
		to: "contato@normandotransportes.com.br",
		subject: tit,
		textBody: msg,
  	replyTo: params.email

	if (params.copia == "S") {
		mail.send from: config.mailSender,
			to: params.email,
			subject: tit,
			textBody: "Olá ${params.nome},\n\nEsta é a sua cópia da ocorrência reportada à Normando Transportes.\n\nNosso time já está trabalhando nisso, aguarde nosso contato.\n---\n" + msg + "\n\nA gente se entrega e as melhores condições chegam até você.\nNormando Transportes\nwww.normandotransportes.com.br",
			replyTo: config.replyTo
	}

	request.setAttribute 'status', "OK"
	
  def e = new Entity("ocorrencia")
  e << params
  e.dateCreated = (new Clock()).getDateTime()
  e.save()	
} 
forward '/WEB-INF/pages/ocorrencia.gtpl'

