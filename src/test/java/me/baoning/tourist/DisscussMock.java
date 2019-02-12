package me.baoning.tourist;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

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
        page.addTargetRequests(page.getHtml().links().regex("code=jumpnewstemplate&siteid=[0-9]+&channelid=[0-9]+&newsid=[a-z0-9]+").all());
        //  page.putField("author", page.getUrl().regex("https://github\\.com/(\\w+)/.*").toString());
        page.putField("name", page.getHtml().xpath("//div[@class='fulong_news_content']/p/text()").toString());
        System.out.println(page.getHtml());
        if (page.getResultItems().get("name") == null) {
            //skip this page
            page.setSkip(true);
        }
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
                .thread(5)
                //启动爬虫
                .run();
    }
}