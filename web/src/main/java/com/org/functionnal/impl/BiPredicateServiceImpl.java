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
 * Fichier 		:	BiPredicateServiceImpl.java
 * Cree le 		: 	28 août 2016 à 11:28:12
 * Auteur		: 	admin
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package com.org.functionnal.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.entity.Facture;
import com.org.entity.Person;
import com.org.exception.DaoException;
import com.org.exception.FunctionnalException;
import com.org.functionnal.BiPredicate;
import com.org.services.FactureService;
import com.org.services.PersonService;

/**
 * A Renseigner.
 * @author  : mmenhour
 * @project : web
 * @package : com.org.service.impl
 * @date    : 28 août 2016 11:28:12
 */
@Service
public class BiPredicateServiceImpl implements BiPredicate<Person, Facture>
{
   
   private static final Logger logger = LoggerFactory.getLogger( BiPredicateServiceImpl.class );
   
   @Autowired
   private PersonService       personService;
   
   @Autowired
   private FactureService      factureService;
   
   @Override
   public boolean test( Person person, Facture facture ) throws FunctionnalException
   {
      logger.info( "test" );
      BiPredicate<Person, Facture> biPredicate = ( p, f ) -> {
         if( p == null || p.getId() == null || p.getId().intValue() <= 0 )
         {
            throw new FunctionnalException( "The object person is null or empty" );
         }
         if( f == null || f.getId() == null || f.getId().intValue() <= 0 )
         {
            throw new FunctionnalException( "The object facture is null or empty" );
         }
         if( exist( p, f ) ) return true;
         return false;
      };
      return biPredicate.test( person, facture );
   }
   
   /**
    * 
    * @param p
    * @param f
    * @return
    */
   private boolean exist( Person p, Facture f )
   {
      //search in data base if the facture it's liate a the person return true and false otherwise
      try
      {
         p = personService.findById( p.getId() );
      }
      catch( DaoException e )
      {
         logger.error( "Error ", e );
      }
      f = factureService.findById( f.getId() );
      if( p != null && f != null ) return true;
      return false;
   }
}
