package tw.edu.pu.s1114859.taichung__city_social_welfare_organization_map

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.google.gson.Gson
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.json.JSONObject
import tw.edu.pu.s1114859.taichung__city_social_welfare_organization_map.objects.Record
import java.io.IOException


class MainActivity : AppCompatActivity() {
    private val client: OkHttpClient =OkHttpClient.Builder().build()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recyclerview_item)
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
                val rootStr = JSONObject(result).getJSONObject("ROOT").toString()
                val records = JSONObject(rootStr).getJSONArray("RECORD")
                for (i in 0 until 1){
                    val recordObject = records.getJSONObject(0)
                    val gson = Gson()
                    val data = gson.fromJson(recordObject.toString(),Record::class.java)
                    // 在 UI 線程上更新 TextView
                    runOnUiThread {
                        findViewById<TextView>(R.id.dataname).text = data.name
                        findViewById<TextView>(R.id.dataphone).text = data.phone
                        findViewById<TextView>(R.id.dataddress).text = data.address
                        findViewById<TextView>(R.id.datad).text = data.ad
                        findViewById<TextView>(R.id.datalink).text = data.link
                        findViewById<TextView>(R.id.dataob).text = data.group
                    }

                }


            }

            override fun onFailure(call: Call, e: IOException) {
                //連線失敗
                println("error:${e.message}")
            }
        })
    }
}