package com.shaatla.subscribio.infrastructure.structure.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.shaatla.subscribio.BR
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.handleCoroutineException

/**
 * BaseViewModel
 * 23.03.2020
 * Created by shaatla
 * shaatla@gmail.com
 * Copyright (c) 2020 ShaatLa. All rights reserved.
 */
abstract class BaseViewModel<V : ViewDataBinding> : Fragment() {

    protected abstract val layoutId: Int

    protected lateinit var viewBinding: V

    protected lateinit var viewScope: CoroutineScope

    protected lateinit var fragmentScope: CoroutineScope

    @InternalCoroutinesApi
    private val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        handleCoroutineException(coroutineContext, throwable)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        retainInstance = true

        fragmentScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

        viewBinding = DataBindingUtil.inflate(inflater, layoutId, container, false)

        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.lifecycleOwner = viewLifecycleOwner

        viewBinding.setVariable(BR.bindings, this)
    }

    override fun onDestroyView() {
        viewScope.cancel()

        super.onDestroyView()
    }

    override fun onDestroy() {
        fragmentScope.cancel()

        super.onDestroy()
    }
}