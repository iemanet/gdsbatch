package com.gds.batch.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gds.batch.entity.BatchProcess;
import com.gds.batch.repository.BatchProcessRepository;

@Component
public class BatchProcessDao {

    @Autowired
    private static BatchProcessRepository batchProcessRepository;

    public static void createOrUpdate(BatchProcess batchProcess) {
        batchProcessRepository.save(batchProcess);
    }
}
