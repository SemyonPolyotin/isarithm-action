package com.isarithm.action.repository;

import com.isarithm.action.domain.TimeRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeRecordRepository
		extends JpaRepository<TimeRecord, Integer> {
}
