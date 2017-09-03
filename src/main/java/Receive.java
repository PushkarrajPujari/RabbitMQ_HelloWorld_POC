import com.rabbitmq.client.*;

import java.io.UnsupportedEncodingException;

/**
 * @Author : Pushkarraj Pujari
 * @Since : 03/09/17
 */
public class Receive {
    /**
     * Stage 4 - In this stage we will be writing the consumer
     * this stage will not work and is purposely kept this way to bring your attention to an important line of code
     * */
    public static String Queue_Name = "MyFirstQueue";
    public static void main(String[] args) {
        try{
            ConnectionFactory connectionFactory = new ConnectionFactory();
            connectionFactory.setHost("localhost");
            Connection connection = connectionFactory.newConnection("Receive");
            Channel channel = connection.createChannel();
            channel.queueDeclare(Queue_Name,false,false,false,null);
            System.out.println(" [*] Waiting for messages");
            Consumer consumer = new DefaultConsumer(channel){
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws UnsupportedEncodingException {
                    String message = new String(body, "UTF-8");
                    System.out.println(" [x] Received '" + message + "'");
                }
            };
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
