package com.ettounani.Blocking_IO;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ChatClientFX extends Application {

    private TextField messageField;
    private TextArea chatArea;
    private Button sendButton;
    private Socket socketChannel = new Socket();
    private BufferedReader in;
    private PrintWriter out;


    @Override
    public void start(Stage primaryStage) {
        chatArea = new TextArea();
        messageField = new TextField();
        sendButton = new Button("Send");

        sendButton.setOnAction(event -> sendMessage());
        messageField.setOnAction(event -> sendMessage());

        VBox root = new VBox();
        root.getChildren().addAll(chatArea, messageField, sendButton);

        Scene scene = new Scene(root, 500, 500);

        primaryStage.setScene(scene);
        primaryStage.show();

        try {
            connect("localhost", 2001);

        } catch (IOException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            try {
                while (true) {
                    String receivedMessage = receiveMessage();
                    updateChatArea(receivedMessage);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    public void connect(String host, int port) throws IOException {

        socketChannel.connect(new InetSocketAddress(host, port));
        in = new BufferedReader(new InputStreamReader(socketChannel.getInputStream()));
        out = new PrintWriter(socketChannel.getOutputStream(), true);
    }

    public String receiveMessage() throws IOException {
        return in.readLine();
    }

    public void close() throws IOException {
        in.close();
        out.close();
        socketChannel.close();
    }

    private void sendMessage() {
        String message = messageField.getText();
        messageField.clear();
        out.println(message);
    }

    private void updateChatArea(String message) {
        chatArea.appendText(message + "\n");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
