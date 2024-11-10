package com.example.board_final.mapper;

import com.example.board_final.domain.vo.UsersVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    UsersVO findByProviderId(String providerId);
    void insertUser(UsersVO user);
    void updateUser(UsersVO user);
}
