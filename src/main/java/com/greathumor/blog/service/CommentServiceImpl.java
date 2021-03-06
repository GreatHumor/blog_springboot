package com.greathumor.blog.service;

import com.greathumor.blog.dao.CommentRepository;
import com.greathumor.blog.po.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {


    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<Comment> listCommentByBlogId(Long blogId) {
        Sort sort = Sort.by(Sort.Direction.DESC,"createTime");
        return commentRepository.findByBlogId(blogId,sort);
    }

    @Transactional
    @Override
    public Comment saveComment(Comment comment) {
        Long parentCommentId = comment.getParenComment().getId();
        if (parentCommentId != -1){
            comment.setParenComment(commentRepository.getOne(parentCommentId));
        } else {
            comment.setParenComment(null);
        }
        comment.setCreateTime(new Date());
        return commentRepository.save(comment);
    }
}
