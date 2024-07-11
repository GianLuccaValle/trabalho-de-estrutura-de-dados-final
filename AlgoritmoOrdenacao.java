

package ordenacao;

import java.util.Random;

public class AlgoritmoMain {
    // Função para testar um algoritmo de ordenação e imprimir resultados
    public static void testarAlgoritmo(Class<?> algoritmoClass, String nome, int[] arrAleatorio, int[] arrOrdenado, int[] arrInvertido) {
        System.out.println(nome + " - Vetor Aleatório:");
        testarOrdenacao(algoritmoClass, arrAleatorio);

        System.out.println(nome + " - Vetor Ordenado:");
        testarOrdenacao(algoritmoClass, arrOrdenado);

        System.out.println(nome + " - Vetor Invertido:");
        testarOrdenacao(algoritmoClass, arrInvertido);
    }

    // Função para testar a ordenação e imprimir estatísticas
    private static void testarOrdenacao(Class<?> algoritmoClass, int[] arr) {
        try {
            algoritmoClass.getMethod("ordenar", int[].class).invoke(null, (Object) arr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Função para gerar um vetor com números aleatórios
    public static int[] gerarVetorAleatorio(int tamanho) {
        int[] arr = new int[tamanho];
        Random random = new Random();
        for (int i = 0; i < tamanho; i++) {
            arr[i] = random.nextInt();
        }
        return arr;
    }

    // Função para gerar um vetor ordenado
    public static int[] gerarVetorOrdenado(int tamanho) {
        int[] arr = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            arr[i] = i;
        }
        return arr;
    }

    // Função para gerar um vetor invertido
    public static int[] gerarVetorInvertido(int tamanho) {
        int[] arr = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            arr[i] = tamanho - i;
        }
        return arr;
    }
}
