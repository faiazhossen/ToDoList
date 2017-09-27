package com.example.faiaz.todolist.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.faiaz.todolist.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.field_phone_number)
    EditText mPhoneNumber;
    @BindView(R.id.field_verification_code)
    EditText mVerification;
    @BindView(R.id.button_start_verification)
    Button mStartButton;
    @BindView(R.id.button_verify_phone)
    Button mVerifyPhone;
    @BindView(R.id.login_text)
    TextView login_text;
    @BindView(R.id.signup_text)
    TextView singup_text;
    @BindView(R.id.user_email)
    EditText user_email;
    @BindView(R.id.user_password)
    EditText user_password;

    @BindView(R.id.user_email_reg)
    EditText user_email_reg;
    @BindView(R.id.user_password_reg)
    EditText user_password_reg;

    @BindView(R.id.verifyLayout)
    LinearLayout verifyLayout;
    @BindView(R.id.layout_verify)
    LinearLayout layout_verify;

    @BindView(R.id.btn_reg)
    Button btn_reg;
    @BindView(R.id.btn_login)
    Button btn_login;
    @BindView(R.id.user_password_reg_confirm)
    EditText user_password_reg_confirm;

    @BindView(R.id.user_login)
    LinearLayout user_login;
    @BindView(R.id.user_reg)
    LinearLayout user_reg;

    @BindView(R.id.login_with_no)
    TextView login_with_no;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    private PhoneAuthProvider.ForceResendingToken mResendToken;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;
    String mVerificationId;

    private static final String TAG = "PhoneAuthActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        mAuth = FirebaseAuth.getInstance();

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();

                if (user != null) {
                    Log.d(TAG, "onAuthStateChanged: signed in" + user.getUid());
                } else {
                    Log.d(TAG, "onAuthStateChanged: signed out");
                }
            }
        };

        mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
                Log.d(TAG, "onVerificationCompleted: "+phoneAuthCredential);
                signInWithPhoneAuthCredential(phoneAuthCredential);
            }

            @Override
            public void onVerificationFailed(FirebaseException e) {

            }
        };

        initiateView();
    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential phoneAuthCredential) {
        mAuth.signInWithCredential(phoneAuthCredential)
                .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            FirebaseUser user = task.getResult().getUser();
                            startActivity(new Intent(LoginActivity.this,MyToDoList.class));
                            finish();
                        }
                    }
                });
    }


    void initiateView() {
        login_text.setOnClickListener(this);
        singup_text.setOnClickListener(this);
        btn_login.setOnClickListener(this);
        btn_reg.setOnClickListener(this);
        login_with_no.setOnClickListener(this);


    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthStateListener);
    }

    @Override
    protected void onStop() {
        super.onStop();

        if (mAuthStateListener != null) {
            mAuth.removeAuthStateListener(mAuthStateListener);
        }
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch (id) {
            case R.id.login_text:
                user_reg.setVisibility(View.GONE);
                user_login.setVisibility(View.VISIBLE);
                verifyLayout.setVisibility(View.GONE);
                break;
            case R.id.signup_text:
                user_login.setVisibility(View.GONE);
                user_reg.setVisibility(View.VISIBLE);
                verifyLayout.setVisibility(View.GONE);
                break;
            case R.id.btn_login:
                String useremail = user_email.getText().toString();
                String userPass = user_password.getText().toString();

                if (useremail.isEmpty() || userPass.isEmpty()) {
                    Toast.makeText(this, "Please insert email and password", Toast.LENGTH_SHORT).show();
                } else {
                    mAuth.signInWithEmailAndPassword(useremail, userPass)
                            .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(LoginActivity.this, "Login Succcessful", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(LoginActivity.this, MyToDoList.class));
                                        finish();
                                    } else
                                        Toast.makeText(LoginActivity.this, "Login Failed, Please Try again", Toast.LENGTH_SHORT).show();
                                }
                            });
                }
                break;
            case R.id.btn_reg:
                Toast.makeText(this, "please wait", Toast.LENGTH_SHORT).show();
                String reg_name = user_email_reg.getText().toString();
                String reg_pass = user_password_reg.getText().toString();
                String confimrm_pass = user_password_reg_confirm.getText().toString();
                if (reg_name.isEmpty() || reg_pass.isEmpty() || !reg_pass.equals(confimrm_pass)) {
                    Toast.makeText(this, "Please insert email and password", Toast.LENGTH_SHORT).show();
                } else {
                    mAuth.createUserWithEmailAndPassword(reg_name, reg_pass)
                            .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(LoginActivity.this, "Signup successful", Toast.LENGTH_SHORT).show();
                                        finish();

                                        startActivity(new Intent(LoginActivity.this, MyToDoList.class));
                                    } else {
                                        Toast.makeText(LoginActivity.this, "Please try again", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
                break;
            case R.id.login_with_no:
                verifyLayout.setVisibility(View.VISIBLE);
                user_reg.setVisibility(View.GONE);
                user_login.setVisibility(View.GONE);
                if(!validatePhoneNumber()){
                    return;
                }

                layout_verify.setVisibility(View.VISIBLE);
                startPhoneNumberVerification(mVerifyPhone.getText().toString());
                break;
        }
    }

    private void startPhoneNumberVerification(String phoneNumber) {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phoneNumber,
                60,
                TimeUnit.SECONDS,
                this,
                mCallbacks
        );
    }

    private boolean validatePhoneNumber() {
        String phoneNumber = mPhoneNumber.getText().toString();
        if (TextUtils.isEmpty(phoneNumber)) {
            mPhoneNumber.setError("Invalid phone number.");
            return false;
        }
        return true;
    }



}
