get "/favicon.ico", redirect: "/img/favicon.ico"

// SITE PUBLICO
get "/", forward: "/WEB-INF/pages/index.gtpl"
get "/equipe", forward: "/WEB-INF/pages/equipe.gtpl"
get "/contato", forward: "/WEB-INF/pages/contato.gtpl"
post "/contato", forward: "/contato.groovy"
get "/orcamento", forward: "/WEB-INF/pages/orcamento.gtpl"
post "/orcamento", forward: "/orcamento.groovy"
get "/localizacao_matriz", forward: "/WEB-INF/pages/localiza_matriz.gtpl"
get "/localizacao_filial", forward: "/WEB-INF/pages/localiza_filial.gtpl"

// INTRANET
get "/intranet", forward: "/intra/index.groovy"
get "/intranet/login", forward: "/intra/login.groovy"
get "/intranet/logout", forward: "/intra/logout.groovy"
get "/intranet/orcamentos", forward: "/intra/orcamentos.groovy"
get "/intranet/contatos", forward: "/intra/contatos.groovy"
get "/intranet/motoristas", forward: "/intra/motoristas.groovy"
post "/intranet/motorista", forward: "/intra/motorista.groovy"
get "/intranet/chat", forward: "/intra/chatServer.groovy"
get "/intranet/upload", forward: "/WEB-INF/pages/intra/upload.gtpl"
get "/intranet/success", forward: "/WEB-INF/pages/intra/success.gtpl"
get "/intranet/failure", forward: "/WEB-INF/pages/intra/failure.gtpl"
get "/intranet/ponto", forward: "/intra/ponto.groovy"
post "/intranet/ponto", forward: "/intra/ponto.groovy"
get "/intranet/clock", forward: "/intra/clock.groovy"

// GOOGLE CLOUD MESSAGE (GCM)
post "/gcm/register", forward: "/gcm/register.groovy"
get "/gcm/list", forward: "/gcm/list.groovy"
get "/gcm/unregister", forward: "/gcm/unregister.groovy"
get "/gcm/send", forward: "/gcm/send.groovy"

// JABBER
get "/jabber/send", forward: "/jabber/send.groovy"
jabber to: "/jabber/receive.groovy"
jabber presence, to: "/jabber/presence.groovy"
jabber subscription, to: "/jabber/subscription.groovy"

// CHAT
get "/webchat", forward: "/WEB-INF/pages/webchat.gtpl"
get "/chat", forward: "/chatClient.groovy"
post "/chat", forward: "/chatClient.groovy"
post "/chat/send", forward: "/chatSend.groovy"
post "/_ah/channel/connected/", forward: "/chat/channelConn.groovy"
post "/_ah/channel/disconnected/", forward: "/chat/channelDisconn.groovy"


