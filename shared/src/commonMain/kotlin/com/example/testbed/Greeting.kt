package com.example.testbed

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}