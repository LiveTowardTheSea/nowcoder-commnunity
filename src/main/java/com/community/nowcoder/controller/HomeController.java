package com.community.nowcoder.controller;

import com.community.nowcoder.entity.DiscussPost;
import com.community.nowcoder.entity.Page;
import com.community.nowcoder.entity.User;
import com.community.nowcoder.service.DiscussPostService;
import com.community.nowcoder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String getIndexPage(Model model, Page page){
        // page 会自动装载到model里面
        int rows = discussPostService.findDiscussPostCount(0);
        page.setRows(rows);
        page.setPath("/index");
        List<Map<String, Object>> res = new ArrayList<>();
        List<DiscussPost> discussPosts = discussPostService.findDiscussPost(0, page.getOffset(), page.getLimit());
        for(DiscussPost discussPost: discussPosts){
            Map<String, Object> post = new HashMap<>();
            post.put("post", discussPost);
            User user = userService.findUserById(discussPost.getUserId());
            post.put("user", user);
            //添加进去
            res.add(post);
        }
        model.addAttribute("discussPosts", res);
        model.addAttribute("page",page);
        return "/index";
    }
}
