package me.baoning.tourist;

import org.apache.commons.lang3.StringUtils;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
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

        page.putField("content", page.getHtml().xpath("//div[@class='fulong_news_content']").smartContent());
        if (StringUtils.isEmpty(page.getResultItems().get("content").toString())) {
            page.setSkip(true);
        }
        List<String> picUrlList = page.getHtml().regex("\\/cms\\/file\\/image\\/[0-9]+\\/[0-9]+\\/[a-z0-9]+\\.jpg").all();
        for (int i = 0; i < picUrlList.size(); i++) {
            String picUrl = picUrlList.get(i);
            String completeUrl = "http://www.xian-tourism.com" + picUrl;
            picUrlList.set(i, completeUrl);
        }
        page.putField("pic", picUrlList);
        page.putField("title", page.getHtml().xpath("//div[@class='nationti']/text()"));
        //System.out.println(page.getHtml());

        //page.putField("readme", page.getHtml().xpath("//div[@id='readme']/tidyText()"));    }

    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new DisscussMock())
//                .addUrl("http://www.xian-tourism.com/xiangcun/show.action?code=publish_4028807457e519330157ffc1239d002b&siteid=100002")
                .addUrl("http://www.xian-tourism.com/cms/show.action?code=publish_40288074580926c101580a9a467e009b&siteid=100002&channelid=0000000035")
                //开启5个线程抓取
                .addPipeline(new JsonFilePipeline("D:\\webmagic\\"))
                .thread(1)
                //启动爬虫
                .run();
    }
}