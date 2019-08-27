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

import com.miracle.Motion.FourCornersOfHealth.Entity.FCHealthBP;
import com.miracle.Motion.FourCornersOfHealth.Repos.FCHealthBPRepository;
import com.miracle.Motion.FourCornersOfHealth.Service.CommonService;

@RestController
@RequestMapping("/BP")
public class FCHealthBPController {
	
	@Autowired
	FCHealthBPRepository bpRepository;
	
	@Autowired
	private CommonService commonService;
	
	  @GetMapping("/LoggedInUser")
	   public long getLoggedInUser() {
		   return commonService.getCurrentUserID();
	   }
	   
	   @GetMapping("/PatientBPs")
	   public List<FCHealthBP> retrievePatientBP() {
		   return bpRepository.findAll();
	   }
	   
	   @PostMapping("/PatientBP")
	   public FCHealthBP newFCHealthBP(@RequestBody FCHealthBP fchBP) {
		   fchBP.setBpDate(new Date());
		  // System.out.println(new Date());
		   return bpRepository.save(fchBP);
	   }

	   @GetMapping("/CurrentBP/{patientId}")
	   public String recentBpOfPatient(@PathVariable("patientId") long patientId, @Value("${highBpQuery}") String query1, @Value("${lowBpQuery}") String query2) {
		  // System.out.println (query);
		   long highBp = bpRepository.findRecentValueByPid(patientId, query1);
		   long lowBp = bpRepository.findRecentValueByPid(patientId, query2);
		   if(highBp != 0 && lowBp != 0  )
			   return highBp+"/"+ lowBp;
		   else
			   return "No Patient Available";
	   }
	
}