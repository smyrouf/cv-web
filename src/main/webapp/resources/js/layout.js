dojo.require("dijit.Dialog");
dojo.require("dijit.form.ValidationTextBox");
dojo.require("dijit.form.Button");
dojo.require("dijit.form.Form");
dojo.addOnLoad(function() {
    if (document.pub) {
        document.pub();
    }
    secondDlg = new dijit.Dialog({
        title: "Login",
        style: "width: 300px"
    });
    var loginForm = dijit.byId("loginForm");
    dojo.connect(loginForm, "onSubmit", function(e) {
        e.preventDefault();
        if (loginForm.isValid()) {
            alert("Ready to submit data: " + dojo.toJson(loginForm.attr("value")));
        }
    });

});