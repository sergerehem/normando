<!DOCTYPE html>
<!--[if lt IE 7]>       <html class="no-js lt-ie9 lt-ie8 lt-ie7">   <![endif]-->
<!--[if IE 7]>          <html class="no-js lt-ie9 lt-ie8">          <![endif]-->
<!--[if IE 8]>          <html class="no-js lt-ie9">                 <![endif]-->
<!--[if gt IE 8]><!-->  <html class="no-js">                        <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>WebChat</title>
        <meta name="description" content="Bizstrap: Bootstrap Responsive Admin Theme">
        <meta name="viewport" content="width=device-width">
	      <%if (request.status != 'LOGIN'){%>
	      <script type="text/javascript" src="/_ah/channel/jsapi"></script>
	      <%}%>        
        <link type="text/css" rel="stylesheet" href="/chat/css/bootstrap.min.css">
  		  <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
        <link type="text/css" rel="stylesheet" href="/css/font-awesome.css">
        <link type="text/css" rel="stylesheet" href="/chat/css/chat.css">
        <link rel="stylesheet" href="/css/custom.css" />        
        <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
        <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
        <!--[if IE 7]>
        <link type="text/css" rel="stylesheet" href="/chat/css/font-awesome-ie7.min.css"/>
        <![endif]-->
    </head>
    <body>
    <!-- BEGIN MAIN CONTENT -->
    <div id="content">
        <!--BEGIN LATEST COMMENT-->
        <!-- .row-fluid -->
        <div class="row-fluid">
            <div class="span6">
              <%if (request.status == "LOGIN") {%>				
              <form method="POST" action="/chat">
                <%if (request.chatlist) {%>				
                <select name="chatRoom">
                <%request.chatlist.eachWithIndex() { c, i -> %>
                  <option value="$c">SALA ${i+1} -> $c</option>			
                <%}%>
                </select>
                <%
                } 
                %>
                <input type="text" name="usuario" size="15" placeholder="Nome do usuário ${request.status} ${request.chatlist}"/>
                <input type="submit" class="button" value="Login" />
              </form>
              <%
              } else {
              %>
              <div id="divAguarde"><p>Olá! ${request.usuario}! Por favor, aguarde a entrada de um dos nossos atendentes...</p></div>
              <div id="divChat">
                <!-- Chat inputs/output -->
                <textarea readonly value="Awaiting messages..."></textarea>
                <input id="inputMessage" placeholder="enter a message..."/>
              </div>				
              <%
              } 
              %>            
            </div>
            <!-- .span6 -->
            <div class="span6">
                <!-- .box -->
                <div class="box comments">
                    <header>
                        <div class="icons">
                            <i class="icon-comments"></i>
                        </div>
                        <h5>Latest Comment</h5>
                    </header>
                    <!-- .body -->
                    <div id="divChat" class="body">
<div class="media">
                            <a href="#" class="pull-left">
                                <img data-src="holder.js/64x64" class="media-object" alt="64x64" style="width: 64px; height: 64px;" src="/chat/img/charles.jpg">
                            </a>
                            <div class="media-body">
                                <div class="popover right">
                                    <div class="arrow"></div>
                                    <h3 class="popover-title">Popover left</h3>
                                    <div class="popover-content">
                                        <p>Sed posuere consectetur est at lobortis. Aenean eu leo quam. Pellentesque ornare sem lacinia quam venenatis vestibulum.</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="media">
                            <a href="#" class="pull-right">
                                <img data-src="holder.js/64x64" class="media-object" alt="64x64" style="width: 64px; height: 64px;" src="/chat/img/lucy.jpg">
                            </a>
                            <div class="media-body">
                                <div class="popover left">
                                    <div class="arrow"></div>
                                    <h3 class="popover-title">Popover right</h3>
                                    <div class="popover-content">
                                        <p>Sed posuere consectetur est at lobortis. Aenean eu leo quam. Pellentesque ornare sem lacinia quam venenatis vestibulum.</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                                            
                        <div class="media">
                            <a href="#" class="pull-left">
                                <img data-src="holder.js/64x64" class="media-object" alt="64x64" style="width: 64px; height: 64px;" src="/chat/img/charles.jpg">
                            </a>
                            <div class="media-body">
                                <div class="popover right">
                                    <div class="arrow"></div>
                                    <h3 class="popover-title">Popover left</h3>
                                    <div class="popover-content">
                                        <p>Sed posuere consectetur est at lobortis. Aenean eu leo quam. Pellentesque ornare sem lacinia quam venenatis vestibulum.</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="media">
                            <a href="#" class="pull-right">
                                <img data-src="holder.js/64x64" class="media-object" alt="64x64" style="width: 64px; height: 64px;" src="/chat/img/lucy.jpg">
                            </a>
                            <div class="media-body">
                                <div class="popover left">
                                    <div class="arrow"></div>
                                    <h3 class="popover-title">Popover right</h3>
                                    <div class="popover-content">
                                        <p>Sed posuere consectetur est at lobortis. Aenean eu leo quam. Pellentesque ornare sem lacinia quam venenatis vestibulum.</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- /.body -->
                </div>
                <!-- /.box -->
            <hr/>
            <div class="controls">
                <input class="span12" type="text" id="text2" placeholder="Digite a mensagem e pressione <ENTER>"/>
            </div>                    
                
            </div>
            <!-- /.span6 -->
        </div>
        <!-- /.row-fluid -->
        <!--END LATEST COMMENT-->
    </div>
    <!-- END CONTENT -->
      <script src="/chat/js/jquery-1.9.1.min.js"></script>
      <script type="text/javascript" src="/js/style-switcher/style-switcher.js"></script>
      <script type="text/javascript" src="/chat/js/jquery.slimscroll.min.js"></script>      
      <script type="text/javascript">
      (jQuery)('#divChat').slimscroll({});
      </script>      
	    <% if (request.status != "LOGIN") { %>
	    <script type="text/javascript" charset="utf-8">
		    //Initialize our little chat application
		    (jQuery)(function() {
			    var channel = new goog.appengine.Channel('${request.token}');
			    var socket = channel.open();
			
			    //Assign our handler function to the open socket
			    socket.onmessage = onMessage;
		      socket.onopen = onOpened;
		      //socket.onerror = onError;
		      socket.onclose = onClose;

			    //(jQuery)("#divChat").hide();

			    //handle submitting chat message
			    function submitMessage(message) {
				    var msg = message != null ? message : (jQuery)('#inputMessage').val();
				    (jQuery).ajax('/chat/send', {
					    method:'POST',
					    dataType:'text',
					    data: {
						    clientId: '<%=request.chatRoom ?: request.clientId%>',
						    message:'${request.usuario}: '+msg
					    },
					    success:function(response) {
						    (jQuery)('input').val('').focus();
						    console.log(response);
					    }
				    });
			    }
			
			    function onOpened() {
				    console.log('abriu canal');
				    //(jQuery)("#divChat").show();
			    }

			    function onClose() {
				    console.log('fechou canal');
			    }

			    function closeChannel() {
				    submitMessage("Saiu do chat");
				    console.log('fechando socket');
				    socket.close();
			    }

			    //handle incoming chat messages, pushed by App Engine
			    function onMessage(message) {
			        console.log('chegou message ' + message.data)
				    //(jQuery)("#buttonSend").removeAttr("disabled");
				    var current = (jQuery)('textarea').val();
				    message && (jQuery)('textarea').val(current+'\\n'+message.data);
			    }

			    //Attach event handlers
			    window.onunload=function(){
			        closeChannel
			    };
			    (jQuery)('input').keypress(function (e) {
				    if (e.which == 13) {
					    submitMessage();
				    }
			    });
		    });
	    </script>
	    <%}%>      
    </body>
</html>
