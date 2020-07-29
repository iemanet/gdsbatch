package com.gds.batch.reader;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ItemReader;

import com.gds.batch.entity.BatchProcess;
import com.gds.batch.enums.BatchProcessTypeEnum;

/**
 * @author I_EMANET
 */
public class PrintJobReader implements ItemReader<BatchProcess> {

    private List<BatchProcess> batchProcessList = new ArrayList<BatchProcess>();

    private int count = 0;

    public PrintJobReader() {
        initialize();
    }

    private void initialize() {
        batchProcessList = new ArrayList<BatchProcess>();
        batchProcessList.add(new BatchProcess(BatchProcessTypeEnum.PAYBACK.name()));
        batchProcessList.add(new BatchProcess(BatchProcessTypeEnum.SMS.name()));
        batchProcessList.add(new BatchProcess(BatchProcessTypeEnum.MAIL.name()));
        batchProcessList.add(new BatchProcess(BatchProcessTypeEnum.CANCEL_RESERVATION.name()));
        count = 0;
    }

    @Override
    public BatchProcess read() {
        if (count < batchProcessList.size()) {
            return batchProcessList.get(count++);
        } else {
            initialize();
            return null;
        }
    }
}
