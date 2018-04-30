package rifu.demo.mybatisspring.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import rifu.demo.mybatisspring.entity.Users;

import java.util.List;

@Mapper
@Component
public interface UserMapper {
    @Select("SELECT * FROM \"USERS\"")
    @Results({
            @Result(property = "id", column = "ID"),
            @Result(property = "name", column = "NAME")
    })
    List<Users> getAll();

}
