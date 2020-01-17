package com.listj.community.community.controller;

import com.listj.community.community.dto.CommentDTO;
import com.listj.community.community.dto.ResultDTO;
import com.listj.community.community.exception.CustomizeErrorCode;
import com.listj.community.community.mapper.CommentMapper;
import com.listj.community.community.model.Comment;
import com.listj.community.community.model.User;
import com.listj.community.community.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @ResponseBody
    @RequestMapping(value = "/comment",method = RequestMethod.POST)
    public Object post(@RequestBody CommentDTO commentDTO,
                       HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        if(user==null){
            return ResultDTO.errorOf(CustomizeErrorCode.NO_LOGIN);
        }
        Comment comment = new Comment();
        comment.setParentId(commentDTO.getParentId());
        comment.setContent(commentDTO.getContent());
        comment.setType(commentDTO.getType());
        comment.setGmtModified(System.currentTimeMillis());
        comment.setGmtCreate(System.currentTimeMillis());
        comment.setCommentator(1L);
        comment.setLikeCount(0L);
        commentService.insert(comment);
        Map<Object,Object> objectObjectHashMap=new HashMap<>();
        objectObjectHashMap.put("message","成功");
        return objectObjectHashMap;

    }
}
