package com.sbs.untact.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbs.untact.dao.ArticleDao;
import com.sbs.untact.dto.Article;
import com.sbs.untact.dto.ResultData;


@Service
public class ArticleService {
	@Autowired
	private ArticleDao articleDao;


	public ResultData modifyArticle(Integer id, String title, String body) {
		Article article = getArticleById(id);

		if (article == null) {
			return new ResultData("F-1", id + "번 글은 존재하지 않습니다.", "id", id);
		}
		articleDao.modifyArticle(id, title, body);

		return new ResultData("S-1", id + "번 글을 수정했습니다.", "article", getArticleById(id));
	}

	public ResultData deleteArticle(Integer id) {
		Article article = getArticleById(id);

		if (article == null) {
			return new ResultData("F-1", id + "번 글은 존재하지 않습니다.", "id", id);
		}

		articleDao.deleteArticle(id);
		return new ResultData("S-1", id + "번 글을 삭제하였습니다.", "id", id);
	}

	public Article getArticleById(int id) {
		return articleDao.getArticleById(id);
	}

	public ResultData addArticle(String title, String body) {
		int boardId = 3; // 가짜 데이터
		int memberId = 3; // 가짜 데이터
		articleDao.addArticle(boardId, memberId, title, body);
		int id = 1; // 가짜 데이터

		return new ResultData("S-1", "게시물이 작성되었습니다.", "id", id);
	}
}
