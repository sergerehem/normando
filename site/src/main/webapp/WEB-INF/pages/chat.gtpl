<!doctype html>
<html>
<head>
	<title>Twilio Chat</title>
	
	<!-- JS dependencies - jQuery is not required, but included to make DOM manipulation and Ajax easier -->
	<%if (request.status != 'LOGIN'){%>
	<script type="text/javascript" src="/_ah/channel/jsapi"></script>
	<%}%>
  <script src="/chat/js/jquery-1.9.1.min.js"></script>
	
	<!-- A bit of style 
	<link rel="stylesheet" href="/css/chat.css" type="text/css" media="screen" title="no title" charset="utf-8"/>
  -->
  <link type="text/css" rel="stylesheet" href="/chat/css/bootstrap.min.css">
  <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
  <link type="text/css" rel="stylesheet" href="/css/font-awesome.css">
  <link type="text/css" rel="stylesheet" href="/chat/css/webchat.css">
  <link rel="stylesheet" href="/css/custom.css" />        
  <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
  <!--[if lt IE 9]>
  <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
  <!--[if IE 7]>
  <link type="text/css" rel="stylesheet" href="/chat/css/font-awesome-ie7.min.css"/>
  <![endif]-->	
</head>

<body>
	<div id="container">
		<header>
			<div id="header">
				<h1 class="section-heading">App Engine Chat</h1>
			</div>
		</header>
    <div class="row-fluid">
			<div id="content">
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
			      <% if (request.tipo == "SERVER"){ %>
        		 <input type="hidden" name="usuarioCliente" value="${request.usuarioCliente}">
		        <%}%>            
            <input type="hidden" name="tipo" value="${request.tipo}">
            <input type="text" name="usuario" size="15" placeholder="Nome do usuário ${request.status} ${request.chatlist}"/>
            <input type="submit" class="button" value="Login" />
          </form>
				  <%
				  } else {
				  %>
          <!-- .span6 -->
          <div class="span6">
              <!-- .box -->
              <div class="box comments">
                  <header>
                      <div class="icons">
                          <i class="icon-comments"></i>
                      </div>
                      <h5>Olá! ${request.usuario}! Por favor, aguarde a entrada de um dos nossos atendentes... ${request.tipo}</h5>
                  </header>
                  <!-- .body -->
                  <div id="divChat" class="body">
                  </div>
                  <!-- /.body -->
              </div>
              <!-- /.box -->
          <hr/>
          <div class="controls">
              <input id="inputMessage" name="inputMessage" class="span12" type="text" id="text2" placeholder="Digite a mensagem e pressione <ENTER>"/>
                              <textarea readonly value="Awaiting messages..."></textarea>
          </div>                    
              
          </div>
          <!-- /.span6 -->
      </div>
      <!-- /.row-fluid -->
      <!--END LATEST COMMENT-->		      		
				  <%
				  } 
				  %>
			  </div>
		  </div>
		</div>
	</div>

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
			function submitMessage(code, message) {
				var jsonMsg = {
				  type: '${request.tipo}',				
				  sender: '${request.usuario}',
				  code: code,
				  message: message
				}
				console.log(jsonMsg.sender);
								console.log(jsonMsg.code);
												console.log(jsonMsg.message);
				(jQuery).ajax('/chat/send', {
					method:'POST',
					dataType:'text',
					data: {
						clientId: '<%=request.chatRoom ?: request.clientId%>',
						message: JSON.stringify(jsonMsg), //'${request.usuario}: '+msg,
			      <% if (request.tipo == "SERVER"){ %>
						usuarioCliente: '${request.usuario}',
		        <%}%>   						
						type:'${request.tipo}'
					},
					success:function(response) {
						(jQuery)('input').val('').focus();
						console.log(response);
					}
				});
			}
			
			function onOpened() {
			  <% if (request.tipo == "SERVER"){ %>
  			//submitMessage("Olá ${request.usuarioCliente}, em que posso ajudá-lo(a)?");
  			submitMessage("INI","Olá ${request.usuarioCliente}, em que posso ajudá-lo(a)?");
		    <%}%>
				console.log('abriu canal');
				//(jQuery)("#divChat").show();
			}

			function onClose() {
				console.log('fechou canal');
			}

			function closeChannel() {
				submitMessage("END","Saiu do chat");
				console.log('fechando socket');
				socket.close();
			}

      function newMessage(m) {
        var leftOrRight = (m.type == '${request.tipo}') ? "right" : "left";
        console.log("tipo:" + m.type)
        var msg  =  "<div class='media'>" +
                          "<div class='media-body'>" +
                              "<div class='popover " + leftOrRight + "'>" +
                                  "<div class='arrow'></div>" +
                                  "<div class='popover-content'>" +
                                      "<p>" + m.message + "</p>" +
                                  "</div>" +
                              "</div>" +
                          "</div>" +
                      "</div>";
        (jQuery)('#divChat').append(msg);
        // update slimscroll every time content changes
        (jQuery)('#divChat').slimscroll({ scrollBy: '50px' });      
      }
      
			//handle incoming chat messages, pushed by App Engine
			function onMessage(message) {
			    console.log('chegou message ' + message.data)
				//(jQuery)("#buttonSend").removeAttr("disabled");
				var current = (jQuery)('textarea').val();
				console.log("SOURCE"+message.source);
				newMessage(JSON.parse(message.data));
				message && (jQuery)('textarea').val(current+'\\n'+message.data);
			}

			//Attach event handlers
			window.onunload=function(){
			    closeChannel
			};
			(jQuery)('input').keypress(function (e) {
				if (e.which == 13) {
					submitMessage("MSG",(jQuery)('#inputMessage').val());
				}
			});
		});
	</script>
	<%}%>
</body>
</html>
