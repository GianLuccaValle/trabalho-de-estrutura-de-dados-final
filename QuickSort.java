package ordenacao;

import java.util.Stack;

public class QuickSort {
    private static int compCount = 0;
    private static int swapCount = 0;

    public static void ordenar(int[] arr) {
        compCount = 0;
        swapCount = 0;

        long startTime = System.currentTimeMillis();
        quickSort(arr, 0, arr.length - 1);
        long endTime = System.currentTimeMillis();

        long tempoDecorrido = endTime - startTime;

        System.out.println("Quick Sort :");
        System.out.println("Comparações: " + compCount);
        System.out.println("Trocas: " + swapCount);
        System.out.println("Tempo decorrido: " + tempoDecorrido + " milissegundos");
    }

    private static void quickSort(int[] arr, int low, int high) {
        Stack<Integer> stack = new Stack<>();
        stack.push(low);
        stack.push(high);

        while (!stack.isEmpty()) {
            high = stack.pop();
            low = stack.pop();

            int pi = partition(arr, low, high);

            if (pi - 1 > low) {
                stack.push(low);
                stack.push(pi - 1);
            }

            if (pi + 1 < high) {
                stack.push(pi + 1);
                stack.push(high);
            }
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            compCount++;
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
                swapCount++;
            }
        }
        swap(arr, i + 1, high);
        swapCount++;
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
