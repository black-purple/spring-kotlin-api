package com.blackpurple.springkotlintaf

import com.blackpurple.springkotlintaf.model.Message
import com.blackpurple.springkotlintaf.service.JpaMessageService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1")
class MainController (val messageService: JpaMessageService){

    @GetMapping
    fun helloWorld() : MutableMap<String, String> {
        val res = mutableMapOf<String, String>()
        res["status"] = "API up and running"
        res["version"] = "API v0.0.1"
        return res
    }

    @GetMapping("/messages")
    fun getMessages() = messageService.getMessages()

    @GetMapping("/messages/{messageId}")
    fun getMessage(@PathVariable messageId:String) = messageService.getMessage(messageId)

    @PostMapping("/messages/add")
    fun addMessage(@RequestBody body: Message) = messageService.addMessage(body);

    @DeleteMapping("/messages/delete/{messageId}")
    fun deleteMessage(@PathVariable messageId: String) = messageService.deleteMessage(messageId)

    @PatchMapping("/messages/update/{messageId}")
    fun editMessage(@PathVariable messageId: String, @RequestBody newMessage:Message) = messageService.editMessage(messageId, newMessage)
}