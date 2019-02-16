package com.palmatolay.hersay

import org.springframework.stereotype.Service
import java.util.HashMap

@Service
class SorterServiceImpl: SorterService{
    override fun sort(data: Input): Output {
        val result = HashMap<String, Array<Any>>()
        data.payload.forEach { (key, value) ->
            if (data.sortKeys.contains(key)) value.sort()
            result[key] = value
        }
        return Output(result)
    }
}