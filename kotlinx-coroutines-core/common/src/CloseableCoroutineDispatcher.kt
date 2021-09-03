/*
 * Copyright 2016-2021 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license.
 */

package kotlinx.coroutines

/**
 * [CoroutineDispatcher] that provides method to close it,
 * causing the rejection of any new tasks and cleanup of all underlying resources
 * associated with the current dispatcher.
 * Examples of closeable dispatchers are dispatchers backed by `java.lang.Executor` and
 * by `kotlin.native.Worker`.
 *
 * **The `CloseableCoroutineDispatcher` class is not stable for inheritance in 3rd party libraries**, as new methods
 * might be added to this interface in the future, but is stable for use.
 */
public expect abstract class CloseableCoroutineDispatcher() : CoroutineDispatcher {

    /**
     * Initiate the closing sequence of the coroutine dispatcher.
     * After a successful call to [close], no new tasks will
     * be accepted to be [dispatched][dispatch], but previously dispatched tasks will be run.
     *
     * Invocations of `close` on already closed dispatcher have no effect.
     */
    public abstract fun close()
}
