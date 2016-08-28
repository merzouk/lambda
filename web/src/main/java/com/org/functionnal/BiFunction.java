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
 * Fichier 		:	BiFunction.java
 * Cree le 		: 	27 août 2016 à 18:23:17
 * Auteur		: 	admin
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package com.org.functionnal;

import java.util.List;

/**
 * BiFunction
 * To represent a function that takes two arguments of types P and U, and returns a result {@see List} of type F.
 * 
 * @author  : admin
 * @project : web
 * @package : com.org
 * @date    : 27 août 2016 18:23:17
 */
@FunctionalInterface
public interface BiFunction<P, U, F>
{
   /**
    * 
    * @param p : {@see Object} of type P
    * @param u : {@see Object} of type U
    * @return : {@see List} {@see Object} of type F
    */
   public List<F> apply( P p, U u );
}
