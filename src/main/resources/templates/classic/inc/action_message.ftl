<#if msg??>
	<div class="alert alert-danger">
		<#--<button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span></button>-->
		${msg}
	</div>
</#if>
<#if data??>
	<#if (data.code >0)>
		<div class="alert alert-success">
			<#--<button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span></button>-->
			${data.msg}
		</div>
	<#else>
		<div class="alert alert-danger">
			<#--<button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span></button>-->
			${data.msg}
		</div>
	</#if>
</#if>