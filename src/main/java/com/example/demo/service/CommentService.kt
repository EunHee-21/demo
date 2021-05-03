package com.example.demo.service

import lombok.extern.slf4j.Slf4j
import lombok.RequiredArgsConstructor
import com.example.demo.repository.ArticleRepository
import com.example.demo.dto.ArticleForm
import com.example.demo.entity.Article
import com.example.demo.service.ArticleService
import com.example.demo.repository.CommentRepository
import com.example.demo.dto.CommentForm
import com.example.demo.entity.Comment
import com.example.demo.service.CommentService
import org.springframework.stereotype.Service
import java.lang.IllegalArgumentException
import javax.transaction.Transactional

@Slf4j
@RequiredArgsConstructor
@Service
class CommentService {
    private val articleRepository: ArticleRepository? = null
    private val commentRepository: CommentRepository? = null

    @Transactional
    fun create(articleId: Long, form: CommentForm): Comment {
        // 폼 데이터를 엔티티 객체로 변경
        val comment = form.toEntity()

        // 댓글이 달릴 게시글을 가져옴!
        val article = articleRepository!!.findById(articleId)
            .orElseThrow { IllegalArgumentException("댓글을 작성할 Article이 없습니다.") }!!

        // 댓글 엔티티에 게시글 엔티티를 등록
        comment.stickTo(article)
        return comment
    }

    @Transactional
    fun update(id: Long, form: CommentForm): Comment {

        // 수정 댓글 폼을 엔티티로 변경
        val edited = form.toEntity()

        // DB에서 기존 댓글을 가져옴
        val target = commentRepository!!.findById(id)
            .orElseThrow { IllegalArgumentException("해당 댓글이 없습니다.") }!!

        // 기존 댓글을 수정!
        target.rewrite(edited.content)
        return commentRepository.save(target)
    }

    @Transactional
    fun destroy(id: Long): Long {
        commentRepository!!.deleteById(id)
        return id
    }
}