<#import "/layout/html.ftl" as html>
<#import "/spring.ftl" as spring />
<@html.head>
<link href="<@spring.url "/resources/css/index.css"/>" type="text/css" rel="stylesheet" />
<script src="<@spring.url "/resources/js/index.js"/>" type="text/javascript"></script>
</@html.head>
<@html.layout>
<div id="text_login">
<p>Bienvenu ${user.login} vous pouvez maintenant acceder a vos CV</p>

</p>
</div>
</@html.layout>
<@html.footer></@html.footer>