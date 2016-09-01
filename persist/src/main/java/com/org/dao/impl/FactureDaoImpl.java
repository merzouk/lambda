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
 * Fichier 		:	FactureDaoImpl.java
 * Cree le 		: 	28 ao�t 2016 � 11:41:08
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
import com.org.dao.FactureDao;
import com.org.entity.Facture;
import com.org.exception.DaoException;

/**
 * A Renseigner.
 * @author  : mmenhour
 * @project : web
 * @package : com.org.dao.impl
 * @date    : 28 ao�t 2016 11:41:08
 */
public class FactureDaoImpl extends GenericDao implements FactureDao
{
   private static final Logger logger = LoggerFactory.getLogger( FactureDaoImpl.class );
   
   /**
    * @param pERSISTENCE_UNIT_NAME
    */
   public FactureDaoImpl( String unit, String dbName )
   {
      PERSISTENCE_UNIT_NAME = unit;
      DB_NAME = dbName;
   }
   
   private String PERSISTENCE_UNIT_NAME = "";
   
   private String DB_NAME               = "";
   
   @Override
   public Facture saveFacture( Facture facture ) throws DaoException
   {
      logger.info( "saveFacture" );
      if( facture == null )
      {
         throw new DaoException( "facture is requered" );
      }
      EntityManager em = getEntityManager( PERSISTENCE_UNIT_NAME, DB_NAME );
      em.getTransaction().begin();
      if( facture.getId() == null )
      {
         
         em.persist( facture );
         em.getTransaction().commit();
         em.close();
         return facture;
      }
      else
      {
         
         facture = em.merge( facture );
         em.getTransaction().commit();
         em.close();
         return facture;
      }
   }
   
   /**
    * @see org.dao.FactureDao#updateFacture(org.model.Facture)
    */
   @Override
   public Facture updateFacture( Facture facture ) throws DaoException
   {
      logger.info( "update Facture" );
      EntityManager em = getEntityManager( PERSISTENCE_UNIT_NAME, DB_NAME );
      em.getTransaction().begin();
      if( facture.getId() != null )
      {
         
         facture = em.merge( facture );
         em.getTransaction().commit();
         em.close();
         return facture;
      }
      else
      {
         em.close();
         throw new DaoException( "Id not null" );
      }
   }
   
   /**
    * @see org.dao.FactureDao#deleteFacture(org.model.Facture)
    */
   @Override
   public void deleteFacture( Facture facture ) throws DaoException
   {
      logger.info( "delete Facture" );
      EntityManager em = getEntityManager( PERSISTENCE_UNIT_NAME, DB_NAME );
      em.getTransaction().begin();
      if( facture.getId() != null )
      {
         
         facture = em.merge( facture );
         em.remove( facture );
         em.getTransaction().commit();
         em.close();
      }
      else
      {
         em.close();
         throw new DaoException( "Id not null" );
      }
   }
   
   /**
    * @see org.dao.FactureDao#findById(java.lang.Integer)
    */
   @Override
   public Facture findById( Integer id ) throws DaoException
   {
      logger.info( "findById Facture" );
      EntityManager em = getEntityManager( PERSISTENCE_UNIT_NAME, DB_NAME );
      em.getTransaction().begin();
      Facture facture = em.find( Facture.class, id );
      em.close();
      return facture;
   }
   
   /**
    * @see org.dao.FactureDao#listFacture()
    */
   @SuppressWarnings("unchecked")
   @Override
   public List<Facture> listFacture() throws DaoException
   {
      logger.info( "list Facture's" );
      EntityManager em = getEntityManager( PERSISTENCE_UNIT_NAME, DB_NAME );
      em.getTransaction().begin();
      List<Facture> list = em.createQuery( "select f from Facture f" ).getResultList();
      em.close();
      return list;
   }
}
