package br.com.bytebank.model

// To parse the JSON, install Klaxon and do:
//
//   val post = Post.fromJson(jsonString)
import com.beust.klaxon.*

private val klaxon = Klaxon()

data class Post (
    @Json(name = "userId")
    val userID: Long? = null,

    val id: Long? = null,
    val title: String? = null,
    val body: String? = null
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<Post>(json)
    }
}
