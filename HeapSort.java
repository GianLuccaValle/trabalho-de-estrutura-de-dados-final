package ordenacao;
public class HeapSort {
    private static int compCount = 0;
    private static int swapCount = 0;

    public static void ordenar(int[] arr) {
        int n = arr.length;
        compCount = 0;
        swapCount = 0;

        long startTime = System.currentTimeMillis();

        // Construir o heap (rearranjar o array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Extrair elementos um por um do heap
        for (int i = n - 1; i > 0; i--) {
            // Mover a raiz atual para o final do array
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            swapCount++;

            // chamar max heapify no heap reduzido
            heapify(arr, i, 0);
        }

        long endTime = System.currentTimeMillis();

        long tempoDecorrido = endTime - startTime;

        System.out.println("Comparacões: " + compCount);
        System.out.println("Trocas: " + swapCount);
        System.out.println("Tempo decorrido: " + tempoDecorrido + " milissegundos");
    }

    // Função para construir o heap
    private static void heapify(int[] arr, int n, int i) {
        int maior = i; // Inicializar o maior como raiz
        int esquerda = 2 * i + 1; // índice do filho esquerdo
        int direita = 2 * i + 2; // índice do filho direito

        // Se o filho esquerdo for maior que a raiz
        if (esquerda < n) {
            compCount++;
            if (arr[esquerda] > arr[maior]) {
                maior = esquerda;
            }
        }

        // Se o filho direito for maior que o maior até agora
        if (direita < n) {
            compCount++;
            if (arr[direita] > arr[maior]) {
                maior = direita;
            }
        }

        // Se o maior não é a raiz
        if (maior != i) {
            int troca = arr[i];
            arr[i] = arr[maior];
            arr[maior] = troca;
            swapCount++;

            // Recursivamente heapify o subárvore afetada
            heapify(arr, n, maior);
        }
    }
}
