package beans.fitday;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class home extends AppCompatActivity implements View.OnClickListener {
    Button Login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Login  = (Button)findViewById(R.id.BodyBn);
        Login.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if(v == Login)
        {
            Intent intent = new Intent();   //活動
            intent.setClass(home.this, home_weight.class);    //設定要置換的activity
            startActivity(intent);      //啟動設定的activity
            home.this.finish();     //原本舊的activity結束
        }
    }
}
