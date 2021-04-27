<#include "../bases/header.ftl"/>

<form method="POST">
  <label for="firstname">Firstname</label>
  <input type="text" id="firstname" name="firstname"/>
  <label for="lastname">Lastname</label>
  <input type="text" id="lastname" name="lastname"/>

  <#include "./rolesSelection.ftl">

  <input class="btn btn-primary btn-small" type="submit" value="Create"/>
</form>
