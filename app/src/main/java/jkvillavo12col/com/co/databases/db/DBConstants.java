package jkvillavo12col.com.co.databases.db;

/**
 * Created by JkVillavo12Col on 28/10/16.
 */

public class DBConstants {

   public final static String DB_NAME = "DataBaseTest";
   public final static int DB_VERSION = 1;

   public static class Usuario {

      public final static String TABLE_USUARIO = "Usuario";

      public final static String ID = "id";
      public final static String NOMBRES = "nombres";
      public final static String APELLIDOS = "apellidos";
      public final static String CORREO = "correo";
      public final static String PASSWORD = "password";
      public final static String SEXO = "sexo";

      private static StringBuilder builderCreate;

      /**
       * Obtiene un array de Strings con los campos de la tabla
       *
       * @return array de estring de los campos de la tabla
       */
      public static String[] obtenerCampos () {

         return new String[]{ID, NOMBRES, APELLIDOS, CORREO, PASSWORD, SEXO};
      }

      public static String getSQLCreate () {

         builderCreate = new StringBuilder();
         builderCreate.append("	CREATE TABLE Usuario (	");
         builderCreate.append("	   id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,	");
         builderCreate.append("	   nombres    TEXT,	");
         builderCreate.append("	   apellidos  TEXT,	");
         builderCreate.append("	   correo TEXT,	");
         builderCreate.append("	   password   TEXT,	");
         builderCreate.append("	   sexo   NUMERIC	");
         builderCreate.append("	);	");

         return builderCreate.toString();
      }

   }

}
