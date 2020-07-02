package com.shaatla.subscriptionmanager.subscriptions.ui

import android.os.Bundle
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import com.shaatla.subscriptionmanager.R
import com.shaatla.subscriptionmanager.databinding.FragmentSubscriptionsBinding
import com.shaatla.subscriptionmanager.infrastructure.structure.ui.BaseViewModel
import com.shaatla.subscriptionmanager.subscriptions.domain.boundary.SubscriptionsDomain
import com.shaatla.subscriptionmanager.subscriptions.ui.recycler.SubscriptionItemBindings
import com.shaatla.subscriptionmanager.subscriptions.ui.recycler.SubscriptionsAdapter
import com.shaatla.subscriptionmanager.subscriptions.ui.recycler.SubscriptionsItemDecoration
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

/**
 * CommentsViewModel
 * 23.03.2020
 * Created by shaatla
 * shaatla@gmail.com
 * Copyright (c) 2020 ShaatLa. All rights reserved.
 */
class SubscriptionsViewModel :
    BaseViewModel<FragmentSubscriptionsBinding>(), SubscriptionsBindings {

    override val layoutId: Int = R.layout.fragment_subscriptions

    private val subscriptionsDomain: SubscriptionsDomain by inject()

    override val isShowEmptyState = MutableLiveData<Boolean>(false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupSubscriptionsAdapter()
    }

    override fun onCreateNewClick() {
        findNavController().navigate(SubscriptionsViewModelDirections.toInfo())
    }

    private fun setupSubscriptionsAdapter() {
        //TODO Setup RecyclerView adapter
        val adapter = SubscriptionsAdapter(object: SubscriptionItemBindings {
            override fun onClick() {
                TODO("Not yet implemented")
            }

            override fun onDeleteClick() {
                TODO("Not yet implemented")
            }

        })

        viewBinding.subscriptionsRecyclerView.adapter = adapter
        viewBinding.subscriptionsRecyclerView.addItemDecoration(SubscriptionsItemDecoration(8))

        viewScope.launch {
            subscriptionsDomain.observeSubscriptions().collect { subscriptions ->
                isShowEmptyState.postValue(subscriptions.isEmpty())

                adapter.submitList(subscriptions)

                subscriptions[0].price.toString()
                Float
            }
        }
    }
}