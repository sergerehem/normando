request.status = "LOGIN"
request.chatlist = memcache['chatlist']
request.tipo = "SERVER"
request.usuarioCliente = params.usuarioCliente
forward "/WEB-INF/pages/chat.gtpl"
