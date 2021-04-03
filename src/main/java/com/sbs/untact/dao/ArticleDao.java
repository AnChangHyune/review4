package com.sbs.untact.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sbs.untact.dto.Article;

@Mapper
public interface ArticleDao {

	boolean modifyArticle(@Param(value = "id") int id, @Param(value = "title")  String title, @Param(value = "body") String body);

	void deleteArticle(@Param(value = "id") int id);

	Article getArticleById(@Param(value = "id") int id);

	void addArticle(@Param("boardId") int boardId, @Param("memberId") int memberId, @Param("title") String title, @Param("body") String body);

	
}
