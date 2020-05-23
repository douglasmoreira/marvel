package br.com.zup.marvel.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zup.marvel.gateway.ConverterComicGatewayToComic;
import br.com.zup.marvel.gateway.RestTemplateComic;
import br.com.zup.marvel.gateway.json.ComicResultGateway;
import br.com.zup.marvel.gateway.json.ComicRootGateway;
import br.com.zup.marvel.repository.ComicRepository;

@Service
public class ComicService {

	RestTemplateComic restTemplateComic = new RestTemplateComic();
	
	@Autowired
	ComicRepository comicRepository;
	
	public List<ComicResultGateway> salvaComic() {
		
		ComicRootGateway comicRootGateway = restTemplateComic.buscaDadosAPIMarvel(50,0);
		List<ComicResultGateway> comicResultGatewayList = comicRootGateway.getDataGateway().getResultGateways();
		
		for (ComicResultGateway comicResultGateway : comicResultGatewayList) {
			comicRepository.save(ConverterComicGatewayToComic.toComic(comicResultGateway));
		}
		
		return comicResultGatewayList;
	}
}
