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

package io.reactivex.rxjava3.android.handler

import android.os.Handler
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.plugins.RxJavaPlugins

class SchedulableRunnable private constructor(
  private val handler: Handler,
  private val delegate: Runnable): Runnable, Disposable {

  companion object {
    @JvmStatic fun newInstance(handler: Handler, delegate: Runnable): SchedulableRunnable = SchedulableRunnable(handler, delegate)
  }

  @Volatile private var disposed = false

  override fun run() {
    try {
      delegate.run()
    } catch (error: Throwable) {
      RxJavaPlugins.onError(error)
    }
  }

  override fun isDisposed(): Boolean = disposed

  override fun dispose() = handler.removeCallbacks(this).also {
    disposed = true
  }
}