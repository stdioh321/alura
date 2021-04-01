package br.com.bytebank.util

import com.beust.klaxon.Klaxon
import java.lang.Exception
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class Api {

    companion object {
        fun request(url: String, body: String? = null, method: Method = Method.GET): HttpResponse<String> {

            val client = HttpClient.newBuilder().build();
            var request: HttpRequest = with(
                HttpRequest.newBuilder()
                    .uri(URI.create(url))
            ) {
                when {

                    method.equals(Method.POST) -> {
                        this.POST(HttpRequest.BodyPublishers.ofString(body));
                    }
                    method.equals(Method.PUT) -> {
                        this.PUT(HttpRequest.BodyPublishers.ofString(body));
                    }
                    method.equals(Method.DELETE) -> {
                        this.DELETE();
                    }
                    else -> this.GET()
                }

            }.build();

            return client.send(request, HttpResponse.BodyHandlers.ofString());

        }

        inline fun <reified T : Any> objectFromRequest(
            url: String,
            body: String? = null,
            method: Method = Method.GET
        ): List<T>? {
            val response = request(url, body, method);
            return response.body()?.let {

                var res: List<T>? = try {
                    Klaxon().parseArray<T>(it)
                } catch (e1: Exception) {
                    try {
                        listOf(
                            Klaxon().parse<T>(it) as T
                        )
                    } catch (e2: Exception) {
                        null
                    }
                }
                res;
            }
        }
    }

}

enum class Method(val type: String) {
    GET("GET"),
    POST("POST"),
    PUT("PUT"),
    DELETE("DELETE")
}