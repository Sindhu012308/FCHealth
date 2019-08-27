package com.miracle.Motion.FourCornersOfHealth.Controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miracle.Motion.FourCornersOfHealth.Entity.FCHealthWeight;
import com.miracle.Motion.FourCornersOfHealth.Repos.FCHealthWeightRepository;
import com.miracle.Motion.FourCornersOfHealth.Service.CommonService;

@RestController
@RequestMapping("/Weight")
@CrossOrigin(origins="http://localhost:4200/")
public class FCHealthWeightContoller {
	
	@Autowired
	private FCHealthWeightRepository weightRepository;
	
	@Autowired
	private CommonService commonService;
	
	   @GetMapping("/LoggedInUser")
	   public long getLoggedInUser() {
		   return commonService.getCurrentUserID();
	   }
	   
	   @GetMapping("/PatientWeights")
	   public List<FCHealthWeight> retrievePatientWeight() {
		   return weightRepository.findAll();
	   }
	   
	   @PostMapping(value="/PatientWeight",produces=MediaType.APPLICATION_JSON_VALUE)
	   public ResponseEntity<?> newFCHealthWeight(@RequestBody FCHealthWeight fcWeight) {
		   fcWeight.setWeightDate(new Date());
		   fcWeight.setPid(2);
		  // System.out.println(new Date());
		   FCHealthWeight weight = weightRepository.save(fcWeight);
		   return new ResponseEntity<>(weight.getWeight(), HttpStatus.OK);
	   }
	   
//	   @GetMapping("/CurrentWeight/{patientId}")
//	   public Long recentWeightOfPatient(@PathVariable("patientId") long patientId, @Value("${weightQuery}") String query) {
//		   System.out.println (query);
//		   return weightRepository.findRecentValueByPid(patientId, query);
//	   }

	   @GetMapping(value="/CurrentWeight/{patientId}",produces=MediaType.APPLICATION_JSON_VALUE)
	   public ResponseEntity<?>  recentWeightOfPatient(@PathVariable("patientId") long patientId, @Value("${weightQuery}") String query) {
		  // System.out.println (query);
		   long valueByPid = weightRepository.findRecentValueByPid(patientId, query);
		   if(valueByPid != 0)
			   return new ResponseEntity<>(valueByPid, HttpStatus.OK);
		   else
			    return new ResponseEntity<>("No Patient", HttpStatus.BAD_REQUEST);
	   }
}
