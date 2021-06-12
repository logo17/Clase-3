package com.loguito.clase3.views.fragments

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.loguito.clase3.R

class DetailFragment : Fragment(R.layout.fragment_detail) {
    //TODO 7: Inicializamos los argumentos
    private val args: DetailFragmentArgs by navArgs()

    private lateinit var greetingTextView: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        greetingTextView = view.findViewById(R.id.greetingTextView)

        greetingTextView.text = requireContext().getString(R.string.greeting_text, args.userName)
    }
}