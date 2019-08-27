package com.miracle.Motion.FourCornersOfHealth.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miracle.Motion.FourCornersOfHealth.Entity.PatientProfile;
@Repository
public interface PatientRepository extends JpaRepository<PatientProfile, Long>, CustomFCHRepository {
		long findIdBypatientName(String patientName);
}
