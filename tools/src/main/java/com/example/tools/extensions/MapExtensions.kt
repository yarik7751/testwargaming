package com.example.tools.extensions

fun <K, V> Map<K, V>.forEachMap(action: (key: K, value: V) -> Unit) {
    for((k, v) in this) {
        action(k, v)
    }
}