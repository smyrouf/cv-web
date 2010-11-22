<#import "/decorator/html.ftl" as html>
<#import "/spring.ftl" as spring />
<@html.layout>
 <script   src="<@spring.url "/resources/js/essai.js" />" type="text/javascript"></script>
 <form id="myForm">
 <input type="text" name="name"/>
 <input type="button" id="myButton" value="Submit"/>
</form>
</@html.layout>