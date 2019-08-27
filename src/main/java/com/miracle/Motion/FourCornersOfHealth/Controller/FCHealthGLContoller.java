package com.miracle.Motion.FourCornersOfHealth.Controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miracle.Motion.FourCornersOfHealth.Entity.FCHealthGL;
import com.miracle.Motion.FourCornersOfHealth.Entity.FCHealthWeight;
import com.miracle.Motion.FourCornersOfHealth.Repos.FCHealthGLRepository;
import com.miracle.Motion.FourCornersOfHealth.Service.CommonService;

@RestController
@RequestMapping("/GL")
public class FCHealthGLContoller {
	
	@Autowired
	FCHealthGLRepository glRepository;
	
	@Autowired
	private CommonService commonService;
	
	  @GetMapping("/LoggedInUser")
	   public long getLoggedInUser() {
		   return commonService.getCurrentUserID();
	   }
	   
	   @GetMapping("/PatientGLs")
	   public List<FCHealthGL> retrievePatientGL() {
		   return glRepository.findAll();
	   }
	   
	   @PostMapping("/PatientGL")
	   public FCHealthGL newFCHealthGL(@RequestBody FCHealthGL fcGlucose) {
		   fcGlucose.setGlDate(new Date());
		  // System.out.println(new Date());
		   return glRepository.save(fcGlucose);
	   }

	   @GetMapping("/CurrentGL/{patientId}")
	   public String recentGlOfPatient(@PathVariable("patientId") long patientId, @Value("${glQuery}") String query) {
		  // System.out.println (query);
		   long valueByPid = glRepository.findRecentValueByPid(patientId, query);
		   if(valueByPid != 0)
			   return valueByPid+"";
		   else
			   return "No Patient Available";
	   }
	

}