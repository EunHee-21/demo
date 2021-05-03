package com.example.demo.dto

import com.example.demo.entity.Comment
import lombok.Data

@Data
class CommentForm {
    val id: Long? = null            //원래 private
    val author: String? = null      //원래 private
    val content: String? = null     //원래 private

    fun toEntity(): Comment {
        return Comment(
            id = id,
            author = author,
            content = content
        )
    }

}