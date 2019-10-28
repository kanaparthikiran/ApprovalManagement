/*
 * Copyright 2019 Twitter. All Rights Reserved.
 *
 * This software is the proprietary information of Twitter.
 * Use is subject to license terms.
 */
package com.twitter.beans;

import java.util.List;

/**
 * Encapsulates user inputs for Validation.
 *
 * @author Kiran Kanaparthi
 * @since October 15, 2019
 */
public class Validation {
	
	private List<String> approvers;
	private List<String> files;
	
	/**
	 * @return the approvers
	 */
	public List<String> getApprovers() {
		return approvers;
	}
	/**
	 * @param approvers the approvers to set
	 */
	public void setApprovers(List<String> approvers) {
		this.approvers = approvers;
	}
	/**
	 * @return the files
	 */
	public List<String> getFiles() {
		return files;
	}
	/**
	 * @param files the files to set
	 */
	public void setFiles(List<String> files) {
		this.files = files;
	}
	@Override
	public String toString() {
		return "Approvers [approvers=" + approvers + ", files=" + files + "]";
	}
	
}
