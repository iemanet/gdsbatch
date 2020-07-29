package com.gds.batch.processor;

import org.springframework.batch.item.ItemProcessor;

import com.gds.batch.entity.BatchProcess;

/**
 * @author I_EMANET
 */
public class PrintJobProcessor implements ItemProcessor<BatchProcess, String> {

    @Override
    public String process(BatchProcess batchProcess) throws Exception {

        StringBuffer batchMessageStringBuffer = new StringBuffer();

        if (batchProcess.getId() != null) {
            batchMessageStringBuffer.append("\n");
            batchMessageStringBuffer.append("Batch job id:");
            batchMessageStringBuffer.append(batchProcess.getId());
            batchMessageStringBuffer.append("\n");
        }

        if (batchProcess.getBatchProcessType() != null && !batchProcess.getBatchProcessType().isEmpty()) {
            batchMessageStringBuffer.append("\n");
            batchMessageStringBuffer.append("Batch job process type:");
            batchMessageStringBuffer.append(batchProcess.getBatchProcessType());
            batchMessageStringBuffer.append("\n");
        }

        if (batchProcess.getProcessStatus() != null && !batchProcess.getProcessStatus().isEmpty()) {
            batchMessageStringBuffer.append("\n");
            batchMessageStringBuffer.append("Batch job process status:");
            batchMessageStringBuffer.append(batchProcess.getProcessStatus());
            batchMessageStringBuffer.append("\n");
        }

        if (batchProcess.getProcessCreationDate() != null) {
            batchMessageStringBuffer.append("\n");
            batchMessageStringBuffer.append("Batch job process creation date:");
            batchMessageStringBuffer.append(batchProcess.getProcessCreationDate());
            batchMessageStringBuffer.append("\n");
        }

        if (batchProcess.getProcessUpdateDate() != null) {
            batchMessageStringBuffer.append("\n");
            batchMessageStringBuffer.append("Batch job process update date:");
            batchMessageStringBuffer.append(batchProcess.getProcessUpdateDate());
            batchMessageStringBuffer.append("\n");
        }

        if (batchProcess.getRecordKey() != null && !batchProcess.getRecordKey().isEmpty()) {
            batchMessageStringBuffer.append("\n");
            batchMessageStringBuffer.append("Batch job record key:");
            batchMessageStringBuffer.append(batchProcess.getRecordKey());
            batchMessageStringBuffer.append("\n");
        }

        return batchMessageStringBuffer.toString();
    }
}
