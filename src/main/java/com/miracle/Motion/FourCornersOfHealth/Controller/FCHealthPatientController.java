package com.miracle.Motion.FourCornersOfHealth.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miracle.Motion.FourCornersOfHealth.Entity.PatientProfile;
import com.miracle.Motion.FourCornersOfHealth.Repos.PatientRepository;
import com.miracle.Motion.FourCornersOfHealth.Service.CommonService;

@RestController
@RequestMapping("/patientProfile")
public class FCHealthPatientController {
	
	@Autowired
	PatientRepository patientRepository;
	
	@Autowired
	private CommonService commonService;
	
	  @GetMapping("/LoggedInUser")
	   public long getLoggedInUser() {
		   return commonService.getCurrentUserID();
	   }
	   
	   @GetMapping("/Patients")
	   public List<PatientProfile> retrievePatients() {
		   return patientRepository.findAll();
	   }
	   
	   @PostMapping("/Patient")
	   public PatientProfile newFCHealthPatient(@RequestBody PatientProfile fchPatient) {
		   fchPatient.setUserId(commonService.getCurrentUserID());
		   return patientRepository.save(fchPatient);
	   }
	
//	   @GetMapping("/CurrentBP/{patientId}")
//	   public String recentBpOfPatient(@PathVariable("patientId") long patientId, @Value("${highBpQuery}") String query1, @Value("${lowBpQuery}") String query2) {
//		  // System.out.println (query);
//		   long highBp = bpRepository.findRecentValueByPid(patientId, query1);
//		   long lowBp = bpRepository.findRecentValueByPid(patientId, query2);
//		   if(highBp != 0 && lowBp != 0  )
//			   return highBp+"/"+ lowBp;
//		   else
//			   return "No Patient Available";
//	   }
}