if (user != null) {
//	println "Usuario logado $params.continueTo " + user.getNickname() 
//	println "<a href='" + users.createLogoutURL(request.getRequestURI()) + "'>Logoff</a>"
//  request.logoutURL = users.createLogoutURL(request.getRequestURI())
  forward "/intranet"
} else {
//  if (params.continueTo) {
//    url = params.continueTo
//  } else {
  	url = request.continueTo ?: request.queryString
//	}
	redirect users.createLoginURL(url ?: request.requestURI,"www.normandotransportes.com.br") 
}

