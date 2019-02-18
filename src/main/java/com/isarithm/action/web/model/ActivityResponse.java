package com.isarithm.action.web.model;

import com.isarithm.action.domain.Activity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
public class ActivityResponse {
	private Integer id;
	private UUID ownerId;
	private UUID modelId;
	private String name;
	private Date createDate;
	private Date lastUpdateDate;

	public ActivityResponse(Activity activity) {
		this.id = activity.getId();
		this.ownerId = activity.getOwnerId();
		this.modelId = activity.getModelId();
		this.name = activity.getName();
		this.createDate = activity.getCreateDate();
		this.lastUpdateDate = activity.getLastUpdateDate();
	}
}
