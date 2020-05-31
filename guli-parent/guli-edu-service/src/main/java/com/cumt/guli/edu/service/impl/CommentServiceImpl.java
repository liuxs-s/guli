package com.cumt.guli.edu.service.impl;

import com.cumt.guli.edu.entity.Comment;
import com.cumt.guli.edu.mapper.CommentMapper;
import com.cumt.guli.edu.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 评论 服务实现类
 * </p>
 *
 * @author atliuxs
 * @since 2020-05-04
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

}
