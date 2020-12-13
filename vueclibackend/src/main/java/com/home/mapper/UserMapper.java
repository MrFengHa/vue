package com.home.mapper;

import com.home.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 文件描述
 *
 * @author 冯根源
 * @date 2020/12/13 18:52
 */
@Mapper
@Repository
public interface UserMapper {
    void save(User user);
    void update(User user);
    void delete(String id);
    List<User> findAll();
    User findById(String id);
}
