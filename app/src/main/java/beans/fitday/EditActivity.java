package beans.fitday;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
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


public class EditActivity extends AppCompatActivity {

    Button back;
    Button correct;
    private String meal[] = {"早餐","中餐","晚餐","其他","取消"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        back = (Button)findViewById(R.id.button2) ;
        correct = (Button)findViewById(R.id.button3) ;

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(view.getContext(), "add test", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.setClass(EditActivity.this, FoodActivity.class);
                startActivity(intent);
                EditActivity.this.finish();
            }
        });

        correct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(view.getContext(), "add test", Toast.LENGTH_SHORT).show();

                ShowListDialog();
                /*Intent intent = new Intent();
                                intent.setClass(EditActivity.this, FoodActivity.class);
                                startActivity(intent);
                                EditActivity.this.finish();*/
            }
        });
    }
    private void ShowListDialog(){
        AlertDialog.Builder builder=new AlertDialog.Builder(EditActivity.this);
        builder.setTitle("選擇時間");
        builder.setIcon(R.drawable.salad);
        builder.setItems(meal, new DialoglistClickListener());
        AlertDialog dialog=builder.create();
        dialog.show();
    }

    class DialoglistClickListener implements DialogInterface.OnClickListener{

        @Override
        public void onClick(DialogInterface dialog, int which) {

            Toast.makeText(EditActivity.this,meal[which],Toast.LENGTH_SHORT).show();

            dialog.dismiss();
        }

    }
}