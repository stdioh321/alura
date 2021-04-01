// To parse the JSON, install Klaxon and do:
//
//   val welcome = Welcome.fromJson(jsonString)

package quicktype

import com.beust.klaxon.*

private val klaxon = Klaxon()

data class UserJsonPlaceholder (
    val id: Long? = null,
    val name: String? = null,
    val username: String? = null,
    val email: String? = null,
    val address: Address? = null,
    val phone: String? = null,
    val website: String? = null,
    val company: Company? = null
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<UserJsonPlaceholder>(json)
    }
}

data class Address (
    val street: String? = null,
    val suite: String? = null,
    val city: String? = null,
    val zipcode: String? = null,
    val geo: Geo? = null
)

data class Geo (
    val lat: String? = null,
    val lng: String? = null
)

data class Company (
    val name: String? = null,
    val catchPhrase: String? = null,
    val bs: String? = null
)
