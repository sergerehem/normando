import com.google.appengine.api.datastore.*
import java.text.SimpleDateFormat

def sdfDate = new SimpleDateFormat("dd/MM/yyyy")
sdfDate.setTimeZone(TimeZone.getTimeZone("GMT-3"));
def sdfTime = new SimpleDateFormat("kk:mm:ss")
sdfTime.setTimeZone(TimeZone.getTimeZone("GMT-3"));
def date = new Date()
def data = sdfDate.format(date)
def hora = sdfTime.format(date)

if (params.email == "" || params.nome == "" || params.assunto == "" || params.messagem == "") {
	request.setAttribute 'status', "ERRO"
} else {
	mail.send from: "serge.rehem@normandotransportes.com.br",
	to: "contato@normandotransportes.com.br",
	subject: "[NOVO CONTATO] " + params.assunto,
	textBody: "Nome: ${params.nome}\nEmail: ${params.email}\n---\n${params.mensagem}"

	request.setAttribute 'status', "OK"
	
  def e = new Entity("contato")
  e << params
  e.data_hora = "$data $hora"
  e.save()	
}
forward '/WEB-INF/pages/contato.gtpl'
