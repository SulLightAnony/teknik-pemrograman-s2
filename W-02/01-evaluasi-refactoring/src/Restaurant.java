public class Restaurant {
    private String[] nama_makanan;
    private double[] harga_makanan;
    private int[] stok;
    private byte id = 0;

    public Restaurant() {
        nama_makanan = new String[10];
        harga_makanan = new double[10];
        stok = new int[10];
    }

    public void tambahMenuMakanan(String nama, double harga, int stok) {
        if(!isAvailable(stok)){
            System.out.println("\nPeringatan: Stok menu " + nama + " tidak boleh kurang dari 1, maka stok akan diatur menjadi 0.");
            stok = 0;
        }

        this.nama_makanan[id] = nama;
        this.harga_makanan[id] = harga;
        this.stok[id] = stok;
    }

    public void tampilMenuMakanan() {
        for (int i = 0; i <= id; i++) {
            System.out.println(
                    "(" + i + ") " + nama_makanan[i] + "[" + stok[i] + "]" + " - Rp. " + harga_makanan[i]);
        }

        System.out.println("");
    }

    public boolean isOutOfStock(int id, int stok) {
        if (this.stok[id] - stok < 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isAvailable(int stok) {
        if (stok > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void nextId() {
        id++;
    }

    public boolean pesanMakanan(int id, int stok){
        if(isOutOfStock(id, stok)){
            System.out.println("\nMaaf, stok menu " + nama_makanan[id] + " tidak cukup untuk memenuhi pesanan Anda. Pesanan dibatalkan, silahkan ulangi.");
            return false;
        } else {
            this.stok[id] -= stok;
            System.out.println("Pesanan " + stok + " " + nama_makanan[id] + " dengan total harga Rp " + (this.harga_makanan[id] * stok) + " berhasil!");
            return true;
        }
    }
}