package com.tistory.antop.framework.support;

import java.text.MessageFormat;
import java.util.Locale;

import org.springframework.context.support.AbstractMessageSource;

public class DatabaseMessageResource extends AbstractMessageSource {

	private MessageSource messageSource;

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@Override
	protected MessageFormat resolveCode(String code, Locale locale) {
		MessageFormat mf = null;

		String lang = locale.getLanguage();
		String message = messageSource.getMessage(code, lang);

		if (message == null) {
			mf = new MessageFormat(code + "." + lang);
		} else {
			mf = new MessageFormat(message, locale);
		}

		return mf;
	}

}
