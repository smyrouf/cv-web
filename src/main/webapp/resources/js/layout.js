dojo.require("dijit.Dialog");
dojo.require("dijit.form.ValidationTextBox");
dojo.require("dijit.form.Button");
dojo.require("dijit.form.Form");
dojo.addOnLoad(function() {
	var ok_login = dojo.byId("ok_login");
	var ok_logout = dojo.byId("ok_logout");
	if (ok_login != null ) {
		dojo.connect(ok_login,"onclick", function(event){
	    	dojo.stopEvent(event);
	        dojo.xhrPost({
	    		// The URL of the request
	    		url: root_url+"/j_spring_security_check",
	    		 handleAs: "json",
	    		// No content property -- just send the entire form
	    		form: dojo.byId("formAuthentification"),
	    		// The success handler
	    		load: function(reponseJSON, ioArgs) {
	    			
	    			//var reponseJSON = dojox.json.ref.fromJson(response);
	    			if ( reponseJSON.status == "ok" ) {
	    				location.reload(true);
	    				return
	    			}
	    			alert("le login ou le mot de passe est incorrecte");
	    			return;
	    		},
	    		// The error handler
	    		error: function(ioArgs) {
	    			if (ioArgs.xhr && (ioArgs.xhr.status != 301 && ioArgs.xhr.status == 302)) {
	    				alert("Un probleme de serveur nous empeche de vous enregistrer");
	    			}
	    		},
	    		// The complete handler
	    		handle: function() {
	    			hasBeenSent = true;
	    		}
	       	});
	        return false;
	    });
	}
	if (ok_logout != null ) {
		dojo.connect(ok_logout,"onclick", function(event){
	    	dojo.stopEvent(event);
	        dojo.xhrPost({
	    		// The URL of the request
	    		url: root_url+"/j_spring_security_logout",
	    		 handleAs: "json",
	    		// No content property -- just send the entire form
	    		form: dojo.byId("formAuthentification"),
	    		// The success handler
	    		load: function(reponseJSON, ioArgs) {
	    			if ( reponseJSON.status == "ok" ) {
	    				location.reload(true);
	    				return
	    			}
	    			alert("le login ou le mot de passe est incorrecte");
	    			return;
	    		},
	    		// The error handler
	    		error: function(ioArgs) {
	    			if (ioArgs.xhr && (ioArgs.xhr.status != 301 && ioArgs.xhr.status == 302)) {
	    				alert("Un probleme de serveur nous empeche de vous enregistrer");
	    			}
	    		},
	    		// The complete handler
	    		handle: function() {
	    			hasBeenSent = true;
	    		}
	       	});
	        return false;
	    });
	}
});