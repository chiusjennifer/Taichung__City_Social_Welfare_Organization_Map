package tw.edu.pu.s1114859.taichung__city_social_welfare_organization_map

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import tw.edu.pu.s1114859.taichung__city_social_welfare_organization_map.objects.Record
import java.io.IOException

class MainActivity : AppCompatActivity() {
    private val client: OkHttpClient =OkHttpClient.Builder().build()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var record:Record
        //建立Request，設置連線資訊
        val request: Request = Request.Builder()
            .url("https://datacenter.taichung.gov.tw/swagger/OpenData/c2ee604c-e0ec-4776-8f7a-4b840df0caf8")
            .build()
        //建立Call
        val call: Call =client.newCall(request)
        //執行Call連線到網址
        call.enqueue(object :Callback {
            override fun onResponse(call: Call, response: Response) {
                //連線成功，自response取得連線結果
                val result: String = response.body!!.string()

                Log.d("OkHttp result", result)
            }

            override fun onFailure(call: Call, e: IOException) {
                //連線失敗
                println("error:${e.message}")
            }
        })
    }
}