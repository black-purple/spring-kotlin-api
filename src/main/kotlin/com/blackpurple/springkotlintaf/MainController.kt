package com.blackpurple.springkotlintaf

import com.blackpurple.springkotlintaf.service.JpaMessageService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

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

//    @PostMapping("/messages/add")
//    fun addMessage(@RequestBody body:String) = messageService.addMessage()
}