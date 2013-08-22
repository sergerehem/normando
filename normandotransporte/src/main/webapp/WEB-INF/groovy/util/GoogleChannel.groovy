package util

import groovyx.gaelyk.GaelykBindings

@GaelykBindings
public class GoogleChannel {
		
	def sendMessage(clientId, message) {
    channel.createChannel(clientId)
    channel.send(clientId, message)
    "sent message to $clientId: $message"
	}

}
