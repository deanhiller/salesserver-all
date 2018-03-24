package com.sales.mysvr.base.tags;

import javax.inject.Inject;

import org.webpieces.templating.api.ConverterLookup;
import org.webpieces.templating.api.HtmlTagLookup;
import org.webpieces.templating.api.RouterLookup;
import org.webpieces.templating.api.TemplateConfig;
import org.webpieces.templating.impl.tags.CustomTag;
import org.webpieces.templating.impl.tags.FieldTag;

public class MyHtmlTagLookup extends HtmlTagLookup {

	@Inject
	public MyHtmlTagLookup(TemplateConfig config, RouterLookup lookup, ConverterLookup converter) {
		super(config, lookup, converter);
		//add any custom tags you like here...
		put(new CustomTag("/com/sales/mysvr/base/tags/mytag.tag"));
		put(new IdTag(converter, "/com/sales/mysvr/base/tags/id.tag"));
	}

	/**
	 * Override the Field Tag
	 */
	@Override
	protected void addFieldTag(TemplateConfig config) {
		//you can subclass FieldTag and add more of these if you have 2 or 3 styles
		put(new FieldTag(converter, "/com/sales/mysvr/base/tags/field.tag"));
	}
	
}
