package beans.fitday;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextClock;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;


public class AddActivity extends AppCompatActivity {

ImageView back,barcode,voice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_add);
        setContentView(R.layout.activity_add);

        back = (ImageView) findViewById(R.id.imageView5);
        barcode = (ImageView) findViewById(R.id.imageView6);
        voice = (ImageView) findViewById(R.id.imageView4);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(view.getContext(), "add test", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.setClass(AddActivity.this, FoodActivity.class);
                startActivity(intent);
                AddActivity.this.finish();
            }
        });

        barcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "barcode test", Toast.LENGTH_SHORT).show();
            }
        });

        voice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //點擊語音按鈕

                Intent intent = new Intent();   //活動
                intent.setClass(AddActivity.this,MainActivitystt.class);    //設定要置換的activity
                startActivity(intent);      //啟動設定的activity
                //Toast.makeText(view.getContext(), "voice test", Toast.LENGTH_SHORT).show();

            }
        });



    }
}