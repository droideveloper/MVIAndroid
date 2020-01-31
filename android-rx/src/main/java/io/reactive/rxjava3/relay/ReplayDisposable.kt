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

package io.reactive.rxjava3.relay

import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import java.util.concurrent.atomic.AtomicInteger

class ReplayDisposable<T>(val downstream: Observer<T>, val state: ReplayRelay<T>): AtomicInteger(), Disposable {

  override fun toByte(): Byte {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun toChar(): Char {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun toShort(): Short {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun isDisposed(): Boolean {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun dispose() {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }
}