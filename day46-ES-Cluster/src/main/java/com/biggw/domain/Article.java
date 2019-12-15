package com.biggw.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldIndex;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author gw
 * @date 2019/12/3 0003 下午 21:56
 */

@Document(indexName = "es_index2", type = "article")
public class Article {
    @Id
    @Field(type = FieldType.Long, store = true, index = FieldIndex.not_analyzed)
    private long id;

    // 默认索引 index = FieldIndexd
    @Field(type = FieldType.String, store = true, index = FieldIndex.analyzed,analyzer = "ik_smart")
    private String title;

    @Field(type = FieldType.String, store = true, index = FieldIndex.analyzed,analyzer = "ik_smart")
    private String content;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
