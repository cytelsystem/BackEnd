import com.main.persistence.dao.impl.OdontologoDAOH2;
import com.main.Service.OdontologoService;


public class Main {


    public static void main(String[] args) {

    org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Main.class);

        OdontologoService odontologoService = new OdontologoService();  // Instancio OdontologoService
        odontologoService.setOdontologoIDAO(new OdontologoDAOH2()); // Utilizo un metodo de odontologoService y le paso una conexion OdontologoDAOH2()

        //********************************Crear un nuevo objeto (Registro)*******************************//


//        Odontologo odontologo = new Odontologo(); //Instancio Odontologo
//
//        odontologo.setNombre("Hector");
//        odontologo.setApellido("moreno");
//        odontologo.setNumeroMatricula("79904519");
//        odontologoService.guardaOdontologoService(odontologo); // le paso por parametro la informacion creada en el objeto odontologo

        //****************Consultar Todos los registro de la base de datos**********************************//

            // Debe existir un metodo toString en el Odontologo

//            int ListarTodo = odontologoService.listarTodosServices().size();
//
//            for (int i=0; i< ListarTodo; i++) {
//                Odontologo registros = odontologoService.listarTodosServices().get(i);
//                logger.info(registros);
//            }



        //***************************************Consultar por un Solo ID**************************************//

        logger.info(odontologoService.buscarOdontologoService(17));

        //****************************************Eliminar Registro por ID******************************************//
//         odontologoService.eliminar(13L);

        //****************************************************************************************************//



    }
}
