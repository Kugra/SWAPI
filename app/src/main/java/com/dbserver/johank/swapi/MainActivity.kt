package com.dbserver.johank.swapi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    val charactersList = mutableListOf<Character>()
    var hasNext: Boolean = false
    var firstRun: Boolean = true
    var nextPageUrl: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getAllCharacters()

    }

    /*private fun firstTest(){
        val call = RetrofitInitializer().starWarsService().getCharacterOneAsTest()

        call.enqueue(object : Callback<Character> {
            override fun onResponse(call: Call<Character>?, response: Response<Character>?) {
                response?.body()?.let {
                    println("===============>${it.name} / ${it.gender} / ${it.birth_year}")
                }
            }

            override fun onFailure(call: Call<Character>?, t: Throwable?) {
                Log.e("onFailure", t?.message)
            }
        })
    }

    private fun secondTest(){
        val call = RetrofitInitializer().starWarsService().getCharacters()

        call.enqueue(object : Callback<CharactersPage> {
            override fun onFailure(call: Call<CharactersPage>?, t: Throwable?) {
                Log.e("onFailure", t?.message)
            }

            override fun onResponse(call: Call<CharactersPage>?, response: Response<CharactersPage>?) {
                response?.body()?.let {
                    it.results.let {
                        it.forEach {
                            Log.d("response",it.name)
                        }
                    }
                }
            }

        })
    }*/

    private fun getAllCharacters(){

        if(firstRun) {
            val call = RetrofitInitializer().starWarsService().getCharacters()

            call.enqueue(object : Callback<CharactersPage> {
                override fun onFailure(call: Call<CharactersPage>?, t: Throwable?) {
                    Log.e("error", t?.message)
                }

                override fun onResponse(call: Call<CharactersPage>?, response: Response<CharactersPage>?) {
                    response?.body()?.let {

                        if (it.next != null) {
                            hasNext = true
                            nextPageUrl = it.next

                        } else {
                            hasNext = false
                        }

                        it.results.forEach {
                            charactersList.add(it)
                        }
                    }
                    firstRun = false
                    getAllCharacters()
                }
            })
        } else {
            if(hasNext) {
                val call = RetrofitInitializer().starWarsService().getCharactersPage(nextPageUrl!!)

                call.enqueue(object : Callback<CharactersPage> {
                    override fun onFailure(call: Call<CharactersPage>?, t: Throwable?) {
                        Log.e("error", t?.message)
                    }

                    override fun onResponse(call: Call<CharactersPage>?, response: Response<CharactersPage>?) {
                        response?.body()?.let{
                            if (it.next != null) {
                                hasNext = true
                                nextPageUrl = it.next

                            } else {
                                hasNext = false
                            }

                            it.results.forEach {
                                charactersList.add(it)
                            }
                        }
                        getAllCharacters()
                    }
                })
            }
            else {
                charactersList.forEach {
                    Log.d("try", it.name) //faça algo
                }
            }
        }
    }

}
