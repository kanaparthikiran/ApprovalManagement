/*
 * Copyright 2019 Twitter. All Rights Reserved.
 *
 * This software is the proprietary information of Twitter.
 * Use is subject to license terms.
 */
package com.twitter.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
/**
 * Utility class for various approval management functionalities.
 *
 * @author Kiran Kanaparthi
 * @since October 15, 2019
 */
public class ApprovalUtil {

    private static final Logger logger = LoggerFactory.getLogger(ApprovalUtil.class);
	
	/**
	 * 
	 */
	private ApprovalUtil() {
			throw new IllegalStateException("Utility class, not meant to be instantiated");
	}
	
	/**
	 * @param approvers approver Param Name
	 * @param changedFiles changed file Param Name
	 * @return returns true if the parameter names are as expected
	 */
	public static boolean areValidParamNames(String approvers, String changedFiles) {
		return ApprovalConstants.PARAM_APPROVERS.equalsIgnoreCase(approvers) 
				&& ApprovalConstants.PARAM_CHANGED_FILES.equalsIgnoreCase(changedFiles);
	}
	
	/**
	 * Gets the List of Approvers required for a given file
	 * 
	 * @param filePaths input file Paths
	 * @return returns the mapping from fileName to the List of Approvers 
	 */
	public static Map<String,List<String>> getRequiredApprovers(List<String> filePaths) {
		Map<String,List<String>> mapping  = new HashMap<>();
		if(CollectionUtils.isEmpty(filePaths)) {
			return Collections.unmodifiableMap(mapping);
		}
		//Get all files at the given path and the dependency paths
		List<String> filesAtPath = new ArrayList<>();
		for(String filePath : filePaths) {
			List<String> dependencyFiles = getDependencies(filePath);
			if(!CollectionUtils.isEmpty(dependencyFiles)) {
				filesAtPath.addAll(dependencyFiles);
			}
			//Get Owners for all the files at the original path and at the dependency files
			getOwnersOrApprovers(filePath);
		}
		return mapping;
	}
	
	/**
	 * Gets the Actual Approvers Map for the given list of files
	 * @param filePaths filePaths
	 * @return returns the mapping of files to the actual approvers
	 */
	public static Map<String,List<String>> getActualApprovers(List<String> filePaths) {
		Map<String,List<String>> mapping  = new HashMap<>();
		if(CollectionUtils.isEmpty(filePaths)) {
			return Collections.unmodifiableMap(mapping);
		}
		//Get all files at the given path and the dependency paths
		List<String> filesAtPath = new ArrayList<>();
		for(String filePath : filePaths) {
			List<String> dependencyFiles = getDependencies(filePath);
			if(!CollectionUtils.isEmpty(dependencyFiles)) {
				filesAtPath.addAll(dependencyFiles);
			}
			//Get Owners for all the files at the original path and at the dependency files
			getOwnersOrApprovers(filePath);
		}
		return mapping;
	}
	
	/**
	 * 
	 * @param filePath File Path
	 * @return returns the dependencies for the filePath
	 */
	public static List<String> getDependencies(String filePath) {
		List<String> dependencies = new ArrayList<>();
		if(StringUtils.isEmpty(filePath)) {
			return Collections.unmodifiableList(dependencies);
		}
		parseDependencies(filePath);
		return dependencies;
	}
	
	/**
	 * Gets the owners of the files at the given path
	 * @param filePath file path
	 * @return returns the list of owners for the file at the path
	 */
	public static List<String> getOwnersOrApprovers(String filePath) {
		return null;
	}
	
	/**
	 * Get the mapping for file to Approvers
	 * 
	 * @param filePaths paths of the files
	 * @return retruns the mapping from files to approvers
	 */
	public static Map<String,List<String>> getFilesAndDependencies(List<String> filePaths) {
		return null;
	}
	
	
	/**
	 * Parse the dependencies for the given file at the path
	 * 
	 * @param filePath reads the file at the given path
	 * @return returns the dependencies
	 */
	public static List<String> parseDependencies(String filePath) {
		List<String> dependencies = new ArrayList<>();
		if(StringUtils.isEmpty(filePath)) {
			return Collections.unmodifiableList(dependencies);
		}
		logger.info(" filePath for Parsing the dependencies file {} ",filePath);
		try (BufferedReader br = Files.newBufferedReader(Paths.get(filePath))) {
			dependencies = br.lines().collect(Collectors.toList());
		} catch (IOException e) {
			logger.error("The Exception while parsing the dependencies ",e);
		}
		return dependencies;
	}
}
