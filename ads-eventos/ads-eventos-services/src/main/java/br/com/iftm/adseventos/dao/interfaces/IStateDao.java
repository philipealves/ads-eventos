package br.com.iftm.adseventos.dao.interfaces;

import java.util.List;

import br.com.iftm.adseventos.services.domain.State;

public interface IStateDao {

	List<State> findAll() throws Exception;

	State findById(Long id) throws Exception;

}
