package tw.edu.pu.s1114859.taichung__city_social_welfare_organization_map
import com.google.gson.annotations.SerializedName
class JsonObjectArray {

    data class ExampleJson2KtKotlin (

        @SerializedName("ROOT" ) var ROOT : ROOT? = ROOT()

    )

    data class RECORD (

        @SerializedName("基金會名稱"  ) var 基金會名稱  : String? = null,
        @SerializedName("連絡電話"   ) var 連絡電話   : String? = null,
        @SerializedName("傳真"     ) var 傳真     : String? = null,
        @SerializedName("電子郵件"   ) var 電子郵件   : String? = null,
        @SerializedName("地址"     ) var 地址     : String? = null,
        @SerializedName("行政區"    ) var 行政區    : String? = null,
        @SerializedName("X坐標"    ) var X坐標    : String? = null,
        @SerializedName("Y坐標"    ) var Y坐標    : String? = null,
        @SerializedName("相關網址"   ) var 相關網址   : String? = null,
        @SerializedName("最後更新日期" ) var 最後更新日期 : String? = null,
        @SerializedName("服務對象"   ) var 服務對象   : String? = null,
        @SerializedName("縣市別代碼"  ) var 縣市別代碼  : String? = null

    )

    data class ROOT (

        @SerializedName("RECORD" ) var RECORD : ArrayList<RECORD> = arrayListOf()

    )
}