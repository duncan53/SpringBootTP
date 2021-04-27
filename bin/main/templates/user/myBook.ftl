<#include "../bases/header.ftl"/>

<div class="container-fluid">

	
	<div class="row">
	
	
	
	<#list items as item>

		<div class="col-auto pb-3">
			<div class="card" style="width: 18rem;">
			  <img class="card-img-top" src="https://picsum.photos/200" alt="Card image cap">
			  <div class="card-header">
			  	<h5 class="card-title">${item.name}</h5>
			  </div>
			  <div class="card-body">
			    <p class="card-text">Pages : ${item.nbPage}</p>
			    <p class="card-text">Price : ${item.price}</p>
			  </div>
			</div>
		</div>
	
	

	</#list>
	
	</div>

</div>