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
        // 部分二：定义如何抽取页面信息，并保存下来
        System.out.println(page.getHtml().get());
        page.putField("name", page.getHtml().xpath("//div[@class='comment-content']/p/text()").toString());
        if (page.getResultItems().get("name") == null) {
            //skip this page
            page.setSkip(true);
        }
        //page.putField("readme", page.getHtml().xpath("//div[@id='readme']/tidyText()"));

        // 部分三：从页面发现后续的url地址来抓取
        // page.addTargetRequests(page.getHtml().links().regex("(https://github\\.com/[\\w\\-]+/[\\w\\-]+)").all());
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {

        Spider.create(new DisscussMock())
                //从"https://github.com/code4craft"开始抓
                .addUrl("http://www.dianping.com/shop/90325407")
                //开启5个线程抓取
                .addPipeline(new ConsolePipeline())
                .thread(5)
                //启动爬虫
                .run();

    }
}
