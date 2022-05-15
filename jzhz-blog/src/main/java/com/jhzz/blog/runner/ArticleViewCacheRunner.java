package com.jhzz.blog.runner;

import com.jhzz.common.config.RedisCache;
import com.jhzz.common.domain.entity.Article;
import com.jhzz.common.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: Huanzhi
 * \* Date: 2022/5/15
 * \* Time: 12:02
 * \* Description: 在应用启动时把博客的浏览量存储到redis中
 * \
 */
@Component
@Slf4j
public class ArticleViewCacheRunner implements CommandLineRunner {
    @Resource
    private RedisCache redisCache;
    @Resource
    private ArticleService articleService;
    @Override
    public void run(String... args) throws Exception {
        //博客的浏览量存储到redis中
        List<Article> articles = articleService.list();
        for(Article article : articles){
            Long viewCount = article.getViewCount();
            Long articleId = article.getId();
            redisCache.setCacheObject("articleId-"+articleId,viewCount);
        }
        log.info("--------------------redis缓存浏览数完毕--------------------------");
    }
}
