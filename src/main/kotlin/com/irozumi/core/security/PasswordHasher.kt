package com.irozumi.core.security

import com.password4j.BcryptFunction
import com.password4j.Password
import com.password4j.types.Bcrypt

object PasswordHasher {

    private val bcrypt = BcryptFunction.getInstance(Bcrypt.B, 12)

    fun hash(password: String): String {
        return Password.hash(password)
            .addPepper("irozumi-secret")
            .with(bcrypt)
            .result
    }

    fun verify(password: String, hash: String): Boolean {
        return Password.check(password, hash)
            .addPepper("irozumi-secret")
            .with(bcrypt)
    }
}