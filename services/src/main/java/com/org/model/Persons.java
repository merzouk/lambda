/*
 *--------------------------------------------------------
 * Administrateur
 *--------------------------------------------------------
 * Project     : persist
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
 * Fichier 		:	Persons.java
 * Cree le 		: 	28 août 2016 à 18:16:46
 * Auteur		: 	admin
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package com.org.model;

import java.io.Serializable;

import com.org.entity.Person;
import com.org.entity.Users;

/**
 * A Renseigner.
 * @author  : mmenhour
 * @project : persist
 * @package : com.org.entity
 * @date    : 28 août 2016 18:16:46
 */
public class Persons implements Serializable
{
   
   /**
    * 
    */
   private static final long serialVersionUID = -6437710523643900701L;

   private final Person person;
   
   private final Users  user;
   
   /**
    * @param person
    * @param user
    */
   public Persons( Person person, Users user )
   {
      super();
      this.person = person;
      this.user = user;
   }
   
   /**
    * @return the person
    */
   public Person getPerson()
   {
      return person;
   }
   
   /**
    * @return the user
    */
   public Users getUser()
   {
      return user;
   }
}
