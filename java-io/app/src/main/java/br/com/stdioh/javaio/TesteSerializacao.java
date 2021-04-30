package br.com.stdioh.javaio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.io.*;
import java.net.URISyntaxException;
import java.util.Scanner;

public class TesteSerializacao {
    public static void main(String[] args) throws IOException, ClassNotFoundException, URISyntaxException {
        String nome = "Sérgio";

        var r = Thread.currentThread().getContextClassLoader().getResourceAsStream("lorem3.txt");
        var scn = new Scanner(r);
        while (scn.hasNextLine()) System.out.println(scn.nextLine());
        scn.close();
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("lorem4.bin"));
        oos.writeObject(
//                new ArrayList<>() {{
//                    add(new Cliente(10, "Mario"));
//                    add(new Cliente(12, "Peach"));
//                }}
                new Cliente(123, "Mario")
        );
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("lorem4.bin"));
        try {
            var novoObj = (Cliente) ois.readObject();
            System.out.println(novoObj);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

@Data
@AllArgsConstructor
@ToString
class Cliente implements Serializable {
    private static final long serialVersionUID = 2L;
    private Integer id;
    private String nome;
}