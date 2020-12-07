package com.meteoro.workmanagerexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.work.*

class MainActivity : AppCompatActivity() {

    lateinit var btnWorker: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnWorker = findViewById(R.id.btn_worker)
        btnWorker.setOnClickListener {
            val constraints = Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .build()

            val seedWorker: OneTimeWorkRequest =
                OneTimeWorkRequestBuilder<SeedDatabaseWorker>()
                    .setConstraints(constraints)
                    .build()

            WorkManager.getInstance(this)
                .enqueueUniqueWork(
                    "seed_database",
                    ExistingWorkPolicy.KEEP,
                    seedWorker
                )
        }
    }
}
