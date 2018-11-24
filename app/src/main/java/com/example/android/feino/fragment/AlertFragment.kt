package com.example.android.feino.fragment

import android.widget.Toast
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.*
import com.example.android.feino.R


class AlertFragment : FeinoBaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        setHasOptionsMenu(false)
        return inflater.inflate(R.layout.fragment_alert, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_alert, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.getItemId() === R.id.action_alert) {
            Toast.makeText(getActivity(), "Clicked on " + item.getTitle(), Toast.LENGTH_SHORT)
                .show()
        }
        return true
    }

}