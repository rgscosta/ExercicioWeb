package br.com.ifpe.aulaweb.contato;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoRepository 
	extends JpaRepository<Contato, Integer> {

}
