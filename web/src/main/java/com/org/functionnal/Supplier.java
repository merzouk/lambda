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
 * Fichier 		:	Supplier.java
 * Cree le 		: 	27 août 2016 à 18:25:34
 * Auteur		: 	admin
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package com.org.functionnal;

import java.util.List;

/**
 * Supplier
 * To represent a function that returns a value as of type T.
 * 
 * @author  : mmenhour
 * @project : web
 * @package : com.org
 * @date    : 27 août 2016 18:25:34
 */
@FunctionalInterface
public interface Supplier<T>
{
   public List<T> get();
}
