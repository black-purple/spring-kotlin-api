package com.blackpurple.springkotlintaf.repository

import com.blackpurple.springkotlintaf.model.Message
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MessageRepo : JpaRepository<Message, Int>