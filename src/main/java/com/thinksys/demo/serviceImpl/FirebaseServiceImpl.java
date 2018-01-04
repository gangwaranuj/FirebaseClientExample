package com.thinksys.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinksys.demo.bean.FirebaseBean;
import com.thinksys.demo.dao.FirebaseDao;
import com.thinksys.demo.model.FirebaseDetail;
import com.thinksys.demo.service.FirebaseService;
import com.thinksys.demo.util.Response;
import com.thinksys.demo.util.ResponseMessage;
import com.thinksys.demo.util.Utility;

@Service
public class FirebaseServiceImpl implements FirebaseService{

	
	@Autowired
	FirebaseDao firebaseDao;
	

	@Override
	public ResponseMessage save(FirebaseBean browserBean) {
		ResponseMessage responseMessage = new ResponseMessage();

		try{
			FirebaseDetail tokenDetail = new FirebaseDetail();
			tokenDetail.setBrowserName(browserBean.getBrowserName());
			tokenDetail.setToken(browserBean.getToken());	
			Response response =this.firebaseDao.saveToken(tokenDetail);
			if(response.isStatus())
				responseMessage.setMsg("Successfully Save");
			else
				responseMessage.setMsg("Failed");
		}
		catch(Exception ex){
			responseMessage.setMsg("Unsuccessfull "+ex.getMessage());
		}
		return responseMessage;
	}

	@Override
	public ResponseMessage fetchToken(String title,String description) {
		ResponseMessage responseMessage = new ResponseMessage();
		
		responseMessage.setMsg("sss");
		try{
		Response response =	this.firebaseDao.fetchToken();
		for(FirebaseDetail firebaseBeanList:(List<FirebaseDetail>)response.getData())
		{
			Utility.sendNotification(title, description, firebaseBeanList.getToken());
		}
		responseMessage.setMsg("Successfully");
		}catch(Exception ex){
			responseMessage.setMsg("Unsuccessfull"+ex.getMessage());
		}
		return responseMessage;
	}

	
}
