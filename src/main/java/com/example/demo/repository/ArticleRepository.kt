package com.example.demo.repository

import com.example.demo.entity.Article
import org.springframework.data.repository.CrudRepository

interface ArticleRepository // DB와 소통하는 인터페이스, JPA가 해당 객체를 알아서 만듦!
    : CrudRepository<Article, Long>