package rifu.demo.mybatisspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rifu.demo.mybatisspring.entity.Users;
import rifu.demo.mybatisspring.mapper.UserMapper;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserMapper mapper;

    @GetMapping
    public List<Users> getAllUser() {
        return mapper.getAll();
    }
}
