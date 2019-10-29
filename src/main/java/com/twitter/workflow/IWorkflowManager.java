/*
 * Copyright 2019 Twitter. All Rights Reserved.
 *
 * This software is the proprietary information of Twitter.
 * Use is subject to license terms.
 */
package com.twitter.workflow;

import com.twitter.beans.ApprovalRequest;

/**
 * Followers implementation.
 *
 * @author Kiran Kanaparthi
 * @since October 15, 2019
 */
public interface IWorkflowManager {
	
	public boolean isValidWorkflow(Workflow workflow);
	
	public Workflow createWorkflow(ApprovalRequest validation);
	
	public void setNextWorkflow(Workflow workflow);
}
