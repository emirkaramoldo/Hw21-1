package com.example.hw21_2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class FirstFragment : Fragment() {
    private lateinit var textView: TextView
    private lateinit var button: Button
    private var count = 0
    private var isIncrementing = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        textView = view.findViewById(R.id.textView)
        button = view.findViewById(R.id.button)

        button.setOnClickListener {
            if (isIncrementing) {
                count++
                if (count == 10) {
                    isIncrementing = false
                    button.text = "-1"
                }
            } else {
                count--
                if (count == 0) {
                    isIncrementing = true
                    button.text = "+1"
                    val secondFragment = SecondFragment()
                    val bundle = Bundle()
                    bundle.putInt("COUNT", count)
                    secondFragment.arguments = bundle
                    (activity as MainActivity).replaceFragment(secondFragment)
                    return@setOnClickListener
                }
            }
            updateTextView()
        }

        return view
    }

    private fun updateTextView() {
        textView.text = count.toString()
    }
}