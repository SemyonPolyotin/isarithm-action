package com.isarithm.action.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "time_records", schema = "action")
public class TimeRecord {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "time_records_id")
	private Integer id;

	@Column(name = "time_records_order", nullable = false)
	private Integer order;

	@Column(name = "time_records_angle_x", nullable = false)
	private Integer angleX;

	@Column(name = "time_records_angle_y", nullable = false)
	private Integer angleY;

	@Column(name = "time_records_angle_z", nullable = false)
	private Integer angleZ;

	@Column(name = "time_records_acceleration_x", nullable = false)
	private Integer accelerationX;

	@Column(name = "time_records_acceleration_y", nullable = false)
	private Integer accelerationY;

	@Column(name = "time_records_acceleration_z", nullable = false)
	private Integer accelerationZ;

	@ManyToOne
	@JoinColumn(name = "time_records_activity_id")
	private Activity activity;
}
