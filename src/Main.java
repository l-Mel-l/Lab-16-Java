import java.util.Arrays;
import java.util.Scanner;

public class Main {
    interface ArraySorter {
        boolean sravn(int a, int b);
    }

    public static void sortirovka(int[] array, ArraySorter sorter) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (sorter.sravn(array[j], array[j+1])) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("Введите размер массива:");
            int razm = input.nextInt();
            int[] array = new int[razm];
            System.out.println("Введите элементы массива:");
            for (int i = 0; i < razm; i++) {
                array[i] = input.nextInt();
            }
            System.out.println("Массив отсортированный по возрастанию");
            sortirovka(array, ((a, b) -> a > b));
            System.out.println(Arrays.toString(array));
            System.out.println("Массив отсортированный по убыванию");
            sortirovka(array, ((a, b) -> a < b));
            System.out.println(Arrays.toString(array));
        } catch (Exception ex) {
            System.out.println("Введено неверное значение");
            System.out.println(ex.getMessage());
        }
    }
}