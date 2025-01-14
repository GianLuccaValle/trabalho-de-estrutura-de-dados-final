package ordenacao;

public class MergeSort {
    private static int compCount = 0;
    private static int swapCount = 0;

    public static void ordenar(int[] arr) {
        compCount = 0;
        swapCount = 0;

        long startTime = System.currentTimeMillis();
        mergeSort(arr, 0, arr.length - 1);
        long endTime = System.currentTimeMillis();

        long tempoDecorrido = endTime - startTime;

        System.out.println("Comparacões: " + compCount);
        System.out.println("Trocas: " + swapCount);
        System.out.println("Tempo decorrido: " + tempoDecorrido + " milissegundos");
    }

    private static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;

            // Ordena a primeira e a segunda metade
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            // Mescla as metades ordenadas
            merge(arr, l, m, r);
        }
    }

    private static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        System.arraycopy(arr, l, L, 0, n1);
        System.arraycopy(arr, m + 1, R, 0, n2);

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            compCount++;
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
            swapCount++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
            swapCount++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
            swapCount++;
        }
    }
}
