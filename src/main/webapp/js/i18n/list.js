function doRemove(code) {
	var bool = confirm(locale['confirm.remove']);
	
	if(bool == true) {
		var params = {
			'code' : code
		};
		
		document.location.href = context['contextPath']
			+ '/i18n/remove' + '?' + Ext.Object.toQueryString(params);
	}
}