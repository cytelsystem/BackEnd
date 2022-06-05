import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class crearTabla {


        public static void main(String[] args) throws Exception {

            //Crear la conexion a la base de datos
            Class.forName("org.h2.Driver").newInstance(); // instancia del driver
            Connection con = DriverManager.getConnection ("jdbc:h2:~/Estudiantes", "sa",""); //objeto conexion
            Statement stmt = con.createStatement(); // Crear objetos Statement

            //Código para crear una tabla. Elimina la tabla si esta ya existe y la vuelve a crear
            String createtable = "DROP TABLE IF EXISTS Estudiantes; CREATE TABLE Estudiantes(ID INT PRIMARY KEY, NOMBRE VARCHAR(255), APELLIDO VARCHAR(255))";
            stmt.execute(createtable); //Ejecutar SQL


        }

}
