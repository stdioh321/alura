package br.com.stdioh.javaio;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class TesteEncoding {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = "ç";
        System.out.println(s.codePointAt(0));
        System.out.println(Charset.defaultCharset().displayName());

        System.out.println(s.getBytes(StandardCharsets.US_ASCII).length);


        String sNovo = new String("Sérgio".getBytes(), StandardCharsets.US_ASCII);
        System.out.println(sNovo);
    }
}
