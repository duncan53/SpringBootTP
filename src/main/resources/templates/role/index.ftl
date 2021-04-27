<#include "../bases/header.ftl"/>

<div class="container-fluid">

</br>
<a class="btn btn-primary btn-small" href="/role/create">Create Role</a></br></br>

	
	<div class="row">
	
	
	
	<#list items as item>

		<div class="col-auto pb-3">
			<div class="card" style="width: 18rem;">
			  <img class="card-img-top" src="https://fakeimg.pl/512/" alt="Card image cap">
			  <div class="card-header">
			  	<h5 class="card-title">${item.name}</h5>
			  </div>
			   <div class="card-footer">
			  	<a class="btn btn-primary btn-small" href="/role/details/${item.id}">Detail</a>
			  </div>
			</div>
		</div>
	
	

	</#list>
	
	</div>

</div>
