package br.com.zup.marvel.gateway.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(value = Include.NON_NULL)
public class ComicRootGateway {
	
	private int code;
	private String statuString;
	private String copyright;
	private String attributionText;
	private String attributionHTML;
	
	@JsonProperty(value = "data")
	private ComicDataGateway dataGateway;
	
	
	public ComicRootGateway() {
		super();
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getStatuString() {
		return statuString;
	}
	public void setStatuString(String statuString) {
		this.statuString = statuString;
	}
	public String getCopyright() {
		return copyright;
	}
	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}
	public String getAttributionText() {
		return attributionText;
	}
	public void setAttributionText(String attributionText) {
		this.attributionText = attributionText;
	}
	public String getAttributionHTML() {
		return attributionHTML;
	}
	public void setAttributionHTML(String attributionHTML) {
		this.attributionHTML = attributionHTML;
	}
	public ComicDataGateway getDataGateway() {
		return dataGateway;
	}
	public void setDataGateway(ComicDataGateway dataGateway) {
		this.dataGateway = dataGateway;
	}

	
}
