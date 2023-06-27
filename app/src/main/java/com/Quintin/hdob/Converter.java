package com.Quintin.hdob;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import java.util.Stack;

public class Converter extends AppCompatActivity {

    EditText hexadecimal, decimal, octal, binary, input;
    Button button;
    RadioGroup radioGroup;
    RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);
        hexadecimal =(EditText)findViewById(R.id.hexadecimal);
        decimal =(EditText)findViewById(R.id.decimal);
        octal =(EditText)findViewById(R.id.octal);
        binary =(EditText)findViewById(R.id.binary);
    }

    public void addListenerOnButton() {
        radioGroup = (RadioGroup) findViewById(R.id.radiogroup);
        button = (Button) findViewById(R.id.converterButton);
        button.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View view) {
            switch(radioGroup.getCheckedRadioButtonId()){
            case 1:{
                converter(2, binary);
                converter(8, octal);
                converter(10, decimal);
            }
            case 2:{
                converter(2, binary);
                converter(8, octal);
                converter(16, hexadecimal);
                break;
            }
            case 3: {
                converter(2, binary);
                converter(16, hexadecimal);
                converter(10, decimal);
                break;
            }
            case 4: {
                converter(2, binary);
                converter(8, octal);
                converter(10, decimal);
                break;
            }
        }
    }

    private void converter(int base, EditText editText){
        if(editText.getText().toString().trim().length()==0){
            editText.setText("");
        }
        try
        {
            Stack<Object> stack=new Stack<Object>();
            int number=Integer.parseInt(editText.getText().toString());
            while(number>0){
                int remainder=number%base;
                if(remainder<10)
                {
                    stack.push(remainder);
                }
                else
                {
                    switch (remainder){
                        case 10:
                            stack.push("A");
                            break;
                        case 11:
                            stack.push("B");
                            break;
                        case 12:
                            stack.push("C");
                            break;
                        case 13:
                            stack.push("D");
                            break;
                        case 14:
                            stack.push("E");
                            break;
                        case 15:
                            stack.push("F");
                            break;
                    }
                }
                number/=base;
            }
            StringBuffer buffer=new StringBuffer();
            while (!stack.isEmpty()){
                buffer.append(stack.pop().toString());
            }
            editText.setText(buffer.toString());
            switch(base){
                case 2:
                    binary.setText(buffer.toString());
                    break;
                case 8:
                    octal.setText(buffer.toString());
                    break;
                case 10:
                    decimal.setText(buffer.toString());
                    break;
                case 16:
                    hexadecimal.setText(buffer.toString());
                    break;
                default:
            }

        }catch(Exception e){
            editText.setText(e.getMessage());
        }
    }
    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}
)
        ;
    }
}
//https://www.codeproject.com/articles/479257/number-system-converter-android-app
//Cite this ^^^^