package me.baoning.tourist;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;

/**
 * @author: zhangbaoning
 * @date: 2019/2/12
 * @since: JDK 1.8
 * @description: TODO
 */
public class DisscussMock implements PageProcessor {
    // 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

    @Override
    // process是定制爬虫逻辑的核心接口，在这里编写抽取逻辑
    public void process(Page page) {
        List<String> urlList = page.getHtml().links().regex("code=jumpnewstemplate&siteid=[0-9]+&channelid=[0-9]+&newsid=[a-z0-9]+").all();
        for (int i = 0; i <urlList.size() ; i++) {
            String url = urlList.get(i);
            url = url.replace("jumpnewstemplate","publish_40288074580926c1015818c41a9a0104");
            String completeUrl = "http://www.xian-tourism.com/cms/show.action?"+url;
            urlList.set(i,completeUrl);
        }
        page.addTargetRequests(urlList);
        //  page.putField("author", page.getUrl().regex("https://github\\.com/(\\w+)/.*").toString());
        page.putField("name", page.getHtml().xpath("//div[@class='fulong_news_content']").smartContent());
        //System.out.println(page.getHtml());

        //page.putField("readme", page.getHtml().xpath("//div[@id='readme']/tidyText()"));    }

    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new DisscussMock())
                //从"https://github.com/code4craft"开始抓
                .addUrl("http://www.xian-tourism.com/xiangcun/show.action?code=publish_4028807457e519330157ffc1239d002b&siteid=100002")
                //开启5个线程抓取
                .addPipeline(new ConsolePipeline())
                .thread(1)
                //启动爬虫
                .run();
    }
}