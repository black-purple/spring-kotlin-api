package com.blackpurple.springkotlintaf.service

import com.blackpurple.springkotlintaf.model.Message
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

interface MessageService {
    fun getMessage(messageId: String) : Any
    fun getMessages() : List<Message>
    fun addMessage(message: Message) : Map<Any, Any>
    fun deleteMessage(messageId:String) : Any
    fun editMessage(messageId: String, newMessage: Message) : Any
}