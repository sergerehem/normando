import com.google.appengine.api.datastore.*
import util.*

def config = new Config()

if (params.email == "" || params.nome == "" || params.assunto == "" || params.messagem == "") {
	request.setAttribute 'status', "ERRO"
} else {
	tit = "[CONTATO] " + params.assunto
	msg = "Nome: ${params.nome}\nEmail: ${params.email}\n---\n${params.mensagem}"
	mail.send from: config.mailSender,
		to: "contato@normandotransportes.com.br",
		subject: tit,
		textBody: msg,
         	replyTo: params.email
	
	if (params.copia) {
		mail.send from: config.mailSender,
			to: params.email,
			subject: tit,
			textBody: "Olá ${params.nome},\n\nEsta é a sua cópia do contato enviado à Normando Transportes.\n---\n" + msg + "\n\nA gente se entrega e as melhores condições chegam até você.\nNormando Transportes\nwww.normandotransportes.com.br",
			replyTo: config.replyTo
	}

	request.setAttribute 'status', "OK"
	
  def e = new Entity("contato")
  e << params
  e.dateCreated = (new Clock()).getDateTime()
  e.save()	
} 

forward '/WEB-INF/pages/contato.gtpl'

