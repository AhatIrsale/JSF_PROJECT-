/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.domaine;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import ma.projet.beans.Employee;
import ma.projet.beans.Service;
import ma.projet.service.EmployeeService;
import ma.projet.service.ServiceService;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartModel;
import org.primefaces.model.chart.ChartSeries;


@ManagedBean(name = "employe")
public class EmployeeBean {

    private Employee employee;
    private Service service;
    private List<Employee> employees;
    private EmployeeService employeeService;
    private ServiceService serviceService;
    private static ChartModel barModel;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public List<Employee> getEmployees() {
        if (employees == null) {
            employees = employeeService.getAll();
        }
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public EmployeeService getEmployeeService() {
        return employeeService;
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public ServiceService getServiceService() {
        return serviceService;
    }

    public void setServiceService(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    public EmployeeBean() {
        employee = new Employee();
        employee.setService(new Service()); // Initialize the service object within employee
        employeeService = new EmployeeService();
        serviceService = new ServiceService();
        service = null;  // Initialize the service object

    }

    public String onCreateAction() {
        employeeService.create(employee);
        employee = new Employee();
        return null;
    }

    public String onDeleteAction() {

        employeeService.delete(employeeService.getById((int) employee.getId()));
        return null;
    }

    public List<Employee> serviceLoad() {
        employees = new ArrayList<>(); // Initialize the list
        for (Employee m : employeeService.getAll()) {
            if (m.getService().equals(service)) {
                employees.add(m);
            }
        }
        return employees;

    }

    public void load() {
            service = new Service();
    service = serviceService.getById((int) service.getId());

    // Ensure that each employee's service is initialized
    for (Employee m : employees) {
        m.setService(new Service()); // Initialize the service object within employee
    }

    getEmployees();
    }

    public void onEdit(RowEditEvent event) {
        employee = (Employee) event.getObject();
        Service service = serviceService.getById((int) this.employee.getService().getId());
        employee.setService(service);
        employee.getService().setLibelle(service.getLibelle());
        employeeService.update(employee);
    }

    public void onCancel(RowEditEvent event) {
    }

    public ChartModel getBarModel() {
        return barModel;
    }

}
