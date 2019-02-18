package com.isarithm.action.web.model;

import lombok.Data;

import java.util.UUID;

@Data
public class ActivityRequest {
	private UUID ownerId;
	private UUID modelId;
	private String name;
}
