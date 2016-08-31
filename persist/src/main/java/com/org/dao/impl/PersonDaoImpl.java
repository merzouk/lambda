/*
 *--------------------------------------------------------
 * Administrateur
 *--------------------------------------------------------
 * Project     : web
 *
 * Copyright Administrateur,  All Rights Reserved.
 *
 * This software is the confidential and proprietary
 * information of Administrateur.
 * You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms
 * of the license agreement you entered into with
 * Administrateur.
 *-------------------------------------------------------- 
 * 
 * Fichier 		:	PersonDaoImpl.java
 * Cree le 		: 	28 ao�t 2016 � 11:40:44
 * Auteur		: 	admin
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package com.org.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.org.commons.IntPropertiesReader;
import com.org.dao.PersonDao;
import com.org.entity.Person;
import com.org.exception.DaoException;

/**
 * A Renseigner.
 * @author  : mmenhour
 * @project : web
 * @package : com.org.dao.impl
 * @date    : 28 ao�t 2016 11:40:44
 */
public class PersonDaoImpl implements PersonDao
{
   private static final Logger logger = LoggerFactory.getLogger( PersonDaoImpl.class );
   
   /**
    * @param pERSISTENCE_UNIT_NAME
    */
   public PersonDaoImpl( String unit, String dbName )
   {
      PERSISTENCE_UNIT_NAME = unit;
      DB_NAME = dbName;
   }
   
   private String PERSISTENCE_UNIT_NAME = "";
   
   private String DB_NAME               = "";
   
   @Override
   public Person savePerson( Person person ) throws DaoException
   {
      logger.info( "savePerson" );
      if( person == null )
      {
         throw new DaoException( "person is requered" );
      }
      EntityManager em = getEntityManager( PERSISTENCE_UNIT_NAME, DB_NAME );
      em.getTransaction().begin();
      if( person.getId() == null )
      {
         
         em.persist( person );
         em.getTransaction().commit();
         em.close();
         return person;
      }
      else
      {
         
         person = em.merge( person );
         em.getTransaction().commit();
         em.close();
         return person;
      }
   }
   
   /**
    * @see org.dao.PersonDao#updatePerson(org.model.Person)
    */
   @Override
   public Person updatePerson( Person person ) throws DaoException
   {
      logger.info( "update Person" );
      EntityManager em = getEntityManager( PERSISTENCE_UNIT_NAME, DB_NAME );
      em.getTransaction().begin();
      if( person.getId() != null )
      {
         
         person = em.merge( person );
         em.getTransaction().commit();
         em.close();
         return person;
      }
      else
      {
         em.close();
         throw new DaoException( "Id est non null" );
      }
   }
   
   /**
    * @see org.dao.PersonDao#deletePerson(org.model.Person)
    */
   @Override
   public void deletePerson( Person person ) throws DaoException
   {
      logger.info( "delete Person" );
      EntityManager em = getEntityManager( PERSISTENCE_UNIT_NAME, DB_NAME );
      em.getTransaction().begin();
      if( person.getId() != null )
      {
         
         person = em.merge( person );
         em.remove( person );
         em.getTransaction().commit();
         em.close();
      }
      else
      {
         em.close();
         throw new DaoException( "Id est non null" );
      }
   }
   
   /**
    * @see org.dao.PersonDao#findById(java.lang.Integer)
    */
   @Override
   public Person findById( Integer id ) throws DaoException
   {
      logger.info( "findById Person" );
      EntityManager em = getEntityManager( PERSISTENCE_UNIT_NAME, DB_NAME );
      em.getTransaction().begin();
      Person person = em.find( Person.class, id );
      em.close();
      return person;
   }
   
   /**
    * @see org.dao.PersonDao#listPerson()
    */
   @SuppressWarnings("unchecked")
   @Override
   public List<Person> listPerson() throws DaoException
   {
      logger.info( "list Person's" );
      EntityManager em = getEntityManager( PERSISTENCE_UNIT_NAME, DB_NAME );
      em.getTransaction().begin();
      List<Person> list = em.createQuery( "select f from Person f" ).getResultList();
      em.close();
      return list;
   }
   
   /**
    * 
    * @param persistenceUnitName
    * @return
    */
   private EntityManager getEntityManager( String persistenceUnitName, String dataBaseName )
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
