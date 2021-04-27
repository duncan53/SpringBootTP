<#include "../bases/header.ftl"/>




<div class="container-fluid">

	<div class="py-3">
		<a class="btn btn-primary btn-small" href="/book/create">Create</a>
	</div>
	
	<div class="row">
		
		
		<form method="post" action="search">
			<input type="text" name="inputName" placeholder="Name">
			<input type="number" name="inputnbPageMin" placeholder="Nombre de Page minimum">
			<input type="number" name="inputnbPageMax" placeholder="Nombre de Page maximum">
			<input type="text" name="inputPriceMin" placeholder="Price Maximum">
			<input type="text" name="inputPriceMax" placeholder="Price Minimum">
			<input class="btn btn-primary btn-small" type="submit" value="Submit">
		</form>
	</div>
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
			  <div class="card-footer">
			  	<a class="btn btn-primary btn-small" href="/book/details/${item.id}">Details</a>
			  </div>
			</div>
		</div>
	
	

	</#list>
	
	</div>

</div>


