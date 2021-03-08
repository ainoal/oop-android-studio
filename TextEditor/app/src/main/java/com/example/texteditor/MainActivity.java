package com.example.texteditor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    Context context = null;
    Button buttonRead;
    Button buttonWrite;
    EditText inputFile;
    EditText inputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = MainActivity.this;
        buttonRead = (Button) findViewById(R.id.buttonRead);
        buttonWrite = (Button) findViewById(R.id.buttonWrite);
        inputFile = (EditText) findViewById(R.id.inputFile);
        inputText = (EditText) findViewById(R.id.inputText);
    }

    public void writeFile(View v) {
        try {
            String filename = inputFile.getText().toString();
            OutputStreamWriter osw = new OutputStreamWriter(context.openFileOutput("file.txt", Context.MODE_PRIVATE));
            String s = inputText.getText().toString();
            osw.write(s);
            osw.close();
        } catch (IOException e) {
            Log.e("IOException", "Invalid input");
        }
    }

    public void readFile(View v) {
        try {
            String filename = inputFile.getText().toString();
            InputStream is = context.openFileInput("file.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String s = "";
            String fileContent = "";

            while ((s = br.readLine()) != null) {
                fileContent = fileContent.concat(s);
            }

            inputText.setText(fileContent);
            is.close();

        } catch (IOException e) {
            Log.e("IOException", "Invalid input");
        } finally {
            System.out.println("READ");
        }
    }
}
