package beans.fitday;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity implements View.OnClickListener{
    Button Login;

    EditText id,pw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //getSupportActionBar().hide();
        Login  = (Button)findViewById(R.id.LoginBn);
        Login.setOnClickListener(this);
        id  = (EditText)findViewById(R.id.account);
        pw  = (EditText)findViewById(R.id.password);
    }
    @Override
    public void onClick(View v) {
        if(v == Login)
        {
            if(id.getText().toString().equals("123") && pw.getText().toString().equals("456")) {
                Intent intent = new Intent();   //活動
                intent.setClass(this, home.class);    //設定要置換的activity
                startActivity(intent);      //啟動設定的activity
                //home.this.finish();     //原本舊的activity結束
            }
            else {
                Toast toast = Toast.makeText(this,
                        "帳號密碼錯誤!", Toast.LENGTH_SHORT);
                //顯示Toast
                toast.show();
            }
        }

    }
}
