package com.example.demo.api

import lombok.extern.slf4j.Slf4j
import lombok.RequiredArgsConstructor
import org.springframework.web.bind.annotation.RestController
import org.springframework.beans.factory.annotation.Autowired
import com.example.demo.repository.ArticleRepository
import com.example.demo.service.ArticleService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import com.example.demo.dto.ArticleForm
import com.example.demo.api.ArticleApiController
import com.example.demo.entity.Article
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.DeleteMapping
import com.example.demo.service.CommentService
import com.example.demo.dto.CommentForm
import com.example.demo.api.CommentApiController
import java.lang.IllegalArgumentException

@Slf4j
@RequiredArgsConstructor // final 필드 값을 알아서 가져옴 (@autowired 대체!)
@RestController

class ArticleApiController {
    @Autowired
    private val articleRepository: ArticleRepository? = null
    private val articleService: ArticleService? = null

    @PostMapping("/api/articles")
    fun create(@RequestBody form: ArticleForm): Long? {
        val article = form.toEntity()
        val saved = articleRepository!!.save(article)
        return saved.id
    }

    @GetMapping("/api/articles/{id}"A)
    fun getArticle(@PathVariable id: Long): ArticleForm {
        val entity = articleRepository!!.findById(id)
            .orElseThrow { IllegalArgumentException("해당 Article이 없습니다.") }
        return ArticleForm(entity)
    }

    @PutMapping("/api/articles/{id}")
    fun update(@PathVariable id: Long, @RequestBody form: ArticleForm): Long?
    {
        val saved = articleService!!.update(id, form)
        return saved.id
    }

    @DeleteMapping("/api/articles/{id}")
    fun destroy(@PathVariable id: Long): Long? {
        return articleService!!.destroy(id)
    }
}