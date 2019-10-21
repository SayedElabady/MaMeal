package abadyyy.side_projects.mameal.shared.di

import abadyyy.side_projects.mameal.shared.Constants
import abadyyy.side_projects.mameal.shared.store.api.IMaMealService
import abadyyy.side_projects.mameal.shared.store.api.interceptor.JsonInterceptor
import android.content.Context
import android.os.Build
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class NetworkingModule {

    @Provides
    @Singleton
    fun provideApiClient(
        context: Context,
        jsonInterceptor: JsonInterceptor,
        gson: Gson
    ): Retrofit {
        val cacheSize = 10 * 1024 * 1024
        val dir = context.cacheDir
        val cache = Cache(dir, cacheSize.toLong())

        val client = OkHttpClient.Builder()
            .cache(cache)
            .addInterceptor(jsonInterceptor)
            .build()

        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()
    }

    @Provides
    @Singleton
    fun providesJsonInterceptor(): JsonInterceptor {
        return JsonInterceptor()
    }

    @Provides
    @Singleton
    fun providesGson(): Gson {
        return Gson()
    }

    @Provides
    @Singleton
    fun provideMaMealService(retrofit: Retrofit): IMaMealService {
        return retrofit.create(IMaMealService::class.java)
    }

}