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

import beans.fitday.EditActivity;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

public class FoodActivity extends AppCompatActivity {


    PieChart pieChart ;
    ImageView add,back,edit;
    ArrayList<Entry> entries ;
    ArrayList<String> PieEntryLabels ;
    PieDataSet pieDataSet ;
    PieData pieData ;
    public int allCalories = 2200;
    public int carbs = 800;
    public int fats = 300;
    public int protenis = 400;
    public int blankCalories = allCalories - carbs - fats - protenis;
    public int useCalories = allCalories - blankCalories;
    TextClock mTextClock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
      /*  ListView listview = (ListView) findViewById(R.id.listview);
        String[] str = {"新北市","台北市","台中市","台南市","高雄市"};
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1 ,
                str);
        listview.setAdapter(adapter);
*/

        pieChart = (PieChart) findViewById(R.id.idPieChart);
        back = (ImageView) findViewById(R.id.imageView);
        add = (ImageView) findViewById(R.id.imageView2);
        edit = (ImageView) findViewById(R.id.imageView3);
        mTextClock = (TextClock)findViewById(R.id.textClock);

        mTextClock.setFormat12Hour("E, MMMM dd, yyyy ");
        mTextClock.setFormat24Hour("E, MMMM dd, yyyy ");

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(view.getContext(), "back test", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.setClass(FoodActivity.this, home.class);
                startActivity(intent);
                FoodActivity.this.finish();
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(view.getContext(), "add test", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.setClass(FoodActivity.this, AddActivity.class);
                startActivity(intent);
                FoodActivity.this.finish();
            }
        });
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(view.getContext(), "edit test", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.setClass(FoodActivity.this, EditActivity.class);
                startActivity(intent);
                FoodActivity.this.finish();
            }
        });
        Weather weather_data[] = new Weather[]
                {
                        new Weather(R.drawable.salad1, "沙拉"),
                        new Weather(R.drawable.fruite, "水果"),
                        new Weather(R.drawable.salad1, "Snow"),
                        new Weather(R.drawable.salad1, "Storm"),
                        new Weather(R.drawable.salad1, "Sunny")
                };

        WeatherAdapter adapter = new WeatherAdapter(this,
                R.layout.listview_item_row, weather_data);


        ListView listView1 = (ListView)findViewById(R.id.listview);

        View header = (View)getLayoutInflater().inflate(R.layout.listview_header_row, null);
       // listView1.addHeaderView(header);

        listView1.setAdapter(adapter);


        entries = new ArrayList<>();

        PieEntryLabels = new ArrayList<String>();
        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(Color.parseColor("#f77968"));
        colors.add(Color.parseColor("#02c3e0"));
        colors.add(Color.parseColor("#fabe4d"));
        colors.add(Color.parseColor("#00ffffff"));
        AddValuesToPIEENTRY();

        AddValuesToPieEntryLabels();

        pieDataSet = new PieDataSet(entries, "");
        pieChart.setTransparentCircleAlpha(0);
        pieChart.setCenterText(useCalories+"/"+allCalories);
        pieChart.setCenterTextSize(16);
        pieData = new PieData(PieEntryLabels, pieDataSet);
        pieDataSet.setSliceSpace(2);
        pieDataSet.setValueTextSize(12);
        pieDataSet.setColors(colors);
        pieChart.setData(pieData);
        pieChart.animateY(1000);

    }

    public void AddValuesToPIEENTRY(){

        entries.add(new BarEntry(carbs, 0));
        entries.add(new BarEntry(fats, 1));
        entries.add(new BarEntry(protenis, 2));
        entries.add(new BarEntry(blankCalories, 3));
    }

    public void AddValuesToPieEntryLabels(){

        PieEntryLabels.add("carbs");
        PieEntryLabels.add("fats");
        PieEntryLabels.add("protenis");
        PieEntryLabels.add("");

    }
}