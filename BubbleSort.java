
package ordenacao;

public class BubbleSort {
    public static void ordenar(int[] arr) {
        int n = arr.length;
        int compCount = 0;
        int swapCount = 0;

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < n - 1; i++) {
            boolean trocou = false;
            for (int j = 0; j < n - i - 1; j++) {
                compCount++;
                if (arr[j] > arr[j + 1]) {
                    // troca arr[j] e arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapCount++;
                    trocou = true;
                }
            }
            if (!trocou)
                break; // O array já está ordenado
        }

        long endTime = System.currentTimeMillis();
        long tempoDecorrido = endTime - startTime;

        System.out.println("Comparacões: " + compCount);
        System.out.println("Trocas: " + swapCount);
        System.out.println("Tempo decorrido: " + tempoDecorrido + " milissegundos");
    }
}
