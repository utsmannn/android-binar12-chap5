package com.utsman.binarku

import java.io.Serializable

data class User(
    val name: String,
    val password: String
) : Serializable