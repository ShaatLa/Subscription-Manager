package com.shaatla.subscribio.subscriptioninfo.ui

import android.app.DatePickerDialog
import android.content.Context
import android.icu.util.Calendar
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.AdapterView
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.jaredrummler.android.colorpicker.ColorPickerDialog
import com.jaredrummler.android.colorpicker.ColorPickerDialogListener
import com.jaredrummler.android.colorpicker.ColorShape
import com.mynameismidori.currencypicker.CurrencyPicker
import com.shaatla.subscribio.R
import com.shaatla.subscribio.infrastructure.extension.hideKeyboard
import com.shaatla.subscribio.infrastructure.util.setDebouncedOnClickListener
import com.shaatla.subscribio.subscriptions.domain.model.BillingPeriod
import com.shaatla.subscribio.subscriptions.domain.model.Subscription
import kotlinx.android.synthetic.main.fragment_subscription_info.billingPeriod
import kotlinx.android.synthetic.main.fragment_subscription_info.changeCurrencyButton
import kotlinx.android.synthetic.main.fragment_subscription_info.colorImage
import kotlinx.android.synthetic.main.fragment_subscription_info.creationDate
import kotlinx.android.synthetic.main.fragment_subscription_info.icon
import kotlinx.android.synthetic.main.fragment_subscription_info.infoCloseButton
import kotlinx.android.synthetic.main.fragment_subscription_info.infoDeleteButton
import kotlinx.android.synthetic.main.fragment_subscription_info.price
import kotlinx.android.synthetic.main.fragment_subscription_info.priceCurrency
import kotlinx.android.synthetic.main.fragment_subscription_info.subscriptionName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.joda.time.DateTime
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import java.util.Currency
import java.util.Locale

/**
 * SubscriptionInfoFragment
 * 28.06.2020
 * Created by shaatla
 * shaatla@gmail.com
 * Copyright (c) 2020 ShaatLa. All rights reserved.
 */
class SubscriptionInfoFragment : Fragment(R.layout.fragment_subscription_info) {

    private val args: SubscriptionInfoFragmentArgs by navArgs()

    private val viewModel: SubscriptionInfoViewModel by viewModel {
        parametersOf(args.subscriptionId)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupButtons()

        obtainSubscriptionInfo()

        billingPeriod.setSelection(2, false)
    }

    private fun setupButtons() {
        val inputMethodManager = requireView().context
            .getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        infoCloseButton.setOnClickListener {
            when {
                //inputMethodManager.isActive -> hideKeyboard(requireView())

                subscriptionName.isEnabled -> {
                    viewModel.saveSubscription()
                    findNavController().popBackStack()
                }

                else -> findNavController().popBackStack()
            }
        }

        infoDeleteButton.setOnClickListener {
            viewModel.deleteSubscription()
            findNavController().popBackStack()
        }

        subscriptionName.setOnClickListener {
            if (!subscriptionName.isEnabled) {
                setupEditor()
            }
        }
    }

    private fun observeSubscriptionInfo() {
        viewModel.subscriptionLiveData
            .observe(
                viewLifecycleOwner,
                Observer { subscription ->
                    setupSubscription(subscription)
                }
            )
    }

    private fun obtainSubscriptionInfo() {
        when (args.subscriptionId) {
            EMPTY_ID -> {
                setupEditor()
            }

            else -> {
                viewModel.getSubscriptionInfo()

                observeSubscriptionInfo()
            }
        }
    }

    private fun setupSubscription(subscription: Subscription) {
        subscriptionName.text.insert(0, subscription.provider)
        creationDate.text = subscription.creationDate.toLocalDate().toString()
        priceCurrency.text = subscription.currency.symbol
        price.text.insert(0, subscription.price.toString())
        icon.text.insert(0, subscription.icon)
    }

    private fun setupEditor() {
        subscriptionName.isEnabled = true
        creationDate.isEnabled = true
        price.isEnabled = true
        priceCurrency.isEnabled = true
        icon.isEnabled = true

        subscriptionName.doOnTextChanged { text, _, _, _ ->
            viewModel.baseSubscription = viewModel.baseSubscription.copy(provider = text.toString())

            if (infoDeleteButton.isGone) {
                infoDeleteButton.isVisible = true
                infoCloseButton.setText(R.string.save)
            }

            if (text.isNullOrBlank()) {
                infoDeleteButton.isGone = true
                infoCloseButton.setText(R.string.close)
            }
        }

        icon.doOnTextChanged { text, _, _, _ ->
            viewModel.baseSubscription = viewModel.baseSubscription.copy(icon = text.toString())
        }

        setupDatePickerDialog()
        setupCurrencyPicker()
        setupPeriodSpinner()
        setupColorPicker()
    }

    private fun setupDatePickerDialog() {
        val date = Calendar.getInstance()

        val datePickerCallback =
            DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
                date.set(year, month, dayOfMonth)

                val dateTime = DateTime(date.timeInMillis)
                creationDate.text = dateTime.toLocalDate().toString(
                    "dd MMM yyyy",
                    Locale.getDefault()
                )
                viewModel.baseSubscription =
                    viewModel.baseSubscription.copy(creationDate = dateTime)
            }

        creationDate.setOnFocusChangeListener { view, hasFocus ->
            if (hasFocus) {
                showDatePickerDialog(datePickerCallback, date)

                view.setDebouncedOnClickListener {
                    showDatePickerDialog(datePickerCallback, date)
                }
            } else {
                view.setOnClickListener(null)
            }
        }


    }

    private fun showDatePickerDialog(
        datePickerCallback: DatePickerDialog.OnDateSetListener,
        date: Calendar
    ) {
        hideKeyboard(requireView())

        DatePickerDialog(
            requireContext(),
            datePickerCallback,
            date.get(Calendar.YEAR),
            date.get(Calendar.MONTH),
            date.get(Calendar.DAY_OF_MONTH)
        ).show()
    }

    private fun setupCurrencyPicker() {
        changeCurrencyButton.isVisible = true

        val picker = CurrencyPicker.newInstance(getString(R.string.currency_dialog_header))
        picker.setListener { _, code, symbol, _ ->
            priceCurrency.text = symbol

            viewModel.baseSubscription = viewModel.baseSubscription
                .copy(currency = Currency.getInstance(code))

            picker.dismiss()
        }

        priceCurrency.setDebouncedOnClickListener {
            picker.show(parentFragmentManager, CURRENCY_PICKER)
        }

        changeCurrencyButton.setDebouncedOnClickListener {
            picker.show(parentFragmentManager, CURRENCY_PICKER)
        }
    }

    private fun setupPeriodSpinner() {
        billingPeriod.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                //no-op
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                setupBillingPeriod(position)
            }
        }
    }

    private fun setupBillingPeriod(period: Int) {
        when (period) {
            0 -> viewModel.baseSubscription = viewModel.baseSubscription
                .copy(billingPeriod = BillingPeriod.DAILY)

            1 -> viewModel.baseSubscription = viewModel.baseSubscription
                .copy(billingPeriod = BillingPeriod.WEEKLY)

            2 -> viewModel.baseSubscription = viewModel.baseSubscription
                .copy(billingPeriod = BillingPeriod.MONTHLY)

            3 -> viewModel.baseSubscription = viewModel.baseSubscription
                .copy(billingPeriod = BillingPeriod.YEARLY)
        }
    }

    private fun setupColorPicker() {
        val picker = ColorPickerDialog.newBuilder()
            .setColor(viewModel.baseSubscription.color)
            .setColorShape(ColorShape.CIRCLE)
            .setAllowCustom(true)
            .create()

        picker.setColorPickerDialogListener(
            object : ColorPickerDialogListener {
                override fun onDialogDismissed(dialogId: Int) {
                    //no-op
                }

                override fun onColorSelected(dialogId: Int, color: Int) {
                    viewModel.baseSubscription = viewModel.baseSubscription.copy(color = color)

                    val newColorDrawable =
                        resources.getDrawable(R.drawable.subscription_color_shape, null)
                    newColorDrawable.setTint(color)
                    colorImage.setImageDrawable(newColorDrawable)
                }
            }
        )

        colorImage.setOnClickListener {
            picker.show(parentFragmentManager, COLOR_PICKER)
        }
    }

    companion object {
        const val EMPTY_ID = 0

        const val CURRENCY_PICKER = "currency_picker"

        const val COLOR_PICKER = "color_picker"
    }
}