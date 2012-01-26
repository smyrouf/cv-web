dojo.require("dijit.MenuBar");
dojo.require("dijit.MenuBarItem");
dojo.require("dijit.PopupMenuBarItem");
dojo.require("dijit.Menu");
dojo.require("dijit.MenuItem");
dojo.require("dijit.PopupMenuItem");
/*
 * 
 * Create a menu so that you can create save or delete a resume
 * 
 */
dojo.addOnLoad(function() {
	pMenuBar = new dijit.MenuBar({});
	 var pSubMenu = new dijit.Menu({});
     pSubMenu.addChild(new dijit.MenuItem({
         label: "create"
     }));
     pSubMenu.addChild(new dijit.MenuItem({
         label: "save"
     }));
     pMenuBar.addChild(new dijit.PopupMenuBarItem({
         label: "File",
         popup: pSubMenu
     }));

     var pSubMenu2 = new dijit.Menu({});
     pSubMenu2.addChild(new dijit.MenuItem({
         label: "default"
     }));
     pMenuBar.addChild(new dijit.PopupMenuBarItem({
         label: "C.V.",
         popup: pSubMenu2
     }));

     pMenuBar.placeAt("menu");
     pMenuBar.startup();
});