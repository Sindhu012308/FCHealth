package com.miracle.Motion.FourCornersOfHealth.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miracle.Motion.FourCornersOfHealth.Entity.FCHealthGL;

@Repository
public interface FCHealthGLRepository extends JpaRepository<FCHealthGL, Long>, CustomFCHRepository {

}
