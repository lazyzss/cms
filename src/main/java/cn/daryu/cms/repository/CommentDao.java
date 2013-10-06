package cn.daryu.cms.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import cn.daryu.cms.entity.Comment;

/**
 * 与Comment实例有关的dao
 * 
 * @author Day
 *
 */
public interface CommentDao extends PagingAndSortingRepository<Comment, Long>{


}
