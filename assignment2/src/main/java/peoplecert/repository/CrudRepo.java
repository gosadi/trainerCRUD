/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peoplecert.repository;

import java.util.List;

/**
 *
 * @author alkinoos
 */
public interface CrudRepo<E> {
    
    public abstract E save(E e);
    public abstract void delete(int id);
    public abstract E findById(int id);
    public abstract List<E> findAll();
}
