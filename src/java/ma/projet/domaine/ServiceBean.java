/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.domaine;

import java.util.List;
import javax.faces.bean.ManagedBean;
import ma.projet.beans.Service;
import ma.projet.service.ServiceService;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartModel;
import org.primefaces.model.chart.ChartSeries;


@ManagedBean(name = "service")
public class ServiceBean {

    private Service service;
    private ServiceService serviceService;
    private List<Service> services;
   // private List<Machine> machines;
    //private static ChartModel barModel;

    public ServiceBean() {
        service = new Service();
        serviceService = new ServiceService();
    }

   /* public List<Machine> getMachines() {
        if (machines == null) {
            machines = s.getMachines();
        }
        return machines;
    }
*/
    /*public void setMachines(List<Machine> machines) {
        this.machines = machines;
    }*/

    public List<Service> getServices() {
        if (services == null) {
            services = serviceService.getAll();
        }
        return services;
    }

    public void setService(List<Service> services) {
        this.services = services;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public String onCreateAction() {
        serviceService.create(service);
        service  = new Service();
        return null;
    }

    public void onDeleteAction() {
        //salle.setMachines(null);
        serviceService.delete(service);

    }

    public void onEdit(RowEditEvent event) {
        service = (Service) event.getObject();
        //service.setMachines(null);
        serviceService.update(service);
    }

    public void load() {
        System.out.println(service.getLibelle());
        service = serviceService.getById((int) service.getId());
        //getMachines();
    }

    public void onCancel(RowEditEvent event) {
    }

   /* public void onEditm(RowEditEvent event) {
        machine = (Machine) event.getObject();
        Salle salle = salleService.getById(this.machine.getSalle().getId());
        machine.setSalle(salle);
        machine.getSalle().setLibelle(salle.getLibelle());
        machineService.update(machine);
    }*/

    /*public String onDeleteActionm() {

        machineService.delete(machineService.getById(machine.getId()));
        return null;
    }
*/
   /* public List<Machine> salleLoad() {
        for (Machine m : machineService.getAll()) {
            if (m.getSalle().equals(salle)) {
                machines.add(m);
            }
        }
        return machines;

    }
*/
   /* public void onCancelm(RowEditEvent event) {
    }
*/
  /*  public ChartModel getBarModel() {
        return barModel;
    }*/

   /* public ChartModel initBarModel() {
        CartesianChartModel model = new CartesianChartModel();
        ChartSeries series = new ChartSeries();
        series.setLabel("Service");
        model.setAnimate(true);
        for (Service s : serviceService.getAll()) {
            series.set(s.getLibelle());
        }
        model.addSeries(services);
        
                
        return model;
    }
    */
}