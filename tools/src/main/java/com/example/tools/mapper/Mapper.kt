package com.example.tools.mapper

interface Mapper<in T, out R> {
    fun map(data: T): R
}