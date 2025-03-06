package org.api.services;

import io.restassured.response.Response;

public class UserService extends BaseService{

    private static final String BASE_PATH = "/user";

    public Response createUser(Object payload){
        return postRequest(BASE_PATH ,payload);
    }
}
