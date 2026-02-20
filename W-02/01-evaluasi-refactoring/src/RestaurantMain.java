import java.util.Scanner;

public class RestaurantMain {
    public static void main(String[] args) {
        Restaurant menu = new Restaurant();
        tambahMenuMakanan(menu);
        tampilanMenuMakanan(menu);
        pesanMakanan(menu);
        tampilanMenuMakanan(menu);
    }

    public static void tambahMenuMakanan(Restaurant menu){
        String[] menu_nama_makanan = {"Soto", "Nasi Goreng", "Mie Goreng", "Ayam Goreng", "Bakso"};
        Double[] menu_harga_makanan = {(double) 10000, (double) 15000, (double) 12000, (double) 20000, (double) 8000};
        int[] menu_stok = {5, 20, 10, 15, -1};

        for(int i = 0; i < menu_nama_makanan.length; i++){
            menu.tambahMenuMakanan(menu_nama_makanan[i], menu_harga_makanan[i], menu_stok[i]);

            if(i != menu_nama_makanan.length - 1){
                menu.nextId();
            }
        }
    }

    public static void tampilanMenuMakanan(Restaurant menu){
        System.out.println("\nDaftar Menu Makanan:");
        menu.tampilMenuMakanan();
    }

    public static void pesanMakanan(Restaurant menu){
        Scanner input = new Scanner(System.in);
        char ulangi = 'y';

        while (ulangi == 'y' || ulangi == 'Y') {
            
            System.out.print("Pesan makanan (masukkan ID menu): ");
            int id_pesanan = input.nextInt();

            System.out.print("Jumlah pesanan: ");
            int jumlah_pesanan = input.nextInt();

            if(menu.pesanMakanan(id_pesanan, jumlah_pesanan)){
                System.out.print("\nPesan lagi? (y/n): ");
                ulangi = input.next().charAt(0);
            }

            System.out.println("");
        }

        input.close();
    }
}