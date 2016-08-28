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
 * Fichier 		:	PersonService.java
 * Cree le 		: 	28 ao�t 2016 � 11:41:51
 * Auteur		: 	admin
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package com.org.services;

import java.util.List;

import com.org.entity.Person;
import com.org.exception.DaoException;
import com.org.model.Persons;

/**
 * A Renseigner.
 * @author  : admin
 * @project : web
 * @package : com.org.service
 * @date    : 28 ao�t 2016 11:41:51
 */
public interface PersonService
{
   /**
    * 
    * @param person
    * @throws DaoException
    */
   Persons savePerson( Person person ) throws DaoException;
   
   /**
    * 
    * @param person
    * @return
    * @throws DaoException
    */
   Person updatePerson( Person person ) throws DaoException;
   
   /**
    * 
    * @param person
    * @throws DaoException
    */
   void deletePerson( Person person ) throws DaoException;
   
   /**
    * 
    * @param id
    * @return
    * @throws DaoException
    */
   Person findById( Integer id ) throws DaoException;
   
   /**
    * 
    * @return
    * @throws DaoException
    */
   List<Person> listPerson() throws DaoException;
   
   /**
    * 
    * @param persistenceUnit
    */
   public void setPersistenceUnit( String persistenceUnit );
   
   /**
    * @param dbName the dbName to set
    */
   public void setDbName( String dbName );
}
