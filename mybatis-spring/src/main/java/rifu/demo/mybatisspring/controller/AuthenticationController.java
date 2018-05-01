package rifu.demo.mybatisspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rifu.demo.mybatisspring.entity.Authentication;
import rifu.demo.mybatisspring.mapper.ds2.AuthenticationMapper;

import java.util.List;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationMapper mapper;

    @GetMapping
    public List<Authentication> getAllAuthentication() {
        return mapper.getAll();
    }
}
