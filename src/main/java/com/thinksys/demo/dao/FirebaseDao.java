package com.thinksys.demo.dao;

import com.thinksys.demo.model.FirebaseDetail;
import com.thinksys.demo.util.Response;

public interface FirebaseDao {

	Response saveToken(FirebaseDetail tokenDetail);
	Response fetchToken();
}