package com.jhzz.common.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: Huanzhi
 * \* Date: 2022/5/9
 * \* Time: 23:56
 * \* Description:
 * \
 */
@Data
public class ArticleListVo {
    private Long id;
    private String title;
    private String summary;
    private String categoryName;
    private Long categoryId;
    private String thumbnail;
    private Long viewCount;
    @JsonFormat(locale = "zh", timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    private String isTop;


}
