package com.isarithm.action.web.model;

import com.isarithm.action.domain.TimeRecord;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TimeRecordResponse {
	private Integer id;
	private Integer order;
	private Integer activityId;
	private Integer angleX;
	private Integer angleY;
	private Integer angleZ;
	private Integer accelerationX;
	private Integer accelerationY;
	private Integer accelerationZ;

	public TimeRecordResponse(TimeRecord timeRecord) {
		this.id = timeRecord.getId();
		this.order = timeRecord.getOrder();
		this.activityId = timeRecord.getActivity().getId();
		this.angleX = timeRecord.getAngleX();
		this.angleY = timeRecord.getAngleY();
		this.angleZ = timeRecord.getAngleZ();
		this.accelerationX = timeRecord.getAccelerationX();
		this.accelerationY = timeRecord.getAccelerationY();
		this.accelerationZ = timeRecord.getAccelerationZ();
	}
}
