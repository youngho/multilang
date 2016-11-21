function doRemove(code, language) {
	var bool = confirm(locale['confirm.remove']);
	
	if(bool == true) {
		var params = {
			'code' : code,
			'language' : language
		};
		
		document.location.href = context['contextPath']
			+ '/i18n/detail/remove' + '?' + Ext.Object.toQueryString(params);
	}
}