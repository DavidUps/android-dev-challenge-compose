/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.feature.puppy

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.feature.puppy.model.Puppy
import com.example.androiddevchallenge.feature.puppy.usecases.GetPuppies.getPuppies

class PuppyViewModel : ViewModel() {

    private val _puppies = MutableLiveData<List<Puppy>>()
    val puppies: LiveData<List<Puppy>> = _puppies

    fun puppies() {
        _puppies.value = getPuppies()
    }

    fun puppies(filter: String) {
        puppies.value?.let { value ->
            if (filter.isNullOrEmpty())
                _puppies.value = getPuppies()
            else {
                val list: MutableList<Puppy> = value.filter {
                    it.name.toLowerCase().contains(filter.toLowerCase())
                }.toMutableList()
                _puppies.value = list
                Log.w("hola", "")
            }
        }
    }
}
