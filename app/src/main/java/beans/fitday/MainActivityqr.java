package beans.fitday;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

//import beans.fitday.integration.android.*;

public class MainActivityqr extends AppCompatActivity {
   private Activity mainactivity;
    private TextView scan_content;
    private TextView scan_format;
    private Button scan_btn;
    @Override
    protected void onCreate(Bundle saveInstanceStat){
        super.onCreate(saveInstanceStat);
        setContentView(R.layout.activityqr_main);
        init_view();
        scan_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator scanIntegrator = new IntentIntegrator(mainactivity);
                scanIntegrator.initiateScan();
            }
        });
    }
    public void onActivityResult(int requestCode, int resultCode, Intent intent){
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if(scanningResult!=null){
            String scanContent=scanningResult.getContents();
            String scanFormat=scanningResult.getFormatName();
            scan_content.setText(scanContent);
            scan_format.setText(scanFormat);
        }else{
            Toast.makeText(getApplicationContext(),"nothing",Toast.LENGTH_SHORT).show();
        }
    }
    private void init_view(){
        this.scan_content=(TextView)findViewById(R.id.scan_content);
        this.scan_format=(TextView)findViewById(R.id.scan_format);
        this.mainactivity=this;
        this.scan_btn = (Button)findViewById(R.id.scan_btn);
    }
}
