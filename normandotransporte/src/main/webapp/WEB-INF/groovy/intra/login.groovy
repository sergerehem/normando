import com.google.appengine.api.datastore.*

if (params.email && params.password) {

  def user = datastore.execute {
	  select email from "users"
	  where email = params.email
  }
  
  if (user != null) {
  //	println "Usuario logado $params.continueTo " + user.getNickname() 
  //	println "<a href='" + users.createLogoutURL(request.getRequestURI()) + "'>Logoff</a>"
  //  request.logoutURL = users.createLogoutURL(request.getRequestURI())
    forward "/intranet"
  } else {
    session.
    forward
  }

