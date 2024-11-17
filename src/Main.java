import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    /**
     * Método principal que executa o programa de criptografia. O programa solicita que o
     * usuário insira uma palavra, criptografa essa palavra usando a classe `Criptografia`
     * e exibe o resultado. O programa continua a executar até que o usuário insira a palavra
     * "exit", momento em que o programa será encerrado.
     *
     * Fluxo do programa:
     * 1. O usuário é solicitado a digitar uma palavra.
     * 2. A palavra é passada para o método `criptografar()` da classe `Criptografia`,
     *    que processa e exibe o texto criptografado.
     * 3. O programa continua a pedir entradas até que o usuário digite "exit".
     * 4. Quando "exit" é digitado, o programa exibe "Encerrando programa..." e termina.
     *
     * @param args parâmetros passados na linha de comando (não utilizados neste programa)
     */
    public static void main(String[] args) {
        /**
         * Instanciando um objeto da Classe Scanner para receber os dados de entrada do usuário.
         * A classe `Criptografia` também é instanciada para processar o texto.
         * O programa entra em um laço de repetição onde ficará aguardando o usuário digitar a entrada.
         * O laço será interrompido se o usuário digitar "exit".
         */
        Scanner ler = new Scanner(System.in);
        Criptografia criptografia = new Criptografia();

        // Inicia o laço de repetição para obter entradas do usuário
        while (true) {
            System.out.println("Digite um palavra ou 'exit' para encerrar:");
            String texto = ler.nextLine(); // Lê a entrada do usuário
            // Verifica se o usuário deseja encerrar o programa
            if(texto.equalsIgnoreCase("exit")){
                System.out.println("Encerrando programa..."); // Mensagem de encerramento
                break; // Encerra o laço e o programa
            }
            // Criptografa o texto fornecido pelo usuário
            criptografia.criptografar(texto);
        }
    }

}