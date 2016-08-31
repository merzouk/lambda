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
 * Fichier 		:	UnaryOperatorTest.java
 * Cree le 		: 	27 août 2016 à 18:37:28
 * Auteur		: 	admin
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package com.org.functionnal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.org.entity.Person;
import com.org.functionnal.UnaryOperator;

/**
 * A Renseigner.
 * @author  : mmenhour
 * @project : web
 * @package : com
 * @date    : 27 août 2016 18:37:28
 */
public class UnaryOperatorTest
{
   private static final Logger logger = LoggerFactory.getLogger( UnaryOperatorTest.class );
   
   @org.junit.Test
   public void test()
   {
      try
      {
         
         UnaryOperator<Person> ope = ( t ) -> {
            if( t == null ) return null;
            return t;
         };
         logger.info( "" + ope.apply( new Person() ) );
      }
      catch( Exception e )
      {
         logger.error( "Error ", e );
      }
   }
}
