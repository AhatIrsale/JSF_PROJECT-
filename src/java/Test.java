
import ma.projet.beans.Salle;
import ma.projet.service.MachineService;
import ma.projet.service.SalleService;


public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SalleService ss = new SalleService();
        //création des Salles
        ss.create(new Salle("I", "Informatique"));
        ss.create(new Salle("A", "Arabe"));
        ss.create(new Salle("C", "Comptailité"));
        //La liste des salles
        for (Salle s : ss.getAll()) {
            System.out.println("" + s.getCode());
        }
    }
}
