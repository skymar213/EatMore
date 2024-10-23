package com.sky.eatmore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout clWelcome;
    private TextView txtSignUp,txtLogIn,txtForgotPassword,txtGuest;
    private TextInputLayout txtConfirmPassword;
    private Button btnSubmit;
    private boolean isSignUp  = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_EatMore);
        setContentView(R.layout.activity_main);
        clWelcome = findViewById(R.id.clWelcome);
        clWelcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clWelcome.setVisibility(View.GONE);
            }
        });

        txtLogIn = findViewById(R.id.txtLogIn);
        txtSignUp = findViewById(R.id.txtSignUp);
        btnSubmit = findViewById(R.id.btnSubmit);
        txtConfirmPassword = findViewById(R.id.txtConfirmPassword);
        txtForgotPassword = findViewById(R.id.txtForgotPassword);
        txtGuest = findViewById(R.id.txtGuest);

        txtGuest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Home.class));
            }
        });



        txtLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtLogIn.setBackground(getResources().getDrawable(R.drawable.text_selected));
                txtLogIn.setTextColor(getResources().getColor(R.color.white));
                txtLogIn.setElevation(4);

                txtSignUp.setBackground(getResources().getDrawable(R.drawable.unselected_text));
                txtSignUp.setTextColor(getResources().getColor(R.color.red));
                txtSignUp.setElevation(0);

                btnSubmit.setText("Log In");

                txtConfirmPassword.setVisibility(View.GONE);
                txtForgotPassword.setVisibility(View.VISIBLE);
                isSignUp = false;

            }
        });


        txtSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtSignUp.setBackground(getResources().getDrawable(R.drawable.text_selected));
                txtSignUp.setTextColor(getResources().getColor(R.color.white));
                txtSignUp.setElevation(4);

                txtLogIn.setBackground(getResources().getDrawable(R.drawable.unselected_text));
                txtLogIn.setTextColor(getResources().getColor(R.color.red));
                txtLogIn.setElevation(0);

                btnSubmit.setText("Sign Up");

                txtConfirmPassword.setVisibility(View.VISIBLE);
                txtForgotPassword.setVisibility(View.GONE);
                isSignUp = true;
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isSignUp){
                    Toast.makeText(MainActivity.this, "Signing Up", Toast.LENGTH_SHORT).show();
                }else
                    Toast.makeText(MainActivity.this, "Logging In", Toast.LENGTH_SHORT).show();

            }
        });



    }
}