package cn.daryu.cms.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import cn.daryu.cms.entity.User;

/**
 * 与User实例有关的dao
 * 
 * @author Day
 *
 */
public interface UserDao extends PagingAndSortingRepository<User, Long>{


}
