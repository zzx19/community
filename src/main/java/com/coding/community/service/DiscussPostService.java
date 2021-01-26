package com.coding.community.service;

import com.coding.community.dao.DiscussPostMapper;
import com.coding.community.entity.DiscussPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussPostService {

    @Autowired
    private DiscussPostMapper discussPostMapper;

    public List<DiscussPost> findDiscucussPost(int userId){
        return discussPostMapper.selectDiscussPosts(userId);
    }

    public int findDiscussPostRows(int userid){
        return discussPostMapper.selectDiscussPostRows(userid);
    }
}
