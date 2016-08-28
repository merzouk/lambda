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
 * Fichier 		:	BiConsumerImpl.java
 * Cree le 		: 	27 août 2016 à 22:34:14
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

import com.org.entity.Person;
import com.org.entity.Users;
import com.org.exception.DaoException;
import com.org.exception.FunctionnalException;
import com.org.functionnal.BiConsumer;
import com.org.services.PersonService;
import com.org.services.UserService;

/**
 * A Renseigner.
 * @author  : admin
 * @project : web
 * @package : com.org.service.impl
 * @date    : 27 août 2016 22:34:14
 */
@Service
public class BiConsumerServiceImpl implements BiConsumer<Users, Person>
{
   
   private static final Logger logger = LoggerFactory.getLogger( BiConsumerServiceImpl.class );
   
   @Autowired
   private PersonService       personService;
   
   @Autowired
   private UserService         userService;
   
   /**
    * 
    * @see com.org.functionnal.BiConsumer#accept(java.lang.Object, java.lang.Object)
    */
   @Override
   public void accept( Users user, Person person ) throws FunctionnalException
   {
      logger.debug( "accept" );
      BiConsumer<Users, Person> biConsumer = ( u, p ) -> {
         if( u == null || u.getId() == null || p == null || p.getId() == null )
         {
            throw new FunctionnalException( "The User or/and Person object is/are not correct" );
         }
         try
         {
            u = userService.findById( u.getId() );
         }
         catch( DaoException e )
         {
            logger.error( "Error ", e );
         }
         if( u == null )
         {
            throw new FunctionnalException( "The User not found into data base" );
         }
         try
         {
            p = personService.findById( p.getId() );
         }
         catch( DaoException e )
         {
            logger.error( "Error ", e );
         }
         if( p == null )
         {
            throw new FunctionnalException( "The Person not found into data base" );
         }
         //Other traitments
      };
      biConsumer.accept( user, person );
   }
}
