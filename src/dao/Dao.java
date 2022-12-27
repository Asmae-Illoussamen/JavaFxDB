package dao;

import java.util.List;

//interface générique des nethodes générale de DAO
public interface Dao <T> {
    List<T> findAll() ;
    T findOne(int id) ;
    T save(T o) ;
    boolean delete(T o);
    T update(T o) ; // retourne l'objet modifié

}
