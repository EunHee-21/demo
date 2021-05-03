package com.example.demo.api

import com.example.demo.dto.CommentForm
import com.example.demo.entity.Comment
import com.example.demo.repository.CommentRepository
import com.example.demo.service.CommentService
import lombok.RequiredArgsConstructor
import lombok.extern.slf4j.Slf4j
import org.springframework.web.bind.annotation.*
import com.example.demo.entity.Article
import java.lang.IllegalArgumentException


@Slf4j
@RequiredArgsConstructor
@RestController
class CommentApiController {

    private val commentRepository: CommentRepository? = null
    private val commentService // 서비스 레이어 객체
            : CommentService? = null

    @PostMapping("/api/comments/{articleId}")
    fun create(@PathVariable articleId: Long?, @RequestBody form: CommentForm?): Long?
    {
        // 서비스 객체가 댓글 생성
        val saved = commentService!!.create(articleId!!, form!!)
        return saved.id
    }

    @PutMapping("/api/comments/{id}")
    fun update(@PathVariable id: Long?, @RequestBody form: CommentForm?): Long?
    {
        // 서비스 객체가 댓글 수정
        val updated = commentService!!.update(id!!, form!!)
        return updated.id
    }

    @DeleteMapping("/api/comments/{id}")
    fun destroy(@PathVariable id: Long): Long {
        return commentService!!.destroy(id)
    }
}