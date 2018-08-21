package org.chronos.web.app.repository;

import org.chronos.web.app.model.StatusUpdate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusUpdateRepository extends JpaRepository<StatusUpdate, Long> 
{
	StatusUpdate findFirstByOrderByAddedDesc();
}