if (user != null) {
	println "Usuario logado " + user.getNickname() 
	println "<a href='" + users.createLogoutURL(request.getRequestURI()) + "'>Logoff</a>"
} else {
	url = request.continueTo ?: request.queryString
println url
	redirect users.createLoginURL(url ?: request.requestURI,"www.normandotransportes.com.br") 
}

