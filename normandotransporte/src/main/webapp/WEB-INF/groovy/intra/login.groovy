if (user != null) {
	println "usuario logado " + user.getNickname() 
	println "<a href='" + users.createLogoutURL(request.getRequestURI()) + "'>sign out</a>"
} else {
	println "Hello!"
	println "<a href='" + users.createLoginURL(request.getRequestURI(),"www.normandotransportes.com.br") + "'>Sign in</a>"
}

