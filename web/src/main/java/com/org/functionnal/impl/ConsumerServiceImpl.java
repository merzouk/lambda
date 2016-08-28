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
 * Fichier 		:	ConsumerServiceImpl.java
 * Cree le 		: 	28 août 2016 à 17:52:13
 * Auteur		: 	admin
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package com.org.functionnal.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.entity.Person;
import com.org.exception.DaoException;
import com.org.exception.FunctionnalException;
import com.org.functionnal.Consumer;
import com.org.services.PersonService;

/**
 * A Renseigner.
 * @author  : admin
 * @project : web
 * @package : com.org.functionnal.impl
 * @date    : 28 août 2016 17:52:13
 */
@Service
public class ConsumerServiceImpl implements Consumer<Person>
{
   @Autowired
   private PersonService personService;
   
   @Override
   public void accept( Person person ) throws Exception
   {
      Consumer<Person> consumer = ( Person p ) -> {
         if( p == null || p.getNom() == null || p.getPrenom() == null || p.getEmail() == null || p.getNom().length() <= 1 || p.getPrenom().length() <= 1 || p.getEmail().length() <= 1 )
         {
            throw new FunctionnalException( "The Person Object is incorrect" );
         }
         try
         {
            personService.savePerson( p );
         }
         catch( DaoException e )
         {
            throw e;
         }
      };
      consumer.accept( person );
   }
}
