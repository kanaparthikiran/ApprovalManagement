/*
 * Copyright 2019 Twitter. All Rights Reserved.
 *
 * This software is the proprietary information of Twitter.
 * Use is subject to license terms.
 */
package com.twitter.util;

/**
 * Followers implementation.
 *
 * @author Kiran Kanaparthi
 * @since October 15, 2019
 */
public class ValidationUtil {

	/**
	 * @param approvers
	 * @param changedFiles
	 * @return returns true if the parameter names are as expected
	 */
	public static boolean areValidParamNames(String approvers, String changedFiles) {
		return ApprovalConstants.PARAM_APPROVERS.equalsIgnoreCase(approvers) 
				&& ApprovalConstants.PARAM_CHANGED_FILES.equalsIgnoreCase(changedFiles);
	}
}
