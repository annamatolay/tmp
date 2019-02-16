package com.palmatolay.hersay

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletResponse


@RestController
@RequestMapping("/", produces = ["application/json"])
class MainRestController(val sorterService: SorterService) {

    var data: Input? = null

    @PostMapping
    fun postSortedData(@RequestBody input: Input) { data = input }

    @GetMapping
    fun getSortedData(response: HttpServletResponse) =
            data?.let { sorterService.sort(it) } ?:  throw PayloadNotFoundException()
}


@ResponseStatus(HttpStatus.NOT_FOUND)
private class PayloadNotFoundException : RuntimeException("Payload is missing")