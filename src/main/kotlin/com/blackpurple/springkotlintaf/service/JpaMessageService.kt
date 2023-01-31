package com.blackpurple.springkotlintaf.service

import com.blackpurple.springkotlintaf.model.Message
import com.blackpurple.springkotlintaf.repository.MessageRepo
import org.springframework.stereotype.Service

@Service
class JpaMessageService(val messageRepo: MessageRepo) : MessageService {

    override fun getMessage(messageId: String): Any {
        var res: Any = Message.whenMessageNotFound()
        try {
            val message = messageRepo.getReferenceById(messageId.toInt())
            res =  Message(id = message.id, body = message.body)
        } catch (e:Exception) {
            println(e)
        }
        return res
    }

    override fun getMessages(): List<Message> {
        return messageRepo.findAll()
    }

    override fun addMessage(message: Message) : Map<Any, Any> {
        var responseBody = mutableMapOf<Any, Any>()
        try {
            messageRepo.save(message)
            responseBody["saved"] = true
            responseBody["savedMessage"] = message

        }catch (e:Exception) {
            responseBody = Message.whenMessageNotSaved() as MutableMap<Any, Any>
        }
        return responseBody
    }

    override fun deleteMessage(messageId: String) : Any {
        var responseBody = mutableMapOf<Any, Any>()
        try {
            responseBody["deletedMessage"] = messageRepo.getReferenceById(messageId.toInt())
            messageRepo.deleteById(messageId.toInt())
            responseBody["deleted"] = true
            return responseBody
        } catch (e:Exception) {
            responseBody = Message.whenMessageNotFound() as MutableMap<Any, Any>
        }
        return responseBody
    }

    override fun editMessage(messageId: String, newMessage: Message) : Any {
        var responseBody = mutableMapOf<Any, Any>()
        try {
            val message = messageRepo.getReferenceById(messageId.toInt())
            message.body = newMessage.body
            messageRepo.saveAndFlush(message)
            responseBody["updated"] = true
            responseBody["newMessage"] = messageRepo.getReferenceById(messageId.toInt())
            return responseBody
        }
        catch (e:Exception) {
            responseBody = Message.whenMessageNotFound() as MutableMap<Any, Any>
        }
        return  responseBody
    }


}