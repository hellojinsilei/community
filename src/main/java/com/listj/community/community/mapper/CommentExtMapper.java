package com.listj.community.community.mapper;

import com.listj.community.community.model.Comment;
import com.listj.community.community.model.CommentExample;
import com.listj.community.community.model.Question;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface CommentExtMapper {
    int incCommentCount(Comment comment);
}