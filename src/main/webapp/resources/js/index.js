	dojo.require("dijit.form.Button");
    dojo.require("dijit.form.ValidationTextBox");
    dojo.require("dijit.Dialog");
    dojo.require("dijit.form.Form");
    dojo.require("dojox.form.BusyButton");
    dojo.require("dojox.validate.regexp");
    dojo.addOnLoad(function() {
    	if (document.pub) {
            document.pub();
        }
    	// Create a button programmatically:
        	new dojox.form.BusyButton({
            label: "s'incrire",
            busyLabel: "Sending mail...",
            timeout: 5000,
            onClick: function() {
            	var form = dijit.byId("FormSignIn");
            	if (form.validate()) {
            	   	dojo.xhrPost({
            			// The URL of the request
            			url: root_url+"/register/init",
            			 handleAs: "json",
            			// No content property -- just send the entire form
            			form: dojo.byId("FormSignIn"),
            			// The success handler
            			load: function(reponseJSON, ioArgs) {
            				//var reponseJSON = dojox.json.ref.fromJson(response);

            				if ( reponseJSON.status != "ok" ) {
            			 	alert(reponseJSON.message);
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
            	} else {
                	alert('Certains champs sont manquants ou invalides. Veuillez les completer pour finaliser l\'inscription.');
                	return false;
            	}
         
            }
        },
        "submit");
    });