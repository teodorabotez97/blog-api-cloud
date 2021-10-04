package com.example.demo.controller;

import com.example.demo.exceptions.ArticleNotFoundException;
import com.example.demo.model.Article;
import com.example.demo.service.ArticleService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/")
    public String displayHello() {
        return "Hello";
    }

    @GetMapping("/articles")
    public List<Article> getAllArticles() {
        return articleService.findAll();
    }

    @GetMapping("/articles/{id}")
    public Optional<Article> getArticleById(@PathVariable(value = "id") Integer articleId) {
        
      return articleService.findById(articleId);                
    }
 
    @DeleteMapping("/articles/{id}")
    public void deleteEArticle(@PathVariable(value = "id") Integer articleId) {
        if(articleService.existsById(articleId)){
            articleService.deleteById(articleId);
        }else{
            throw new ArticleNotFoundException(articleId);
        }
    }
  
    @PutMapping("/articles/{id}")
    public Article updateArticle(@PathVariable(value = "id") Integer articleId, @RequestBody Article articleDetails)
            throws ArticleNotFoundException {    
            return articleService.updateArticle(articleId, articleDetails);
    }
  
    @PostMapping("/articles")
    public Article createArticle(@RequestBody Article newArticle) {
        return articleService.insertArticle(newArticle);
    }

    @GetMapping("/article")
    public List<Article> getArticleByAuthor(@Param("author") String author) {

        return articleService.getArticleByAuthor(author);
    }


    @GetMapping("/articleTitle")
    public List<Article> getArticleByTitle(@Param("title") String title) {
        return articleService.getArticleByTitle("%title%");
    }

    @GetMapping("/articleTag")
    public List<Article> getArticleByTag(@Param("tag") String tag) {

        return articleService.getArticleByTag("%tag%");
    }

    @GetMapping("/articleTitleTag")
    public List<Article> getArticleByTitleAndTag(@Param("title") String title,@Param("tag") String tag) {

        return articleService.getArticleByTitleAndTag("%title%", "%tag%");
    }
   
    @GetMapping("/articleTitleAuthor")
    public List<Article> getArticleByTitleAndAuthor(@Param("title") String title,@Param("author") String author) {

        return articleService.getArticleByTitleAndAuthor("%title%", "%author%");
    }


}