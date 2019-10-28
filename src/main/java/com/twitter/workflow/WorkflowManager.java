/*
 * Copyright 2019 Twitter. All Rights Reserved.
 *
 * This software is the proprietary information of Twitter.
 * Use is subject to license terms.
 */
package com.twitter.workflow;

import com.twitter.beans.Approvals;

/**
 * Implements Workflow Management logic.
 *
 * @author Kiran Kanaparthi
 * @since October 15, 2019
 */
public class WorkflowManager implements IWorkflowManager {

	@Override
	public boolean isValidWorkflow(Workflow workflow) {
		return false;
	}

	@Override
	public Workflow createWorkflow(Approvals validation) {
		return null;
	}

	
}
