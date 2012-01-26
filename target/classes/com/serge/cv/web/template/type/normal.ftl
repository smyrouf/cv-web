<#import "/snippet/element.ftl" as element>
<#import "/spring.ftl" as spring />
<@element.container "normal.js" "normal.css" >
<div dojoType="dijit.layout.BorderContainer" gutters="true" id="title_container">
	<div dojoType="dijit.layout.ContentPane" region="left" splitter="true" id="civic_information_1">
	<h2>left</h2>
	</div>
	<div dojoType="dijit.layout.ContentPane" region="center" splitter="false" id="job">
	<h2>center</h2>
	</div>
	<div dojoType="dijit.layout.ContentPane" region="right" splitter="true" id="civic_information_2">
	<h2>right</h2>
	</div>
</div>
<div id="skills_container" dojoType="dijit.TitlePane" title="Competence">
    
</div>
</@element.container >
