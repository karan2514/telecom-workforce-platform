package com.telecom.jms;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Properties;

public class JMSSender {

    public static void main(String[] args) throws Exception {

        Properties props = new Properties();

        props.put(Context.INITIAL_CONTEXT_FACTORY,
                "weblogic.jndi.WLInitialContextFactory");

        props.put(Context.PROVIDER_URL,
                "t3://localhost:7001");

        props.put(Context.SECURITY_PRINCIPAL,
                "weblogic");

        props.put(Context.SECURITY_CREDENTIALS,
                "Wll123@@");

        Context context = new InitialContext(props);

        ConnectionFactory factory =
                (ConnectionFactory)
                        context.lookup("jms/EmployeeConnectionFactory");

        Queue queue =
                (Queue)
                        context.lookup("jms/EmployeeQueue");

        Connection connection =
                factory.createConnection();

        Session session =
                connection.createSession(false,
                        Session.AUTO_ACKNOWLEDGE);

        MessageProducer producer =
                session.createProducer(queue);

        TextMessage message =
                session.createTextMessage("Hello from WebLogic JMS!");

        producer.send(message);

        System.out.println("Message Sent Successfully!");

        producer.close();
        session.close();
        connection.close();
    }
}