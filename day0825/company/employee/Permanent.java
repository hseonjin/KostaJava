package company.employee;

public class Permanent extends Employee{
    int salary; // 급여
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Permanent(){}

    public Permanent(int id, String name, int salary){
        super(id, name); 
        this.salary=salary;
    }

    public int getPay(){ 
        return getSalary();
    }
//    @Override
//    public String info(){
//        return super.info() + ", 급여 : " + getPay();
//    }

    @Override
    public String toString() {
    	return super.toString() + ", 급여 : " + getPay();
    }
}