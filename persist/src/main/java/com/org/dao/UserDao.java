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
 * Fichier 		:	UserDao.java
 * Cree le 		: 	28 ao�t 2016 � 11:39:58
 * Auteur		: 	admin
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */
package com.org.dao;

import java.util.List;

import com.org.entity.Users;
import com.org.exception.DaoException;

/**
 * A Renseigner.
 * @author  : mmenhour
 * @project : web
 * @package : com.org.dao
 * @date    : 28 ao�t 2016 11:39:58
 */
public interface UserDao
{
   /**
    * 
    * @param user
    * @throws DaoException
    */
   Users saveUser( Users user ) throws DaoException;
   
   /**
    * 
    * @param user
    * @return
    * @throws DaoException
    */
   Users updateUser( Users user ) throws DaoException;
   
   /**
    * 
    * @param user
    * @throws DaoException
    */
   void deleteUser( Users user ) throws DaoException;
   
   /**
    * 
    * @param id
    * @return
    * @throws DaoException
    */
   Users findById( Integer id ) throws DaoException;
   
   /**
    * 
    * @return
    * @throws DaoException
    */
   List<Users> listUser() throws DaoException;
}
