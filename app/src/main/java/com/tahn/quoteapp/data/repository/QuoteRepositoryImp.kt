package com.tahn.quoteapp.data.repository

import androidx.lifecycle.LiveData
import com.tahn.quoteapp.data.db.QuoteDao
import com.tahn.quoteapp.data.model.Quote

class QuoteRepositoryImp (private val quoteDao : QuoteDao) : QuoteRepository{
    override fun addQuote(quote: Quote) {
        quoteDao.addQuote(quote)
    }

    override fun getQuotes() = quoteDao.getQuotes()

}