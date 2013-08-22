import util.*

def clock = new Clock()

if (!params.usuario) { //USUARIO EFETUA LOGIN
	request.status = "LOGIN"
} else {
	request.status = "CHAT"
	def clientId = params.chatRoom ?: ["${params.usuario}", "${clock.getDateTime()}"] as String
	//def clientId = params.chatRoom ?: nextChatRoom()
	token = channel.createChannel(clientId)
	log.info "CRIEI CANAL $clientId $token"
	request.chatRoom = params.chatRoom
	request.token = token
	request.clientId = clientId
	request.usuario = params.usuario
}
request.tipo = params.tipo ?: "CLIENT"
forward '/WEB-INF/pages/chat.gtpl'

def nextChatRoom() {
	def chatlist = memcache['chatlist']
	"SALA " + (chatlist.size() + 1)
}

/*
if (!params.usuario) { //USUARIO EFETUA LOGIN
	request.status = "LOGIN"
} else {
	request.status = "CHAT"
	def token = channel.createChannel("sala1")//params.usuario)
	request.token = token
	request.usuario = params.usuario
}
forward 'WEB-INF/pages/chat.gtpl'
*/


