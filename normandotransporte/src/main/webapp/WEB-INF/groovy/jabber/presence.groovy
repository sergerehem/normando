// parse the incoming presence from the request
def presence = xmpp.parsePresence(request)
 
log.info "${presence.fromJid.id} is ${presence.available ? '' : 'not'} available"
