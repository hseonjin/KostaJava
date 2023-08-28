package company.employee;

public abstract class Employee {
    int id; // 사원 번호
    String name; // 이름
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public abstract int getPay(); // 추상 메서드 
    public Employee(){}
    public Employee(int id, String name){ 
        this.id= id;
        this.name = name;
    }

//    public String info(){
//        return "사번 : " + id + ",\t이름 : " + name;
//    }
    @Override
    public String toString() {
    	return "사번 : " + id + ",\t이름 : " + name;
    }
}