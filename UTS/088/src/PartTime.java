public class PartTime extends Employee{
    public double getSalary(double gajiPokok){
        return gajiPokok + getGajiPokok() + getTunjanganLembur() + getBonusProyek();
    }
}
