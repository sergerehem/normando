import util.*

def clientId = HttpUtil.getBodyPart(request,'from')

if (memcache['chatlist'] == null) {
	memcache['chatlist'] = [clientId]
	memcache[clientId] = [clientId]	
} else {
	def chatlist = memcache['chatlist']
    if (!(clientId in chatlist)) {
    	chatlist.add clientId
    	memcache['chatlist'] = chatlist
    }
}

//GoogleChannel.send(clientId, "$clientId entrou no chat.")

log.info "CHANNEL CONN: $clientId"

