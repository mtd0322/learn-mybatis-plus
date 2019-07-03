package org.alan.utils;

import org.alan.commons.template.EmailSendThread;

/**
 * @program: learn-more
 * @ClassName: MailUtil
 * @description: 邮箱工具类
 * @author: AlanMa
 * @create: 2019-04-18 11:16
 */
public class MailUtil {

    public static void sendMailThread(String title, String content, String to) {

        try {
            EmailSendThread emailSendWorker = new EmailSendThread(title, content, to);
            Thread tMail = new Thread(emailSendWorker);
            tMail.start();
            tMail.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
