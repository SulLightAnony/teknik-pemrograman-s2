public class FullTime extends Koperasi{
    public FullTime(){
        this.gajiPokok = 0;
    }

    public double getSalary(double gajiPokok){
        return gajiPokok + getTunjanganLembur() + getTunjanganJabatan() + getTunjanganAnak() + getTunjanganKomunikasi() + 
        getBonusProduktivitas() - loanMonthly();
    }
    
    @Override
    public double loanMonthly(){
        return loan;
    }
}