println params

if (params.email == "" || params.nome == "" || params.assunto == "" || params.messagem == "") {
	request.setAttribute 'status', "ERRO"
} else {
	mail.send from: "serge.rehem@normandotransportes.com.br",
	to: "contato@normandotransportes.com.br",
	subject: "[NOVO CONTATO] " + params.assunto,
	textBody: "Nome: ${params.nome}\nEmail: ${params.email}\n---\n${params.mensagem}"

	request.setAttribute 'status', "OK"
}
forward '/WEB-INF/pages/contato.gtpl'
