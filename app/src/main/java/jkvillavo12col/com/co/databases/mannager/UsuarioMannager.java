package jkvillavo12col.com.co.databases.mannager;

import android.content.ContentValues;
import android.content.Context;

import jkvillavo12col.com.co.databases.dao.UsuarioDaoSqlite;
import jkvillavo12col.com.co.databases.db.ConexionSQLite;
import jkvillavo12col.com.co.databases.db.DBConstants;
import jkvillavo12col.com.co.databases.entities.Usuario;

/**
 * Created by JkVillavo12Col on 28/10/16.
 */

public class UsuarioMannager {

   private static UsuarioMannager instance;

   /**
    * Obtiene la instancia unica de la clase
    * Creado el 28/10/16 a las 12:00 PM <br>
    *
    * @return instancia unica de la clase
    */
   public static UsuarioMannager getInstance () {

      if (instance == null) {
         instance = new UsuarioMannager();
      }
      return instance;
   }

   public static void destroyInstance () {

      instance = null;
   }

   public Usuario findUsuarioById (Context applicationContext, long idUsuario) throws Exception {

      Usuario usuarioLogueadoDTO = null;
      ConexionSQLite conexionSQLite = ConexionSQLite.getInstance(applicationContext);

      try {
         conexionSQLite.openDatabase();
         conexionSQLite.getDbSqlite().beginTransactionNonExclusive();
         usuarioLogueadoDTO = UsuarioDaoSqlite.getInstance().findUsuarioById(conexionSQLite, idUsuario);
         conexionSQLite.getDbSqlite().setTransactionSuccessful();
      } finally {
         conexionSQLite.getDbSqlite().endTransaction();
         conexionSQLite.closeDatabase();
      }

      return usuarioLogueadoDTO;
   }

   public Usuario findUsuarioByUserPass (Context applicationContext, String usuario, String contrasenia) {

      Usuario usuarioLogueadoDTO = null;
      ConexionSQLite conexionSQLite = ConexionSQLite.getInstance(applicationContext);

      try {
         conexionSQLite.openDatabase();
         conexionSQLite.getDbSqlite().beginTransactionNonExclusive();
         usuarioLogueadoDTO = UsuarioDaoSqlite.getInstance().findUsuarioByUserPass(conexionSQLite,
                 usuario, contrasenia);
         conexionSQLite.getDbSqlite().setTransactionSuccessful();
      } finally {
         conexionSQLite.getDbSqlite().endTransaction();
         conexionSQLite.closeDatabase();
      }

      return usuarioLogueadoDTO;
   }

   public void insertUsuario (Context applicationContext, Usuario usuario) {

      ConexionSQLite conexionSQLite = ConexionSQLite.getInstance(applicationContext);

      try {
         conexionSQLite.openDatabase();
         ContentValues contentValues = new ContentValues();
         contentValues.put(DBConstants.Usuario.NOMBRES, usuario.getNombres());
         contentValues.put(DBConstants.Usuario.APELLIDOS, usuario.getApellidos());
         contentValues.put(DBConstants.Usuario.CORREO, usuario.getCorreo());
         contentValues.put(DBConstants.Usuario.PASSWORD, usuario.getPassword());
         contentValues.put(DBConstants.Usuario.SEXO, usuario.isMachito());

         UsuarioDaoSqlite.getInstance().insertUsuario(conexionSQLite, contentValues);
      } finally {
         conexionSQLite.closeDatabase();
      }

   }

   public void saveUsuario (Context applicationContext, Usuario usuario) {

      ConexionSQLite conexionSQLite = ConexionSQLite.getInstance(applicationContext);

      try {
         conexionSQLite.openDatabase();
         if (!existUsuario(applicationContext, usuario.getId())) {
            insertUsuario(applicationContext, usuario);
         } else {
            updateUsuario(applicationContext, usuario);
         }
      } finally {
         conexionSQLite.closeDatabase();
      }

   }

   private void updateUsuario (Context applicationContext, Usuario usuario) {

      ConexionSQLite conexionSQLite = ConexionSQLite.getInstance(applicationContext);

      try {
         conexionSQLite.openDatabase();
         ContentValues contentValues = new ContentValues();
         contentValues.put(DBConstants.Usuario.NOMBRES, usuario.getNombres());
         contentValues.put(DBConstants.Usuario.APELLIDOS, usuario.getApellidos());
         contentValues.put(DBConstants.Usuario.CORREO, usuario.getCorreo());
         contentValues.put(DBConstants.Usuario.PASSWORD, usuario.getPassword());
         contentValues.put(DBConstants.Usuario.SEXO, usuario.isMachito());

         UsuarioDaoSqlite.getInstance().updateUsuario(conexionSQLite, usuario.getId(), contentValues);
      } finally {
         conexionSQLite.closeDatabase();
      }

   }

   public boolean existUsuario (Context applicationContext, long idUsuario) {

      ConexionSQLite conexionSQLite = ConexionSQLite.getInstance(applicationContext);
      try {
         conexionSQLite.openDatabase();
         return UsuarioDaoSqlite.getInstance().existUsuario(conexionSQLite, idUsuario);
      } finally {
         conexionSQLite.closeDatabase();
      }

   }


}
