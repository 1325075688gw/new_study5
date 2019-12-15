package com.biggw;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author gw
 * @date 2019/12/3 0003 下午 16:41
 */
public class ElasticSearchClientTest {

    private TransportClient client = null;

    @Before
    public void init() throws UnknownHostException {
        Settings settings = Settings.builder()
                .put("cluster.name", "ES-Cluster")
                .put("client.transport.sniff", false)// 自动嗅探整个集群的状态，把集群中其他ES节点的ip添加到本地的客户端列表中
                .build();
        client = new PreBuiltTransportClient(settings);

        // 3.客服端去连接集群
        // 此步骤添加 IP ，至少一个，其实一个就够了，因为添加了自动嗅探配置
        client.addTransportAddress(new TransportAddress(InetAddress.getByName("127.0.0.1"),9301));
        client.addTransportAddress(new TransportAddress(InetAddress.getByName("127.0.0.1"),9302));
    }

    @Test
    public void testClient() throws Exception{
        // 1.创建一个Settings对象，相当于是一个配置信息，主要配置集群的名称
        Settings settings = Settings.builder()
                .put("cluster.name", "ES-Cluster")
                .put("client.transport.sniff", false)// 自动嗅探整个集群的状态，把集群中其他ES节点的ip添加到本地的客户端列表中
                .build();

        // 2.创建一个client客户端对象
        TransportClient client = new PreBuiltTransportClient(settings);

        // 3.客服端去连接集群
        // 此步骤添加 IP ，至少一个，其实一个就够了，因为添加了自动嗅探配置
        client.addTransportAddress(new TransportAddress(InetAddress.getByName("127.0.0.1"),9301));
        client.addTransportAddress(new TransportAddress(InetAddress.getByName("127.0.0.1"),9302));

        // 4.使用client对象创建一个索引库
        client.admin().indices().prepareCreate("es2_index")
                // 执行操作
                .get();

        // 5.关闭client对象
        client.close();
    }

    @Test
    public void testMappings() throws Exception{
        // 1.创建一个Settings对象，相当于是一个配置信息，主要配置集群的名称
        Settings settings = Settings.builder()
                .put("cluster.name", "ES-Cluster")
                .put("client.transport.sniff", false)// 自动嗅探整个集群的状态，把集群中其他ES节点的ip添加到本地的客户端列表中
                .build();

        // 2.创建一个client客户端对象
        TransportClient client = new PreBuiltTransportClient(settings);

        // 3.客服端去连接集群
        // 此步骤添加 IP ，至少一个，其实一个就够了，因为添加了自动嗅探配置
        client.addTransportAddress(new TransportAddress(InetAddress.getByName("127.0.0.1"),9301));
        client.addTransportAddress(new TransportAddress(InetAddress.getByName("127.0.0.1"),9302));

        // 4.创建Mappings
        XContentBuilder xContentBuilder = XContentFactory.jsonBuilder()
                .startObject()
                    .startObject("article")
                        .startObject("properties")
                            .startObject("id")
                                .field("type","long")
                                .field("store",true)
                                .field("index",false)
                            .endObject()
                            .startObject("title")
                                .field("type","text")
                                .field("store",true)
                                .field("index",true)
                                .field("analyzer","ik_smart")
                            .endObject()
                            .startObject("content")
                                .field("type","text")
                                .field("store",true)
                                .field("index",true)
                                .field("analyzer","ik_smart")
                            .endObject()
                        .endObject()
                    .endObject()
                .endObject();

        client.admin().indices().preparePutMapping("es2_index")  // 设置索引
                .setType("article")  // 设置type,这个必须取自上面
                .setSource(xContentBuilder) // 设置mapping信息
                .get();  // 执行命令
    }


    @Test
    public void testDocument() throws IOException {
        XContentBuilder builder = XContentFactory.jsonBuilder()
                .startObject()
                    .field("id",1)
                    .field("title","北京")
                    .field("content","下雪啦")
                .endObject();

        // 把文档对象添加到索引库
        client.prepareIndex()
                .setIndex("es2_index")
                .setType("article")
                .setId("1")
                .setSource(builder)
                // 执行操作
                .get();
        client.close();
    }

    @Test
    public void testDocumentWithJson() throws IOException {
        Article article = new Article();
        article.setId(3);
        article.setTitle("北京哈哈哈");
        article.setContent("我们可以一起撒谎见个面");



        ObjectMapper mappers = new ObjectMapper();
        String s = mappers.writeValueAsString(article);
        System.out.println("s = " + s);

        // 把文档对象添加到索引库
        client.prepareIndex()
                .setIndex("es2_index")
                .setType("article")
                .setId("3")
                .setSource(s, XContentType.JSON)
                .get();
        client.close();
    }

    @Test
    public void testDocumentWithJsonBulk() throws IOException {
        for (int i = 4; i < 50; i++) {
            Article article = new Article();
            article.setId(i);
            article.setTitle("北京哈哈哈"+i);
            article.setContent("我们可以一起撒谎见个面"+i);



            ObjectMapper mappers = new ObjectMapper();
            String s = mappers.writeValueAsString(article);
//            System.out.println("s = " + s);

            // 把文档对象添加到索引库
            client.prepareIndex()
                    .setIndex("es2_index")
                    .setType("article")
                    .setId(String.valueOf(i))
                    .setSource(s, XContentType.JSON)
                    .get();
        }

        client.close();
    }


    @Test
    public void testQueryById(){
        // 1.准备client对象
        // 2.准备查询语句
        IdsQueryBuilder queryBuilder = QueryBuilders.idsQuery().addIds("1", "2");

        // 3.执行查询语句
        SearchResponse searchResponse = client.prepareSearch()
                .setIndices("es2_index")
                .setTypes("article")
                .setQuery(queryBuilder)
                .get();

        // 4.获取查询结果
        SearchHits hits = searchResponse.getHits();

        // 5.获取查询结果数
        long totalHits = hits.getTotalHits();
        System.out.println("totalHits = " + totalHits);

        // 6.遍历查询结果集
        Iterator<SearchHit> iterator = hits.iterator();
        while (iterator.hasNext()){
            SearchHit next = iterator.next();
            // 打印整个文档对象
            System.out.println(next.getSourceAsString());
        }

        System.out.println("==========================================================");

        Iterator<SearchHit> iterator1 = hits.iterator();
        while(iterator1.hasNext()){
            SearchHit next = iterator1.next();
            // 按照键值对打印
            Map<String, Object> sourceAsMap = next.getSourceAsMap();
//            Map<String, Object> sourceAsMap = next.getSource();
            Set<String> strings = sourceAsMap.keySet();
            for (String string : strings) {
                System.out.println(string+": "+sourceAsMap.get(string));
            }
        }
        client.close();
    }

    @Test
    public void testQueryByTerm(){
        // 1.准备client对象
        // 2.准备查询语句
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("title", "北京");
        query(termQueryBuilder);

        client.close();
    }

    @Test
    public void testQueryByQueryString(){
        // 1.准备client对象
        // 2.准备查询语句
        QueryStringQueryBuilder queryString = QueryBuilders.queryStringQuery("北京").queryName("title");
        query(queryString);

        QueryStringQueryBuilder queryString2 = QueryBuilders.queryStringQuery("北京").defaultField("title");
        query(queryString2);

        client.close();
    }


    @Test
    public void testQueryByQueryStringPage(){
        // 1.准备client对象
        // 2.准备查询语句
        QueryStringQueryBuilder queryString = QueryBuilders.queryStringQuery("北京").queryName("title");
        // 3.执行查询语句
        SearchResponse searchResponse = client.prepareSearch()
                .setIndices("es2_index")
                .setTypes("article")
                .setQuery(queryString)
                .setFrom(0) // 起始行号
                .setSize(5) // 每页多少记录
                .get();

        // 4.获取查询结果
        SearchHits hits = searchResponse.getHits();

        // 5.获取查询结果数
        long totalHits = hits.getTotalHits();
        System.out.println("totalHits = " + totalHits);

        // 6.遍历查询结果集
        Iterator<SearchHit> iterator = hits.iterator();
        while (iterator.hasNext()){
            SearchHit next = iterator.next();
            // 打印整个文档对象
            System.out.println(next.getSourceAsString());
        }

        System.out.println("==========================================================");

        Iterator<SearchHit> iterator1 = hits.iterator();
        while(iterator1.hasNext()){
            SearchHit next = iterator1.next();
            // 按照键值对打印
            Map<String, Object> sourceAsMap = next.getSourceAsMap();
//            Map<String, Object> sourceAsMap = next.getSource();
            Set<String> strings = sourceAsMap.keySet();
            for (String string : strings) {
                System.out.println(string+": "+sourceAsMap.get(string));
            }
        }

        client.close();
    }

    public void query(QueryBuilder queryBuilder){
        // 3.执行查询语句
        SearchResponse searchResponse = client.prepareSearch()
                .setIndices("es2_index")
                .setTypes("article")
                .setQuery(queryBuilder)
                .get();

        // 4.获取查询结果
        SearchHits hits = searchResponse.getHits();

        // 5.获取查询结果数
        long totalHits = hits.getTotalHits();
        System.out.println("totalHits = " + totalHits);

        // 6.遍历查询结果集
        Iterator<SearchHit> iterator = hits.iterator();
        while (iterator.hasNext()){
            SearchHit next = iterator.next();
            // 打印整个文档对象
            System.out.println(next.getSourceAsString());
        }

        System.out.println("==========================================================");

        Iterator<SearchHit> iterator1 = hits.iterator();
        while(iterator1.hasNext()){
            SearchHit next = iterator1.next();
            // 按照键值对打印
            Map<String, Object> sourceAsMap = next.getSourceAsMap();
//            Map<String, Object> sourceAsMap = next.getSource();
            Set<String> strings = sourceAsMap.keySet();
            for (String string : strings) {
                System.out.println(string+": "+sourceAsMap.get(string));
            }
        }
    }

    @Test
    public void testQueryByQueryStringColor(){
        // 1.准备client对象
        // 2.准备查询语句
        QueryStringQueryBuilder queryString = QueryBuilders.queryStringQuery("我们").queryName("content");
        queryColor(queryString,"content");
        client.close();
    }


    public void queryColor(QueryBuilder queryBuilder,String... highLightFields){
        HighlightBuilder builder = null;
        if(highLightFields!=null && highLightFields.length>0){
            for (int i = 0; i < highLightFields.length; i++) {
                builder = new HighlightBuilder();
                builder.field(highLightFields[i]);
                builder.preTags("<em>");
                builder.postTags("</em>");
            }
        }

        // 3.执行查询语句
        SearchResponse searchResponse = client.prepareSearch()
                .setIndices("es2_index")
                .setTypes("article")
                .setQuery(queryBuilder)
//                .setHighlighterEncoder("content")
                 .highlighter(builder)
                .setFrom(0)
                .setSize(5)
                .get();

        // 4.获取查询结果
        SearchHits hits = searchResponse.getHits();

        // 5.获取查询结果数
        long totalHits = hits.getTotalHits();
        System.out.println("totalHits = " + totalHits);

        // 6.遍历查询结果集
        Iterator<SearchHit> iterator = hits.iterator();
        while (iterator.hasNext()){
            SearchHit next = iterator.next();
            // 打印整个文档对象
            System.out.println(next.getSourceAsString());
        }

        System.out.println("==========================================================");

        Iterator<SearchHit> iterator1 = hits.iterator();
        while(iterator1.hasNext()){
            SearchHit next = iterator1.next();
            // 按照键值对打印
            Map<String, HighlightField> sourceAsMap = next.getHighlightFields();
            Set<String> strings = sourceAsMap.keySet();
            for (String string : strings) {
                System.out.println(string+": "+sourceAsMap.get(string));
            }
        }
        System.out.println("==========================================================");
        Iterator<SearchHit> iterator2 = hits.iterator();
        ArrayList<Text> fragments = new ArrayList<>();
        while (iterator2.hasNext()){
            Map<String, HighlightField> highlightFields = iterator2.next().getHighlightFields();
            HighlightField content = highlightFields.get("content");
//            System.out.println(content.getFragments());
            fragments.add(content.getFragments()[0]);
            System.out.println(content);
        }
        System.out.println("==========================================================");
        for (Text fragment : fragments) {
            System.out.println(fragment);
        }
    }
}
