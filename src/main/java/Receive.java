import com.rabbitmq.client.*;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 * @Author : Pushkarraj Pujari
 * @Since : 03/09/17
 */
public class Receive {
    /**
     * Stage 4.1 - working example of consumer
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
            channel.basicConsume(Queue_Name,true,consumer);
            blockingCall();
            channel.close();
            connection.close();
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }
    public static void blockingCall(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press Enter To Exit.......");
        scanner.nextLine();
    }
}
