package com.oosca.dogtracker

import android.app.Application
import com.oosca.dogtracker.data.dogs
import com.oosca.dogtracker.repositories.DogRepository

class DogReviewerApplication : Application() {
    val dogRepository: DogRepository by lazy {
        DogRepository(dogs)
    }
}