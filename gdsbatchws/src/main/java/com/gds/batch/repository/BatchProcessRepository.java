package com.gds.batch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gds.batch.entity.BatchProcess;

/**
 * @author I_EMANET
 */
@Repository
public interface BatchProcessRepository extends JpaRepository<BatchProcess, Long>
{

}

