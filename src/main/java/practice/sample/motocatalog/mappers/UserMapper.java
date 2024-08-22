package practice.sample.motocatalog.mappers;

import org.apache.ibatis.annotations.Mapper;
import practice.sample.motocatalog.beans.User;


@Mapper
public interface UserMapper {

    public User selectByUsername(String username);
}