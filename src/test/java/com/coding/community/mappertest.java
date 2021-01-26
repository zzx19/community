package com.coding.community;

import com.coding.community.dao.DiscussPostMapper;
import com.coding.community.dao.UserMapper;
import com.coding.community.entity.DiscussPost;
import com.coding.community.entity.User;
import com.coding.community.service.DiscussPostService;
import com.coding.community.service.UserService;
import org.apache.ibatis.session.Configuration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
public class mappertest {

    @Autowired
    UserService userService;

    @Autowired
    DiscussPostService discussPostService;

    @Test
    public void testSelectUser(){
        List<DiscussPost> discussPosts = discussPostService.findDiscucussPost(0);
        List<Map<String, Object>> list = new ArrayList<>();
        if(list != null){
            for(DiscussPost discussPost : discussPosts) {
                Map<String, Object> map = new HashMap<>();
                map.put("post", discussPost);
                //System.out.println(discussPost);
                //System.out.println(discussPost.getUserId());
                User user = userService.findUserById(discussPost.getUserId());
                System.out.println(user);
            }
        }
    }

}
