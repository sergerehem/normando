package util

import groovy.json.*

public class GoogleGCM {
  private static final def GCM_URL = 'https://android.googleapis.com/gcm/send'
  private static final def API_KEY = 'AIzaSyA_Xsie4tmgMzkMQCmvxTbitpcqn47moOE'

  def send(regId, msgCode, msgText) {
    def queryString = "{\"registration_ids\":[\"${regId}\"],\"data\":{\"msg\":\"${msgText}\"}}"

    def regIds = [regId]

    def jsonQueryString = new JsonBuilder() 
    jsonQueryString {
      registration_ids regIds
      data(
        msgCode: msgCode,
        msgText: msgText,        
      )
    }
    
    def url = new URL(GCM_URL)     
    def connection = url.openConnection()     
    connection.setRequestMethod("POST")    
    connection.setRequestProperty("Content-Type", "application/json")
    connection.setRequestProperty("Authorization", "key=$API_KEY")
    connection.doOutput = true      
    def writer = new OutputStreamWriter(connection.outputStream)     
    writer.write(jsonQueryString.toString())     
    writer.flush()     
    writer.close()     
    connection.connect()      
    def result = connection.content.text
    connection.disconnect()

	  def slurper = new JsonSlurper()
	  def jsonResponse = slurper.parseText(result)
    return jsonResponse
  }
}
