package br.com.iftm.adseventos.dao.impl;

import br.com.iftm.adseventos.services.domain.Participant;

public interface IParticipantDao {

	Participant add(Participant participant) throws Exception;
	
}