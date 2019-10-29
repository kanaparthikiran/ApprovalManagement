/**
 * 
 */
package com.twitter.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Main class that initializes the application
 *
 * @author Kiran Kanaparthi
 * @since October 15, 2019
 */
@Configuration
@ConfigurationProperties
public class ApprovalConfig {
    /**
	 * @return the approvers
	 */
	public String getApprovers() {
		return approvers;
	}
	/**
	 * @param approvers the approvers to set
	 */
	public void setApprovers(String approvers) {
		this.approvers = approvers;
	}
	/**
	 * @return the changed_files
	 */
	public String getChanged_files() {
		return changed_files;
	}
	/**
	 * @param changed_files the changed_files to set
	 */
	public void setChanged_files(String changed_files) {
		this.changed_files = changed_files;
	}
	private String approvers;
    private String changed_files;
}
