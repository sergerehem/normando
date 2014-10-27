import util.*

def state = "/intranet/profile"
def api = new GoogleAPI()
if (!request.token) {
  redirect api.requestAuthToken(GoogleAPI.USERINFO_SCOPE, state)
} else {
//  println "USER $user.nickname"
  json = api.requestUserInfo(request.token)
  request.session.setAttribute ('userEmail',json.email)
  request.session.setAttribute ('userNickname',json.name)
//  println session
  println json.email + " " + json.name
  println json
}
