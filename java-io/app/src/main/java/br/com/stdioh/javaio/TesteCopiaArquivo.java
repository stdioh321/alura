/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package br.com.stdioh.javaio;

import java.io.*;

public class TesteCopiaArquivo {

    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("app/lorem.txt");
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);

        FileOutputStream fos = new FileOutputStream("app/lorem_copiado.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        BufferedWriter bw = new BufferedWriter(osw);

        br.lines().forEach(l -> {
            try {
                bw.write(l);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        br.close();
        bw.close();
    }
}

