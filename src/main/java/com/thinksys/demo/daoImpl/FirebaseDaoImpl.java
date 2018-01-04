package com.thinksys.demo.daoImpl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.thinksys.demo.dao.FirebaseDao;
import com.thinksys.demo.model.FirebaseDetail;
import com.thinksys.demo.util.Response;

@Repository
public class FirebaseDaoImpl implements FirebaseDao {

	@Autowired
	HibernateTemplate hibernateTemplate;

	@Transactional
	public Response saveToken(FirebaseDetail tokenDetail) {

		Response response = new Response();
		this.hibernateTemplate.setCheckWriteOperations(false);
		int id =(Integer) this.hibernateTemplate.save(tokenDetail);
		tokenDetail.setId(id);
		response.setStatus(true);
		return response;
	}

	@Transactional
	public Response fetchToken() {
		Response response = new Response();

		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(FirebaseDetail.class);
		List<FirebaseDetail> listUser = (List<FirebaseDetail>) this.hibernateTemplate.findByCriteria(detachedCriteria);
		if(listUser.size()>0){
			response.setData(listUser);
			response.setStatus(true);	
		}else{
			response.setStatus(false);	
		}
		return response;
	}
}
