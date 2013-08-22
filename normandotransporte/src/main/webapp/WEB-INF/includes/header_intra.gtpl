<!DOCTYPE html>
<html>
    <head>
        <!--  SEO STUFF START HERE -->
        <title><%if (!params.title) {%>Normando Transportes<%} else {%>$params.title<%}%></title>
        <meta name="keywords" content="transportadora, transporte, rodoviário, carga, frete, caminhão, frota, transportes" />
        <meta name="description" content="<%if (!params.title) {%>Normando Transportes<%} else {%>$params.title<%}%>" />
        <meta name="author" content="Serge Rehem" />
        <meta name="robots" content="follow, index" />
        <!--  SEO STUFF END -->
        <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <!--  revolution slider plugin : begin -->        
        <link rel="stylesheet" href="/rs-plugin/css/settings.css" media="screen" />
        <link rel="stylesheet" href="/css/rs-responsive.css" media="screen" />
        <!--  revolution slider plugin : end -->
        <link rel="stylesheet" href="/css/bootstrap.css" />
        <link rel="stylesheet" href="/css/custom.css" />
        <link rel="stylesheet" href="/css/isotope.css" />
        <link rel="stylesheet" href="/css/color_scheme.css" />
        <!--<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,400italic,600,600italic,700,700italic" rel="stylesheet" type="text/css" />-->
        <link rel="stylesheet" href="/css/font-awesome.css" />
        <link rel="stylesheet" href="/css/font-awesome-ie7.css" />
        <link rel="stylesheet" href="/css/flexslider.css" />
        <link rel="stylesheet" href="/css/jquery.fancybox.css?v=2.1.0" type="text/css" media="screen" />
        <!--[if lte IE 8]>
            <link rel="stylesheet" type="text/css" href="/css/IE-fix.css" />
        <![endif]-->
        <script type="text/javascript" src="/js/jquery-1.7.2.min.js"></script>
        <script type="text/javascript" src="/js/jquery.validate.min.js"></script>
        <script type="text/javascript" src="/js/jquery.maskedinput.min.js"></script>                        
        <script type="text/javascript" src="/js/jquery.maskMoney.js"></script>        
        
        <!-- Footable -->        
        <link href="/footable/css/footable-0.1.css" rel="stylesheet">
        <link href="/footable/css/footable.sortable-0.1.css" rel="stylesheet">    
        <script src="/footable/js/footable.js" type="text/javascript"></script>
        <script src="/footable/js/footable.sortable.js" type="text/javascript"></script>
        <script src="/footable/js/footable.filter.js" type="text/javascript"></script>        
        <script type="text/javascript">
          (jQuery)(function() {
	          (jQuery)('table.footable').footable();
          });
        </script> 
                                
        <style>                        
					#clock
            {
                display: block;
                width: 300px;
                height: 100px;
                margin: 0 auto;
                background: #FFFF00;
                border: 2px solid #FA8072;
            }
            
          .text-center {
              text-align: center !important;
          }            
          
          thead th {
              background-color: #ff9900;
              color: white;
          }          
				</style>        
    </head>
    <body>
<!-- THE LINE AT THE VERY TOP OF THE PAGE -->
        <div class="top_line"></div>
<!-- HEADER AREA -->
        <header>
            <div class="container">
                <div class="row">
<!-- HEADER: LOGO AREA -->
                    <div class="span4 logo">
                        <a class="logo" href="index.html">
                            <img alt="logo" title="Normando Transportes" src="/img/logo.png">
                        </a>
                    </div>
                    <div class="span6 offset2">
<!-- HEADER: PHONE NUMBER -->
                        <p class="head_phone">INTRANET</p>
                        <p class="head_phone"><%if (user != null) {%>${user?.nickname} <a href="${users.createLogoutURL('/intranet')}">sair</a><%} else {%><a href="/intranet/login?continueTo=/intranet">login</a><%}%></p>                        
                    </div>
                </div>
            </div>
<!-- HEADER: PRIMARY SITE NAVIGATION -->
            <div class="container">
                <div class="navbar">
                    <div class="navbar-inner">
                        <div class="container">
                            <div class="buttons-container">
                            </div>
                            <div class="nav-collapse">
                                <ul class="nav nav-pills">
                                    <li class="active single"><a href="/">HOME</a></li> 
                                    <li class="single"><a href="/intranet/motoristas">MOTORISTAS</a></li>                                                                          
                                    <li class="single"><a href="/intranet/orcamentos">ORÇAMENTO</a></li>                                       
                                    <li class="single"><a href="/intranet/contatos">CONTATO</a></li>
                                    <li class="single"><a href="/intranet/ponto">PONTO</a></li>                                                                          
                                    <li class="single"><a href="/intranet/chat">CHAT</a></li>                                                                          


                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </header>
<!-- MAIN CONTENT AREA -->
        <div class="main-content">
            <div class="container">

