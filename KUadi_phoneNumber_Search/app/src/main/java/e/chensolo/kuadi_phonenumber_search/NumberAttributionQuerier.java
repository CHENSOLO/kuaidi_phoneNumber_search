package e.chensolo.kuadi_phonenumber_search;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2018/4/21.
 */

public class NumberAttributionQuerier {
    /**
     * 从电话号码获取电话对象
     *
     * @param number 电话号码
     * @return Phone Object
     * @throws IOException 网络错误
     */
    public static Phone getPhone(String number) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url("https://tcc.taobao.com/cc/json/mobile_tel_segment.htm?tel=" + number).build();
        Response response = okHttpClient.newCall(request).execute();
        String json = response.body().string();
        int index = json.indexOf("{");
        json = json.substring(index, json.length());
        Gson gson = new Gson();
        Phone phone = gson.fromJson(json, Phone.class);
        return phone;
    }
}
