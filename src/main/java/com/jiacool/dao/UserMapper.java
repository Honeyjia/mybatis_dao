package com.jiacool.dao;

import com.jiacool.domain.User;

import java.io.IOException;
import java.util.List;

public interface UserMapper {
    List<User> findAll() throws IOException;
    User findById(int id);
}
