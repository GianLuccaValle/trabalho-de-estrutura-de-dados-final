package ordenacao;

public class InsertionSort {
    public static void ordenar(int[] arr) {
        int compCount = 0;
        int swapCount = 0;

        long startTime = System.currentTimeMillis();

        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int chave = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > chave) {
                arr[j + 1] = arr[j];
                j = j - 1;
                compCount++;
                swapCount++;
            }
            arr[j + 1] = chave;
            compCount++;
        }

        long endTime = System.currentTimeMillis();
        long tempoDecorrido = endTime - startTime;

        System.out.println("Comparacões: " + compCount);
        System.out.println("Trocas: " + swapCount);
        System.out.println("Tempo decorrido: " + tempoDecorrido + " milissegundos");
    }
}
