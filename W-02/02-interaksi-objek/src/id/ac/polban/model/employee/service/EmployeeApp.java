package id.ac.polban.model.employee.service;

import id.ac.polban.model.employee.model.Department;
import id.ac.polban.model.employee.model.Employee;
import id.ac.polban.model.employee.model.EmploymentType;

public class EmployeeApp {
    
    public static void main(String[] args) {
        Department deptIT = new Department("IT");
        Department deptHR = new Department("HRD");

        EmploymentType tipeTetap = new EmploymentType("Tetap");
        EmploymentType tipeKontrak = new EmploymentType("Kontrak");

        Employee emp1 = new Employee(1, "Andi", deptIT, tipeTetap, 5000000);
        Employee emp2 = new Employee(2, "Budi", deptHR, tipeKontrak, 4000000);

        EmployeeService service = new EmployeeService();
        service.addEmployee(emp1);
        service.addEmployee(emp2);

        System.out.println("=== DATA KARYAWAN AWAL ===");
        tampilkanInfo(service.getEmployee(1));
        tampilkanInfo(service.getEmployee(2));

        System.out.println("=== PROSES NAIK GAJI ANDI 10% ===");
        service.raiseSalary(1, 10);

        System.out.println("\n=== DATA KARYAWAN TERBARU ===");
        tampilkanInfo(service.getEmployee(1));
    }

    public static void tampilkanInfo(Employee emp) {
        if (emp != null) {
            System.out.println("ID: " + emp.getId());
            System.out.println("Nama: " + emp.getName());
            System.out.println("Departemen: " + emp.getDepartment().getName());
            System.out.println("Tipe: " + emp.getType().getType());
            System.out.println("Gaji: Rp " + emp.getSalary());
            System.out.println("-----------------------------");
        }
    }
}