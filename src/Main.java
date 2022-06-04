import DAO.OdontologoDAOH2;
import Model.Odontologo;
import Service.OdontologoService;

public class Main {

    public static void main(String[] args) {

        Odontologo odontologo = new Odontologo();

        odontologo.setNombre("carlos");
        odontologo.setApellido("moreno");
        odontologo.setNumeroMatricula("n5086");

        OdontologoService odontologoService = new OdontologoService();
        odontologoService.setOdontologoIDAO(new OdontologoDAOH2());
        odontologoService.guardaOdontologoService(odontologo); // guardar odontologo




        for (int i=0; i<odontologoService.listarTodosServices().size(); i++) {
            Odontologo curr = odontologoService.listarTodosServices().get(i);

            System.out.println(curr);
        }











    }
}
