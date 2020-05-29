package br.com.zup.marvel.gateway;

import br.com.zup.marvel.entity.Comic;
import br.com.zup.marvel.gateway.json.ComicResultGateway;

public class ConverterComicGatewayToComic {

	public static Comic toComic(ComicResultGateway comicResultGateway) {
		Comic comic = new Comic();
		comic.setIdOrigin(comicResultGateway.getId());
		comic.setTitle(comicResultGateway.getTitle());
		comic.setEan(comicResultGateway.getEan());
		comic.setIsbn(comicResultGateway.getIsbn());
		comic.setDescription(comicResultGateway.getDescription());
		
		return comic;
	}
}
