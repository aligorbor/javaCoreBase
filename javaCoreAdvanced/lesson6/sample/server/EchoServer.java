package sample.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {
    private static final int SERVER_PORT = 8888;
    private static DataOutputStream out;
    private static Socket clientSocket;
    private static boolean waitClient = true;

    public static void main(String[] args) {
        boolean newThread = true;
        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            System.out.println("Ожидание подключения...");

            while (waitClient) {
                clientSocket = serverSocket.accept();
                System.out.println("Соединение установлено!");
                System.out.println("для завершения работы сервера введите: /end");

                DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                out = new DataOutputStream(clientSocket.getOutputStream());

                writeToClient(newThread);
                newThread = false;

                try {
                    while (waitClient) {
                        String message = in.readUTF();

                        if (message.equals("/end")) {
                            clientSocket.close();
                            break;
                        }

                        System.out.println(message);

                        out.writeUTF(message.toUpperCase());

                    }

                    System.out.println("Сервер остановлен");
                } catch (IOException e) {
                    clientSocket.close();
                    System.out.println("Клиент отключился");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeToClient(boolean newThread) {
        if (newThread)
            new Thread(() -> {
                Scanner scanner = new Scanner(System.in);
                while (true) {
                    String strToClient = scanner.nextLine();
                    try {
                        out.writeUTF(strToClient);
                    } catch (IOException e) {
                        System.out.println("Ошибка отправки сообщения клиенту");
                        break;
                    }
                    if (strToClient.equalsIgnoreCase("/end")) {
                        try {
                            waitClient = false;
                            clientSocket.close();
                        } catch (IOException e) {
                            System.out.println("Отключаем клиента");
                        }
                        break;
                    }
                }

            }
            ).start();
    }
}
