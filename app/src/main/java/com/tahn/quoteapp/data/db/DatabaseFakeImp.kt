package com.tahn.quoteapp.data.db

class DatabaseFakeImp : Database {
    override val quoteDao: QuoteDao = QuoteDaoFakeImp()
}