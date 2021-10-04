package com.example.demo.repository;

import com.example.demo.model.*;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

    List<Article> getArticleByTitle(String title);

    List<Article> getArticleByAuthor(String author);

    List<Article> getArticleByTag(String tag);

    List<Article> getArticleByTitleAndTag(String title, String tag);

    List<Article> getArticleByTitleAndAuthor(String title, String author);
}
