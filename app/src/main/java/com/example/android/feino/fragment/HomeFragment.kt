package com.example.android.feino.fragment

import android.content.Context
import android.widget.Toast
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.*
import com.example.android.feino.R
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_profile.*


class HomeFragment : FeinoBaseFragment() {
    private lateinit var communicator: PageFragment.HomeCommunicator

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        setHasOptionsMenu(false)
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setClickListeners()
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_home, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.getItemId() === R.id.action_home) {
            Toast.makeText(getActivity(), "Clicked on " + item.getTitle(), Toast.LENGTH_SHORT)
                .show()
        }
        return true
    }
    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is PageFragment.HomeCommunicator) {
            communicator = context
        } else {
            throw RuntimeException(context.toString() + " Login communicator error")
        }
    }
    private fun setClickListeners() {
        register_tv.setOnClickListener {
            communicator?.launchFragment(BarcodeFragment(), true, false)

        }
        scan_tv.setOnClickListener {
            communicator?.launchFragment(BarcodeFragment(), true, false)


        }

    }

}