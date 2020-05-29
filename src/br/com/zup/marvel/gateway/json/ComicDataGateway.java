package br.com.zup.marvel.gateway.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class ComicDataGateway {

	private int offset;
	private int limit;
	private int total;
	private int count;
	
	@JsonProperty(value = "results")
	List<ComicResultGateway> resultGateways;
	
	public ComicDataGateway() {
		super();
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<ComicResultGateway> getResultGateways() {
		return resultGateways;
	}

	public void setResultGateways(List<ComicResultGateway> resultGateways) {
		this.resultGateways = resultGateways;
	}
	
	
	
}
