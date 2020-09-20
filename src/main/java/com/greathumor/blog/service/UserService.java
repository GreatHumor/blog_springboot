package com.greathumor.blog.service;

import com.greathumor.blog.po.User;

public interface UserService {

    User checkUser(String name,String password);

}
