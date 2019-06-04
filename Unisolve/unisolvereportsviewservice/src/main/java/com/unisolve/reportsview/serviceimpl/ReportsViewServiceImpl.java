package com.unisolve.reportsview.serviceimpl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import com.unisolve.reportsview.DTO.ReportsViewDto;
import com.unisolve.reportsview.DTO.ResultDTO;
import com.unisolve.reportsview.DTO.ResultListDTO;
import com.unisolve.reportsview.model.ReportsViewModel;
import com.unisolve.reportsview.repository.ReportsViewRepository;
import com.unisolve.reportsview.service.ReportsViewService;

/**
 * @author sumilon.mondal
 *
 */
@Service
@Transactional
public class ReportsViewServiceImpl implements ReportsViewService {
	
	@Autowired
	private ReportsViewRepository viewRepository;
	
	@Override
	public ResultDTO getReportById(Integer reportId) {
		System.out.println("reportId->"+reportId);
		List<ReportsViewModel> reportsDetailsList = viewRepository.getReportById(reportId);
		ResultDTO resultDTO = new ResultDTO();
		ReportsViewDto viewDTO = new ReportsViewDto();
		for (ReportsViewModel viewModel : reportsDetailsList) {
			viewDTO.setId(viewModel.getId());
			viewDTO.setUserId(viewModel.getUserId());
			viewDTO.setReportType(viewModel.getReportType());
			viewDTO.setReportTitle(viewModel.getReportTitle());
			viewDTO.setReportDesc(viewModel.getReportDesc());
			viewDTO.setReportCreatedDate(viewModel.getReportCreatedDate());
			viewDTO.setReportModifiedDate(viewModel.getReportModifiedDate());
			viewDTO.setImageUrl(viewModel.getImageurl());
			viewDTO.setComments(viewModel.getComments());
			viewDTO.setStatus(viewModel.getStatus());
			
		}
		resultDTO.setResults(viewDTO);
		System.out.println("resultDTO->"+resultDTO);
		return resultDTO;
	}

	@Override
	public ResultListDTO getAllReports(String categories) {
		List<ReportsViewModel> reportsDetailsList = viewRepository.getAllIssues(categories);
		ResultListDTO resultListDTO = new ResultListDTO();
		List<ReportsViewDto> viewDTOList = new ArrayList<ReportsViewDto>();
		for (ReportsViewModel viewModel : reportsDetailsList) {
			System.out.println("id->"+viewModel.getId());
			ReportsViewDto viewDTO = new ReportsViewDto();
			viewDTO.setId(viewModel.getId());
			viewDTO.setUserId(viewModel.getUserId());
			viewDTO.setReportType(viewModel.getReportType());
			viewDTO.setReportTitle(viewModel.getReportTitle());
			viewDTO.setReportDesc(viewModel.getReportDesc());
			viewDTO.setReportCreatedDate(viewModel.getReportCreatedDate());
			viewDTO.setReportModifiedDate(viewModel.getReportModifiedDate());
			viewDTO.setImageUrl(viewModel.getImageurl());
			viewDTO.setComments(viewModel.getComments());
			viewDTO.setStatus(viewModel.getStatus());
			viewDTOList.add(viewDTO);
			
		}
		resultListDTO.setResults(viewDTOList);
		return resultListDTO;
	}
	
	
}
