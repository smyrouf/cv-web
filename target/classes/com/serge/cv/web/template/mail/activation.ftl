<#import "/spring.ftl" as spring />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2> Bonjour ${user.login} !!</h2>
	<p> Afin de valider votre inscription veuillez cliquer sur le lien suivant <a href="http://127.0.0.1:8080/<@spring.url "/register/activate?activationkey=${user.activationkey}"/>" >http://127.0.0.1:8080/<@spring.url "/register/activate?activationkey=${user.activationkey}" /></a>
	
	</p>
</body>
</html>