package com.community.nowcoder.dao;

import com.community.nowcoder.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {
    List<DiscussPost> selectDiscussPost(int userId, int offset, int limit);
    //只有一个参数并且使用if的话要加上@Param取别名。
    int selectDiscussPostCount(@Param("userId") int userId);

}
