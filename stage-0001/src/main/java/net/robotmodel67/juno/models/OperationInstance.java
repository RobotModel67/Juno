package net.robotmodel67.juno.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "operationInstances")
public class OperationInstance {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String uuid;
	private long processInstanceId;
	private long operationId;
	private int state;
	private Date startDate;
	private Date closeDate;
	private String evidences;
	
	@Transient
	private Operation operation;
	@Transient
	private List<ActivityInstance> activities;
		
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public long getProcessInstanceId() {
		return processInstanceId;
	}
	public void setProcessInstanceId(long processInstanceId) {
		this.processInstanceId = processInstanceId;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getCloseDate() {
		return closeDate;
	}
	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}
	public String getEvidences() {
		return evidences;
	}
	public void setEvidences(String evidences) {
		this.evidences = evidences;
	}
	public long getOperationId() {
		return operationId;
	}
	public void setOperationId(long operationId) {
		this.operationId = operationId;
	}
	public Operation getOperation() {
		return operation;
	}
	public void setOperation(Operation operation) {
		this.operation = operation;
	}
	public List<ActivityInstance> getActivities() {
		return activities;
	}
	public void setActivities(List<ActivityInstance> activities) {
		this.activities = activities;
	}	
	
}

