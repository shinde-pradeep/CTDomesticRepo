/**
 * 
 */
package com.kjnext.utility.email;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
//import org.apache.log4j.*;
/**
 * @author kiran
 *
 */
public class EmailMessage extends MimeMessage {

	//private Logger logger = Logger.getLogger(this.getClass().getName()); 
    /** The value stored in the Message-ID header tag for the message.*/
    protected String messageID = "";
    
    /**
     * Create a new EmailMessage object.
     * @param session The javax.mail.Session object the mail message is for.
     *
     */        
    public EmailMessage(javax.mail.Session session) {
        super(session);
    }
    
    /**
     * Set the value stored in the Message-ID header tag for the message.
     * @param p_value The value of the Message-ID header tag.
     *
     */        
    void setMessageID(String p_value) {
        messageID = p_value;
    }
    
    /**
     * Calls the super.updateHeaders() method, and also ensures 
     * that the Message-ID header tag
     * gets set if the setMessageID method was called.
     *
     * @throws MessagingException If an error occurs.
     */        
    protected void updateHeaders() throws MessagingException {
        super.updateHeaders();
        if (messageID != null && messageID.length() > 0) {
            setHeader("Message-ID", messageID);
        }
    }

}
