package cn.daryu.cms.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import cn.daryu.cms.entity.Post;

/**
 * 与Post实例有关的dao
 * 
 * @author Day
 *
 */
public interface PostDao extends PagingAndSortingRepository<Post, Long>{


}
