package com.isarithm.action.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "activities", schema = "action")
public class Activity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "activities_id")
	private Integer id;

	@Column(name = "activities_owner_id", nullable = false)
	private UUID ownerId;

	@Column(name = "activities_model_id", nullable = false)
	private UUID modelId;

	@Column(name = "activities_name", nullable = false)
	private String name;

	@Column(name = "activities_create_date", nullable = false)
	private Date createDate;

	@Column(name = "activities_last_update_date", nullable = false)
	private Date lastUpdateDate;

	@Column(name = "activities_tolerance", nullable = false)
	private Integer tolerance;

	@OneToMany(mappedBy = "activity", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<TimeRecord> timeRecords = new ArrayList<>();
}
