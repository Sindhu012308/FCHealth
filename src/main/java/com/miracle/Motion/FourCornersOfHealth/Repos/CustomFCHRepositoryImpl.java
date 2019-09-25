package com.miracle.Motion.FourCornersOfHealth.Repos;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.miracle.Motion.FourCornersOfHealth.Entity.AverageEntity;

@Repository
@Transactional(readOnly=true)
public class CustomFCHRepositoryImpl implements CustomFCHRepository {

	@Autowired
	EntityManager entityManager;
	
	@Override
	public long findRecentValueByPid(long patientId, String sqlQuery) {
		//String sqlQuery="SELECT weight, to_char(w_date,'DD/MM/YYYY HH24:MI:SS') as w_date1 FROM fchealth_weight " +
			//				"WHERE pid = ? Order by w_date desc ";
		long res = 0l;
		Query query = entityManager.createNativeQuery(sqlQuery);
        query.setParameter(1, patientId );
        try {
        	List<Object[]> result = query.getResultList();
        	res = Long.parseLong(String.valueOf(result.get(0)[0]));
        }catch(Exception ex) {
        	ex.printStackTrace();
        }
        return res;
	}

	@Override
	public List<AverageEntity> findAverageValues(long patientId, String avgQuery, int year) throws Exception{
		// TODO Auto-generated method stub
		Query query = entityManager.createNativeQuery(avgQuery);
		query.setParameter(1, patientId );
		query.setParameter(2, year);
        	List<Object[]> result = query.getResultList();
        	List<AverageEntity> avgList =new ArrayList<AverageEntity>();
        	//List<Object[]> rows = query.list();
        	for(Object[] row : result){
        		AverageEntity avgent = new AverageEntity();
        		int x= Integer.parseInt(row[0].toString());
        		String str=Integer.toString((year%100));
        		switch(x) {
	        		case 1:  avgent.setAvgMonth("JAN"+str);break;
	        		case 2:  avgent.setAvgMonth("FEB"+str);break;
	        		case 3:  avgent.setAvgMonth("MAR"+str);break;
	        		case 4:  avgent.setAvgMonth("APR"+str);break;
	        		case 5:  avgent.setAvgMonth("MAY"+str);break;
	        		case 6:  avgent.setAvgMonth("JUN"+str);break;
	        		case 7:  avgent.setAvgMonth("JUL"+str);break;
	        		case 8:  avgent.setAvgMonth("AUG"+str);break;
	        		case 9:  avgent.setAvgMonth("SEP"+str);break;
	        		case 10:  avgent.setAvgMonth("OCT"+str);break;
	        		case 11:  avgent.setAvgMonth("NOV"+str);break;
	        		case 12: avgent.setAvgMonth("DEC"+str);break;
        		}
        		//avgent.setAvgMonth(Integer.parseInt(row[0].toString()));
        		avgent.setAvgWeight(Double.parseDouble(row[1].toString()));
        		//System.out.println("Before Adding"+avgent);
        		avgList.add(avgent); 
        		//System.out.println("After adding:"+avgList);
        	}
        	//System.out.println(ent);
        			//getResultList();
        	return avgList;
	}

}
