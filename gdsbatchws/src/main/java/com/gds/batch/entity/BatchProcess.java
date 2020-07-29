package com.gds.batch.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "BATCH_PROCESS")
@EntityListeners(AuditingEntityListener.class)
public class BatchProcess implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "RECORD_KEY")
	private String recordKey;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "PROCESS_CREATION_DATE")
	@CreatedDate
	private Date processCreationDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "PROCESS_UPDATE_DATE")
	@LastModifiedDate
	private Date processUpdateDate;

	@Column(name = "BATCH_PROCESS_TYPE")
	private String batchProcessType;

	@Column(name = "PROCESS_STATUS")
	private String processStatus;

	public BatchProcess() {

	}

	public BatchProcess(String batchProcessType) {
		setBatchProcessType(batchProcessType);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRecordKey() {
		return recordKey;
	}

	public void setRecordKey(String recordKey) {
		this.recordKey = recordKey;
	}

	public Date getProcessCreationDate() {
		return processCreationDate;
	}

	public void setProcessCreationDate(Date processCreationDate) {
		this.processCreationDate = processCreationDate;
	}

	public Date getProcessUpdateDate() {
		return processUpdateDate;
	}

	public void setProcessUpdateDate(Date processUpdateDate) {
		this.processUpdateDate = processUpdateDate;
	}

	public String getBatchProcessType() {
		return batchProcessType;
	}

	public void setBatchProcessType(String batchProcessType) {
		this.batchProcessType = batchProcessType;
	}

	public String getProcessStatus() {
		return processStatus;
	}

	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}

}
