package com.example.swapp

import dagger.Component

@Component
interface Component {
    fun inject(activity: MainActivity)
}