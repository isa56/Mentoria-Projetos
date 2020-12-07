package com.meteoro.workmanagerexample

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class SeedDatabaseWorker(context: Context, params: WorkerParameters) : Worker(context, params) {

    override fun doWork(): Result {

        // Fazer alguma coisa aqui
        Log.d("SeedDatabase", "Semeando database")

        return Result.success()
    }
}
