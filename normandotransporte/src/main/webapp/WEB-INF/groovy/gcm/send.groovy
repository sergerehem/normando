import util.*

def gcm = new GoogleGCM()
def result = gcm.send(params.regId, "OK", "A NEW MESSAGE FOR Uxx")
if (result.success == 1) {
  println "FUNFOU!!!!"
} else {
  println "DEU $result.success BRAGA!! $result "
}
