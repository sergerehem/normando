// parse the incoming subscription from the request
def subscription = xmpp.parseSubscription(request)
 
log.info "Subscription from ${subscription.fromJid.id}: ${subscription.subscriptionType}}"
