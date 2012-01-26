<#macro head>
<#import "/spring.ftl" as spring />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<!-- Meta Data -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="description" content="resume builder" />
<meta name="keywords" content="cv, resume, web" />
<!-- Site Title -->
<title>Resume Generator</title>
<!-- Link to Style External Sheet -->
<link href="<@spring.url "/resources/css/style.css"/>" type="text/css" rel="stylesheet" />
<link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/dojo/1.5/dijit/themes/claro/claro.css" />
<script src="http://ajax.googleapis.com/ajax/libs/dojo/1.6/dojo/dojo.xd.js" type="text/javascript"  djConfig="parseOnLoad: true" ></script>
<script src="<@spring.url "/resources/js/layout.js"/>" type="text/javascript"></script>
<script type="text/javascript">
var root_url = "<@spring.url ""/>";
window.setTimeout(function hideLoader(){
    dojo.fadeOut({ 
        node: 'loader', 
        duration:500,
        onEnd: function(n){
            n.style.display = "none";
        }
    }).play();
}, 250);
</script>
<#nested>
</head>
</#macro>
<#macro layout>
<body class="claro" >
<div id="loader"></div>
<div id="header">
<div id="header_title"></div>
<#if getLogin() == "-1">
	<form id="formAuthentification" class="loginForm" action="j_spring_security_check" method="POST" >
				<p> Deja menbre ?</p>
		        <input class="login_field" id="login" type="text" size="15"  name="j_username" placeHolder="login...."  />
		        <input class="login_field" id="password"  type="password" size="15"  name="j_password" placeHolder="mot de passe...." /> 
		        <div id="login_submit" ><a href="" id="ok_login" > ok </a></div>
	</form>
<#else>
	<div id="loginWelcome"> 
	<span id="user_login">${getLogin()}</span> | <span id="logout"> <a href="" id="ok_logout" >  deconnection </a></span> 
	</div>
</#if>

 
<div class="clear"></div>
<div id="header_menu">
 <div class="sub_menu" ><a href="<@spring.url "/register/login"/>">s'inscrire </a></div>
 <div class="sub_menu" id="login" ><a href="<@spring.url "/sample/default"/>">exemples</a></div>
 <#if getLogin() != "-1">
 	 <div class="sub_menu" id="login" ><a href="#">vos CV</a></div>
 </#if>
</div>

</div>
<div id="navcontainer">
<div class="clear" > </div>
<#nested>
</div>
</body>
</html>
</#macro>

<#macro footer>
<div id="footer_ligne2">
<span><a href="">sign in </a>| <a href="">view model </a>| <a href=""> contact </a></span>
</div>
<#nested>
</#macro>