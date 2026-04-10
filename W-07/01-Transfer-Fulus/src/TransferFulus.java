class Account {
    int balance = 150;
}

public class TransferFulus {
    public static void main(String[] args) throws InterruptedException {
        Account acc1 = new Account();
        Account acc2 = new Account();

        // Thread 1: Menjumlahkan/ transfer fulus dari acc1 ke acc2
        Thread t1 = new Thread(() -> {
            synchronized (acc1) { // Blok ini berfungsi untuk mengunci objek acc1 agar thread lain tidak bisa mengaksesnya sampai thread ini selesai dengan blok ini.
                System.out.println("Berikan pesan yang di cetak sebagai penanda thread ini sedang melakukan apa?");
                try { Thread.sleep(100); } catch (Exception e) {} // Simulasi dengan memberikan jeda. Mengapa diperlukan Exception?: Supaya program tidak crash jika terjadi interupsi saat thread sedang tidur.

                synchronized (acc2) { // Blok ini berfungsi untuk menguci objek acc1 lagi
                    System.out.println("Berikan pesan yang di cetak sebagai penanda thread ini sedang melakukan apa?");
                    acc2.balance += acc1.balance;
                }
            }
        });

        // Thread 2: Menjumlahkan/ transfer fulus dari acc2 ke acc1
        Thread t2 = new Thread(() -> {
            synchronized (acc2) { // Blok ini berfungsi agar blok acc2 tidak bisa diakses oleh thread lain hingga thread ini selesai dijalankan
                System.out.println("Berikan pesan yang di cetak sebagai penanda thread ini sedang melakukan apa?");
                try { Thread.sleep(100); } catch (Exception e) {}

                synchronized (acc1) { // Blok ini berfungsi agar blok acc1 tidak bisa diakses oleh thread lain hingga thread ini selesai dijalankan
                    System.out.println("Berikan pesan yang di cetak sebagai penanda thread ini sedang melakukan apa?");
                    acc1.balance += acc2.balance;
                }
            }
        });

        t1.run();
        t2.run();

        t1.join();
        t2.join();

        System.out.println("--- HASIL AKHIR ---");
        System.out.println("Saldo Akhir acc1: " + acc1.balance);
		System.out.println("Saldo Akhir acc2: " + acc2.balance);
    }
}