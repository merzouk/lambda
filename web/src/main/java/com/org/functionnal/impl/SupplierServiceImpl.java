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
 * Fichier 		:	SupplierServiceImpl.java
 * Cree le 		: 	28 août 2016 à 13:32:45
 * Auteur		: 	admin
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package com.org.functionnal.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.entity.Person;
import com.org.exception.DaoException;
import com.org.functionnal.Supplier;
import com.org.services.PersonService;

/**
 * A Renseigner.
 * @author  : admin
 * @project : web
 * @package : com.org.functionnal.impl
 * @date    : 28 août 2016 13:32:45
 */
@Service
public class SupplierServiceImpl implements Supplier<Person>
{
   private static final Logger logger = LoggerFactory.getLogger( SupplierServiceImpl.class );
   
   @Autowired
   private PersonService       personService;
   
   @Override
   public List<Person> get()
   {
      Supplier<Person> supplier = () -> {
         try
         {
            return personService.listPerson();
         }
         catch( DaoException e )
         {
            logger.error( "Error ", e );
            return null;
         }
      };
      return supplier.get();
   }
}
