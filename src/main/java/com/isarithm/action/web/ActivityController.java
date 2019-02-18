package com.isarithm.action.web;

import com.isarithm.action.services.ActivityService;
import com.isarithm.action.web.model.ActivityResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

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
}
