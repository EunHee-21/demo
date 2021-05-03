package com.example.demo.dto

import com.example.demo.entity.Article
import lombok.Data

@Data // 생성자(디폴트, All), 게터, 세터, toString 등 다 만들어 줌!
data class ArticleForm(val entity: Article) {
    var id: Long? = null
    var title: String
    var content: String

    fun rewrite(title: String, content: String) {
        this.title = title
        this.content = content
    }

    fun toEntity(): Article {
        return Article (
            id = null,
            title = title,
            content = content
        )
    }


    init {
        id = entity.id
        title = entity.title
        content = entity.content
    }
}