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
 * Fichier 		:	BiPredicate.java
 * Cree le 		: 	27 août 2016 à 18:24:11
 * Auteur		: 	admin
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package com.org.functionnal;

import com.org.exception.FunctionnalException;

/**
 * BiPredicate
 * To represent a boolean function that returns true or false for the two specified arguments of types P and F.
 * 
 * @author  : mmenhour
 * @project : web
 * @package : com.org
 * @date    : 27 août 2016 18:24:11
 */
@FunctionalInterface
public interface BiPredicate<P, F>
{
   
   /**
    * 
    * @param p
    * @param f
    * @return : true if person facture and false otherwise 
    * @throws FunctionnalException
    */
   public boolean test( P p, F f ) throws FunctionnalException;
}
