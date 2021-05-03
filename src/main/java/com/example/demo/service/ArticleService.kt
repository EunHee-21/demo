package com.example.demo.service

import lombok.extern.slf4j.Slf4j
import lombok.RequiredArgsConstructor
import com.example.demo.repository.ArticleRepository
import com.example.demo.dto.ArticleForm
import com.example.demo.entity.Article
import com.example.demo.service.ArticleService
import com.example.demo.repository.CommentRepository
import com.example.demo.dto.CommentForm
import com.example.demo.service.CommentService
import org.springframework.stereotype.Service
import java.lang.IllegalArgumentException
import javax.transaction.Transactional

@Slf4j
@RequiredArgsConstructor
@Service
class ArticleService {
    private val articleRepository: ArticleRepository? = null

    @Transactional
    fun update(id: Long, form: ArticleForm): Article {
        val target = articleRepository!!.findById(id)
            .orElseThrow { IllegalArgumentException("해당 Article이 없습니다.") }!!

        target.rewrite(form.toEntity().title, form.toEntity().content)
        val saved = articleRepository.save(target)
        return saved
    }

    @Transactional
    fun destroy(id: Long): Long? {
        val target = articleRepository!!.findById(id)
            .orElseThrow { IllegalArgumentException("해당 Article이 없습니다.") }!!
        articleRepository.delete(target)
        return target.id
    }
}