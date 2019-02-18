package com.isarithm.action.services;

import com.isarithm.action.domain.Activity;
import com.isarithm.action.repository.ActivityRepository;
import com.isarithm.action.web.model.ActivityRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ActivityServiceImpl
		implements ActivityService {
	private final ActivityRepository activityRepository;

	@Autowired
	public ActivityServiceImpl(ActivityRepository activityRepository) {
		this.activityRepository = activityRepository;
	}

	@Override
	public Page<Activity> getActivities(Integer page, Integer size) {
		return activityRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public Activity createActivity(ActivityRequest activityRequest) {
		Activity activity = new Activity()
				.setOwnerId(activityRequest.getOwnerId())
				.setName(activityRequest.getName())
				.setCreateDate(new Date())
				.setLastUpdateDate(new Date());
		return activityRepository.save(activity);
	}

	@Override
	public Activity getActivity(Integer id) {
		return activityRepository.getOne(id);
	}

	@Override
	public Activity updateActivity(Integer id, ActivityRequest activityRequest) {
		Activity activity = this.getActivity(id);
		if (activityRequest.getName() != null) activity.setName(activityRequest.getName());
		return activityRepository.save(activity);
	}

	@Override
	public void deleteActivity(Integer id) {
		activityRepository.deleteById(id);
	}
}
