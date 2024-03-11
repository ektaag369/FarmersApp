package com.example.farmersapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.farmersapp.databinding.ActivitySellerLoginBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class SellerLoginActivity extends AppCompatActivity {
    ActivitySellerLoginBinding binding;
    String realCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding= DataBindingUtil.setContentView(this,R.layout.activity_seller_login);

        //for underline the "send code" text
        binding.txtSendcode.setPaintFlags(binding.txtSendcode.getPaintFlags() |   Paint.UNDERLINE_TEXT_FLAG);

        //for back icon
        binding.icBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(SellerLoginActivity.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        //get code
        binding.txtSendcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCode();
            }
        });

        //login after writing code
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifyOtp(realCode);
            }
        });
    }

    private void verifyOtp(String realCode) {
        if(binding.edtCode.getText().toString().length()==6){
            String entercodeotp=binding.edtCode.getText().toString();

            if(realCode!=null){
                binding.progressbar.setVisibility(View.VISIBLE);
                binding.btnLogin.setVisibility(View.INVISIBLE);
                PhoneAuthCredential phoneAuthCredential= PhoneAuthProvider.getCredential(realCode,entercodeotp);
                FirebaseAuth.getInstance().signInWithCredential(phoneAuthCredential)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                binding.progressbar.setVisibility(View.GONE);
                                if(task.isSuccessful()){
                                    Toast.makeText(SellerLoginActivity.this, "OTP verified successfully", Toast.LENGTH_SHORT).show();
                                    Intent i=new Intent(SellerLoginActivity.this, SellerDashboardActivity.class);
                                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                    startActivity(i);
                                }else{
                                    Toast.makeText(SellerLoginActivity.this, "Please check the OTP", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

            }else{
                Toast.makeText(SellerLoginActivity.this, "OTP Not Fetched", Toast.LENGTH_SHORT).show();
            }

        }
        else{
            Toast.makeText(SellerLoginActivity.this, "Enter correct code", Toast.LENGTH_SHORT).show();
        }
    }


    private void getCode() {
        if(!binding.inputMobileno.getText().toString().trim().isEmpty()){
            if(binding.inputMobileno.getText().toString().trim().length()==10){
                binding.progressbar.setVisibility(View.VISIBLE);
                PhoneAuthProvider.getInstance().verifyPhoneNumber(
                        "+91" + binding.inputMobileno.getText().toString(), 120, TimeUnit.SECONDS,
                        SellerLoginActivity.this,
                        new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                                binding.progressbar.setVisibility(View.GONE);
                            }
                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e) {
                                binding.progressbar.setVisibility(View.GONE);
                                Toast.makeText(SellerLoginActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                            @Override
                            public void onCodeSent(@NonNull String backendotp, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                binding.progressbar.setVisibility(View.GONE);
                                binding.btnLogin.setVisibility(View.VISIBLE);
                                realCode=backendotp;
                            }
                        }
                );
            }
            else{
                Toast.makeText(SellerLoginActivity.this, "Mobile Number is Incorrect", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(SellerLoginActivity.this, "Please Enter Mobile Number", Toast.LENGTH_SHORT).show();
        }
    }
}