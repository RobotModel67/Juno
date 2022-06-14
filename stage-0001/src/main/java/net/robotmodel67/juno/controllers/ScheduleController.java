package net.robotmodel67.juno.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.robotmodel67.juno.models.ActivityInstance;
import net.robotmodel67.juno.models.OperationInstance;
import net.robotmodel67.juno.models.Process;
import net.robotmodel67.juno.models.ProcessInstance;
import net.robotmodel67.juno.models.Schedule;
import net.robotmodel67.juno.models.TaskInstance;
import net.robotmodel67.juno.repos.ProcessRepository;
import net.robotmodel67.juno.repos.ScheduleRepository;
import net.robotmodel67.juno.repos.TaskInstanceRepository;
import net.robotmodel67.juno.repos.TaskRepository;
import net.robotmodel67.juno.repos.ActivityInstanceRepository;
import net.robotmodel67.juno.repos.ActivityRepository;
import net.robotmodel67.juno.repos.OperationInstanceRepository;
import net.robotmodel67.juno.repos.OperationRepository;
import net.robotmodel67.juno.repos.ProcessInstanceRepository;

@RestController
@RequestMapping(path = "/api/schedules")
public class ScheduleController {

	@Autowired
	private ScheduleRepository scheduleRepo;
	@Autowired
	private ProcessRepository processRepo;
	@Autowired
	private ProcessInstanceRepository processInstanceRepo;
	@Autowired
	private OperationRepository operationRepo;
	@Autowired
	private OperationInstanceRepository operationInstanceRepo;
	@Autowired
	private ActivityRepository activityRepo;
	@Autowired
	private ActivityInstanceRepository activityInstanceRepo;
	@Autowired
	private TaskRepository taskRepo;
	@Autowired
	private TaskInstanceRepository taskInstanceRepo;
	
	@GetMapping(path = "")
	public List<Schedule> list() {
		return scheduleRepo.findAll();
	}
	
	@PostMapping(path="")
	public Schedule create(@RequestBody Schedule schedule) {
		Schedule result = scheduleRepo.saveAndFlush(schedule);
		return result;
	}

	@GetMapping(path="/instances/{uuid}")
	public ScheduleInstance listInstance(@PathVariable String uuid) {
		ScheduleInstance result = new ScheduleInstance();
		Schedule schedule = scheduleRepo.findByUuid(uuid);
		result.setSchedule(schedule);
		ProcessInstance process = processInstanceRepo.findByScheduleId(schedule.getId());
		process.setProcess(processRepo.findById(process.getProcessId()).get());
				
		process.setOperations(getOperationInstances(process.getProcessId()));
		
		result.setProcess(process);
		return result;
	}
		
	private List<OperationInstance> getOperationInstances(long processInstanceId) {
		List<OperationInstance> operationInstances = operationInstanceRepo.findByProcessInstanceId(processInstanceId);
		for (OperationInstance operationInstance : operationInstances) {
			operationInstance.setOperation(operationRepo.findById(operationInstance.getOperationId()).get());
			operationInstance.setActivities(getActivityInstances(operationInstance.getOperationId()));
		}
		return operationInstances;
	}
	
	private List<ActivityInstance> getActivityInstances(long operationInstanceId) {
		List<ActivityInstance> activityInstances = activityInstanceRepo.findByOperationInstanceId(operationInstanceId);
		for (ActivityInstance activityInstance : activityInstances) {
			activityInstance.setActivity(activityRepo.findById(activityInstance.getActivityId()).get());
			activityInstance.setTasks(getTaskInstances(activityInstance.getActivityId()));
		}
		return activityInstances;
	}

	private List<TaskInstance> getTaskInstances(long activityInstanceId) {
		List<TaskInstance> taskInstances = taskInstanceRepo.findByActivityInstanceId(activityInstanceId);
		for (TaskInstance taskInstance : taskInstances) {
			taskInstance.setTask(taskRepo.findById(taskInstance.getTaskId()).get());
		}
		return taskInstances;
	}
	
	
}
