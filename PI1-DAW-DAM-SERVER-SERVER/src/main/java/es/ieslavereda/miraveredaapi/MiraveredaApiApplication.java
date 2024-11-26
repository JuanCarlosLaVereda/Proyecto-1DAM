package es.ieslavereda.miraveredaapi;

import es.ieslavereda.miraveredaapi.repository.model.OracleDataSourceDB;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;

@SpringBootApplication
public class MiraveredaApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiraveredaApiApplication.class, args);
/*        try (Connection connection = OracleDataSourceDB.getOracleDataSource().getConnection()){
            if (connection != null){
                System.out.println("Conexion establecida");
            }
        } catch (Exception e){
            e.printStackTrace();
        }*/

    }

}
