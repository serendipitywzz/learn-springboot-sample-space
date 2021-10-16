package com.huidatech.crawler.app.utils;

import com.huidatech.crawler.app.entity.JDContent;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description: 解析网页
 * @Author: Wangzz
 * @Version: 1.0.0
 * @CreateDate: Created in 2021/10/16 20:57
 * @UpdateDate: [dateFormat:YYYY-MM-DD][modifier][description]
 */

@Component
public class HtmlParseUtil {

//    public static void main(String [] args) throws Exception {
//        AtomicInteger count = new AtomicInteger();
//        new HtmlParseUtil().parseJD("Java").forEach(jdContent -> {
//            count.getAndIncrement();
//            System.out.println("【" + count + "】" + jdContent);
//        });
//    }

    public List<JDContent> parseJD(String keywords) throws Exception{
        // 获得请求 https://search.jd.com/Search?keyword=java
        // 前提需要联网
        String url = "https://search.jd.com/Search?keyword=" + keywords;

        // 解析网页(Jsoup返回的Document就是JS页面对象)
        Document document = Jsoup.parse(new URL(url), 30000);

        // 所有JS中可以使用的方法都可以使用
        Element j_goodsListElement = document.getElementById("J_goodsList");
//        System.out.println(j_goodsListElement);
        // 获取所有的li元素
        Elements liElements = j_goodsListElement.getElementsByTag("li");

        // ============================================================================================
        List<JDContent> jdGoodsList = new ArrayList<>();
        // ============================================================================================
        // 获取元素中的内容
        liElements.forEach(x -> {
            // 关于这种图片特别多的网站 所有的图片都是延迟加载的
//            String img01 = x.getElementsByTag("img").eq(0).attr("src");
            String img01 = x.getElementsByTag("img").eq(0).attr("data-lazy-img");
            String price01 = x.getElementsByClass("p-price").eq(0).text();
            String title01 = x.getElementsByClass("p-name").eq(0).text();

//            System.out.println("图书图片地址: " + img01);
//            System.out.println("图书价格: " + price01);
//            System.out.println("图书标题: " + title01);
            JDContent jdContent = new JDContent(title01,img01, price01);
            jdGoodsList.add(jdContent);

        });
        return jdGoodsList;
    }
}
