package com.thinksys.demo.controller;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thinksys.demo.bean.FirebaseBean;
import com.thinksys.demo.service.FirebaseService;
import com.thinksys.demo.util.ResponseMessage;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	FirebaseService firebaseService;

	@CrossOrigin("*")
	@RequestMapping(value = "/saveToken", method = RequestMethod.GET)
	@ResponseBody
	public ResponseMessage save(@RequestParam String token,
			@RequestParam String browser,HttpServletResponse response) {

		ResponseMessage responseMessage =new ResponseMessage();
		/* Gson gson =new Gson();
         FirebaseBean firebaseBean=gson.fromJson(requestJson, FirebaseBean.class);*/
		FirebaseBean firebaseBean = new FirebaseBean();
		firebaseBean.setBrowserName(browser);
		firebaseBean.setToken(token);
		responseMessage= this.firebaseService.save(firebaseBean);
		return responseMessage;
	}

	@CrossOrigin("*")
	@RequestMapping(value = "/submitnotification", method = RequestMethod.POST)
	@ResponseBody
	public ResponseMessage getToken(@RequestParam String title ,@RequestParam String description){
		ResponseMessage responseMessage =new ResponseMessage();
		responseMessage=this.firebaseService.fetchToken( title, description);
		return responseMessage;
	}

}
