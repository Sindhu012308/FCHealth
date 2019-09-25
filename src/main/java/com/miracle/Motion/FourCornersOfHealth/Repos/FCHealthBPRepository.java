package com.miracle.Motion.FourCornersOfHealth.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miracle.Motion.FourCornersOfHealth.Entity.FCHealthBP;

@Repository
public interface FCHealthBPRepository extends JpaRepository<FCHealthBP, Long>, CustomFCHRepository {

}
