package beans.fitday;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
//
//import com.nine_rise.kjyy_client.R;


public class SharedPreferencesUtility {
    private static SharedPreferences cookie;
    private static String PreferenceName="";
    public static String TAG=SharedPreferencesUtility.class.getSimpleName();
    public static boolean D=true;
    private static Context context;
    public static Intent intent;
    public SharedPreferencesUtility(Context context) {
        SharedPreferencesUtility.context = context;
        PreferenceName=context.getString(R.string.app_name);
    }
    /**
     *存在回傳TAG對應內容值；不存在回傳空值
	 *name:TAG名稱
     */
    public static String isCookieExist(String name)
    {
        //取得SharedPreference設定(PreferenceName為設定檔的名稱)
        String cookieStr="";
        try
        {
            cookie = context.getSharedPreferences(PreferenceName, Context.MODE_PRIVATE);
            cookieStr = cookie.getString(name, "");
        }
        catch (Exception e) {}
        return cookieStr;
    }
    /**
     *設定本機暫存
	 *name:TAG名稱
     *value:TAG值
     */
    public static void setCookie(String name,String value) {
        cookie = context.getSharedPreferences(PreferenceName, Context.MODE_PRIVATE);
        cookie.edit().putString(name,value).commit();
    }
    /**
	 *刪除TAG名稱對應值
	 *name:TAG名稱
     */
    public static void deleteCookie(String name){
        try {
            SharedPreferences.Editor edit = cookie.edit();
            edit.putString(name, "");
            edit.commit();
        }catch (Exception e){}
    }
}
