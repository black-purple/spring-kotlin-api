package com.blackpurple.springkotlintaf.model

import jakarta.persistence.*

@Entity
@Table(name = "messages")
data class Message(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Int,
    @Column
    var body:String
) {
    companion object {
        fun whenMessageNotFound() : Map<Any, Any> {
            val responseBody = mutableMapOf<Any, Any>()
            responseBody["status"] = "Message Not Found"
            return responseBody
        }
        fun whenMessageNotSaved() : Map<Any, Any> {
            val responseBody = mutableMapOf<Any, Any>()
            responseBody["status"] = "Message Not Found"
            return responseBody
        }
    }
}