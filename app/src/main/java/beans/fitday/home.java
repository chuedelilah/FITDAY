package beans.fitday;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.MPPointF;

import java.util.ArrayList;

public class home extends AppCompatActivity implements View.OnClickListener,OnChartValueSelectedListener {
    Button Login,food;
    Button B;
    TextView text;
    protected HorizontalBarChart mChart;
    //protected Typeface mTfRegular;
    protected Typeface mTfLight;
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
        text = (TextView)findViewById(R.id.textView4);
        init();
        setData( 1, 1000 );//資料count表示幾筆資料 range 表示範圍
        mChart.setFitBars(true);
        mChart.invalidate();//刷新
//        SharedPreferences sharedPreferences = getSharedPreferences("weight" , MODE_PRIVATE);
//        //取得SharedPreferences ， 丟入的參數為("名稱" , 存取權限)
//
//        sharedPreferences.edit().putString("weight" , "100").apply();
//        //存入資料，丟入的參數為(key , value)
//
//        sharedPreferences.getInt("weight" , 0);
//        //取出資料， 丟入的參數為(key , 若是沒值，預設為多少)
//
//        String str = sharedPreferences.getString("weight","10");
//        text.setText(sharedPreferences.getString("weight","10"));
        text.setText("請輸入體重");
    }
    private void init(){
        //mTfRegular = Typeface.createFromAsset(getAssets(), "fonts/OpenSans-Regular.ttf");
        mTfLight = Typeface.createFromAsset(getAssets(), "fonts/OpenSans-Light.ttf");

        mChart = (HorizontalBarChart) findViewById(R.id.chart1);
        mChart.setOnChartValueSelectedListener(this);
        // mChart.setHighlightEnabled(false);

        mChart.setDrawBarShadow(false);

        mChart.setDrawValueAboveBar(true);

        mChart.getDescription().setEnabled(false);

        // if more than 60 entries are displayed in the chart, no values will be
        // drawn
        mChart.setMaxVisibleValueCount(60);

        // scaling can now only be done on x- and y-axis separately
        mChart.setPinchZoom(false);

        // draw shadows for each bar that show the maximum value
        // mChart.setDrawBarShadow(true);

        mChart.setDrawGridBackground(false);

        XAxis xl = mChart.getXAxis();
        xl.setPosition(XAxis.XAxisPosition.BOTTOM);
        xl.setTypeface(mTfLight);
        xl.setDrawAxisLine(true);
        xl.setDrawGridLines(false);
        xl.setGranularity(10f);

        YAxis yl = mChart.getAxisLeft();
        yl.setTypeface(mTfLight);
        yl.setDrawAxisLine(true);
        yl.setDrawGridLines(true);
        yl.setAxisMinimum(0f); // this replaces setStartAtZero(true)
//        yl.setInverted(true);

        YAxis yr = mChart.getAxisRight();
        yr.setTypeface(mTfLight);
        yr.setDrawAxisLine(true);
        yr.setDrawGridLines(false);
        yr.setAxisMinimum(0f); // this replaces setStartAtZero(true)
//        yr.setInverted(true);

        setData(1, 1000);
        mChart.setFitBars(true);
        mChart.animateY(2500);

        Legend l = mChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);//顯示此資料圖示
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(false);
        l.setFormSize(8f);
        l.setXEntrySpace(4f);
    }
    private void setData(int count, float range) {//設定資料數據

        float barWidth = 3f;//數據的寬度(藍色')
        float spaceForBar = 10f;//每隔的間隔
        ArrayList<BarEntry> yVals1 = new ArrayList<BarEntry>();

        for (int i = 0; i < count; i++) {
            float val = (float) (Math.random() * range);
            yVals1.add(new BarEntry(i * spaceForBar, val,getResources().getDrawable(R.drawable.star)));
        }

        BarDataSet set1;

        if (mChart.getData() != null &&
                mChart.getData().getDataSetCount() > 0) {
            set1 = (BarDataSet)mChart.getData().getDataSetByIndex(0);
            set1.setValues(yVals1);
            mChart.getData().notifyDataChanged();
            mChart.notifyDataSetChanged();
        } else {
            set1 = new BarDataSet(yVals1, "Today's  colories");

            set1.setDrawIcons(false);

            ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
            dataSets.add(set1);

            BarData data = new BarData(dataSets);
            data.setValueTextSize(10f);
            data.setValueTypeface(mTfLight);
            data.setBarWidth(barWidth);
            mChart.setData(data);

        }
    }
    @Override
    public void onClick(View v) {
        if(v == Login)
        {
                Intent intent = new Intent();   //活動
                intent.setClass(home.this, Map.class);    //設定要置換的activity
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
    protected RectF mOnValueSelectedRectF = new RectF();
    @Override
    public void onValueSelected(Entry e, Highlight h) {
        if (e == null)
            return;

        RectF bounds = mOnValueSelectedRectF;
        mChart.getBarBounds((BarEntry) e, bounds);

        MPPointF position = mChart.getPosition(e, mChart.getData().getDataSetByIndex(h.getDataSetIndex())
                .getAxisDependency());

        Log.i("bounds", bounds.toString());
        Log.i("position", position.toString());

        MPPointF.recycleInstance(position);
    }

    @Override
    public void onNothingSelected() {

    }
}
