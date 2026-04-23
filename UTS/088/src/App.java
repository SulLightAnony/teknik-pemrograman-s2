public class App extends Employee{
    public static void main(String[] args) throws Exception {
        Employee E1 = new Employee();

        showData(E1, "Asep", 0, 1, 3, 2, 500000, "Weekend", 6);

        Employee("Ujang", 1, 1, 3, 50, 500000, "Weekend", 9);
        showData();
    }

    public static void showData(Employee E1, String namaPekerja, int idDepartment, int totalJam){
        System.out.println("==== Slip Gaji Bulan Maret ====\nTanggal Terbit: 1 April 2026\nTanggal Pembayaran: 1 April 2026\n\n");
        System.out.println("Nama: " + E1.getNamaPekerja(namaPekerja) + "\nJabatan: " + getDepartmentName(idDepartment) + "\nTotal Jam Kerja: " + getHourTotal(totalJam) + "\nTotal Tunjangan: " + getTunjangan(getTunjanganKomunikasi(), getTunjanganLembur(), getTunjanganAnak(), getBonusProduktivitas(), getBonusProyek()) + "");
    }
}