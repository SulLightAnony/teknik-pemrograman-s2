import java.util.Arrays;

public class ProblemThree {
    public static void main(String[] args) {
        int arr[] = {12, 4, 3, 1, 9, 657};
        int n = 3; // Mencari elemen terbesar ke-3
        int ans = Arrays.stream(arr).boxed()

        // Konversi ke Stream<Integer>
        .sorted((a, b) -> Integer.compare(b, a)) // Urutkan descending

        // Lewati 2 elemen pertama
        .skip(n - 1)

        // Ambil elemen yang tersisa
        .findFirst()

        // Nilai default jika tidak ada
        .orElse(0);

        System.out.println("Elemen terbesar ke-3 adalah: " + ans);
    }
}