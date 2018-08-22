package org.chronos.web.app.services;

import org.chronos.web.app.model.StatusUpdate;
import org.chronos.web.app.repository.StatusUpdateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusUpdateService {
	
	@Autowired
	private StatusUpdateRepository statusUpdateRepository;
	
	public void save(StatusUpdate statusUpdate) {
		statusUpdateRepository.save(statusUpdate);
	}
	
	public StatusUpdate getLatest() {
		return statusUpdateRepository.findFirstByOrderByDateAddedDesc();
	}
}
