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
 * Fichier 		:	UserService.java
 * Cree le 		: 	28 ao�t 2016 � 11:41:59
 * Auteur		: 	admin
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package com.org.services;

import com.org.entity.Users;
import com.org.exception.DaoException;

/**
 * A Renseigner.
 * @author  : admin
 * @project : web
 * @package : com.org.service
 * @date    : 28 ao�t 2016 11:41:59
 */
public interface UserService
{
   
   /**
    * 
    * @param id
    * @return
    */
   Users findById( Integer id ) throws DaoException;
   
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
