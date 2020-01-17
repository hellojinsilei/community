package com.listj.community.community.controller;

import com.listj.community.community.dto.QuestionDTO;
import com.listj.community.community.exception.CustomizeErrorCode;
import com.listj.community.community.exception.CustomizeException;
import com.listj.community.community.mapper.QuestionMapper;
import com.listj.community.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;
    @GetMapping("/question/{id}")
    public String question(@PathVariable(name = "id") String id,
                           Model model){
        Long questionId = null;
        try {
            questionId = Long.parseLong(id);
        } catch (NumberFormatException e) {
            throw new CustomizeException(CustomizeErrorCode.INVALID_INPUT);
        }
        QuestionDTO questionDTO=questionService.getById(questionId);
        //增加阅读数
        questionService.incView(questionId);
        model.addAttribute("question",questionDTO);
        return "question";
    }
}
