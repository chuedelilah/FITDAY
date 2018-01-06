package beans.fitday;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class home extends AppCompatActivity implements View.OnClickListener {
    Button Login,food;
    Button B;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Login  = (Button)findViewById(R.id.BodyBn);
        Login.setOnClickListener(this);
        food  = (Button)findViewById(R.id.button);
        food.setOnClickListener(this);
        B=(Button)findViewById(R.id.button5);
        B.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if(v == Login)
        {
                Intent intent = new Intent();   //活動
                intent.setClass(home.this, home_weight.class);    //設定要置換的activity
                startActivity(intent);      //啟動設定的activity
                //home.this.finish();     //原本舊的activity結束

        }
        if(v == food)
        {
            Intent intent = new Intent();   //活動
            intent.setClass(home.this, FoodActivity.class);    //設定要置換的activity
            startActivity(intent);      //啟動設定的activity
            //home.this.finish();     //原本舊的activity結束
        }
        if(v == B)
        {
            Intent intent = new Intent();   //活動
            intent.setClass(home.this, Login.class);    //設定要置換的activity
            startActivity(intent);      //啟動設定的activity
            //home.this.finish();     //原本舊的activity結束
        }
    }
}
