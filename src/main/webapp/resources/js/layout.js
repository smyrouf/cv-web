dojo.require("dijit.form.DropDownButton");
dojo.require("dijit.TooltipDialog");
dojo.require("dijit.form.ValidationTextBox");
dojo.require("dijit.form.Button");
dojo.require("dijit.form.Form");


dojo.addOnLoad(function() {
    if (document.pub) {
        document.pub();
    }
    var loginForm = dijit.byId("loginForm");
    dojo.connect(loginForm, "onSubmit", function(e) {
        e.preventDefault();
        if (loginForm.isValid()) {
            alert("Ready to submit data: " + dojo.toJson(loginForm.attr("value")));
        }
    });

});