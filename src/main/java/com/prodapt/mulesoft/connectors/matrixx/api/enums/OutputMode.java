package com.prodapt.mulesoft.connectors.matrixx.api.enums;

public enum OutputMode {
	JSON("json"),
	XML("xml");
	
	@SuppressWarnings("unused")
	private String outputModes;
	OutputMode(String outputModes) {
		this.outputModes = outputModes;
	}

}
