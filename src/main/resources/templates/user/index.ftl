
<#include "../bases/header.ftl"/>



<div class="container-fluid">


	<div class="py-3">
		<a class="btn btn-primary btn-small" href="/user/create">Create</a>
	</div>
	
	<div class="row">
	
	
	
	<#list items as item>

		<div class="col-auto pb-3">
			<div class="card" style="width: 18rem;">
			  <img class="card-img-top" src="https://eu.ui-avatars.com/api/?name=${item.firstname}+${item.lastname}&size=512" alt="Card image cap">
			  <div class="card-header">
			  	<h5 class="card-title">${item.firstname} ${item.lastname}</h5>
			  </div>
			  <div class="card-body">
			    <p class="card-text">Role : ${item.role.name}</p>
			  </div>
			   <div class="card-footer">
			  	<a class="btn btn-primary btn-small" href="/user/connect/${item.id}">Connect</a>
			  </div>
			</div>
		</div>
	
	

	</#list>
	
	</div>

</div>
