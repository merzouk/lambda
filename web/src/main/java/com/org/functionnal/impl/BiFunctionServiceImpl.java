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
 * Fichier 		:	BiFunctionServiceImpl.java
 * Cree le 		: 	27 août 2016 à 19:15:21
 * Auteur		: 	admin
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package com.org.functionnal.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.org.entity.Facture;
import com.org.entity.Person;
import com.org.entity.Users;
import com.org.functionnal.BiFunction;

/**
 * A Renseigner.
 * @author  : admin
 * @project : web
 * @package : com.org.service.impl
 * @date    : 27 août 2016 19:15:21
 */
@Service
public class BiFunctionServiceImpl implements BiFunction<Person, Users, Facture>
{
   /**
    * 
    * @see com.org.functionnal.BiFunction#apply(com.org.entity.Person, com.org.entity.Users)
    */
   @Override
   public List<Facture> apply( Person person, Users user )
   {
      BiFunction<Users, Person, Facture> biFunction = ( u, p ) -> {
         Person persona = null;
         if( p != null && p.getId() != null && p.getId().intValue() > 0 )
         {
            //search person into data base; getPersonById
            persona = new Person();
         }
         else
         {
            return null;
         }
         Users usera = null;
         if( u.getId() != null && u.getId().intValue() > 0 )
         {
            //search user into data base get User by Id
            usera = new Users();
         }
         else
         {
            return null;
         }
         List<Facture> factures = null;
         //if not exist in data base return null; 
         if( usera != null && persona != null )
         {
            //get list facture impayee 
            factures = new ArrayList<Facture>();
            Facture facture = new Facture();
            facture.setId( 1 );
            facture.setEmail( "emailtrouve@gmail.com" );
            factures.add( facture );
         }
         return factures;
      };
      return biFunction.apply( user, person );
   }
}
