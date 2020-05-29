package br.com.zup.marvel.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.marvel.Service.ComicService;
import br.com.zup.marvel.gateway.json.ComicResultGateway;

@RestController
@RequestMapping("/sincronizar/comic")
public class ComicControler {

	@Autowired
	ComicService comicService;
	
	@GetMapping
	public List<ComicResultGateway> get() {
		return comicService.salvaComic();
	}
	
}
