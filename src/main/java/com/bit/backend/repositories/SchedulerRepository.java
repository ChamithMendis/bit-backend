package com.bit.backend.repositories;

import com.bit.backend.entities.SchedulerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchedulerRepository  extends JpaRepository<SchedulerEntity, Long> {
}
