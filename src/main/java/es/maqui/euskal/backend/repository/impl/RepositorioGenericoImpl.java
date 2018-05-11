package es.maqui.euskal.backend.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.maqui.euskal.backend.repository.Identificable;
import es.maqui.euskal.backend.repository.RepositorioGenerico;


public abstract class RepositorioGenericoImpl<K extends Number, T extends Identificable<K>> implements RepositorioGenerico<K, T>  {

	@PersistenceContext
	protected EntityManager entityManager;
	
	public RepositorioGenericoImpl() {
		super();
	}

	@Override
	public T add(T nuevo) {
		entityManager.persist(nuevo);
		entityManager.flush();
		return nuevo;
	}	

	@Override
	public T read(K id) {
		return entityManager.find(getClassDeT(), id);
	}	

	@SuppressWarnings("unchecked")
	@Override
	public List<T> list() {
		return entityManager
				.createNativeQuery("select * from " + getNombreTabla(), getClassDeT())
				.getResultList();
	}

	@Override
	public void delete(K id) {
		T aBorrar = entityManager.find(getClassDeT(), id);
		delete(aBorrar);
	}		
	
	@Override
	public void delete(T aBorrar) {
		entityManager.remove(aBorrar);
	}
	
	@Override
	public T update(T modificado) {
		return entityManager.merge(modificado);
	}		
}
