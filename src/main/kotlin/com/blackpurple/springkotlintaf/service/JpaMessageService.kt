package com.blackpurple.springkotlintaf.service

import com.blackpurple.springkotlintaf.model.Message
import com.blackpurple.springkotlintaf.repository.MessageRepo
import org.springframework.stereotype.Service

@Service
class JpaMessageService(val messageRepo: MessageRepo) : MessageService {

    override fun getMessage(messageId: String): Message {
        val message = messageRepo.getById(messageId.toInt())
        return Message(id = message.id, body = message.body)
    }

    override fun getMessages(): List<Message> {
        return messageRepo.findAll()
    }

    override fun addMessage(message: Message) {
        messageRepo.save(message)
    }

}