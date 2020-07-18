package com.shaatla.subscribio.subscriptions.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.shaatla.subscribio.R
import com.shaatla.subscribio.subscriptions.ui.recycler.SubscriptionsAdapter
import com.shaatla.subscribio.subscriptions.ui.recycler.SubscriptionsItemDecoration
import kotlinx.android.synthetic.main.fragment_subscriptions.subscriptionsRecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * CommentsViewModel
 * 23.03.2020
 * Created by shaatla
 * shaatla@gmail.com
 * Copyright (c) 2020 ShaatLa. All rights reserved.
 */
class SubscriptionsFragment : Fragment(R.layout.fragment_subscriptions) {

    private val viewScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    private val viewModel by viewModel<SubscriptionsViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupSubscriptionsAdapter()
    }

    private fun onCreateNewClick() {
        findNavController().navigate(SubscriptionsFragmentDirections.toInfo())
    }

    private fun setupSubscriptionsAdapter() {
        val adapter = SubscriptionsAdapter { id ->
            findNavController().navigate(SubscriptionsFragmentDirections.toInfo(id))
        }

        subscriptionsRecyclerView.adapter = adapter
        subscriptionsRecyclerView.addItemDecoration(SubscriptionsItemDecoration(8))

//        viewScope.launch {
//            subscriptionsDomain.observeSubscriptions()
//                .collect { subscriptions ->
//                    isShowEmptyState.postValue(subscriptions.isEmpty())
//
//                    adapter.submitList(subscriptions)
//                }
//        }
    }
}