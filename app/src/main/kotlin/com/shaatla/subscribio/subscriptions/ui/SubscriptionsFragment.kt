package com.shaatla.subscribio.subscriptions.ui

import android.os.Bundle
import android.view.View
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import com.shaatla.subscribio.R
import com.shaatla.subscribio.subscriptions.domain.model.Subscription
import com.shaatla.subscribio.subscriptions.ui.recycler.ItemAction
import com.shaatla.subscribio.subscriptions.ui.recycler.SubscriptionsAdapter
import com.shaatla.subscribio.subscriptions.ui.recycler.SubscriptionsItemDecoration
import com.shaatla.subscribio.subscriptions.ui.recycler.SubscriptionsItemTouchCallback
import kotlinx.android.synthetic.main.fragment_subscriptions.emptyStateParentLayout
import kotlinx.android.synthetic.main.fragment_subscriptions.emptySubscriptionsHint
import kotlinx.android.synthetic.main.fragment_subscriptions.floatingActionButton
import kotlinx.android.synthetic.main.fragment_subscriptions.subscriptionsRecyclerView
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * CommentsViewModel
 * 23.03.2020
 * Created by shaatla
 * shaatla@gmail.com
 * Copyright (c) 2020 ShaatLa. All rights reserved.
 */
class SubscriptionsFragment : Fragment(R.layout.fragment_subscriptions) {

    private val viewModel: SubscriptionsViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().window.navigationBarColor =
            resources.getColor(R.color.colorPrimaryDark, null)

        setupFloatButton()

        setupSubscriptionsAdapter()
    }

    private fun setupFloatButton() {
        floatingActionButton.setOnClickListener {
            findNavController().navigate(SubscriptionsFragmentDirections.toInfo(null))
        }
    }

    private fun setupEmptySubscriptionsHint() {
        floatingActionButton.isGone = true
        subscriptionsRecyclerView.isGone = true
        emptySubscriptionsHint.isVisible = true
        emptyStateParentLayout.setOnClickListener {
            findNavController().navigate(SubscriptionsFragmentDirections.toInfo(null))
        }
    }

    private fun setupSubscriptionsAdapter() {
        val adapter = SubscriptionsAdapter { id, action ->
            when (action) {
                ItemAction.NAVIGATE -> findNavController().navigate(
                    SubscriptionsFragmentDirections.toInfo(
                        id
                    )
                )

                ItemAction.DELETE -> {
                    //TODO Show delete dialog
                    viewModel.deleteSubscription(id)
                }
            }
        }

        subscriptionsRecyclerView.adapter = adapter
        subscriptionsRecyclerView.addItemDecoration(SubscriptionsItemDecoration(8))

        val callback = SubscriptionsItemTouchCallback()
        val helper = ItemTouchHelper(callback)
        helper.attachToRecyclerView(subscriptionsRecyclerView)

        viewModel
            .observeSubscriptions()
            .observe(
                viewLifecycleOwner,
                Observer<List<Subscription>> { subscriptions ->
                    if (subscriptions.isEmpty()) {
                        setupEmptySubscriptionsHint()
                    } else {
                        adapter.submitList(subscriptions)
                    }
                }
            )

        floatingActionButton.isVisible = true
    }
}