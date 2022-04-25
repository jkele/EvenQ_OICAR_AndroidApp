package hr.algebra.evenq.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://evenq.azurewebsites.net/api/"
const val API_KEY = "90a43b0c0a9444d081d954804aaf9cb8"

class Network {

    private val service: EventService

    init {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BASIC
        val httpClient = OkHttpClient.Builder().addInterceptor(object: Interceptor{
            override fun intercept(chain: Interceptor.Chain): Response {
                val request = chain.request().newBuilder().addHeader("ApiKey", API_KEY).build()
                return chain.proceed(request)
            }

        })




        val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build()).build()
        service = retrofit.create(EventService::class.java)
    }

    fun getService(): EventService = service
}