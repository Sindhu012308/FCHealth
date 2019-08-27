package com.miracle.Motion.FourCornersOfHealth.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miracle.Motion.FourCornersOfHealth.Repos.FCHealthWeightRepository;

@Service
public class FCHealthWeightService {
	@Autowired
	FCHealthWeightRepository weightRepository;

}
