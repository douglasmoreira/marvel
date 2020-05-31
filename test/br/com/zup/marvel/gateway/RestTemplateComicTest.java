package br.com.zup.marvel.gateway;

import org.junit.Assert;
import org.junit.Test;

import br.com.zup.marvel.gateway.json.ComicRootGateway;

public class RestTemplateComicTest{

	@Test
	public void buscaDadosAPIMarvelTest() {
		
		//cenário
		RestTemplateComic restTemplateComic = new RestTemplateComic();
		
		//ação
		ComicRootGateway comicRootGateway = restTemplateComic.buscaDadosAPIMarvel(50, 0);
		
		//Verificação
		Assert.assertEquals(200, comicRootGateway.getCode());
	}
}
