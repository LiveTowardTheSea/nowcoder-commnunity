package com.community.nowcoder.service;

import com.community.nowcoder.dao.DiscussPostMapper;
import com.community.nowcoder.entity.DiscussPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussPostService {

    @Autowired
    private DiscussPostMapper discussPostMapper;

    public List<DiscussPost> findDiscussPost(int userId, int offset, int limit){
        return discussPostMapper.selectDiscussPost(userId, offset, limit);
    }

    public int findDiscussPostCount(int userId){
        return discussPostMapper.selectDiscussPostCount(userId);
    }

}
