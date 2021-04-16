/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import ejb.NewsItem;
import ejb.NewsItemFacadeLocal;
import java.util.List;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;

import javax.inject.Inject;
import javax.inject.Named;

import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

/**
 *
 * @author Tomasz
 */
@Named(value = "newsBean")
@RequestScoped
public class NewsBean {
    @Inject
    private NewsItemFacadeLocal facade;
    @Inject
    private JMSContext context;
    @Resource(lookup="java:app/jms/NewsQueue")
    private javax.jms.Queue queue;
    
    private String headingText;
    private String bodyText;
    
    
    public String submitNews(){
        sendNewsItem(headingText,bodyText);
        return null;
    }
    /**
     * Creates a new instance of NewsBean
     */
    public NewsBean() {}
    
    void sendNewsItem(String heading, String body) {
        try {
            /*
            ObjectMessage message = context.createObjectMessage();
            NewsItem e = new NewsItem();
            e.setHeading(heading);
            e.setBody(body);
            message.setObject(e);
            context.createProducer().send(queue, message);
            */
            TextMessage tm = context.createTextMessage(heading + "|"+body);
            context.createProducer().send(queue,tm);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public List<NewsItem> getNewsItems(){
        return facade.getAllNewsItems();
    }

    /**
     * @return the headingText
     */
    public String getHeadingText() {
        return headingText;
    }

    /**
     * @param headingText the headingText to set
     */
    public void setHeadingText(String headingText) {
        this.headingText = headingText;
    }

    /**
     * @return the bodyText
     */
    public String getBodyText() {
        return bodyText;
    }

    /**
     * @param bodyText the bodyText to set
     */
    public void setBodyText(String bodyText) {
        this.bodyText = bodyText;
    }

   
    
}
