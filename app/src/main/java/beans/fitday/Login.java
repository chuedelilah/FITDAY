package beans.fitday;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login extends AppCompatActivity implements View.OnClickListener{
    Button Login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //getSupportActionBar().hide();
        Login  = (Button)findViewById(R.id.LoginBn);
        Login.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if(v == Login)
        {
            Intent intent = new Intent();   //活動
            intent.setClass(Login.this, home.class);    //設定要置換的activity
            startActivity(intent);      //啟動設定的activity
            Login.this.finish();     //原本舊的activity結束
        }
    }
}
