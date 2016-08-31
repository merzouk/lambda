
package com.org.commons;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * A Renseigner.
 * @author  : mmenhour
 * @project : persist
 * @package : org.dao.impl
 * @date    : 4 sept. 2014 18:56:19
 */
public class IntPropertiesReader
{
   private static Logger    LOGGER       = LoggerFactory.getLogger( IntPropertiesReader.class );
   
   public static Properties props        = new Properties();
   
   public static String     USER         = "javax.persistence.jdbc.user";
   
   public static String     PASSWORD     = "javax.persistence.jdbc.password";
   
   public static String     DBNAME       = "javax.persistence.db.name";
   
   public static String     JDBC         = "javax.persistence.jdbc.url";
   
   public static String     DRIVER       = "javax.persistence.jdbc.driver";
   
   public static String     DIALECT      = "hibernate.dialect";
   
   public static String     TRASACTIONAL = "eclipselink.jdbc.exclusive-connection.mode";
   
   public static String     ISLAZY       = "eclipselink.jdbc.exclusive-connection.is-lazy";
   static
   {
      try
      {
         props.load( IntPropertiesReader.class.getResourceAsStream( "/db/db.properties" ) );
      }
      catch( IOException e )
      {
         LOGGER.error( "error reading default config properties", e );
      }
   }
   
   public static String getValueByKey( String propName )
   {
      return props.getProperty( propName );
   }
   
   public static int getIntProperty( String propName )
   {
      return Integer.parseInt( props.getProperty( propName ) );
   }
   
   public static String getPropertyOrEmpty( String propName )
   {
      String value = getValueByKey( propName );
      return value != null ? value : "";
   }
}