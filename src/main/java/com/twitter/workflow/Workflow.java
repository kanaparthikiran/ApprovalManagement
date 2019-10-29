/*
 * Copyright 2019 Twitter. All Rights Reserved.
 *
 * This software is the proprietary information of Twitter.
 * Use is subject to license terms.
 */
package com.twitter.workflow;

import java.util.List;
import java.util.Map;

/**
 * Workflow for the Approval Management.
 *
 * @author Kiran Kanaparthi
 * @since October 15, 2019
 */
public class Workflow {

	private Map<String,List<String>> filesToActualApproversMap;
	private Map<String,List<String>> filesToRequiredApproversMap;
	
	/**
	 * @return the filesToActualApproversMap
	 */
	public Map<String, List<String>> getFilesToActualApproversMap() {
		return filesToActualApproversMap;
	}
	/**
	 * @param filesToActualApproversMap the filesToActualApproversMap to set
	 */
	public void setFilesToActualApproversMap(Map<String, List<String>> filesToActualApproversMap) {
		this.filesToActualApproversMap = filesToActualApproversMap;
	}
	/**
	 * @return the filesToRequiredApproversMap
	 */
	public Map<String, List<String>> getFilesToRequiredApproversMap() {
		return filesToRequiredApproversMap;
	}
	/**
	 * @param filesToRequiredApproversMap the filesToRequiredApproversMap to set
	 */
	public void setFilesToRequiredApproversMap(Map<String, List<String>> filesToRequiredApproversMap) {
		this.filesToRequiredApproversMap = filesToRequiredApproversMap;
	}


}
