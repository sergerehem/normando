String recipient = "serge.rehem@normandotransportes.com.br"
 
println "will send ${params.msg}"
// check if the user is online
if (xmpp.getPresence(recipient).isAvailable()) {
  // send the message
   
   def status = xmpp.send(to: recipient, body: params.msg)
   
   println "success:"+status.isSuccessful()
} else {
  println "tá fora"
}
