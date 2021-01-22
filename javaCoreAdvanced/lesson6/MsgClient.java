package ru.geekbrains.javaCoreAdvanced.homeWork.lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class MsgClient {
    private static final String SERVER_ADDR = "localhost";
    private static final int SERVER_PORT = 8189;
    private static DataInputStream in;
    private static DataOutputStream out;
    private static boolean endServer = false;

    public static void main(String[] args) {
        try {
            openConnection();
            readFromServer();
            writeToServer();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void openConnection() throws IOException {
        try {
            Socket socket = new Socket(SERVER_ADDR, SERVER_PORT);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            System.out.println("Клиент запущен, введите сообщение,");
            System.out.println("чтобы завершить работу введите: /end");
        } catch (IOException e) {
            throw new IOException("Ошибка подключения к серверу");
        }

    }

    public static void readFromServer() {
        new Thread(() -> {
            while (true) {
                String strFromServer = null;
                try {
                    strFromServer = in.readUTF();
                } catch (IOException e) {
                    break;
                }
                System.out.println("Server: " + strFromServer);
                if (strFromServer.equalsIgnoreCase("/end")) {
                    endServer = true;
                    break;
                }
            }
        }
        ).start();
    }

    public static void writeToServer() throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String strToServer = scanner.nextLine();
            if (endServer) {
                System.out.println("Сервер прервал соедининие");
                break;
            }
            try {
                out.writeUTF(strToServer);
            } catch (IOException e) {
                e.printStackTrace();
                throw new IOException("Ошибка отправки сообщения на сервер");
            }
            if (strToServer.equalsIgnoreCase("/end")) {
                break;
            }
        }

    }

}
