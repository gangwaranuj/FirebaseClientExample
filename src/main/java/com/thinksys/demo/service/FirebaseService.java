package com.thinksys.demo.service;

import com.thinksys.demo.bean.FirebaseBean;
import com.thinksys.demo.util.ResponseMessage;

public interface FirebaseService {


	public ResponseMessage save(FirebaseBean browserBean);
	public ResponseMessage fetchToken(String title,String description);
	
}
