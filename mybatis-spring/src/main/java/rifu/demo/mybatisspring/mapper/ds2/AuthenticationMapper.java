package rifu.demo.mybatisspring.mapper.ds2;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import rifu.demo.mybatisspring.entity.Authentication;

import java.util.List;

@Mapper
@Component
public interface AuthenticationMapper {
    @Select("SELECT * FROM \"AUTHENTICATION\"")
    @Results({
            @Result(property = "id", column = "ID"),
            @Result(property = "name", column = "NAME"),
            @Result(property = "description", column = "DESCRIPTION")
    })
    List<Authentication> getAll();
}
