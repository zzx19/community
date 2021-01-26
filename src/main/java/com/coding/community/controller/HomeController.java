package com.coding.community.controller;

import com.coding.community.entity.DiscussPost;
import com.coding.community.service.DiscussPostService;
import com.coding.community.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    private DiscussPostService discussPostService;

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/index", method = RequestMethod.GET)
    public String getIndexPage(Model model, @RequestParam(value="pn",defaultValue ="1")Integer pn){
        PageHelper.startPage(pn,10);
        List<DiscussPost> discussPosts = discussPostService.findDiscucussPost(0);
        PageInfo<DiscussPost> info = new PageInfo<>(discussPosts,5);
        List<Map<String, Object>> list = new ArrayList<>();
        if(list != null){
            for(DiscussPost discussPost : discussPosts) {
                Map<String, Object> map = new HashMap<>();
                map.put("post", discussPost);
                map.put("user", userService.findUserById(discussPost.getUserId()));
                list.add(map);
            }
        }
        model.addAttribute("discussPosts",list);
        model.addAttribute("info",info);
        return "index";
    }
}
