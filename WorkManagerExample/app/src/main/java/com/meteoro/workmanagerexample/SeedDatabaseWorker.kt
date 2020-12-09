package com.meteoro.workmanagerexample

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader

class SeedDatabaseWorker(context: Context, params: WorkerParameters) : Worker(context, params) {

    override fun doWork(): Result {

        // Fazer alguma coisa aqui
        Log.d("SeedDatabase", "Semeando database")
        try {
            applicationContext.assets.open("plants.json").use { inputStream ->
                JsonReader(inputStream.reader()).use { jsonReader ->
                    val plantType = object : TypeToken<List<Plant>>() {}.type
                    val plantList: List<Plant> = Gson().fromJson(jsonReader, plantType)

                    Log.d("SeedDatabase", "Plants: $plantList")
                }
            }

            return Result.success()

        } catch (ex: Exception) {
            Log.e("SeedDatabase", ex.toString())
            return Result.failure()
        }
    }
}
