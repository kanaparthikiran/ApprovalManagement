/*
 * Copyright 2019 Twitter. All Rights Reserved.
 *
 * This software is the proprietary information of Twitter.
 * Use is subject to license terms.
 */
package com.twitter.util;

/*
 * Copyright 2019 Twitter. All Rights Reserved.
 *
 * This software is the proprietary information of Twitter.
 * Use is subject to license terms.
 */
/**
 * Approval Management constants.
 *
 * @author Kiran Kanaparthi
 * @since October 15, 2019
 */
public class ApprovalConstants {
	private ApprovalConstants() {
		throw new IllegalStateException("Utility class, not meant to be instantiated");
	}
	public static final int VALID_ARGUMENTS_COUNT = 4;
	public static final String ILLEGAL_ARGUMENTS = "The Arguments count is less than four, Please provide valid number of arguments";
	public static final String PARAM_APPROVERS = "--approvers";
	public static final String PARAM_CHANGED_FILES = "--changed-files";
	public static final String PARAM_NAME_INVALID = "The Parameter names are Invalid, Please enter Valid Parameter Names";

}
