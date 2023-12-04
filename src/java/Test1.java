
import java.util.Date;
import ma.projet.beans.Employee;
import ma.projet.beans.Service;
import ma.projet.service.EmployeeService;
import ma.projet.service.ServiceService;


public class Test1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServiceService ms = new ServiceService();
        
        ms.create(new Service("test1"));
       ms.create(new Service("test2"));
        //Afficher les services
        for(Service s : ms.getAll()){
            System.out.println("service  : "+s.getLibelle()+" : ");
         
        }
        
        
        
        
       
            EmployeeService es = new EmployeeService();
       
        es.create(new Employee("ep1", "ee1",  new Date(), "ee2",ms.getById(1)));
        es.create(new Employee("ep2", "ee2", new Date(),"ee2", ms.getById(1)));
      
       
            for(Employee m : es.getAll())
                System.out.println("\t"+m.getNom());
        }
}
