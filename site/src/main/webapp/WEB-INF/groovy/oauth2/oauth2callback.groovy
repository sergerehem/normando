//println 'voltei'
import groovy.json.*
import util.*

def api = new GoogleAPI()

if (!params.code) {
	out << "User denied access."
	return
}

if (!params.state) {
	out << "State parameter missing, somethign is wrong..."
	return
}

if (params.code) {
  request.token = api.requestAccessToken(params.code)
  forward params.state
}
