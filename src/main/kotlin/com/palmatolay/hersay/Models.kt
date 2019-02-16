package com.palmatolay.hersay

import java.util.*

data class Input(
        val sortKeys: Array<String>,
        val payload: HashMap<String, Array<Any>>
)

data class Output(
        val data: HashMap<String, Array<Any>>
)
