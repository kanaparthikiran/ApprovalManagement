/*
 * Copyright 2019 Twitter. All Rights Reserved.
 *
 * This software is the proprietary information of Twitter.
 * Use is subject to license terms.
 */
package com.twitter.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.twitter.application.Application;
import com.twitter.beans.Approvals;

/*
 * Copyright 2019 Twitter. All Rights Reserved.
 *
 * This software is the proprietary information of Twitter.
 * Use is subject to license terms.
 */
/**
 * Parameter Parser implementation.
 *
 * @author Kiran Kanaparthi
 * @since October 15, 2019
 */
@Service
public class ParameterParser implements IParameterParser {

    private static final Logger logger = LoggerFactory.getLogger(ParameterParser.class);

    
	@Override
	public Approvals parseParams(String[] params) {
		Approvals approvals = new Approvals();
		if(params.length<ApprovalConstants.VALID_ARGUMENTS_COUNT) {
			throw new IllegalArgumentException(ApprovalConstants.ILLEGAL_ARGUMENTS);
		}
		String approvers = params[0];
		String approverNames = params[1];
		String changedFiles = params[2];
		String filePaths = params[3];
		List<String> approverList = new ArrayList<>();
		List<String> fileList = new ArrayList<>();

		if(ValidationUtil.areValidParamNames(approvers, changedFiles)) {
			String[] approverItems = approverNames.split(",");
			String[] fileItems = filePaths.split(",");
			
			Arrays.copyOf(approverItems, approverItems.length);
			Collections.addAll(approverList, approverItems);

			Arrays.copyOf(fileItems, fileItems.length);
			Collections.addAll(fileList, fileItems);
		} else {
			throw new IllegalArgumentException(ApprovalConstants.PARAM_NAME_INVALID);
		}
		approvals.setApprovers(approverList);
		approvals.setFiles(fileList);
		logger.info(" Approvals {} ",approvals);

		return approvals;
	}

	public static void main(String args[]) {
		args = new String[4];
		args[0] = "--approvers";
		args[1] =  "alovelace,ghopper";
		args[2] = "--changed-files";
		args[3] = "src/com/twitter/follow/Follow.java,src/com/twitter/user/User.java";
		Approvals approvals = new ParameterParser().parseParams(args);
		logger.info(" Approvals {} ",approvals);
		
	}


}
