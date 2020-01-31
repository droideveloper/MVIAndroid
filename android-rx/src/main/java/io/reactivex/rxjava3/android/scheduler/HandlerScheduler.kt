/*
 *  Copyright (C) 2020 Fatih, MVI Android Kotlin.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.reactivex.rxjava3.android.scheduler

import android.os.Handler
import android.os.Message
import io.reactivex.rxjava3.android.handler.SchedulableRunnable
import io.reactivex.rxjava3.android.worker.HandlerWorkerCompat
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.plugins.RxJavaPlugins
import java.util.concurrent.TimeUnit

abstract class HandlerScheduler(private val handler: Handler): Scheduler() {

  override fun scheduleDirect(run: Runnable, delay: Long, unit: TimeUnit): Disposable {
    val newRunnable = RxJavaPlugins.onSchedule(run)

    val s = SchedulableRunnable.newInstance(handler, newRunnable)

    val message = obtainMessage(handler, s)
    val delayMillis = unit.toMillis(delay)

    handler.sendMessageDelayed(message, delayMillis)

    return s
  }

  override fun createWorker(): Worker = HandlerWorkerCompat.newInstance(handler)

  open fun obtainMessage(handler: Handler, run: Runnable): Message = Message.obtain(handler, run)
}