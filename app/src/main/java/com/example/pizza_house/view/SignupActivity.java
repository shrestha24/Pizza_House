package com.example.pizza_house.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.transition.Explode;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pizza_house.Model.User;
import com.example.pizza_house.Model.User;
import com.example.pizza_house.R;
import com.example.pizza_house.viewModel.SignupActivityViewModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignupActivity extends AppCompatActivity {

    @BindView(R.id.fullName)
    EditText fullName;
    @BindView(R.id.userEmailId)
    EditText userEmailId;
    @BindView(R.id.mobileNumber)
    EditText mobileNumber;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.confirmPassword)
    EditText confirmPassword;
    @BindView(R.id.signUpBtn)
    Button signUpBtn;
    String name,email,mob,pass,cpass;
    private FirebaseAuth mAuth;
    FirebaseUser currentUser;
    SignupActivityViewModel signupActivityViewModel;
    private static String TAG=SignupActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ButterKnife.bind(this);
        mAuth = FirebaseAuth.getInstance();
        currentUser= mAuth.getCurrentUser();
        signupActivityViewModel= ViewModelProviders.of(this).get(SignupActivityViewModel.class);
    }
    @OnClick(R.id.signUpBtn)
    public void onViewClicked() {
        getData();
        int x=check();
        if (x!=0){
            return;
        }else{
            final User user1=new User(name,pass,mob,pass);
            mAuth.createUserWithEmailAndPassword(email, pass)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Log.d(TAG, "createUserWithEmail:success");
                                FirebaseUser user = mAuth.getCurrentUser();

                                String uid=user.getUid();
                                user1.setUid(uid);
                                signupActivityViewModel.UploadUsers(user1);
                                Intent intent=new Intent(SignupActivity.this,CartActivity.class);
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                                    getWindow().setSharedElementEnterTransition(new Explode());
                                    startActivity(intent,
                                            ActivityOptions.makeSceneTransitionAnimation(SignupActivity.this).toBundle());
                                }else{
                                    startActivity(intent);
                                }
                                startActivity(intent);


                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w(TAG, "createUserWithEmail:failure", task.getException().getCause());
                                Toast.makeText(SignupActivity.this, getResources().getString(R.string.authfail)+task.getException().getMessage(),
                                        Toast.LENGTH_SHORT).show();

                            }

                        }
                    });


        }

    }

    private void getData() {
        name=fullName.getText().toString();
        email=userEmailId.getText().toString();
        mob=mobileNumber.getText().toString();
        pass=password.getText().toString();
        cpass=confirmPassword.getText().toString();
    }

    private int check() {
        int t=0;
        if (TextUtils.isEmpty(name)){
            fullName.setError("Name Required");
            t=1;

        }
        if (TextUtils.isEmpty(email)){
            userEmailId.setError("Email Id required");
            t=1;
        }
        if (TextUtils.isEmpty(pass)){
            password.setError("Password Required");
            t=1;

        }
        if (TextUtils.isEmpty(cpass)){
            confirmPassword.setError("Confirm Password Required");
            t=1;
        }
        if (!pass.equals(cpass)){
            Toast.makeText(this, "Password is not same check again", Toast.LENGTH_SHORT).show();
            t=1;
        }
        return t;
    }
}