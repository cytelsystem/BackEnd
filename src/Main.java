import DAO.OdontologoDAOH2;
import Model.Odontologo;
import Service.OdontologoService;

import java.net.SocketTimeoutException;

public class Main {

    public static void main(String[] args) {


        OdontologoService odontologoService = new OdontologoService();  // Instancio OdontologoService
        odontologoService.setOdontologoIDAO(new OdontologoDAOH2()); // Utilizo un metodo de odontologoService y le paso una conexion OdontologoDAOH2()

        //********************************Crear un nuevo objeto (Registro)*******************************//


//        Odontologo odontologo = new Odontologo(); //Instancio Odontologo
//
//        odontologo.setNombre("Ivonne");
//        odontologo.setApellido("Perez");
//        odontologo.setNumeroMatricula("52813884");
//        odontologoService.guardaOdontologoService(odontologo); // le paso por parametro la informacion creada en el objeto odontologo

        //****************Consultar Todos los registro de la base de datos**********************************//

            // Debe existir un metodo toString en el Odontologo
//        int ListarTodo = odontologoService.listarTodosServices().size();
//
//        for (int i=0; i< ListarTodo; i++) {
//            Odontologo curr = odontologoService.listarTodosServices().get(i);
//
//            System.out.println(curr);
//        }


        //***************************************Consultar por un Solo ID**************************************//

//        System.out.println(odontologoService.buscarOdontologoService(14));

        //****************************************************************************************************//



    }
}
