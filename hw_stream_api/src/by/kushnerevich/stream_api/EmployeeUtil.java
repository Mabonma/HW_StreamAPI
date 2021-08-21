package by.kushnerevich.stream_api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeUtil {

    public static Map<String, List<Employee>> groupByJobTitle(List<Employee> employeeList) {

//        Map<String, List<Employee>> resultMap = employeeList.stream().collect(Collectors.groupingBy(Employee::getJobTitle));
//        for (int i = 0; i < employeeList.size(); i++) {
//            Employee employee = employeeList.get(i);
//            List<Employee> employeeSubList = resultMap
//                    .getOrDefault(employee.getJobTitle(), new ArrayList<>());
//            employeeSubList.add(employee);
//            resultMap.put(employee.getJobTitle(), employeeSubList);
//        }
        return employeeList.stream().collect(Collectors.groupingBy(Employee::getJobTitle));
    }

    public static double calculateAverageSalary(List<Employee> employeeList) {

//        return employeeList.stream().reduce(0.0,(x,y)-> x+y.getSalary(), (x, y)->x+y);
        return employeeList.stream().mapToDouble(Employee::getSalary).average().orElseThrow();

//        int sum = 0;
//        int count = 0;
//        for (Employee employee : employeeList) {
//            sum += employee.getSalary();
//            count++;
//        }
//        return (double) sum / count;
    }

    public static List<Employee> filterByName(List<Employee> employeeList, String name) {
        return employeeList.stream().filter(x->x.getName().equals(name)).toList();

//        List<Employee> resultList = new ArrayList<>();
//        for (var item : employeeList) {
//            if (item.getName().equals(name)) {
//                resultList.add(item);
//            }
//        }
//        return resultList;
    }

    public static List<Employee> filterByNameAndSortBySalaryDesc(List<Employee> employeeList,
                                                                 String name) {
        return employeeList.stream()
                .filter(x->x.getName().equals(name))
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .toList();
//        List<Employee> resultList = new ArrayList<>();
//        for (var item : employeeList) {
//            if (item.getName().equals(name)) {
//                resultList.add(item);
//            }
//        }
//        resultList.sort(Comparator.comparing(Employee::getSalary).reversed());
//        return resultList;
    }

    public static Employee filterByNameAndFindWithMaxSalary(List<Employee> employeeList,
                                                            String name) {
        return employeeList.stream()
                .filter(x->x.getName().equals(name))
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow();
//        List<Employee> resultList = new ArrayList<>();
//        for (var item : employeeList) {
//            if (item.getName().equals(name)) {
//                resultList.add(item);
//            }
//        }
//        return Collections.max(resultList, Comparator.comparing(Employee::getSalary));
    }

}
