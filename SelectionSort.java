package ordenacao;

public class SelectionSort {
    public static void ordenar(int[] arr) {
        int n = arr.length;
        int compCount = 0;
        int swapCount = 0;

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                compCount++;
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }

            // Troca o menor elemento encontrado com o primeiro elemento
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
            swapCount++;
        }

        long endTime = System.currentTimeMillis();
        long tempoDecorrido = endTime - startTime;

        System.out.println("Comparacões: " + compCount);
        System.out.println("Trocas: " + swapCount);
        System.out.println("Tempo decorrido: " + tempoDecorrido + " milissegundos");
    }
}
