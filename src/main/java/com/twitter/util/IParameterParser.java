/*
 * Copyright 2019 Twitter. All Rights Reserved.
 *
 * This software is the proprietary information of Twitter.
 * Use is subject to license terms.
 */
package com.twitter.util;

import com.twitter.beans.ApprovalRequest;

/*
 * Copyright 2019 Twitter. All Rights Reserved.
 *
 * This software is the proprietary information of Twitter.
 * Use is subject to license terms.
 */
/**
 * Parameter Parser interface.
 *
 * @author Kiran Kanaparthi
 * @since October 15, 2019
 */
public interface IParameterParser {
	ApprovalRequest parseParams(String params);
}
