package org.alan.commons.template;

import org.alan.utils.PropertyConfig;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.HtmlEmail;

/**
 * @program: learn-more
 * @ClassName: EmailSendThread
 * @description: 发送邮件
 * @author: AlanMa
 * @create: 2019-04-23 14:48
 */
public class EmailSendThread implements Runnable{

    private static final String HOST_NAME = PropertyConfig.getProperty("HOST_NAME", "smtp.163.com");
    private static final String EMAIL_ACCOUNT = PropertyConfig.getProperty("EMAIL_ACCOUNT", "mtd0322@163.com");
    private static final String EMAIL_PASSWORD = PropertyConfig.getProperty("EMAIL_PASSWORD", "qingzhu1903");

    private String title;
    private String content;
    private String to;

    public EmailSendThread(String title, String content, String to) {
        this.title = title;
        this.content = content;
        this.to = to;
    }

    @Override
    public void run() {

        HtmlEmail email = new HtmlEmail();
        email.setHostName(HOST_NAME);
        email.setAuthenticator(new DefaultAuthenticator(EMAIL_ACCOUNT, EMAIL_PASSWORD));
        email.setSSLOnConnect(true);
        try {
            email.addTo(to, "");
            email.setFrom(EMAIL_ACCOUNT, "北京中软信科技有限公司");
            email.setSubject(title);
            email.setCharset("UTF-8");
            email.setHtmlMsg(content);
            email.send();
            System.out.println("邮件发送成功:"+EMAIL_ACCOUNT+"  to  "+to);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}