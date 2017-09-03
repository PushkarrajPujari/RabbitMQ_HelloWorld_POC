import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.util.Scanner;

/**
 * @Author : Pushkarraj Pujari
 * @Since 03/09/2017
 */
public class Send {
    /**
     * Stage 1 , Added all dependencies using maven , you can find a pom.xml file in the project
     * In this stage we will establish a basic connection  to rabbitmq
     * */
    public static void main(String[] args) {
        try{
            ConnectionFactory connectionFactory = new ConnectionFactory();
            connectionFactory.setHost("localhost");
            Connection connection = connectionFactory.newConnection();
            blockingCall();
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
