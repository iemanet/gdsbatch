package com.gds.batch.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

/**
 * @author I_EMANET
 */
public class PrintJobWriter implements ItemWriter<String> {

	@Override
	public void write(List<? extends String> batchMessageStrings) throws Exception {
		for (String batchMessageString : batchMessageStrings) {
			System.out.println(batchMessageString);
		}
	}
}
