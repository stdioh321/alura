package br.com.bytebank.model

import java.util.*

class Livro(
    var id: UUID = UUID.randomUUID(),
    var titulo: String? = null,
    var autor: String,
    var ano: Int,
    var editora: String? = null
) {
    fun doSomething(action: Livro.(a:Int) -> Unit) {
        action(2);
    }
}