package com.jhzz.blog.vo;

import lombok.Data;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: Huanzhi
 * \* Date: 2022/5/9
 * \* Time: 14:25
 * \* Description:
 * \
 */
@Data
public class PageParam {
    private Integer pageNum;
    private Integer pageSize;
    private Long categoryId;

}
