package com.acme;



import javax.validation.constraints.NotNull;

import org.springframework.xd.module.options.spi.ModuleOption;

public class XsltTransformerOptionsMetaData {

	private String xslt;


	@ModuleOption("XSLT File that will be processing the incoming message data.")
	public void setXslt(String xslt) {
		System.out.println("xsltFile passed... "+xslt);
		this.xslt = xslt;
	}

	@NotNull
	public String getXslt() {		
		return xslt;
	}
	


}
