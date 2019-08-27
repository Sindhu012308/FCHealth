package com.miracle.Motion.FourCornersOfHealth.Repos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly=true)
public class CustomFCHRepositoryImpl implements CustomFCHRepository {

	@Autowired
	EntityManager entityManager;
	
	@Override
	public long findRecentValueByPid(long patientId, String sqlQuery) {
		//String sqlQuery="SELECT weight, to_char(w_date,'DD/MM/YYYY HH24:MI:SS') as w_date1 FROM fchealth_weight " +
			//				"WHERE pid = ? Order by w_date desc ";
		Query query = entityManager.createNativeQuery(sqlQuery);
        query.setParameter(1, patientId );
        try {
        	List<Object[]> result = query.getResultList();
        	return Long.parseLong(String.valueOf(result.get(0)[0]));
        }catch(Exception ex) {
        	return 0;
        }
	}

}
