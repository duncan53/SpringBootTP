<#include "../bases/importbase.ftl"/>

<#list items as item>
  <div>
    <div>
      ${item.name}
    </div>
    <div>
      ${item.nbPage}
    </div>
    <div>
	${item.price}
    </div>
  </div>
</#list>
