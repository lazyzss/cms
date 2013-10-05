package cn.daryu.cms.repository;

import org.springframework.data.repository.CrudRepository;

import cn.daryu.cms.entity.User;

/**
 * 与User实例有关的dao
 * 
 * @author Day
 *
 */
public interface UserDao extends CrudRepository<User, Long>{


}
