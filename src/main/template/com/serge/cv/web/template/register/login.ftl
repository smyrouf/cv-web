<#import "/layout/html.ftl" as html>
<#import "/spring.ftl" as spring />
<@html.head>
<link href="<@spring.url "/resources/css/index.css"/>" type="text/css" rel="stylesheet" />
<script src="<@spring.url "/resources/js/index.js"/>" type="text/javascript"></script>
</@html.head>
<@html.layout>
<div id="text_login">
<h2>Vous voulez vous inscrire ?</h2>
<p> Vous pouvez devenir menbre  <strong>gratuitement</strong> de CV dynamique et ainsi creer votre  <strong> CV web, interactif, dynamique </strong> et booster votre profil.
 Pour cela rien de bien complique il suffit de remplir le formulaire ci-dessus. </p>
 <form dojoType="dijit.form.Form" id="FormSignIn" method="GET" action="<@spring.url "/users/init" />" >
 
  <fieldset>
    <legend>Creation du compte </legend>
    <ol>
    <li>
   		<label for="Login">  Login   : </label> <input type="text" size="80" name="login"  placeholder="Veuillez choisir un login" trim="true" dojoType="dijit.form.ValidationTextBox" required="true"  missingmessage="Le login est manquant" regExp="[\w]+" class="login_input"  />
   	</li>
   	<li>
   		<label for="password">  Password   : </label>  <input  size="50" name="password"  placeholder="Veuillez choisir un mot de passe"  trim="true" dojoType="dijit.form.ValidationTextBox" type="password" regExp="[\w]+" required="true"   missingmessage="Le mot de passe est manquant"  class="login_input" />
   </li>
   <li>
   		<label for="courriel"> courriel   : </label>  <input type="text" size="50" name="courriel" regExp="\b[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}\b" trim="true"  placeholder="Veuillez indiquer une adresse email" required="true"  dojoType="dijit.form.ValidationTextBox" class="login_input" />
   </li>
    <li>
		 	<button  id="submit" type="button" />
 	</li>
  </fieldset>
</form> 
 </div id="text_login">
<p>
</@html.layout>
<@html.footer></@html.footer>