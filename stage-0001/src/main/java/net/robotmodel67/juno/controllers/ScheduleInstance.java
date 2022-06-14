package net.robotmodel67.juno.controllers;

import net.robotmodel67.juno.models.ProcessInstance;
import net.robotmodel67.juno.models.Schedule;

public class ScheduleInstance {
	
	private Schedule schedule;
	private ProcessInstance process;
	public Schedule getSchedule() {
		return schedule;
	}
	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}
	public ProcessInstance getProcess() {
		return process;
	}
	public void setProcess(ProcessInstance process) {
		this.process = process;
	}

	
}
