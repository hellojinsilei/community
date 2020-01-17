package com.listj.community.community.dto;

import com.listj.community.community.model.User;
import lombok.Data;

@Data
public class QuestionDTO {
    private Long id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Long creator;
    private Integer commentCount;
    private Integer likeCount;
    private Integer viewCount;
    private User user;
}
