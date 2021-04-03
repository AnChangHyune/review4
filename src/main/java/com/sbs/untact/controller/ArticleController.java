package com.sbs.untact.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sbs.untact.dto.Article;
import com.sbs.untact.dto.ResultData;
import com.sbs.untact.service.ArticleService;

@Controller
public class ArticleController {
	@Autowired
	private ArticleService articleService;
	
	
	@RequestMapping("/usr/article/doAdd")
	@ResponseBody
	public ResultData doAdd(String title, String body){
		
		return articleService.addArticle(title, body);
	}
	
	@RequestMapping("/usr/article/doDelete")
	@ResponseBody
	public ResultData doDelete(Integer id){
		return articleService.deleteArticle(id);
	}
	
	@RequestMapping("/usr/article/getArticle")
	@ResponseBody
	public ResultData getArticle(Integer id,String title, String body){
		Article article = articleService.getArticleById(id);
		
		if(article == null) {
			return new ResultData("F-1", id+"번 글은 존재하지 않습니다.", "id",id);
		}
		return new ResultData("S-1", id+"번 글 입니다", "article",article);
	}
	
	@RequestMapping("/usr/article/doModify")
	@ResponseBody
	public ResultData doModify(Integer id,String title, String body){
		
		return articleService.modifyArticle(id,title, body);
	}
	

		
}
