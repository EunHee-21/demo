package com.example.demo.repository

import com.example.demo.entity.Comment
import org.springframework.data.repository.CrudRepository

interface CommentRepository : CrudRepository<Comment?, Long?>