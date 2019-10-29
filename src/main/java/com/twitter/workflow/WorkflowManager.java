/*
 * Copyright 2019 Twitter. All Rights Reserved.
 *
 * This software is the proprietary information of Twitter.
 * Use is subject to license terms.
 */
package com.twitter.workflow;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.twitter.beans.ApprovalRequest;
import com.twitter.util.ApprovalUtil;
import com.twitter.util.IParameterParser;
/**
 * Implements Workflow Management logic.
 *
 * @author Kiran Kanaparthi
 * @since October 15, 2019
 */
@Service
public class WorkflowManager implements IWorkflowManager {

    @Autowired
	private IParameterParser parameterParser;
	
	@Override
	public boolean isValidWorkflow(Workflow workflow) {
		return false;
	}

	@Override
	public Workflow createWorkflow(ApprovalRequest validation) {
		Workflow workflow = new Workflow();
		
		List<String> filePaths = validation.getFiles();
		
		Map<String,List<String>> requiredApprovers =
				ApprovalUtil.getRequiredApprovers(filePaths);
		Map<String,List<String>> actualApproversMap = 
				ApprovalUtil.getActualApprovers(filePaths);
		return workflow;
	}


	@Override
	public void setNextWorkflow(Workflow workflow) {
		
	}

	
}
