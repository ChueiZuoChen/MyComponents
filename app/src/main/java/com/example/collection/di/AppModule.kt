package com.example.collection.di

import android.app.Application
import com.example.collection.data.remote.MyApi
import com.example.collection.data.repository.MyRepositoryImpl
import com.example.collection.domain.repository.MyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

/**
 * InstallIn 可以取決於你想要這個Module可以活多久
 * SingletonComponent - Module每個注入都是單例
 * ViewModelComponent - 依賴的生命週期將與被注入的ViewModel一致
 * ActivityComponent - 依賴的生命週期將與被注入的Activity一致
 * ActivityRetainedComponent - 依賴的生命週期當螢幕旋轉且activity被重新建立時候，他們不會被銷毀(Retained 螢幕旋轉)
 * ServiceComponent - 依賴的生命週期將與被注入的Service一致
 * */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMyApi(): MyApi {
        return Retrofit.Builder()
            .baseUrl("https://test.com")
            .build()
            .create(MyApi::class.java)
    }

    /**
     * 這裡有一個重點：因為MyRepository必須給一個MyApi物件，所以在provideMyRepository方法上讓他傳入一個MyApi，
     * 這時候他就會和上面的provideMyApi做成關聯
     * */
    @Provides
    @Singleton
    fun provideMyRepository(
        api: MyApi,
        app: Application,
        @Named("hello1") hello1: String
    ): MyRepository {
        return MyRepositoryImpl(api, app)

    }

    @Provides
    @Singleton
    @Named("hello1")
    fun provideString1() = "Hello 1"

    @Provides
    @Singleton
    @Named("hello2")
    fun provideString2() = "Hello 2"


}