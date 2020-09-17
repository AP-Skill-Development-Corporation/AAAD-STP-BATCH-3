package com.example.firebaseexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.security.AuthProvider;
import java.util.concurrent.TimeUnit;

public class PhoneAuth extends AppCompatActivity {
    EditText number,code;
    FirebaseAuth auth;
    // To get the Otp,Auto verification and to capture failures
    PhoneAuthProvider.OnVerificationStateChangedCallbacks callbacks;
    // This token is used to resend the otp
    PhoneAuthProvider.ForceResendingToken token;
    //To hold the verification id
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_auth);
        number = findViewById(R.id.number);
        code = findViewById(R.id.otp);
        auth = FirebaseAuth.getInstance();

        callbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                super.onCodeSent(s, forceResendingToken);
                //verification id
                id = s;
                //Token to resend
                token = forceResendingToken;
            }
            @Override
            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                //This is to perform auto verification
                signPhoneAuth(phoneAuthCredential);
            }
            @Override
            public void onVerificationFailed(@NonNull FirebaseException e) {
                Toast.makeText(PhoneAuth.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        };
    }

    private void signPhoneAuth(PhoneAuthCredential phoneAuthCredential) {
        auth.signInWithCredential(phoneAuthCredential).addOnCompleteListener(this,
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            startActivity(new Intent(PhoneAuth.this,HomeActivity.class));
                            finish();
                        }else{
                            Toast.makeText(PhoneAuth.this, "Authentication Failed",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public void send(View view) {
        String num = number.getText().toString();
        if (num.isEmpty()){
            number.setError("Cant be empty");
        }else{
            PhoneAuthProvider.getInstance().verifyPhoneNumber("+91"+num,
                    60, TimeUnit.SECONDS, TaskExecutors.MAIN_THREAD,callbacks);
            Toast.makeText(this, "Otp Sent", Toast.LENGTH_SHORT).show();
        }
    }

    public void verify(View view) {
        String otp = code.getText().toString();
        if (otp.isEmpty()){
            code.setError("Cant be empty");
        }else {
            //To Authenticate manually
            PhoneAuthCredential credential = PhoneAuthProvider.getCredential(id, otp);
            signPhoneAuth(credential);
        }
    }
    public void resend(View view) {
        String num = number.getText().toString();
        if (num.isEmpty()){
            Toast.makeText(this, "cant be empty", Toast.LENGTH_SHORT).show();
        }else{
            PhoneAuthProvider.getInstance().verifyPhoneNumber("+91"+num,60,TimeUnit.SECONDS,
                    TaskExecutors.MAIN_THREAD,callbacks,token);
            Toast.makeText(this, "Otp sent", Toast.LENGTH_SHORT).show();
        }
    }
}