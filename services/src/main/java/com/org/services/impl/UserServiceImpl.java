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
 * Fichier 		:	UserServiceImpl.java
 * Cree le 		: 	28 ao�t 2016 � 11:42:52
 * Auteur		: 	admin
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package com.org.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.org.dao.UserDao;
import com.org.dao.impl.UserDaoImpl;
import com.org.entity.Users;
import com.org.exception.DaoException;
import com.org.services.UserService;

/**
 * A Renseigner.
 * @author  : admin
 * @project : web
 * @package : com.org.service.impl
 * @date    : 28 ao�t 2016 11:42:52
 */
@Service
public class UserServiceImpl implements UserService
{
   private static final Logger logger = LoggerFactory.getLogger( UserServiceImpl.class );
   
   private UserDao             userDao;
   
   private String              persistenceUnit;
   
   private String              dbName;
   
   /**
    * @param persistenceUnit the persistenceUnit to set
    */
   public void setPersistenceUnit( String persistenceUnit )
   {
      this.persistenceUnit = persistenceUnit;
   }
   
   /**
    * @param dbName the dbName to set
    */
   public void setDbName( String dbName )
   {
      this.dbName = dbName;
   }
   
   /**
    * 
    * @see com.org.services.UserService#findById(java.lang.Integer)
    */
   @Override
   public Users findById( Integer id ) throws DaoException
   {
      logger.debug( "find user dao" );
      if( id == null || id.intValue() <= 0 )
      {
         return null;
      }
      try
      {
         userDao = new UserDaoImpl( persistenceUnit, dbName );
         return userDao.findById( id );
      }
      catch( DaoException e )
      {
         logger.error( "Error ", e );
         return null;
      }
   }
}
