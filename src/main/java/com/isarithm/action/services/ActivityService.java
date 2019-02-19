package com.isarithm.action.services;

import com.isarithm.action.domain.Activity;
import com.isarithm.action.domain.TimeRecord;
import com.isarithm.action.web.model.ActivityRequest;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ActivityService {
	Page<Activity> getActivities(Integer page, Integer size);
	Activity createActivity(ActivityRequest activityRequest);
	Activity getActivity(Integer id);
	Activity updateActivity(Integer id, ActivityRequest activityRequest);
	void deleteActivity(Integer id);

	List<TimeRecord> getTimeRecords(Integer activityId);
}
