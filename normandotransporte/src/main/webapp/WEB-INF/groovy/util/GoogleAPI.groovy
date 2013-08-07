package util

import groovy.json.*

public class GoogleAPI {
  
  private static final def client_id = '557246978688.apps.googleusercontent.com'
  private static final def client_secret = '_FBgZb5KYlWHBZhupttXIuRS'
  private static final def redirect_uri = 'http://localhost:8080/oauth2callback'
  private static final def oauth2_token_uri = "https://accounts.google.com/o/oauth2/token"
  
  private static final def userinfo_uri = "https://www.googleapis.com/oauth2/v3/userinfo"
  
  public static final def USERINFO_SCOPE = "https://www.googleapis.com/auth/userinfo.email+https://www.googleapis.com/auth/userinfo.profile"
  
  // RETORNA AUTHTOKEN URL
  def requestAuthToken(String scope, String state) {
    def continue_url = new URLEncoder().encode("https://accounts.google.com/o/oauth2/auth?response_type=code&scope=${scope}&redirect_uri=${redirect_uri}&approval_prompt=force&state=${state}&client_id=${client_id}&hl=pt-BR","UTF-8")
    "https://accounts.google.com/AccountChooser?service=lso&continue=${continue_url}"  
  }

  def requestAccessToken(String code) {
	  def tokenURL = oauth2_token_uri.toURL()
	  def res = tokenURL.post(deadline: 30, payload:"code=${code}&client_id=${client_id}&client_secret=${client_secret}&redirect_uri=${redirect_uri}&grant_type=authorization_code".getBytes())
	  def slurper = new JsonSlurper()
	  def json = slurper.parseText(res.text)
	  json.access_token
  }
  
  def requestUserInfo(token) {
    def userInfo = new URL("${userinfo_uri}?access_token=${token}").text
	  def slurper = new JsonSlurper()
	  def json = slurper.parseText(userInfo)
    json
  }
}
