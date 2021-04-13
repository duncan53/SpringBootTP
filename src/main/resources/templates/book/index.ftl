<#include "../bases/importbase.ftl"/>

<a href="/user/create">Create</a>
<#list books as book>
  <div>
    <div>
      ${book.name}
    </div>
    <div>
      ${book.nbPage}
    </div>
    <div>
      ${book.price}
    </div>
    <div>
      <a href="/user/details/${book.id}">Details</a>
    </div>
  </div>
</#list>
