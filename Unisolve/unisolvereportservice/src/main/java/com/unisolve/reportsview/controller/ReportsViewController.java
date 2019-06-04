package com.unisolve.reportsview.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unisolve.reportsview.DTO.ReportsViewDto;
import com.unisolve.reportsview.DTO.ResultDTO;
import com.unisolve.reportsview.repository.ReportsViewRepository;
import com.unisolve.reportsview.service.ReportsViewService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author sumilon.mondal
 *
 */
@RestController
@CrossOrigin("*")
@Api(value = "ReportsView-service", description = "All Operations for Ordering Commodity")
public class ReportsViewController {

	@Autowired
	private ReportsViewService viewService;

	private static final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	/**
	 * @param ordId - orderId
	 * @return OrderDTO object
	 */
	@ApiOperation(value = "Get Issue Details based on ID")
	@GetMapping("/get_issue_details/{reportId}")
	public ResponseEntity<ResultDTO> getReportDetailsById(@PathVariable("reportId") Integer reportId) {
		System.out.println("report id ->"+reportId);
		return Optional.ofNullable(viewService.getReportById(reportId))
				.map(e -> new ResponseEntity<>(e, HttpStatus.OK))
				.orElseThrow(() -> new RuntimeException("Error in report details"));
	}

}
