package util

import com.google.appengine.api.datastore.*
//import groovyx.gaelyk.GaelykBindings
 
//@GaelykBindings
public class Config {
	//static def config = null

	public Config() {
		/*
		if (config == null) {
			config = datastore.execute {
				select all from config limit 1
			}
		} else {
			config
		}*/
	}

	def getMailSender() {
		//config.mailSender[0]
		"anisio@normandotransportes.com.br"
	}
	
	def getReplyTo() {
		//config.replyto[0]
		"contato@normandotransportes.com.br"
	}

}
