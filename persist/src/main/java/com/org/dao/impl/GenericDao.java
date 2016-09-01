package com.org.dao.impl;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.org.commons.IntPropertiesReader;

public abstract class GenericDao {

	/**
	    * 
	    * @param persistenceUnitName
	    * @return
	    */
	   protected EntityManager getEntityManager( String persistenceUnitName, String dataBaseName )
	   {
	      Map<String, String> properties = new HashMap<String, String>();
	      properties.put( "javax.persistence.jdbc.user", IntPropertiesReader.getValueByKey( IntPropertiesReader.USER ) );
	      properties.put( "javax.persistence.jdbc.password", IntPropertiesReader.getValueByKey( IntPropertiesReader.PASSWORD ) );
	      properties.put( "javax.persistence.jdbc.url", IntPropertiesReader.getValueByKey( IntPropertiesReader.JDBC ) + "/" + dataBaseName );
	      properties.put( "javax.persistence.jdbc.driver", IntPropertiesReader.getValueByKey( IntPropertiesReader.DRIVER ) );
	      properties.put( "hibernate.dialect", IntPropertiesReader.getValueByKey( IntPropertiesReader.DIALECT ) );
	      properties.put( "eclipselink.jdbc.exclusive-connection.mode", IntPropertiesReader.getValueByKey( IntPropertiesReader.TRASACTIONAL ) );
	      properties.put( "eclipselink.jdbc.exclusive-connection.is-lazy", IntPropertiesReader.getValueByKey( IntPropertiesReader.ISLAZY ) );
	      EntityManagerFactory emf = Persistence.createEntityManagerFactory( persistenceUnitName, properties );
	      EntityManager em = emf.createEntityManager();
	      return em;
	   }
}
