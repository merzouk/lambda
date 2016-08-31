/**
 * 
 */

package com.org.functionnal.impl;

import org.springframework.stereotype.Service;

import com.org.functionnal.Operation;
import com.org.functionnal.OperationService;

/**
 * @author mmenhour
 *
 */
@Service
public class OperationServiceImpl implements OperationService {

	private Operation ope = null;

	/**
	 * 
	 * @see com.org.functionnal.OperationService#somme(int, int)
	 */
	public int somme(int a, int b) {
		ope = (x, y) -> (x + y);
		return ope.somme(a, b);
	}

	/**
	 * 
	 * @see com.org.functionnal.OperationService#produit(int, int)
	 */
	public int produit(int a, int b) {
		ope = (x, y) -> (x + y);
		return ope.produit(a, b);
	}
}
