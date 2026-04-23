public class Department{
    private int id;
    private String name;
    private Double gajiPokok;

    public Department(int id){
        if(id == 0){
            setDepartmentName("Staf Manager");
            setDepartmentSalary(5000000);
        }
        else if(id == 1){
            setDepartmentName("Staf Programmer");
            setDepartmentSalary(3000000);
        }
        else if(id == 2){
            setDepartmentName("Staf Analisis");
            setDepartmentSalary(3000000);
        }

        setDepartmentId(id);
    }

    public int getDepartmentId(){
        return this.id;
    }

    public void setDepartmentId(int id){
        this.id = id;
    }

    public String getDepartmentName(){
        return this.name;
    }

    public void setDepartmentName(String name){
        this.name = name;
    }

    public Double getDepartmentSalary(){
        return this.gajiPokok;
    }

    public void setDepartmentSalary(double gajiPokok){
        this.gajiPokok = gajiPokok;
    }
}
