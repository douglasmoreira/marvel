package br.com.zup.marvel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.marvel.entity.Comic;

@Repository
public interface ComicRepository extends JpaRepository<Comic, Long>{

}
