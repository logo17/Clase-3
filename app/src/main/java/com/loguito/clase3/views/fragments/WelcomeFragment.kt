package com.loguito.clase3.views.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputEditText
import com.jakewharton.rxbinding4.view.clicks
import com.jakewharton.rxbinding4.widget.textChanges
import com.loguito.clase3.R
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import java.util.concurrent.TimeUnit

class WelcomeFragment : Fragment(R.layout.fragment_welcome) {
    private lateinit var userNameEditText: TextInputEditText
    private lateinit var button: Button
    private lateinit var createAccountButton: Button

    private val disposable = CompositeDisposable()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userNameEditText = view.findViewById(R.id.nameEditText)
        button = view.findViewById(R.id.button)
        createAccountButton = view.findViewById(R.id.button2)

        button.setOnClickListener {
            // TODO 6: Inicializamos la accion y pasamos los parametros requeridos (navegacion segura)
            val action =
                WelcomeFragmentDirections.actionWelcomeFragmentToDetailFragment(userNameEditText.text.toString())
            // TODO 7: Navegamos utilizando la accion con los parametros, asi evitamos pasar el id
            findNavController().navigate(action)
        }

        createAccountButton.setOnClickListener {
            val action = WelcomeFragmentDirections.actionWelcomeFragmentToCreateAccountNavGraph()
            findNavController().navigate(action)
        }

//        disposable.add(
//            userNameEditText.textChanges()
//                .debounce(300, TimeUnit.MILLISECONDS)
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe {
//                    button.isEnabled = it.toString().isNotEmpty()
//                }
//        )
//
//        disposable.add(
//            button.clicks()
//                .throttleFirst(1000, TimeUnit.MILLISECONDS)
//                .subscribe {
//                    Log.d("CLICK EVENT", "Clickeado")
//                }
//        )
    }

    override fun onDestroy() {
        disposable.clear()
        super.onDestroy()
    }
}