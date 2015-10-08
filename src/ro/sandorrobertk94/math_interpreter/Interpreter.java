package ro.sandorrobertk94.math_interpreter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by robert on 10/6/15.
 */
public class Interpreter {
    private String[] arguments;

    public Interpreter(String[] args) {
        this.arguments = args;
    }

    public void run() {
        while (true) {
            // read the line
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String input = null;
            try {
                input = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // if the input is null, we have no string to work on, so we return
            if (input == null) {
                return;
            }

            // if the user enters exit, we exit the loop and close the app
            if (input.contentEquals("exit")) {
                return;
            }

            System.out.println(input);
        }
    }
}
