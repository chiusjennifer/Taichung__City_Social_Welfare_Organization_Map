package tw.edu.pu.s1114859.taichung__city_social_welfare_organization_map.objects

import android.provider.DocumentsContract.Root
import com.google.gson.annotations.SerializedName
data class Record(
    @SerializedName("基金會名稱") val name: String,
    @SerializedName("連絡電話") val phone: String,
    @SerializedName("傳真") val TEL: String,
    @SerializedName("電子郵件") val mail: String,
    @SerializedName("地址") val address: String,
    @SerializedName("行政區") val ad: String,
    @SerializedName("X坐標") val X: String,
    @SerializedName("Y坐標") val Y: String,
    @SerializedName("相關網址") val link: String,
    @SerializedName("最後更新日期") val newdate: String,
    @SerializedName("服務對象") val group: String,
    @SerializedName("縣市別代碼") val code: String
)

/*
data class DataResponse(
    @SerializedName("ROOT") val root:Root
)
data class Root(
    @SerializedName("RECORD") val records: List<Record>
)*/
