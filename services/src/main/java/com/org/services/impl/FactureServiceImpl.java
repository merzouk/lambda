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
 * Fichier 		:	FactureServiceImpl.java
 * Cree le 		: 	28 ao�t 2016 � 11:42:27
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

import com.org.dao.FactureDao;
import com.org.dao.impl.FactureDaoImpl;
import com.org.entity.Facture;
import com.org.exception.DaoException;
import com.org.services.FactureService;

/**
 * A Renseigner.
 * @author  : mmenhour
 * @project : web
 * @package : com.org.service.impl
 * @date    : 28 ao�t 2016 11:42:27
 */
@Service
public class FactureServiceImpl implements FactureService
{
   
   private static final Logger logger = LoggerFactory.getLogger( FactureServiceImpl.class );
   
   private FactureDao          factureDao;
   
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
    * @see com.org.services.FactureService#findById(java.lang.Integer)
    */
   @Override
   public Facture findById( Integer id )
   {
      
      logger.debug( "find facture dao" );
      if( id == null || id.intValue() <= 0 )
      {
         return null;
      }
      try
      {
         factureDao = new FactureDaoImpl( persistenceUnit, dbName );
         return factureDao.findById( id );
      }
      catch( DaoException e )
      {
         logger.error( "Error ", e );
         return null;
      }
   }
}
