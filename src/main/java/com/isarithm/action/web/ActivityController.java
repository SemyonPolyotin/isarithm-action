package com.isarithm.action.web;

import com.isarithm.action.services.ActivityService;
import com.isarithm.action.web.model.ActivityResponse;
import com.isarithm.action.web.model.TimeRecordResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(ActivityController.baseUri)
public class ActivityController {
	static final String baseUri = "/activities";

	private final ActivityService activityService;

	@Autowired
	public ActivityController(ActivityService activityService) {
		this.activityService = activityService;
	}

	@RequestMapping(method = RequestMethod.GET, value = "")
	public Page<ActivityResponse> getActivities(@RequestParam(value = "page", defaultValue = "0") Integer page,
												@RequestParam(value = "size", defaultValue = "25") Integer size) {
		return activityService.getActivities(page, size)
				.map(ActivityResponse::new);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{activityId}")
	public ActivityResponse getActivity(@PathVariable("activityId") Integer activityId) {
		return new ActivityResponse(activityService.getActivity(activityId));
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{activityId}/records")
	public List<TimeRecordResponse> getTimeRecords(@PathVariable("activityId") Integer activityId) {
		return activityService.getTimeRecords(activityId)
				.stream()
				.map(TimeRecordResponse::new)
				.collect(Collectors.toList());
	}
}
