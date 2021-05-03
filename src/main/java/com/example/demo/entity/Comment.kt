package com.example.demo.entity

import lombok.*
import javax.persistence.*

@Getter
@ToString
@Builder
@NoArgsConstructor // 디폴트 생성자 자동 기입
@AllArgsConstructor // 모든 필드 포함 생성자 자동 기입
@Entity
class Comment(id: Long?, author: String?, content: String?) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null    //원래 private

    @Column(length = 20, nullable = false)
    var author: String? = null  //원래 private

    @Column(columnDefinition = "TEXT", nullable = false)
    var content: String? = null //원래 private

    @ManyToOne // 여러 Comment가 하나의 Article에 포함 됨
    @JoinColumn(name = "article_id") // 포함 대상 정보는 article_id에 기록!
    var article: Article? = null    //원래 private

    // 해당 댓글이 어느 게시글에 작성된 것인지를 기록
    fun stickTo(article: Article?) {
        this.article = article
    }

    // 해당 댓글의 내용을 새것으로 갱신
    fun rewrite(content: String?) {
        this.content = content
    }
}