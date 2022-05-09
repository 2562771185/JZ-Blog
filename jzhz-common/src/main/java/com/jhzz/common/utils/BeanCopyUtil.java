package com.jhzz.common.utils;

import com.jhzz.common.domain.entity.Article;
import com.jhzz.common.domain.vo.HotArticleVo;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: Huanzhi
 * \* Date: 2022/5/9
 * \* Time: 20:06
 * \* Description:
 * \
 */
public class BeanCopyUtil {
    private BeanCopyUtil() {
    }

    public static <V> V copyOne(Object source, Class<V> target) {
        V result = null;
        try {
            //创建所需对象
            result = target.newInstance();
            //拷贝数据
            BeanUtils.copyProperties(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //返回单个结果
        return result;
    }
    public static <O,V> List<V> copyList(List<O> sources, Class<V> target) {
        return sources.stream()
                .map(v -> copyOne(v, target))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
       List<Article> articles = new ArrayList<>();
        Article article = new Article();
        article.setId(1L);
        article.setTitle("11");
        Article article1 = new Article();
        article1.setId(2L);
        article1.setTitle("22");
        articles.add(article1);
        articles.add(article);
        System.out.println("articles = " + articles);
        List<HotArticleVo> articleVos = copyList(articles, HotArticleVo.class);
        for (HotArticleVo hotArticleVo : articleVos){
            System.out.println("hotArticleVo = " + hotArticleVo);
        }
    }
}
