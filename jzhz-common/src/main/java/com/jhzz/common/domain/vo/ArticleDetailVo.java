package com.jhzz.common.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: Huanzhi
 * \* Date: 2022/5/10
 * \* Time: 15:23
 * \* Description:
 * \
 */
@Data
public class ArticleDetailVo {
    private Long id;
    private String title;
    private String content;
    private Long categoryId;
    private String categoryName;
    private Long viewCount;
//    @JsonFormat(locale = "zh", timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
//    private String authorName;

}
