package br.com.iftm.adseventos.dao.impl;

import javax.transaction.Transactional;

import br.com.iftm.adseventos.dao.mysql.MySQLGenericDao;
import br.com.iftm.adseventos.services.domain.Participant;

public class ParticipantDao extends MySQLGenericDao<Participant> implements IParticipantDao {
	
	@Transactional
	public Participant add(Participant event) throws Exception {
		return super.save(event);
	}
	
}
