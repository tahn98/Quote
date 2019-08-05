package com.tahn.quoteapp.data.db

import androidx.lifecycle.LiveData
import com.tahn.quoteapp.data.model.Quote

interface QuoteDao{
    fun addQuote(quote: Quote)
    fun getQuotes() : LiveData<List<Quote>>
}