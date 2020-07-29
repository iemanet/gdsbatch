package com.gds.batch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gds.batch.entity.BatchProcess;
import com.gds.batch.listener.JobCompletionListener;
import com.gds.batch.processor.PrintJobProcessor;
import com.gds.batch.reader.PrintJobReader;
import com.gds.batch.writer.PrintJobWriter;

/**
 * @author I_EMANET
 */
@Configuration
@RestController
public class PrintJobConfig {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Autowired
	JobLauncher jobLauncher;

	@Autowired
	Job job;

	@Scheduled(cron = "0 */5 * * * ?")
	@RequestMapping("/printjobrun")
	public void printJobRun() {
		JobParameters jobParameters = new JobParametersBuilder().addLong("Time", System.currentTimeMillis())
				.toJobParameters();
		try {
			jobLauncher.run(job, jobParameters);
		} catch (JobExecutionAlreadyRunningException ex) {
			ex.printStackTrace();
		} catch (JobRestartException ex) {
			ex.printStackTrace();
		} catch (JobInstanceAlreadyCompleteException ex) {
			ex.printStackTrace();
		} catch (JobParametersInvalidException ex) {
			ex.printStackTrace();
		}
	}

	@Bean
	public Job printJob() {
		return jobBuilderFactory.get("printJob").listener(listener()).start(printStep()).build();
	}

	@Bean
	public Step printStep() {
		return stepBuilderFactory.get("printStep").<BatchProcess, String>chunk(1).reader(reader())
				.processor(processor()).writer(writer()).build();
	}

	@Bean
	public PrintJobReader reader() {
		return new PrintJobReader();
	}

	@Bean
	public PrintJobProcessor processor() {
		return new PrintJobProcessor();
	}

	@Bean
	public PrintJobWriter writer() {
		return new PrintJobWriter();
	}

	@Bean
	public JobExecutionListener listener() {
		return new JobCompletionListener();
	}

}
