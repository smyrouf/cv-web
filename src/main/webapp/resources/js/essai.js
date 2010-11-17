dojo.addOnLoad(function() {
		var buttonObj = document.getElementById("myButton");
   	dojo.connect(buttonObj, "onclick",null, function() {
   	//Look up the node we'll stick the text under.
        var targetNode = dojo.byId("content");
        //The parameters to pass to xhrGet, the url, how to handle it, and the callbacks.
        var xhrArgs = {
            url: "/cv-web/users/toto/json",
            handleAs: "json",
            preventCache: true,
            headers: { "Content-Type": "text/json"},
            handle: function(error, ioargs) {
                var message = "";
                switch (ioargs.xhr.status) {
                case 200:
                    message = "Good request.";
                    break;
                case 404:
                    message = "The requested page was not found";
                    break;
                case 500:
                    message = "The server reported an error.";
                    break;
                case 407:
                    message = "You need to authenticate with a proxy.";
                    break;
                default:
                    message = "Unknown error.";
                }
                targetNode.innerHTML = message;
            }
        }

        //Call the asynchronous xhrGet
        var deferred = dojo.xhrGet(xhrArgs);

   	});
})