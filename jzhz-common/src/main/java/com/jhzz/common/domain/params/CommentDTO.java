package com.jhzz.common.domain.params;

import lombok.Data;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: Huanzhi
 * \* Date: 2022/5/11
 * \* Time: 19:39
 * \* Description:
 * \
 */
@Data
public class CommentDTO {
    private Long id;
    /**
     * 评论类型（0代表文章评论，1代表友链评论）
     */
    private String type;
    private Long articleId;
    /**
     * 根评论id
     */
    private Long rootId;
    private String content;
    /**
     * 所回复的目标评论的userid
     */
    private Long toCommentUserId;
    /**
     * 回复目标评论id
     */
    private Long toCommentId;

}
