package utils

import com.google.common.hash.Hashing
import org.apache.commons.lang3.RandomStringUtils

import java.nio.charset.StandardCharsets

fun sha256(s: String): String {
    return Hashing.sha256().hashString(s, StandardCharsets.UTF_8).toString()
}

fun createToken(email: String, password: String): String {
    return sha256(sha256(email).plus(sha256(password)).plus(System.currentTimeMillis()))
}

fun createRandomString(lenght: Int): String {
    return RandomStringUtils.random(lenght, "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890")
}
