package com.unisolve.reportsview.service;

import java.util.List;


import com.unisolve.reportsview.DTO.ReportsViewDto;
import com.unisolve.reportsview.DTO.ResultDTO;
import com.unisolve.reportsview.DTO.ResultListDTO;

/**
 * @author Janakiram.ela
 *
 */
public interface ReportsViewService {

	public ResultDTO getReportById(Integer reportId);
	
	public ResultListDTO getAllReports(String categories);
	
	
}
