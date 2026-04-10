import java.util.Scanner;

public class App {

    // Kelas SharedAccumulator bertindak sebagai "Resource Bersama".
    // Kelas ini bertanggung jawab untuk menyimpan dan mengakumulasikan total akhir.
    static class SharedAccumulator {
        private long totalSum = 0;
        public synchronized void addPartialSum(long partialSum) {
            this.totalSum += partialSum;
        }

        public long getTotalSum() {
            return this.totalSum;
        }
    }

    // Kelas SumWorker adalah representasi dari satu unit proses (Thread).
    // Masing-masing objek ini akan mengeksekusi sebagian dari total pekerjaan.
    static class SumWorker extends Thread {
        private int threadId;
        private long start;
        private long end;
        private long partialSum;
        private SharedAccumulator accumulator;

        public SumWorker(int threadId, long start, long end, SharedAccumulator accumulator) {
            this.threadId = threadId;
            this.start = start;
            this.end = end;
            this.partialSum = 0; // Inisialisasi hasil parsial lokal
            this.accumulator = accumulator;
        }

        @Override
        public void run() {
            for (long i = start; i <= end; i++) {
                partialSum += i;
            }

            accumulator.addPartialSum(partialSum);
        }

        // Getter untuk proses pelaporan di Main Thread
        public long getPartialSum() { return partialSum; }
        public long getStart() { return start; }
        public long getEnd() { return end; }
        public int getThreadId() { return threadId; }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Menerima Input
        System.out.print("Masukkan Jumlah Thread: ");
        int numThreads = scanner.nextInt();
        System.out.print("Masukkan Angka Akhir: ");
        long endNumber = scanner.nextLong();
        scanner.close();

        if (numThreads > endNumber) {
            numThreads = (int) endNumber;
        }

        SharedAccumulator accumulator = new SharedAccumulator();
        SumWorker[] workers = new SumWorker[numThreads];

        long chunkSize = endNumber / numThreads;
        long remainder = endNumber % numThreads;

        long currentStart = 1;

        // Distribusi rentang tugas ke masing-masing thread
        for (int i = 0; i < numThreads; i++) {
            long currentEnd = currentStart + chunkSize - 1;

            if (i == numThreads - 1) {
                currentEnd += remainder;
            }

            workers[i] = new SumWorker(i + 1, currentStart, currentEnd, accumulator);
            workers[i].start(); // Memicu eksekusi method run() di latar belakang

            currentStart = currentEnd + 1;
        }

        // Main thread akan dihentikan sementara (block) hingga semua worker selesai bertugas.
        for (int i = 0; i < numThreads; i++) {
            try {
                workers[i].join(); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Output
        System.out.println("\n--- Laporan Eksekusi Paralel ---");
        for (int i = 0; i < numThreads; i++) {
            System.out.println("Thread " + workers[i].getThreadId() + ": " +
                    "Menjumlahkan " + workers[i].getStart() + " - " + workers[i].getEnd() +
                    " | Hasil parsial: " + workers[i].getPartialSum());
        }

        System.out.println("==================================================");
        System.out.println("Hasil Akhir (Total Sum) : " + accumulator.getTotalSum());
        
        long validation = endNumber * (endNumber + 1) / 2;
        System.out.println("Validasi Rumus Matematika: " + validation);
    }
}