import br.com.bytebank.model.*
import br.com.bytebank.util.CalculadoBonificacao
import java.awt.EventQueue
import javax.swing.JFrame
import kotlin.math.absoluteValue

fun main() {
    var sys = SistemInterno();
    var g1 = Gerente("Mario", "11111111111", 1000.0, "1234");
    var d1 = Diretor("Peach", "22222222222", 1500.0, "1234");
    sys.entra(g1, "g1.senha");
    sys.entra(d1, d1.senha);

}
