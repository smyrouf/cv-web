<#macro container js css>
<#import "/spring.ftl" as spring />
<#import "/layout/html.ftl" as html>
<@html.head>
<link href="<@spring.url "/resources/css/cv/${css}"/>" type="text/css" rel="stylesheet" />
<link href="<@spring.url "/resources/css/cv/basic.css"/>" type="text/css" rel="stylesheet" />
<#if getLogin() == "-1">
<script src="<@spring.url "/resources/js/cv/menu_anonymous.js"/>" type="text/javascript"></script>
<#else>
<script src="<@spring.url "/resources/js/cv/menu_user.js"/>" type="text/javascript"></script>
</#if>
<script src="<@spring.url "/resources/js/cv/${js}"/>" type="text/javascript" ></script>

</@html.head>
<@html.layout>
<div id="resume_container">
<div id="menu"></div>
<#nested>
</div>
</@html.layout>
<@html.footer/>
</#macro>