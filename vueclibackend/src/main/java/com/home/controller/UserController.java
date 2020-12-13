package com.home.controller;

import com.home.entity.User;
import com.home.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 文件描述
 *
 * @author 冯根源
 * @date 2020/12/13 18:51
 */
@RestController
@CrossOrigin
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("update")
    public Map<String, Object> update(@RequestBody User user){
        System.out.println(user);
        HashMap<String, Object> map = new HashMap<>();
        try {
            System.out.println("update");
            userService.update(user);
            map.put("success", true);
            map.put("msg", "修改成功");
        } catch (Exception e) {
            map.put("success", false);
            map.put("msg", "修改失败" + e.getMessage());
            e.printStackTrace();

        }
        return map;
    }

    @GetMapping("findOne")
    public User findOne(String id) {
        System.out.println(id);
        return userService.findById(id);

    }

    @GetMapping("delete")
    public Map<String, Object> delete(String id) {

        HashMap<String, Object> map = new HashMap<>();
        try {
            userService.delete(id);
            map.put("success", true);
            map.put("msg", "删除成功");
        } catch (Exception e) {
            map.put("success", false);
            map.put("msg", "删除失败" + e.getMessage());
            e.printStackTrace();

        }
        return map;
    }

    /**
     * @param user
     * @return
     */
    @PostMapping("add")
    public Map<String, Object> add(@RequestBody User user) {
        HashMap<String, Object> map = new HashMap<>();
        try {
            userService.save(user);
            map.put("success", true);
            map.put("msg", "添加成功");
        } catch (Exception e) {
            map.put("success", false);
            map.put("msg", "添加失败" + e.getMessage());
            e.printStackTrace();

        }

        return map;
    }

    /**
     * 查询所有
     *
     * @return
     */
    @GetMapping("findAll")
    public Map<String, Object> findAll(Integer page, Integer rows) {
        Map<String, Object> map = new HashMap<>();

        map.put("total", 10);
        map.put("totalPage", 1);
        map.put("page", page);
        map.put("results", userService.findAll());
        return map;
    }
}
