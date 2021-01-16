package yayang.setiyawan.uasmobile.webservices

import yayang.setiyawan.uasmobile.models.User
import yayang.setiyawan.uasmobile.models.Wisata
import com.google.gson.annotations.SerializedName
import yayang.setiyawan.uasmobile.utilities.WisataUtils
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import java.util.concurrent.TimeUnit

class WisataAPI {
    companion object{
        private var retrofit: Retrofit? = null

        private var okHttpClient = OkHttpClient.Builder().connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS).writeTimeout(30, TimeUnit.SECONDS).build()

        fun instance(): WisataAPIService = getClient()
            .create(WisataAPIService::class.java)

        private fun getClient(): Retrofit {
            return if(retrofit == null){
                retrofit = Retrofit.Builder().baseUrl(
                    WisataUtils.API_ENDPOINT)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create()).build()
                retrofit!!
            }else{
                retrofit!!
            }
        }
    }
}

interface WisataAPIService {
    @FormUrlEncoded
    @POST("auth/login")
    fun login(
        @Field("email") email: String? = null,
        @Field("password") password: String? = null
    ): Call<WrappedResponse<User>>

    @GET("tourism")
    fun get(@Header("x-access-token") token : String) : Call<WrappedListResponse<Wisata>>

    @FormUrlEncoded
    @POST("tourism")
    fun createData(
        @Header("x-access-token") token :String,
        @Field("name") name: String? = null,
        @Field("location") location: String? = null,
        @Field("description") description: String? = null
    ): Call<WrappedResponse<Wisata>>

    @FormUrlEncoded
    @PUT("tourism/{id}")
    fun updateData(
        @Path("id") id: Int,
        @Header("x-access-token") token: String,
        @Field("name") name: String? = null,
        @Field("location") location: String? = null,
        @Field("description") description: String? = null
    ) : Call<WrappedResponse<Wisata>>


    @DELETE("tourism/{id}")
    fun deleteData(
        @Path("id") id: Int,
        @Header("x-access-token") token : String
    ) : Call<WrappedResponse<Wisata>>
}

data class WrappedResponse<T>(
    @SerializedName("message") var message: String?,
    @SerializedName("status") var status: Boolean,
    @SerializedName("data") var data : T?
){
    constructor() : this(null, false, null)
}

data class WrappedListResponse<T>(
    @SerializedName("message") var message: String?,
    @SerializedName("status") var status: Boolean,
    @SerializedName("data") var data : List<T>
){
    constructor() : this(null, false, listOf())
}