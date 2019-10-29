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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.twitter.beans.ApprovalRequest;
import com.twitter.config.ApprovalConfig;
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

//    @Autowired
//    private ApprovalConfig approvalConfig;
    
	@Override
	public ApprovalRequest parseParams(String params) {
		ApprovalRequest approvals = new ApprovalRequest();
		String[] allParams = params.split("\\s+");
		logger.info(" Parameters as is {}  params length{}",Arrays.toString(allParams),allParams.length);
		if(allParams.length<ApprovalConstants.VALID_ARGUMENTS_COUNT) {
			throw new IllegalArgumentException(ApprovalConstants.ILLEGAL_ARGUMENTS);
		}
		String approvers = allParams[0];
		String approverNames = allParams[1];
		String changedFiles = allParams[2];
		String filePaths = allParams[3];
		List<String> approverList = new ArrayList<>();
		List<String> fileList = new ArrayList<>();
		
		if(ApprovalUtil.areValidParamNames(approvers, changedFiles)) {
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
}
