if (user == null) {
	request.continueTo = request.requestURL+"?"+request.queryString
	forward "/intranet/login"
} 

forward "/WEB-INF/pages/intra/index.gtpl"
