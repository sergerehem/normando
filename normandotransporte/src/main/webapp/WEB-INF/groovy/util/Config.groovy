package util

import com.google.appengine.api.datastore.*

public class Config {
	static def config = null

	public Config(ds) {
		if (config == null) {
			config = ds.execute {
				select all from config limit 1
			}
		} else {
			config
		}
	}

	def getMailSender() {
		config.mailsender[0]
	}
	
	def getReplyTo() {
		config.replyto[0]
	}

}
