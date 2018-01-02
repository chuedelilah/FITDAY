package beans.fitday;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class home_weight extends AppCompatActivity implements View.OnClickListener  {
    Button test;
    private final static String TAG = MainActivity.class.getSimpleName();
    private Button button4;
    private BluetoothAdapter mBluetoothAdapter;
    private int REQUEST_ENABLE_BT = 1;
    private BluetoothLeService mBluetoothLeService;
    private xServiceConnection mServiceConnection;
    private Handler mHandler;
    private String mBleScanTagId = "";

    private byte[] mPreScanRecord = {0};
    XenonDecoder mXbDecoder;
    private boolean mScanning;
    private String mDeviceAddress;
    private boolean mEnableScan = true;
    private static long mBleScanInterval = 20000;//20000
    private static long mBleScanTimeout = 15000;//15000
    private EditText editTextWeight;

    class xServiceConnection implements ServiceConnection {

        public xServiceConnection() {
            super();

        }

        @Override
        public void onServiceConnected(ComponentName componentName,
                                       IBinder service) {
            mBluetoothLeService = ((BluetoothLeService.LocalBinder) service)
                    .getService();
            if (!mBluetoothLeService.initialize()) {
                Log.e(TAG, "Unable to initialize Bluetooth");
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            mBluetoothLeService = null;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_weight);
        test=(Button)findViewById(R.id.B);
        test.setOnClickListener(this);
        //按鈕事件
        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // Check if BLE is supported on the device.
                if (!getPackageManager().hasSystemFeature(PackageManager.FEATURE_BLUETOOTH_LE)) {
                    Toast.makeText(home_weight.this, "BLE is not supported in this device!", Toast.LENGTH_SHORT).show();
                    //finish();
                }

                // Initializes Bluetooth adapter.
                final BluetoothManager bluetoothManager =
                        (BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE);
                mBluetoothAdapter = bluetoothManager.getAdapter();

                // Ensures Bluetooth is available on the device and it is enabled. If not,
                // displays a dialog requesting user permission to enable Bluetooth.
                if (mBluetoothAdapter == null || !mBluetoothAdapter.isEnabled()) {
                    Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
                }
                mBleScanTagId = XenonHelper.XENON_ADVERTISING_NAME;

                // BLE Setting
                mBluetoothAdapter = bluetoothManager.getAdapter();

                if (mBluetoothAdapter.isEnabled()) {
                    mHandler = new Handler();
                    registerReceiver(mGattUpdateReceiver, makeGattUpdateIntentFilter());
                    if (mBleScanInterval != 0) {
                        mHandler.post(doTask);
                    }

                    editTextWeight = (EditText) findViewById(R.id.editText);
                    scanLeDevice(true);


                }

            }
        });
    }
    @Override
    public void onClick(View v) {
        if(v == test) {
            Intent intent = new Intent();   //活動
            intent.setClass(home_weight.this, input_weight.class);    //設定要置換的activity
            startActivity(intent);      //啟動設定的activity
            home_weight.this.finish();     //原本舊的activity結束
        }
    }

    private BluetoothAdapter.LeScanCallback mLeScanCallback = new BluetoothAdapter.LeScanCallback() {

        @Override
        public void onLeScan(final BluetoothDevice device, final int rssi,
                             final byte[] scanRecord) {
            mDeviceAddress = device.getAddress();
            String adName = "";
            String msg = device.getAddress() + "---payload = ";
            for (byte b : scanRecord)
                msg += String.format("%02x ", b);
            Log.i(TAG, msg);
            // parse ScanRecord data
            List<AdRecord> records = AdRecord
                    .parseScanRecord(scanRecord);
            XenonData xbData = null;
            // get advertise Name
            for (AdRecord packet : records) {
                Log.i(TAG, "BG Service getType:" + packet.getType());
                // Find the device name record
                if (packet.getType() == AdRecord.TYPE_NAME) {
                    adName = AdRecord.getName(packet);
                    Log.i(TAG, "BG ADV Name:" + adName);
                    Log.i(TAG, "BG DEVICE ADDRESS:" + device.getAddress());
                } else if (packet.getType() == AdRecord.TYPE_MANUFACTURER_SPEC_DATA) {
                    //  xbData = packet.getXenonData();

                }
            }

            if (mBluetoothLeService == null) {
                Intent gattServiceIntent = new Intent(
                        home_weight.this,
                        BluetoothLeService.class);
                mServiceConnection = new xServiceConnection();
                bindService(gattServiceIntent, mServiceConnection,
                        BIND_AUTO_CREATE);
            } else {

                if (!adName.equals("")) {
                    if (adName.toLowerCase().equals(mBleScanTagId.toLowerCase())) {

                        mBluetoothLeService.connect(mDeviceAddress, false, false, null);
                    }
                }
            }
            mPreScanRecord = scanRecord;

        }
    };


    private Runnable doTask = new Runnable() {
        @Override
        public void run() {
            try {
                if (!mScanning) {
                    if (mEnableScan) {
                        scanLeDevice(true);
                    }
                    //   mHandler.postDelayed(doTask, mBleScanInterval);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    };


    private void scanLeDevice(final boolean enable) {
        if (enable) {
            // Stops scanning after a pre-defined scan period.
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mScanning = false;
                    mBluetoothAdapter.stopLeScan(mLeScanCallback);

                }
            }, mBleScanTimeout);
            mScanning = true;

            mBluetoothAdapter.startLeScan(mLeScanCallback);

        } else {
            mScanning = false;
            mBluetoothAdapter.stopLeScan(mLeScanCallback);
        }
    }

    private static IntentFilter makeGattUpdateIntentFilter() {
        final IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(BluetoothLeService.ACTION_GATT_CONNECTED);
        intentFilter.addAction(BluetoothLeService.ACTION_DATA_AVAILABLE);
        intentFilter.addAction(BluetoothLeService.ACTION_GATT_DISCONNECTED);
        return intentFilter;
    }

    private final BroadcastReceiver mGattUpdateReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            final String action = intent.getAction();
            String address;
            if (BluetoothLeService.ACTION_DATA_AVAILABLE.equals(action)) {
                try {
                    Bundle bundle = intent.getBundleExtra(BluetoothLeService.EXTRA_DATA);
                    address = bundle.getString("address");
                    byte value[] = bundle.getByteArray("value");
                    AdRecord adRecord = new AdRecord(value.length + 1, 0xFF, value);
                    XenonData xbData = adRecord.getXenonData();
                    String uid = String.format("%02x ", xbData.productId) + String.format("%02x ", xbData.deviceId);
                    String valueString="";
                    try {
                        byte[] weightValue = new byte[5];
                        weightValue[0] = xbData.values[3];
                        weightValue[1] = xbData.values[4];
                        weightValue[2] = xbData.values[5];
                        weightValue[3] = xbData.values[6];
                        weightValue[4] = xbData.values[7];
                        valueString = new String(weightValue, "UTF-8");
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                    editTextWeight.setText(valueString);
                    Log.e("values", valueString);
                    //   mXbDecoder.putData(uid, xbData.values);

                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
            }
        }
    };
}
