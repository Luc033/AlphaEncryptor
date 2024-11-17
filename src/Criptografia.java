import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A classe Criptografia implementa um sistema simples de criptografia que converte
 * cada letra de um texto em um número correspondente ao seu índice no alfabeto.
 * Caracteres que não são letras do alfabeto são mantidos inalterados.
 *
 * @Author Luc033
 */

public class Criptografia {

    /** Um array contendo as letras do alfabeto em ordem. */
    private Character[] alfabeto = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    /** String que armazena a versão criptografada do texto de entrada. */
    private String criptografia = "";

    /** Array de caracteres que armazena o texto de entrada convertido para caracteres individuais. */
    private char[] letrasEntrada;

    /**
     * Método principal de criptografia que processa o texto de entrada, convertendo
     * cada letra em seu índice correspondente no alfabeto e adicionando o resultado
     * à String de criptografia. O texto é convertido para minúsculas e tem os
     * espaços removidos antes do processamento. Caso o texto contenha caracteres
     * que não sejam letras, uma mensagem de erro é exibida.
     *
     * @param texto o texto a ser criptografado
     */
    public void criptografar(String texto) {
        this.letrasEntrada = texto.trim().toLowerCase().toCharArray();
        boolean excecao = false;
        try {
            verificaLetras(letrasEntrada);
        } catch (IllegalArgumentException e) {
            excecao = true;
        }

        if (!excecao) {
            System.out.println(texto + " criptografado é: ");
            System.out.println(criptografia);
        } else {
            System.out.println("Valor incorreto.");
        }
        this.criptografia = "";
    }

    /**
     * Verifica se cada caractere do texto de entrada está presente no alfabeto.
     * Para cada letra válida, chama o método `enumerar()` para obter o índice da
     * letra e concatená-lo à String de criptografia. Caracteres que não estão no
     * alfabeto são adicionados diretamente à criptografia sem alteração.
     *
     * @param letrasEntrada o array de caracteres do texto a ser verificado
     * @throws IllegalArgumentException se o texto contiver caracteres inválidos
     */
    public void verificaLetras(char[] letrasEntrada) {
        List<Character> letrasCharacter = new ArrayList<>();
        List<Character> alfabetoStream = new ArrayList<>();
        for (char letra : letrasEntrada) {
            letrasCharacter.add(((Character) letra));
        }

        alfabetoStream = Arrays.stream(alfabeto).toList();

        for (Character letra : letrasCharacter) {
            if (alfabetoStream.contains(letra)) {
                this.criptografia += enumerar(letra);
            } else {
                this.criptografia += letra;
            }
        }
    }

    /**
     * Retorna o índice de uma letra específica no alfabeto como uma String.
     * O índice é incrementado em 1 para representar a posição usual das letras
     * no alfabeto (1 para 'a', 2 para 'b', etc.).
     *
     * @param letra a letra para a qual o índice deve ser encontrado
     * @return uma String contendo o índice da letra no alfabeto, ou null se a letra não for encontrada
     */
    public String enumerar(Character letra) {
        String res = null;
        for (int i = 0; i < alfabeto.length; i++) {
            if (letra == alfabeto[i]) {
                int num = i + 1;
                res = String.valueOf(num);
            }
        }
        return res;
    }
}
