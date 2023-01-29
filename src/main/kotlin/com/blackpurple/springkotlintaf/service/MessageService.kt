package com.blackpurple.springkotlintaf.service

import com.blackpurple.springkotlintaf.model.Message

interface MessageService {
    fun getMessage(messageId: String) : Message
    fun getMessages() : List<Message>
    fun addMessage(message: Message)
}