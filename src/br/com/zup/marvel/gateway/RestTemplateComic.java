 package br.com.zup.marvel.gateway;

import java.sql.Timestamp;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import br.com.zup.marvel.gateway.json.ComicRootGateway;

public class RestTemplateComic {

	@Autowired
	RestTemplate restTemplate;
	
	public ComicRootGateway buscaDadosAPIMarvel(int limit, int offset) {
		String comicResourceUrlString = "https://gateway.marvel.com:443/v1/public/comics?ts="+generateTimestamp()+"&apikey=5576cb1772688f0b79b587abcb380449&hash="+gerarHash()+"&limit="+limit+"&offset="+offset;	
		
		RestTemplate restTemplate = new RestTemplate();
	    ComicRootGateway responseEntity = restTemplate.getForObject(comicResourceUrlString, ComicRootGateway.class);
		
	    return responseEntity;
	}
	
	  public String generateTimestamp(){    
		  Timestamp timestamp = new Timestamp(System.currentTimeMillis());
          return Long.toString(timestamp.getTime());                     
  }   
	
	public String gerarHash() {
		
		String key = generateTimestamp() + "c43c18515636b8fd91bcb8749263137f6894ecb15576cb1772688f0b79b587abcb380449";
		String md5Hex = DigestUtils.md5Hex(key);
		
		return md5Hex;		
	}

}
