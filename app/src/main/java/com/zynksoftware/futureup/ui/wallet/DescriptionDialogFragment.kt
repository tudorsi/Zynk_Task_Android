package com.zynksoftware.futureup.ui.wallet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.zynksoftware.futureup.databinding.DescriptionDialogBinding

class DescriptionDialogFragment(coinNameText:String): DialogFragment() {

    private var bindingDialogFragment : DescriptionDialogBinding? =null
    private var coinNameText = coinNameText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingDialogFragment = DescriptionDialogBinding.inflate(inflater,container,false)
        return bindingDialogFragment!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindingDialogFragment?.coinNameTextView?.text = coinNameText
        bindingDialogFragment?.closeButton?.setOnClickListener {
            dismiss()
        }


    }

}