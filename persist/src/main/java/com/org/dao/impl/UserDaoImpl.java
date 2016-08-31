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
 * Fichier 		:	UserDaoImpl.java
 * Cree le 		: 	28 ao�t 2016 � 11:40:23
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
import com.org.dao.UserDao;
import com.org.entity.Users;
import com.org.exception.DaoException;

/**
 * A Renseigner.
 * @author  : mmenhour
 * @project : web
 * @package : com.org.dao.impl
 * @date    : 28 ao�t 2016 11:40:23
 */
public class UserDaoImpl implements UserDao
{
   private static final Logger logger = LoggerFactory.getLogger( UserDaoImpl.class );
   
   /**
    * @param pERSISTENCE_UNIT_NAME
    */
   public UserDaoImpl( String unit, String dbName )
   {
      PERSISTENCE_UNIT_NAME = unit;
      DB_NAME = dbName;
   }
   
   private String PERSISTENCE_UNIT_NAME = "";
   
   private String DB_NAME               = "";
   
   @Override
   public Users saveUser( Users user ) throws DaoException
   {
      logger.info( "saveUser" );
      if( user == null )
      {
         throw new DaoException( "user is requered" );
      }
      EntityManager em = getEntityManager( PERSISTENCE_UNIT_NAME, DB_NAME );
      em.getTransaction().begin();
      if( user.getId() == null )
      {
         
         em.persist( user );
         em.getTransaction().commit();
         em.close();
         return user;
      }
      else
      {
         
         user = em.merge( user );
         em.getTransaction().commit();
         em.close();
         return user;
      }
   }
   
   /**
    * @see org.dao.UserDao#updateUser(org.model.User)
    */
   @Override
   public Users updateUser( Users user ) throws DaoException
   {
      logger.info( "update User" );
      EntityManager em = getEntityManager( PERSISTENCE_UNIT_NAME, DB_NAME );
      em.getTransaction().begin();
      if( user.getId() != null )
      {
         
         user = em.merge( user );
         em.getTransaction().commit();
         em.close();
         return user;
      }
      else
      {
         em.close();
         throw new DaoException( "Id est non null" );
      }
   }
   
   /**
    * @see org.dao.UserDao#deleteUser(org.model.User)
    */
   @Override
   public void deleteUser( Users user ) throws DaoException
   {
      logger.info( "delete User" );
      EntityManager em = getEntityManager( PERSISTENCE_UNIT_NAME, DB_NAME );
      em.getTransaction().begin();
      if( user.getId() != null )
      {
         
         user = em.merge( user );
         em.remove( user );
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
    * @see org.dao.UserDao#findById(java.lang.Integer)
    */
   @Override
   public Users findById( Integer id ) throws DaoException
   {
      logger.info( "findById User" );
      EntityManager em = getEntityManager( PERSISTENCE_UNIT_NAME, DB_NAME );
      em.getTransaction().begin();
      Users user = em.find( Users.class, id );
      em.close();
      return user;
   }
   
   /**
    * @see org.dao.UserDao#listUser()
    */
   @SuppressWarnings("unchecked")
   @Override
   public List<Users> listUser() throws DaoException
   {
      logger.info( "list User's" );
      EntityManager em = getEntityManager( PERSISTENCE_UNIT_NAME, DB_NAME );
      em.getTransaction().begin();
      List<Users> list = em.createQuery( "select f from User f" ).getResultList();
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
