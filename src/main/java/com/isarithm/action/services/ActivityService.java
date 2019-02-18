package com.isarithm.action.services;

import com.isarithm.action.domain.Activity;
import com.isarithm.action.web.model.ActivityRequest;
import org.springframework.data.domain.Page;

public interface ActivityService {
	Page<Activity> getActivities(Integer page, Integer size);
	Activity createActivity(ActivityRequest activityRequest);
	Activity getActivity(Integer id);
	Activity updateActivity(Integer id, ActivityRequest activityRequest);
	void deleteActivity(Integer id);
}
