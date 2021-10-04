package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import com.example.demo.model.Article;
import com.example.demo.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> findAll() {
        return (List<Article>) articleRepository.findAll();
    }

    public Optional<Article> findById(Integer articleId) {
        return articleRepository.findById(articleId);
    }

     public Article insertArticle(Article newArticle){
        return articleRepository.save(newArticle);
     }

     public Article updateArticle(Integer id, Article article){
        Optional<Article> existingArticle = articleRepository.findById(article.getId());
        if(existingArticle.isPresent()){
            Article updatedArticle = existingArticle.get();
            updatedArticle.setTitle(article.getTitle());
            updatedArticle.setTag(article.getTag());
            updatedArticle.setAuthor(article.getAuthor());
            updatedArticle.setDate(article.getDate());
            updatedArticle.setImgUrl(article.getImgUrl());
            updatedArticle.setContent(article.getContent());
            updatedArticle=articleRepository.save(updatedArticle);
            return updatedArticle;
        }
           
        return article;
         
     }

     public boolean existsById(Integer id){
        return articleRepository.existsById(id);
     }

	public void deleteById(Integer articleId) {
        articleRepository.deleteById(articleId);
    }
	public List<Article> getArticleByAuthor(String author) {
		return articleRepository.getArticleByAuthor(author);
	}
	public List<Article> getArticleByTitle(String title) {
		return articleRepository.getArticleByTitle(title);
	}
	public List<Article> getArticleByTag(String tag) {
		return articleRepository.getArticleByTag(tag);
	}
	public List<Article> getArticleByTitleAndTag(String title, String tag) {
		return articleRepository.getArticleByTitleAndTag(title,tag);
	}
	public List<Article> getArticleByTitleAndAuthor(String title, String author) {
		return articleRepository.getArticleByTitleAndAuthor(title,author);
	}

	
  
}