package com.bsoftware.aplikasimanajemengudang.generateId

import kotlin.random.Random

class GenerateIDProduct {
    fun generateIDNumber(length : Int) : String{
        val chartset = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890"
        val random = Random.Default
        return (1..length)
            .map { chartset[random.nextInt(chartset.length)] }
            .joinToString("")
    }
}