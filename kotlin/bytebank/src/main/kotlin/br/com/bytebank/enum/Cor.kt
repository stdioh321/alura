package br.com.bytebank.enum

enum class Cor(val red: String, val green: String, val blue: String) {
    VERMELHO("255", "0", "0");


    fun rgb() = "${red} ${green} ${blue}";
}