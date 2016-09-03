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
 * Fichier 		:	ComparatorServiceImpl.java
 * Cree le 		: 	27 août 2016 à 17:37:32
 * Auteur		: 	admin
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package com.org.functionnal.impl;

import org.springframework.stereotype.Service;

import com.org.entity.Person;
import com.org.functionnal.Comparator;

/**
 * A Renseigner.
 * 
 * @author : mmenhour
 * @project : web
 * @package : com.org.service.impl
 * @date : 27 août 2016 17:37:32
 */
@Service
public class ComparatorServiceImpl implements Comparator<Person> {

	private Comparator<Person> compare = null;

	@Override
	public int compare(Person object1, Person object2) {
		compare = (o1, o2) -> {
			Person p1 = null;
			if (o1 instanceof Person) {
				p1 = (Person) o1;
			}
			Person p2 = null;
			if (o2 instanceof Person) {
				p2 = (Person) o2;
			}
			if (p1 == null || p2 == null) {
				throw new IllegalArgumentException("One or two objects are null or incorrect");
			}
			if (p1.getId() != null && p1.getId().intValue() > 0 && p2.getId() != null && p2.getId().intValue() > 0) {
				return (p1.getId().compareTo(p2.getId()));
			}
			int a = (p1.getEmail().compareTo(p2.getEmail()));
			if (a > 0) {
				return 1;
			}
			if (a < 0) {
				return -1;
			}
			return 0;
		};
		return compare.compare(object1, object2);
	}
}
