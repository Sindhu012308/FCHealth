package com.miracle.Motion.FourCornersOfHealth.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miracle.Motion.FourCornersOfHealth.Entity.FCHealthCL;

@Repository
public interface FCHealthCLRepository extends JpaRepository<FCHealthCL, Long>, CustomFCHRepository{

}
