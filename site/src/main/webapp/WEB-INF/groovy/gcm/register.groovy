import com.google.appengine.api.datastore.*
import util.*

//def gcm = new GoogleGCM()

if (params.name && params.email && params.regId) {
  def e = new Entity("gcm_device")
  e << params
  e.dateCreated = (new Clock()).getDateTime()
  e.save()	

  //gcm.sendMessage(params.regId, "DEU TUDO CERTO")
  
  println "mandei msg para $params.regId"  
} else {
  println "faltou info"
}
