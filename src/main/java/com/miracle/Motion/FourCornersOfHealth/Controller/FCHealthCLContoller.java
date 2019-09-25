package com.miracle.Motion.FourCornersOfHealth.Controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miracle.Motion.FourCornersOfHealth.Entity.FCHealthCL;
import com.miracle.Motion.FourCornersOfHealth.Repos.FCHealthCLRepository;
import com.miracle.Motion.FourCornersOfHealth.Service.CommonService;

@RestController
@RequestMapping("/CL")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FCHealthCLContoller {
	
	@Autowired
	FCHealthCLRepository clRepository;
	
	@Autowired
	private CommonService commonService;
	
	  @GetMapping("/LoggedInUser")
	   public long getLoggedInUser() {
		   return commonService.getCurrentUserID();
	   }
	   
	   @GetMapping("/PatientCLs")
	   public List<FCHealthCL> retrievePatientCL() {
		   return clRepository.findAll();
	   }
	   
	   @PostMapping("/PatientCL")
	   public FCHealthCL newFCHealthCl(@RequestBody FCHealthCL fcChol) {
		   fcChol.setClDate(new Date());
		   fcChol.setPid(2);
		  // System.out.println(new Date());
		   return clRepository.save(fcChol);
	   }

	   @GetMapping("/CurrentCL/{patientId}")
	   public String recentClOfPatient(@PathVariable("patientId") long patientId, @Value("${clQuery}") String query) {
		  // System.out.println (query);
		   
		   long valueByPid = clRepository.findRecentValueByPid(patientId, query);
		   System.out.println (valueByPid);
		   if(valueByPid != 0)
			   return valueByPid+"";
		   else
			   return "No Patient Available";
	   }
	
}
