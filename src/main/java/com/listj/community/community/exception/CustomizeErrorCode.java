package com.listj.community.community.exception;

public enum CustomizeErrorCode implements ICustomizeErrorCode {
    QUESTION_NOT_FOUND(2001,"问题不存在，换一个试试"),
    TARGET_PARAM_NOT_FOUND(2002,"未选中任何问题或评论进行回复"),
    NO_LOGIN(2003,"未登录，不能进行评论,请先登录"),
    SYS_ERROR(2004,"服务器异常！"),
    TYPE_PARAM_WRONG(2005,"评论类型错误或不存在！"),
    COMMENT_NOT_FOUND(2006,"评论不存在，换一个试试"),
    CONTENT_IS_EMPTY(2007,"输入内容不能为空"),
    INVALID_INPUT(2008,"操作错误"),
    ;
    private Integer code;
    private String message;


    CustomizeErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }
}
