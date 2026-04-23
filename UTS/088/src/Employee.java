public class Employee extends Department {
    private String namaPekerja;
    private int idDepartment;
    private int projekSelesai;
    private int lamaBekerjaBulan;
    private int jumlahAnak;
    private String statusHari;
    private int totalJam;
    private double gajiPokok;

    public Employee(String namaPekerja, int idDepartment, int projekSelesai, int lamaBekerjaBulan, int jumlahAnak, String statusHari, int totalJam){
        super(idDepartment);

        setNamaPekerja(namaPekerja);
    }

    public String getNamaPekerja(){
        return this.namaPekerja;
    }

    public void setNamaPekerja(String namaPekerja){
        this.namaPekerja = namaPekerja;
    }

    public double getGajiPokok(){
        return this.gajiPokok;
    }

    public double getTunjanganKomunikasi(){
        return 500000;
    }

    public double getTunjanganLembur(String statusHari, int totalJam){
        double value = 50000;

        if(statusHari == "Weekday"){
            value = 30000;
        }

        return totalJam * value;
    }

    public double getTunjanganAnak(int totalAnak){
        if(totalAnak > 3){
            totalAnak = 3;
        }

        return totalAnak * 500000;
    }

    public double getBonusProduktivitas(int totalJam, double gajiPokok){
        return totalJam > 200 ? (gajiPokok * 10) / 100 : 0;
    }

    public double getBonusProyek(int projekSelesai){
        return projekSelesai * 200000;
    }
}
