<#macro layout>
<#import "/spring.ftl" as spring />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<!-- Meta Data -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="description" content="Short description of your site here." />
<meta name="keywords" content="cv, resume, web" />
<!-- Site Title -->
<title>Resume Generator</title>
<!-- Link to Style External Sheet -->
<link href="<@spring.url "/resources/css/style.css"/>" type="text/css" rel="stylesheet" />
<script src="http://ajax.googleapis.com/ajax/libs/dojo/1.5/dojo/dojo.xd.js" type="text/javascript"></script>
</head>
<body>
<div id="page_wrapper">
<div id="header_wrapper">
<div id="header">
<h1>Resume<font color="#FFDF8C">Builder</font></h1>
<h2>Get your resume interative</h2>
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

<div id="right_side">

<h3>Right Side</h3>

<p>
<a href="#">Lorem ipsum summo</a> nominavi pri et. Stet eruditi 
perfecto at sed, ad enim constituto deseruisse quo, mea no quem 
eros munere.
</p>

<div class='featurebox_side'>
Lorem ipsum summo nominavi pri et. Stet eruditi perfecto at sed, 
ad enim constituto deseruisse quo, mea no quem eros munere. 
</div>

<h4>Sub Title</h4>

<p>
Ad splendide <a href="#">quaerendum</a> per, ea minimum officiis 
oportere vel, an has perpetua percipitur. Consequat contentiones 
his te, id <a href="#">noster</a> menandri his. Per partem perfecto 
eu, est soluta accusata ex.
</p>

<h3>Right Side</h3>

<div class='featurebox_side'>
<a href="#">Lorem ipsum</a> summo nominavi pri et. Stet eruditi 
perfecto at sed, ad enim constituto deseruisse quo, mea no quem 
eros munere. 
</div>

<p>
Lorem ipsum summo nominavi pri et. Stet eruditi perfecto at sed, ad 
enim constituto <a href="#">deseruisse</a> quo, mea no quem eros 
munere. Ad splendide quaerendum per, ea minimum officiis oportere vel, 
an has perpetua percipitur. Consequat contentiones his te, id noster 
<a href="#">menandri</a> his. Per partem perfecto eu, est soluta 
accusata ex.
</p>

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