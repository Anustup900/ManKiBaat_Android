package com.example.mankibaat

import android.app.Application
import com.example.mankibaat.MyApplication.Staticated.task
import io.realm.Realm
import io.realm.mongodb.App
import io.realm.mongodb.AppConfiguration
import java.util.concurrent.TimeUnit

class MyApplication : Application() {
    object Staticated {
        lateinit var task: App
    } override fun onCreate() {
        super.onCreate()
        Realm.init(this) // context, usually an Activity or Application

        val appID = "mankibaat-flfig" // replace this with your App ID
         task = App(
            AppConfiguration.Builder(appID)
                .baseUrl("https://realm.mongodb.com")
                .appName(getString(R.string.app_name))
                .appVersion("1.0")
                .requestTimeout(30, TimeUnit.SECONDS)
                .build())

    }
}