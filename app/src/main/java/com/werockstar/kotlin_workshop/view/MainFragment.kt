package com.werockstar.kotlin_workshop.view


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.werockstar.kotlin_workshop.R
import com.werockstar.kotlin_workshop.toText

class MainFragment : Fragment() {

    lateinit var edtUsername: EditText
    lateinit var edtPassword: EditText
    lateinit var btnSubmit: Button

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_main, container, false)

        edtUsername = view.findViewById(R.id.edtUsername)
        edtPassword = view.findViewById(R.id.edtPassword)
        btnSubmit = view.findViewById(R.id.btnSubmit)

        btnSubmit.setOnClickListener {
            val username = edtUsername.toText()
            val password = edtPassword.toText()

            getMainActivity().changeFragment(SecondFragment.newInstance(username, password))
        }

        return view
    }

    fun getMainActivity(): MainActivity {
        return activity as MainActivity
    }

    companion object {
        fun newInstance(): MainFragment {
            val bundle = Bundle()
            val fragment = MainFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

}
