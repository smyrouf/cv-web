<#macro layout>
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
<script src="http://ajax.googleapis.com/ajax/libs/dojo/1.5/dojo/dojo.xd.js" type="text/javascript"  djConfig="parseOnLoad: true" ></script>
<script src="<@spring.url "/resources/js/layout.js"/>" type="text/javascript"></script>
</head>
<body class="claro" >
<div id="page_wrapper">
<div id="header_wrapper">
<div id="header">
<div id="header_title">
<h1>Resume<font color="#FFDF8C">Builder</font></h1>
<h2>Make your resume interative</h2>
</div>
<div id="account_login" >Have an account ?
 

<div dojoType="dijit.form.DropDownButton"> 
	<span>Login </span> <div dojoType="dijit.TooltipDialog">
	        <div class="login_field"><label for="login"> login </label> <input dojoType="dijit.form.ValidationTextBox"  class="login_text" id="login" name="login" placeHolder="enter your login...."  required="true" ></div>
	        <div class="login_field"> <label for="password"> password </label> <input dojoType="dijit.form.ValidationTextBox"  class="login_text" id="password" name="password" type="password" placeHolder="enter your password...."  required="true" ></div> 
	        <button dojoType="dijit.form.Button" type="submit" type="submit"> Sign in </button>
        </div>
</div>
</div>
</div>
</div>
<div id="navcontainer">
<ul id="navlist">
<li id="active"><a href="<@spring.url "/"/>">Home</a></li>
<li><a href="<@spring.url "/user/add"/>">Create account</a></li>
<li><a href="#">Create Resume</a></li>
</ul>
</div>
</div>

<div id="left_side">

<h3>Left Side</h3>

<p>
Lorem ipsum summo <a href="#">nominavi</a> pri et. Stet 
<a href="#">eruditi</a> perfecto at sed, ad enim constituto 
deseruisse quo, mea no quem eros munere. Ad splendide 
quaerendum per, ea minimum officiis oportere vel, an has 
perpetua percipitur. <a href="#">Consequat</a> contentiones 
his te, id noster menandri his. Per partem perfecto eu, est 
soluta accusata ex.
</p>

<h3>Left Side</h3>

<div class='featurebox_side'>
Lorem ipsum summo nominavi pri et. Stet eruditi perfecto at 
sed, ad enim <a href="#">constituto</a> deseruisse quo, mea 
no quem eros munere. 
</div>

<p>
Lorem ipsum summo nominavi pri et. Stet eruditi perfecto at sed, 
ad enim constituto deseruisse quo, mea no quem eros munere. Ad 
splendide quaerendum per, <a href="#">ea minimum officiis</a> 
oportere vel, an has perpetua percipitur. Consequat contentiones 
his te, id <a href="#">noster menandri</a> his. Per partem perfecto 
eu, est soluta accusata ex.
</p>

<div class='featurebox_side'>
Lorem <a href="#">ipsum summo</a> nominavi pri et. Stet eruditi 
perfecto at sed, ad enim constituto deseruisse quo, mea no quem 
eros munere. 
</div>

</div>

<div id="content">
 <#nested>
</div>
<div id="footer">
<a href="#">Home</a> | 
<a href="#">Create account</a> | 
<a href="#">Create Resume</a>
<br />
</div>
</div>
</body>
</html>
</#macro>