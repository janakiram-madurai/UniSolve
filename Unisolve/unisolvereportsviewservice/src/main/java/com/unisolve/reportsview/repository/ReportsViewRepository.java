package com.unisolve.reportsview.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.unisolve.reportsview.model.ReportsViewModel;

/**
 * @author sumilon.mondal
 *
 */
public interface ReportsViewRepository extends JpaRepository<ReportsViewModel, Integer> {
	
	
/*	
 * Native Query sample
 */
	
	@Query(value="SELECT * from report_details where id = ?1", nativeQuery=true)
	public List<ReportsViewModel> getReportById(Integer id);
	
	
	
	/*@Query("SELECT id,userId,reportCreatedDate,reportModifiedDate,comments,imageurl,"
			+ "reportDesc,reportTitle,reportType,status from ReportsViewModel where id = :id")
	public List<ReportsViewModel> getReportById(@Param("id") Integer id);*/
	
	
	@Query(value="SELECT * from report_details where report_type = ?1", nativeQuery=true)
	public List<ReportsViewModel> getAllIssues(String report_type);
}
