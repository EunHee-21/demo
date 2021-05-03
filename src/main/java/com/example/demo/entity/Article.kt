package com.example.demo.entity

import lombok.Builder
import lombok.Getter
import lombok.ToString
import lombok.NoArgsConstructor
import javax.persistence.*

@Getter
@ToString
@NoArgsConstructor
@Entity
@Builder

class Article(// 이게 ID임! 즉 사람으로 따지면 주민등록 번호!
    @field: GeneratedValue(strategy = GenerationType.IDENTITY)   // DB에서 자동 관리. 매 생성 시, 1, 2, ... 증가
    @field:Id
    var id: Long?, title: String, content: String) //원래 private
    {
    @Column(length = 100, nullable = false) // 최대 100글자, 비어 있으면 안됨
    var title: String   //원래 private

    @Column(columnDefinition = "TEXT", nullable = false) // 텍스트 타입, 비어있으면 안됨
    var content : String   //원래 private


    // 하나의 Article은 여러개의 Comment를 가질 수 있다
    // fetch: 연결 방법 설정
    // mappedBy: comments를 연결할 테이블명 설정
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "article")
    val comments //원래 private
            : List<Comment>? = null

    fun rewrite(title: String, content: String) {
        this.title = title
        this.content = content
    }

    // toString() 메소드를 직접 오버라이딩(재정의) 함
    override fun toString(): String {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", comments=" + comments?.size +
                '}'
    }
    init {
        this.id = null
        this.title = title
        this.content = content
    }
}