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

import android.annotation.TargetApi
import android.os.Build
import android.os.Handler
import android.os.Message

@TargetApi(Build.VERSION_CODES.LOLLIPOP_MR1)
class HandlerSchedulerImpV22(handler: Handler): HandlerScheduler(handler) {

  override fun obtainMessage(handler: Handler, run: Runnable): Message = super.obtainMessage(handler, run).apply {
    isAsynchronous = true
  }
}