package com.imark.marvel.core

import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp

object Constants {
    const val API_KEY = ""
    private const val PRIVATE_KEY = ""
    const val BASE_URL = "https://gateway.marvel.com/"
    val ts = Timestamp(System.currentTimeMillis()).time.toString()

    fun hash(): String {
        val input = "$ts$PRIVATE_KEY$API_KEY"
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
    }
}