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
 * Fichier 		:	FactureDao.java
 * Cree le 		: 	28 ao�t 2016 � 11:39:41
 * Auteur		: 	admin
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package com.org.dao;

import java.util.List;

import com.org.entity.Facture;
import com.org.exception.DaoException;

/**
 * A Renseigner.
 * @author  : mmenhour
 * @project : web
 * @package : com.org.dao
 * @date    : 28 ao�t 2016 11:39:41
 */
public interface FactureDao
{
   /**
    * 
    * @param facture
    * @throws DaoException
    */
   Facture saveFacture( Facture facture ) throws DaoException;
   
   /**
    * 
    * @param facture
    * @return
    * @throws DaoException
    */
   Facture updateFacture( Facture facture ) throws DaoException;
   
   /**
    * 
    * @param facture
    * @throws DaoException
    */
   void deleteFacture( Facture facture ) throws DaoException;
   
   /**
    * 
    * @param id
    * @return
    * @throws DaoException
    */
   Facture findById( Integer id ) throws DaoException;
   
   /**
    * 
    * @return
    * @throws DaoException
    */
   List<Facture> listFacture() throws DaoException;
}
