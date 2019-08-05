package com.tahn.quoteapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.tahn.quoteapp.data.model.Quote
import kotlinx.android.synthetic.main.activity_main.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance
import java.lang.StringBuilder

class MainActivity : AppCompatActivity(), KodeinAware {

    override val kodein by closestKodein()
    private val viewModelFactory : QuotesViewModelFactory by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initUi()
    }

    private fun initUi() {
        val viewModel = ViewModelProviders.of(this, viewModelFactory).get(QuotesViewModel::class.java)
        val stringBuilder = StringBuilder()
        viewModel.getQuotes().observe(this, Observer { quotes ->
            stringBuilder.append("$quotes")

            findViewById<TextView>(R.id.textView_quotes).text = stringBuilder.toString()
        })

        findViewById<Button>(R.id.button_add_quote).setOnClickListener {
            val quote = Quote(editText_quote.text.toString(), editText_author.text.toString())
            viewModel.addQuote(quote)
            editText_quote.text.clear()
            editText_author.text.clear()
        }
    }
}
