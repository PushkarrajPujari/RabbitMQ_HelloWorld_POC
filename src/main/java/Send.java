import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.util.Scanner;

/**
 * @Author : Pushkarraj Pujari
 * @Since 03/09/2017
 */
public class Send {
    /**
     * Stage 3 - Publishing out first message
     * */
    public static String Queue_Name = "MyFirstQueue";
    public static String message = "Hello World";

    public static void main(String[] args) {
        try{
            ConnectionFactory connectionFactory = new ConnectionFactory();
            connectionFactory.setHost("localhost");
            Connection connection = connectionFactory.newConnection("MyFirstConnection");
            Channel channel = connection.createChannel();
            channel.queueDeclare(Queue_Name,false,false,false,null);
            channel.basicPublish("",Queue_Name,null,message.getBytes());
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
