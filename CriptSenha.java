/*
* Uso:
* CriptSenha.encripta("String de senha", "MD5");
* Ele retorna uma string com o hash da string passada no primeiro parâmetro.
* No segundo parâmetro, pode ser MD5, SHA-1 ou SHA-256.
*/
package criptsenha;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CriptSenha {
    private static byte vetor[] = null;
    private static StringBuilder cript = null;
    private static String hash = "";
    
    public static String encripta(String sen, String tipo) {
        try {
            vetor = MessageDigest.getInstance(tipo).digest(sen.getBytes()); // Importe java.security.MessageDigest;
            cript = new StringBuilder();
            
            for(int i = 0; i < vetor.length; i++) {
                cript.append(Integer.toHexString((vetor[i] & 0xFF) | 0x100).substring(1, 3));
            }
            
            hash = cript.toString();
            
            return hash;
        } 
        catch(NoSuchAlgorithmException ex) { // Importe java.security.NoSuchAlgorithmException;
            System.err.println("ERRO: " + ex.getMessage());
            
            return null;
        }
    }
}