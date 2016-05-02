/**
 * 
 */
package com.gotprint.usernote.dao;


/**
 * @author ChoukseA
 *
 */
public interface BaseDao {
	
	<T> T findById(T entity, int id);

	<T> T save(T entity);
	
	<T> T update(T entity);
	
	<T> void deleteById(T entity);

}
