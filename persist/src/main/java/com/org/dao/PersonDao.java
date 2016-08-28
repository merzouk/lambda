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
 * Fichier 		:	PersonDao.java
 * Cree le 		: 	28 ao�t 2016 � 11:39:29
 * Auteur		: 	admin
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package com.org.dao;

import java.util.List;

import com.org.entity.Person;
import com.org.exception.DaoException;

/**
 * A Renseigner.
 * @author  : admin
 * @project : web
 * @package : com.org.dao
 * @date    : 28 ao�t 2016 11:39:29
 */
public interface PersonDao
{
   /**
    * 
    * @param person
    * @throws DaoException
    */
   Person savePerson( Person person ) throws DaoException;
   
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
}
