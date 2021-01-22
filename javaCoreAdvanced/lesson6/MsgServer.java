package ru.geekbrains.javaCoreAdvanced.homeWork.lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MsgServer {
    private static final int SERVER_PORT = 8189;
    private static ServerSocket serverSocket;
    private static DataInputStream in;
    private static DataOutputStream out;
    private static Socket socket;
    private static boolean waitClient = true;

    public static void main(String[] args) {
        try {
            startServer();
            acceptClient();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void startServer() throws IOException {
        try {
            serverSocket = new ServerSocket(SERVER_PORT);
        } catch (IOException e) {
            e.printStackTrace();
            throw new IOException("Не удалось запустить сервер.");
        }
        System.out.println("Сервер запущен.");
        System.out.println("чтобы завершить работу введите: /end");
    }

    public static void acceptClient() throws IOException {
        boolean newThread = true;
        while (waitClient) {
            try {
                System.out.println("Ожидаем подключения...");
                socket = serverSocket.accept();
                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());
                System.out.println("Клиент подключился");

                writeToClient(newThread);
                newThread = false;
                while (waitClient) {
                    String str = null;
                    try {
                        str = in.readUTF();
                        System.out.println("Client: " + str);
                        if (str.equals("/end")) {
                            socket.close();
                            break;
                        }
                    } catch (IOException e) {
                        socket.close();
                        break;
                    }
                }
            } catch (IOException e) {
                System.out.println("Клиент отключился");
            }
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
                            socket.close();
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
