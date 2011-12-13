dojo.require("dijit.Dialog");
dojo.require("dijit.form.ValidationTextBox");
dojo.require("dijit.form.Button");
dojo.require("dijit.form.Form");
dojo.addOnLoad(function() {
	
	var afterlogout = dojo.fx.combine([
	         		                 dojo.fadeOut({ node: "loginForm", duration:1000 }),
	         		                 dojo.fadeIn({ node: "authentification", duration:2000 })
	]);
    dojo.connect(dojo.byId("ok_submit"),"onclick", function(event){
    	dojo.stopEvent(event);
        dojo.xhrPost({
    		// The URL of the request
    		url: root_url+"/j_spring_security_check",
    		 handleAs: "json",
    		// No content property -- just send the entire form
    		form: dojo.byId("authentification"),
    		// The success handler
    		load: function(reponseJSON, ioArgs) {
    			
    			//var reponseJSON = dojox.json.ref.fromJson(response);
    			if ( reponseJSON.status == "ok" ) {
//    				var afterlogin = dojo.fx.combine([
//    				         		                 dojo.fadeOut({ node: "authentification", duration:1000 }),
//    				         		                 dojo.fadeIn({ node: "loginForm", duration:2000 })
//    				         	]);
//    				afterlogin.play();
    				dojo.fadeOut({ node: "authentification", duration:1000 });
	    		 	dojo.byId("loginWelcome").innerHTLM = reponseJSON.login+" | <a href=\"\"> deconnection</a>";
	    		 	dojo.fadeIn({ node: "loginForm", duration:1000 });
	    			return;
    			}
    			alert(reponseJSON.message);
    			return;
    		},
    		// The error handler
    		error: function() {
    			alert("content", "Un probleme de serveur nous empeche de vous enregistrer");
    		},
    		// The complete handler
    		handle: function() {
    			hasBeenSent = true;
    		}
       	});
        return false;
    });

});