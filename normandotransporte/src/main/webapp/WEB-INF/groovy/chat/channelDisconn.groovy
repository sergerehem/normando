import util.*

def clientId = HttpUtil.getBodyPart(request,'from')

if (clientId in memcache['chatlist']) {
	def chatlist = memcache['chatlist']
	chatlist.remove clientId
	memcache['chatlist'] = chatlist
}

//GoogleChannel.send(clientId, "$clientId saiu do chat.")

log.info "CHANNEL DISCONN: $clientId"
