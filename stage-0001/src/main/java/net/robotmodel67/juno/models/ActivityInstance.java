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
@Table(name = "activityInstances")
public class ActivityInstance {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String uuid;
	private long operationInstanceId;
	private long activityId;	
	private int state;
	private Date startDate;
	private Date closeDate;
	private String evidences;

	@Transient
	private Activity activity;
	@Transient
	private List<TaskInstance> tasks;
	
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
	public long getOperationInstanceId() {
		return operationInstanceId;
	}
	public void setOperationInstanceId(long operationInstanceId) {
		this.operationInstanceId = operationInstanceId;
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
	public long getActivityId() {
		return activityId;
	}
	public void setActivityId(long activityId) {
		this.activityId = activityId;
	}
	public Activity getActivity() {
		return activity;
	}
	public void setActivity(Activity activity) {
		this.activity = activity;
	}
	public List<TaskInstance> getTasks() {
		return tasks;
	}
	public void setTasks(List<TaskInstance> tasks) {
		this.tasks = tasks;
	}
	
}

