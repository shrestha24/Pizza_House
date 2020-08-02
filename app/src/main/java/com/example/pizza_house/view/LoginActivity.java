package com.example.pizza_house.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.transition.Explode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pizza_house.R;
import com.example.pizza_house.utils.NetworkChecker;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {
    @BindView(R.id.login_emailid)
    EditText loginEmailid;
    @BindView(R.id.login_password)
    EditText loginPassword;
    @BindView(R.id.loginBtn)
    Button loginBtn;
    @BindView(R.id.createAccount)
    Button createAccount;
    private FirebaseAuth mAuth;
    private static final String TAG = LoginActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(loginEmailid.getText().toString())) {
                    loginEmailid.setError(getResources().getString(R.string.emailreq));
                    return;
                }
                if (TextUtils.isEmpty(loginPassword.getText().toString())) {
                    loginPassword.setError(getResources().getString(R.string.passreq));
                    return;
                }
                String email = loginEmailid.getText().toString();
                String password = loginPassword.getText().toString();
                signin(email, password);
            }
        });
    }
    private void signin(String email, String password) {
        if (NetworkChecker.connected(this)) {
            mAuth.signInWithEmailAndPassword(email,password)
                    .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d(TAG, "createUserWithEmail:success");
                                FirebaseUser user = mAuth.getCurrentUser();
                                Intent intent=new Intent(LoginActivity.this,CartActivity.class);
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                                    getWindow().setSharedElementEnterTransition(new Explode());
                                    startActivity(intent,
                                            ActivityOptions.makeSceneTransitionAnimation(LoginActivity.this).toBundle());
                                }else{
                                    startActivity(intent);
                                }
                                startActivity(intent);
                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                Toast.makeText(LoginActivity.this, getResources().getString(R.string.authfail) + task.getException().getMessage(),
                                        Toast.LENGTH_SHORT).show();

                            }

                            // ...
                        }
                    });
        } else {
            Toast.makeText(this, getResources().getString(R.string.nointernet), Toast.LENGTH_SHORT).show();
        }
    }
    @OnClick(R.id.createAccount)
    public void onViewClicked() {
        Intent intent=new Intent(LoginActivity.this,SignupActivity.class);
        startActivity(intent);
    }
}