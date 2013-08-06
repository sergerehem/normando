import util.*
def state = "/intranet/profile"
def api = new GoogleAPI()
if (!request.token) {
  redirect api.requestAuthToken(GoogleAPI.USERINFO_SCOPE, state)
} else {
  println api.requestUserInfo(request.token)
}
