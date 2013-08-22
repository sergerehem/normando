import util.*

def channel = new GoogleChannel()

println channel.sendMessage(params.clientId, params.message)

