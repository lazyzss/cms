package cn.daryu.cms.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import cn.daryu.cms.entity.Link;

/**
 * 与Link实例有关的dao
 * 
 * @author Day
 *
 */
public interface LinkDao extends PagingAndSortingRepository<Link, Long>{


}
