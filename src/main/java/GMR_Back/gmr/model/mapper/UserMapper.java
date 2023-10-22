package GMR_Back.gmr.model.mapper;

import GMR_Back.gmr.model.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.*;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user WHERE id = #{id}")
    User findById(@Param("id") Long id);

    @Select("SELECT * FROM user")
    List<User> findAll();

    @Insert("INSERT INTO user (email, password, username, phone, weight, height, role, created_at) " +
            "VALUES (#{email}, #{password}, #{username}, #{phone}, #{weight}, #{height}, #{role}, #{created_at})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(User user);

    @Delete("DELETE FROM user WHERE id = #{id}")
    void deleteById(@Param("id") Long id);
}
