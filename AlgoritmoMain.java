package ordenacao;

import java.util.Random;

public class AlgoritmoMain {
    public static void main(String[] args) {
        // Tamanhos dos vetores a serem testados
        int[] tamanhos = {100000, 1000000};

        // Testar para cada tamanho
        for (int tamanho : tamanhos) {
            int[] vetorAleatorio = gerarVetorAleatorio(tamanho);
            int[] vetorOrdenado = gerarVetorOrdenado(tamanho);
            int[] vetorInvertido = gerarVetorInvertido(tamanho);

            System.out.println("Tamanho do vetor: " + tamanho);

            // Testar cada algoritmo com os três tipos de vetor
            testarAlgoritmo(BubbleSort.class, "Bubble Sort", vetorAleatorio.clone(), vetorOrdenado.clone(), vetorInvertido.clone());
            testarAlgoritmo(InsertionSort.class, "Insertion Sort", vetorAleatorio.clone(), vetorOrdenado.clone(), vetorInvertido.clone());
            testarAlgoritmo(SelectionSort.class, "Selection Sort", vetorAleatorio.clone(), vetorOrdenado.clone(), vetorInvertido.clone());
            testarAlgoritmo(MergeSort.class, "Merge Sort", vetorAleatorio.clone(), vetorOrdenado.clone(), vetorInvertido.clone());
            testarAlgoritmo(QuickSort.class, "Quick Sort", vetorAleatorio.clone(), vetorOrdenado.clone(), vetorInvertido.clone());
            testarAlgoritmo(HeapSort.class, "Heap Sort", vetorAleatorio.clone(), vetorOrdenado.clone(), vetorInvertido.clone());

            System.out.println(); // Espaço entre os testes de diferentes tamanhos
        }
    }

    // Função para testar um algoritmo de ordenação e imprimir resultados
    private static void testarAlgoritmo(Class<?> algoritmoClass, String nome, int[] arrAleatorio, int[] arrOrdenado, int[] arrInvertido) {
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
    private static int[] gerarVetorAleatorio(int tamanho) {
        int[] arr = new int[tamanho];
        Random random = new Random();
        for (int i = 0; i < tamanho; i++) {
            arr[i] = random.nextInt();
        }
        return arr;
    }

    // Função para gerar um vetor ordenado
    private static int[] gerarVetorOrdenado(int tamanho) {
        int[] arr = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            arr[i] = i;
        }
        return arr;
    }

    // Função para gerar um vetor invertido
    private static int[] gerarVetorInvertido(int tamanho) {
        int[] arr = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            arr[i] = tamanho - i;
        }
        return arr;
    }
}
