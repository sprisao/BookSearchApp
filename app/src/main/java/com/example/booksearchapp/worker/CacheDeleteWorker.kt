package com.example.booksearchapp.worker

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class CacheDeleteWorker(context: Context, workerParameters: WorkerParameters) :
        Worker(context, workerParameters) {
    override fun doWork(): Result {
        return try {
            Log.d("WorkManager", "Cache has successfully been deleted.")
            Result.success()
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure()
        }
    }
}
