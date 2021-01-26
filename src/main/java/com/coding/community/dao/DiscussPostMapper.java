package com.coding.community.dao;

import com.coding.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DiscussPostMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DiscussPost record);

    DiscussPost selectByPrimaryKey(Integer id);

    List<DiscussPost> selectDiscussPosts(Integer userId);

    int selectDiscussPostRows(int userId);

    int updateByPrimaryKey(DiscussPost record);
}