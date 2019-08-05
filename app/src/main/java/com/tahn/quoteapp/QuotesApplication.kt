package com.tahn.quoteapp

import android.app.Application
import com.tahn.quoteapp.data.db.Database
import com.tahn.quoteapp.data.db.DatabaseFakeImp
import com.tahn.quoteapp.data.db.QuoteDao
import com.tahn.quoteapp.data.repository.QuoteRepository
import com.tahn.quoteapp.data.repository.QuoteRepositoryImp
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class QuotesApplication : Application(), KodeinAware{
    override val kodein = Kodein.lazy {
        bind<Database>() with singleton { DatabaseFakeImp() }
        bind<QuoteDao>() with singleton { instance<Database>().quoteDao }
        bind<QuoteRepository>() with singleton { QuoteRepositoryImp(instance()) }
        bind<QuotesViewModelFactory>() with provider { QuotesViewModelFactory(instance()) }
    }
}