def message = xmpp.parseMessage(request)
 
log.info "Received from ${message.from} with body ${message.body}"
 
// if the message is an XML document instead of a raw string message
if (message.isXml()) {
  // get the raw XML string
  message.stanza
  // or get a document parsed with XmlSlurper
  message.xml()
}
