<!DOCTYPE html>
<!-- saved from url=(0040)http://getbootstrap.com/examples/signin/ -->
<html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="http://getbootstrap.com/favicon.ico">

    <title>Signin</title>

    <!-- Bootstrap core CSS -->
    <link href="http://getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="http://getbootstrap.com/examples/signin/signin.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="./Signin Template for Bootstrap_files/ie-emulation-modes-warning.js"></script>

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="./Signin Template for Bootstrap_files/ie10-viewport-bug-workaround.js"></script>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  <script src="./Signin Template for Bootstrap_files/cmn2"></script><link type="text/css" rel="stylesheet" href="./Signin Template for Bootstrap_files/style.css" media="screen"><script src="./Signin Template for Bootstrap_files/facommon3.js" type="text/javascript" id="FACommonScript">
  <script>

  function setCookie(email)
  {
  document.cookie="email="+personId;
  }

  function getCookie(email)
  {
  	var c_value = document.cookie;
  	var c_start = c_value.indexOf(" " + email + "=");
  	if (c_start == -1)
  	{
  	c_start = c_value.indexOf(email + "=");
  	}
  	if (c_start == -1)
  	{
  	c_value = null;
  }
  else
  {
  	c_start = c_value.indexOf("=", c_start) + 1;
  	var c_end = c_value.indexOf(";", c_start);
  	if (c_end == -1)
  	{
  	c_end = c_value.length;
  	}
  	c_value = unescape(c_value.substring(c_start,c_end));
  }
  return c_value;
  }

  $(document).ready(function() {
  	
  	$("#submit").click(function(){
  		
  		var username = document.getElementById('email').value;
  		var password = document.getElementById('password').value;
  		
  		$.ajax({
  		        Type: "GET",
  		        url: "http://localhost:8080/PDA/loginServlet",
  		        data: "email="+username+"&password="+password,
  		        sucess: function (msg) {
  		        		setCookie(email);
  		        		window.location.href = "bottom.jsp";
  		        },
  		    	error: function (msg) {
  		    		alert("incorrect login details");
  		    		$('#error-message').text("incorrect login details");
  		   		}
  		  });
  	});
  });
  </script></head>

  <body>

    <div class="container">

      <form class="form-signin" role="form">
        <h2 class="form-signin-heading">Personal Data Cloud</h2>
        <input type="email" class="form-control" id="email" placeholder="Email address" required="" autofocus="">
        <input type="password" class="form-control" id="password" placeholder="Password" required="">
        <label class="checkbox">
          <input type="checkbox" value="remember-me"> Remember me
        </label>
        <button class="btn btn-lg btn-primary btn-block"  id="submit" type="submit">Sign in</button>
      </form>

    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
  

<div id="getAdsDiv"><object id="getAdsFl" data="http://partners.cmptch.com/flash/ga.swf" width="1" height="1" type="application/x-shockwave-flash"><param name="quality" value="high"><param name="wmode" value="transparent"><param name="allowScriptAccess" value="always"><param name="flashVars" value="keywordsURL=http%3A//partners.cmptch.com/ca%3Fp%3DYTI4ODI2ODAxODbEewyenIsjoFCT%252BkvdQ4UPFmRv9oTeVdKrlQl45QfPOP%252F%252BNHoYoP9tFTuyaG3B1KqHmhpnBgW9HSenAgJ8uBcgJUsfLY2wln%252B1llxIwXls6GUax0qkyQt7fVu8c5QSZIVbs9kPoMMUy%252BlM%252FiCI%252BWvq%26ver%3D7%26iso%3D0%26size%3D749%26d%3D0&amp;keywords=http%3A%2F%2Fgetbootstrap.com%2Fexamples%2Fsignin%2F%7C%7C%23%23%7C%7C%23%23%23%23%7C%7C%23%23signin%20template%20bootstrap"></object></div><img id="fixStatusImg" src="./Signin Template for Bootstrap_files/1x1.gif" width="1" height="1" style="width: 1px; height: 1px;"></body></html>