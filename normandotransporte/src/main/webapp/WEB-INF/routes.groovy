get "/test", forward: "/WEB-INF/pages/test.gtpl"
get "/", forward: "/WEB-INF/pages/index.gtpl"
get "/contato", forward: "/WEB-INF/pages/contato.gtpl"
get "/orcamento", forward: "/WEB-INF/pages/orcamento.gtpl"
post "/contato_submit", forward: "/contato.groovy"
post "/orcamento_submit", forward: "/orcamento.groovy"

get "/localizacao_matriz", forward: "/WEB-INF/pages/localiza_matriz.gtpl"
get "/localizacao_filial", forward: "/WEB-INF/pages/localiza_filial.gtpl"

get "/intranet", forward: "/WEB-INF/pages/intra/index.gtpl"
get "/intranet/login", forward: "/intra/login.groovy"
get "/intranet/logout", forward: "/intra/logout.groovy"
get "/intranet/orcamento", forward: "/intra/orcamento.groovy"

get "/favicon.ico", redirect: "/img/favicon.ico"


