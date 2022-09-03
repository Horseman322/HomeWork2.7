import java.util.HashMap;
import java.util.Map;


public class EmployeeBook {

    private final Map<String, Employee> employees;

    public EmployeeBook() {
        employees = new HashMap<>();
    }

    private String getKey(Employee employee){
        return employee.getName() + " " + employee.getSecondName() + " " + employee.getThirdName();
    }

    public void addEmployee(Employee employee){
        employees.put(getKey(employee), employee);
    }
    public void addEmployee(String name,
                            String secondName,
                            String thirdName,
                            double salary,
                            int department){
        addEmployee(new Employee(name, secondName, thirdName, salary, department));
    }

    public void removeEmployee(Employee employee){
        employees.remove(getKey(employee));
    }

    public void removeEmployee(int id) {
        for (Map.Entry<String, Employee> entry : employees.entrySet()) {
            if(entry.getValue().getId() == id){
                employees.remove(entry.getKey());
                break;
            }
        }
    }

    public void changeSalary(Employee employee,
                             double newSalary) {
        String key = getKey(employee);
        if (employees.containsKey(key)){
            employees.get(key).setSalary(newSalary);
        }
    }

    public void changeDepartment(Employee employee,
                                 int newDepartment){
        String key = getKey(employee);
        if (employees.containsKey(key)){
            employees.get(key).setDepartment(newDepartment);
        }
    }
    public void printEmployeeByDepartment(){
        for (int department = 1; department <= 5; department ++) {
            System.out.println("Сотрудник из отдела " + department + ":");
            for (Employee employee : employees.values()) {
                if (employee.getDepartment() == department){
                    System.out.println(employee.getSecondName() + employee.getName() + employee.getThirdName());
                }
            }
        }
    }

    public void printEmployeeWithSalaryLessThan(double bound){
        System.out.println("Сотрудник с ЗП меньшей, чем " + bound);
        for (Employee employee : employees.values()){
            if (employee.getSalary() < bound){
                System.out.println(
                        "id: %d, ФИО: %s %s %s, ЗП: %.2f%n");
            }
        }
    }
    public Employee findEmployeeWithMinSalary() {
        double minSalary = Double.MAX_VALUE;
        String key = null;
        for (Map.Entry<String, Employee> entry : employees.entrySet()) {
            Employee employee = entry.getValue();
            if (employee.getSalary() < minSalary){
                minSalary = employee.getSalary();
                key = entry.getKey();
            }
        }
        if (key != null) {
            return employees.get(key);
        }else {
            return null;
        }
    }
    public Employee findEmployeeWithMaxSalary() {
        double maxSalary = Double.MIN_VALUE;
        String key = null;
        for (Map.Entry<String, Employee> entry : employees.entrySet()) {
            Employee employee = entry.getValue();
            if (employee.getSalary() > maxSalary){
                maxSalary = employee.getSalary();
                key = entry.getKey();
            }
        }
        if (key != null) {
            return employees.get(key);
        }else {
            return null;
        }
    }
    public double totalSalaries() {
        double sum = 0;
        for (Employee employee : employees.values()){
            sum += employee.getSalary();
        }
        return sum;
    }













}

