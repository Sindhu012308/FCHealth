package com.miracle.Motion.FourCornersOfHealth.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miracle.Motion.FourCornersOfHealth.Entity.FCHealthWeight;

@Repository
public interface FCHealthWeightRepository extends JpaRepository<FCHealthWeight, Long>, CustomFCHRepository {
	//long findWeightByPid(long patientId);
}
