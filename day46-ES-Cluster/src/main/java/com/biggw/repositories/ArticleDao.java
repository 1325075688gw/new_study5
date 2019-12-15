package com.biggw.repositories;

import com.biggw.domain.Article;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


import java.util.List;

/**
 * @author gw
 * @date 2019/12/3 0003 下午 22:59
 */

// 主键是长整形 long
// Article是类名
public interface ArticleDao extends ElasticsearchRepository<Article,Long> {
    // Spring data 提供了一些方法，但是如果我们还不满足，我们可以按照指定规则进行命名，定义方法，Spring data会按照规则帮我们实现

    // 默认分页了
    List<Article> findByContent(String content);

    List<Article> findByContentOrTitle(String content, String title);

    List<Article> findByContentOrTitle(String content, String title, Pageable pageable);

}
