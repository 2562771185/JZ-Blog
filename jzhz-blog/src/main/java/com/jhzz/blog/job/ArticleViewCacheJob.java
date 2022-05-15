package com.jhzz.blog.job;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.jhzz.common.config.RedisCache;
import com.jhzz.common.domain.entity.Article;
import com.jhzz.common.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Huanzhi
 * 定时任务：更新文章阅读数 --> 每隔10分钟把Redis中的浏览量更新到数据库中
 *
 */
@Component
@Slf4j
public class ArticleViewCacheJob {
    @Resource
    private ArticleService articleService;
    @Resource
    private RedisCache redisCache;
    /**
     * 表示每10分钟 执行任务
     * todo 需要修改为真实需要的事件
     */
    @Scheduled(cron = "0 0/3 * * * ?")
    public void articleViewCountJob(){
        //要执行的代码 每隔10分钟把Redis中的浏览量更新到数据库中
        List<Article> articleList = articleService.list();
        for (Article article : articleList) {
            log.info("------------------更新之前的阅读数："+article.getViewCount());
            Long cacheViewCount =Long.parseLong(redisCache.getCacheObject("articleId-"+article.getId()));
            article.setViewCount(cacheViewCount);
            log.info("*******************更新之后的阅读数："+article.getViewCount());
            //持久化数据库
            UpdateWrapper<Article> updateWrapper = new UpdateWrapper<>();
            //根据id更新
            updateWrapper.eq("id", article.getId());
            //更新的字段 只修改阅读数
            updateWrapper.set("view_count", cacheViewCount);
            articleService.update(updateWrapper);
        }
        log.info("----------------------阅读数持久化完毕=======================");
    }
}