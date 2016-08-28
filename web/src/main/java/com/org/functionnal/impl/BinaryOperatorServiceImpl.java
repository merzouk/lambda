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
 * Fichier 		:	BinaryOperatorServiceImpl.java
 * Cree le 		: 	27 août 2016 à 22:56:04
 * Auteur		: 	admin
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package com.org.functionnal.impl;

import org.springframework.stereotype.Service;

import com.org.entity.Person;
import com.org.exception.FunctionnalException;
import com.org.functionnal.BinaryOperator;

/**
 * A Renseigner.
 * @author  : admin
 * @project : web
 * @package : com.org.service.impl
 * @date    : 27 août 2016 22:56:04
 */
@Service
public class BinaryOperatorServiceImpl implements BinaryOperator<Person>
{
   
   @Override
   public Person apply( Person person1, Person person2 ) throws FunctionnalException
   {
      BinaryOperator<Person> binaryOperator = ( p1, p2 ) -> {
         if( p1 == null || p1.getId() == null || p2 == null || p2.getId() == null )
         {
            throw new FunctionnalException( "The two or one object Person is not correct" );
         }
         if( p1.equals( p2 ) ) return p1;
         return null;
      };
      return binaryOperator.apply( person1, person2 );
   }
}
