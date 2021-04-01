import br.com.bytebank.model.Livro
import br.com.bytebank.model.Post
import br.com.bytebank.util.Api
import com.beust.klaxon.*
import quicktype.UserJsonPlaceholder
import java.io.StringReader
import java.lang.StringBuilder
import java.math.BigDecimal
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

fun main() {
    var livros = listOf<Livro>(
        Livro(titulo = "d", autor = "b", ano = 1990, editora = null),
        Livro(autor = "d", ano = 1991, editora = "edit1"),
        Livro(titulo = "a", autor = "f", ano = 1995, editora = "edit4"),
        Livro(titulo = "a", autor = "f", ano = 1992, editora = "edit2")
    );
    val tmp = try {
        10 / 1
    } catch (e: Exception) {
        "Tudo Errado"
    }
    println(tmp)
    livros
        .groupBy { it.editora ?: "No edit" }
        .forEach { (edit, livros) ->
            println("${edit}: ${livros.joinToString { it?.autor }}");
        }
    println(livros.sortedBy { it?.titulo }.let { it.joinToString(separator = " - ", transform = { it?.autor }) })
    val myMap = mutableMapOf<String, Int>(Pair("a", 1), "b" to 2);
    myMap.forEach { k, v -> println("$k - $v"); }
    var l1 = listOf("a", "b", "c");
    var l2 = listOf("d", "e", "f", "a", "c");


    val m1: MutableMap<Int, Any> = mutableMapOf(1 to "a", 2 to "b");
    var m2 = mutableMapOf(3 to "c", 4 to "d", 5 to 400.0, 1 to "a", 1 to "a");
    var m3 = m1.filter { true }

//    println((m1 + m2).filter { (k, v) -> v is Double });
    println(m3.toList())
    println("====================================================");

//
//    var mapLivros = livros.associateBy { it.id }.toMutableMap();
//    mapLivros.forEach { (k, v) ->
//        println("$k: ${v?.titulo}");
//    }
//    livros.groupBy {  it?.titulo ?: "Nothing"  }.forEach { (k, v) ->
//        println("$k: $v");
//    };

    var myF: () -> Unit = ::ano
    sum1(1, 3) {
        println(it);
        it;
    }


    var myLivro = Livro(titulo = "Meu Titulo", ano = 1994, autor = "Joaozinho");
    myLivro
        .also {
            println(it.titulo)
        }
        .apply {
            titulo = "Alterado...";
        }.also {
            println(it.titulo)
        }.run {
            titulo?.toUpperCase()
        }.also {
            println(it)
        }.let {

        }
    myLivro.doSomething {
        println("doSomething--------------------------------")
        println("$it")
        println(this.titulo)
    }
    somaReceiver(2, 4) {
        println("This: $this, total: $it");
    }

    var url = "https://jsonplaceholder.typicode.com/users";
    val response = Api.request(url);
    if (response.statusCode() in 200..299) {
        val users = Klaxon().parseArray<UserJsonPlaceholder>(response.body())

            .also {
                it?.forEach {
                    println(it.id);
                }
            };
        val o = Parser.default().parse(StringBuilder(response.body())) as JsonArray<*>
        o.forEach {
                (it as JsonObject)?.let {
                println(it.get("idx"))
            }
        }
    }
//    Api.objectFromRequest<UserJsonPlaceholder>(url)?.let {
//        it.forEach {
//            println("${it.id} - ${it.email}")
//        }
//    };
//
//    Api.objectFromRequest<Post>("https://jsonplaceholder.typicode.com/posts")?.let {
//        it.forEach {
//            println("${it.id} - ${it.title}")
//        }
//    };

}

fun somaReceiver(a: Int, b: Int, resultado: Double.(Int) -> Unit) {
    println("Antes");
    val total = (a + b).toDouble();
    total.resultado(total.toInt());
    println("Depois");
}

fun ano() {
    println("ano");
}

fun sum1(a: Int, b: Int, block: (res: Int) -> Int) {
    block(a + b);
}


class MyClassAno : () -> Unit {
    override fun invoke() {
        println("myClassAno");
    }

}

fun bigDecimalArrayOf(vararg valores: String): Array<BigDecimal> {
//    return Array<BigDecimal>(valores.size) { i -> valores[i].toBigDecimal() };
    return valores.map { s -> println(s); s.toBigDecimal(); }.toTypedArray<BigDecimal>();

}

fun Array<BigDecimal>.soma(): BigDecimal {
    return this.reduce { acc, valor -> println(acc); acc + valor };
}


