package com.unipe.springproject.repository;

import com.unipe.springproject.domain.Task;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TaskRepository extends JpaRepository<Task, Long> {
	
	@Query("SELECT t FROM Task t WHERE t.startDate >= :startDate AND t.endDate <= :endDate")
    public List<Task> findByDateRange(
    		@Param("startDate") Date startDate, 
    		@Param("endDate") Date endDate);
	
	@Query("SELECT t FROM Task t WHERE t.startDate >= :startDate AND t.endDate <= :endDate AND t.status = :status")
    public List<Task> findByDateRangeWithStatus(
    		@Param("startDate") Date startDate, 
    		@Param("endDate") Date endDate,
    		@Param("status") Integer status);
}
